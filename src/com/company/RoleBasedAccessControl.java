package com.company;

import java.util.*;
import com.company.models.Role;
import com.company.models.User;
import com.company.models.Resource;
import com.company.util.RbacHelper;
import com.company.models.ActionType;
import com.company.service.UserService;
import com.company.service.RolesService;
import com.company.service.ResourceService;
import com.company.service.Impl.UserServiceImpl;
import com.company.service.Impl.RolesServiceImpl;
import com.company.service.Impl.ResourceServiceImpl;


public class RoleBasedAccessControl {

    private UserService userService;
    private ResourceService resourceService;
    private RolesService rolesService;
    private RbacHelper rbacHelper;

    public static void main(String[] args) {

        RoleBasedAccessControl roleBasedAccessControl = new RoleBasedAccessControl();

        roleBasedAccessControl.initializeSetup();

        int choice;
        do{
            choice = roleBasedAccessControl.rbacHelper.mainMenu();
            roleBasedAccessControl.performOperation(choice);

        }while (choice != 7);


    }

    private  void initializeSetup(){

        List<String> userIds = new ArrayList<String>(){{add("Nikhil"); add("Arun"); add("Sai");}};
        List<String> resourceIds = new ArrayList<String>(){{add("s3:/order"); add("file://home/user/documents"); add("/home/user/downloads"); }};
        List<String> roleIds = new ArrayList<String>(){{ add("QA"); add("Developer"); add("Manager");}};
        List<ActionType> actionTypes = new ArrayList<ActionType>(){{add(ActionType.READ); add(ActionType.WRITE); add(ActionType.DELETE);}};

        //Initializing Services
        userService = new UserServiceImpl();
        resourceService = new ResourceServiceImpl();
        rolesService = new RolesServiceImpl();
        rbacHelper = new RbacHelper();


        //Initializing Users
        userIds.forEach(userId -> {
            userService.createUser(userId);
        });


        //Initializing Resources
        resourceIds.forEach(resourceId -> {
            resourceService.createResource(resourceId);
        });


        //Initializing Roles
        HashMap<String, List<ActionType>> map = new HashMap<>();

        for(int index = 0; index<roleIds.size(); index++){
            map.put(resourceIds.get(index), actionTypes.subList(0,index+1));
            rolesService.createRole(roleIds.get(index), map);
        }

    }

    private void performOperation(int choice){

        String userId;
        String roleId;
        Role role;
        switch (choice){
            case 1:
                List<User> users = userService.getAllUsers();
                rbacHelper.printList(users);
                break;
            case 2:
                List<Resource> resources = resourceService.getAllResources();
                rbacHelper.printList(resources);
                break;
            case 3:
                List<Role> roles = rolesService.getAllRoles();
                rbacHelper.printList(roles);
                break;
            case 4:
                userId = rbacHelper.readInput("UserId");
                roleId = rbacHelper.readInput("RoleId");
                role = rolesService.getRole(roleId);
                userService.addRole(userId, role);
                System.out.println("Successfully Added role");
                break;
            case 5:
                userId = rbacHelper.readInput("UserId");
                roleId = rbacHelper.readInput("RoleId");
                userService.removeRole(userId, roleId);
                System.out.println("Successfully Removed role");
                break;
            case 6:
                userId = rbacHelper.readInput("UserId");
                String resourceId = rbacHelper.readInput("ResourceId");
                String actionType = rbacHelper.readInput("ActionType");
                System.out.println(validateQuery(userId, resourceId, actionType)?"Has Access":"Donot Have Access");
                break;

            default:
                System.out.println("Invalid Operation");
        }
    }

    private boolean validateQuery(String userId, String resoureId, String actionType){

        boolean isValid = false;
        ActionType  actionTypeObj = ActionType.getActionType(actionType.toLowerCase());
        User user = userService.getUser(userId);
        List<String> roleIds = new ArrayList<>(user.getRolesMap().keySet());

        for(String roleId : roleIds){
            Role role = rolesService.getRole(roleId);
            HashMap<String, List<ActionType>> resouceActionMap = role.getResourceActionMap();
            List<ActionType> actionTypeList = resouceActionMap.get(resoureId);
            if(actionTypeList.contains(actionTypeObj)){
                isValid = true;
                break;
            }
        }

        return isValid;

    }

}
