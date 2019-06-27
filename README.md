Docs


Entities or Models:
---------------------------------------------
1. ActionType
    i. It is a enum with 3 actions READ, WRITE and DELETE. If in future number of actions increase we can add.
    ii. 2 local variables action and description.
    iii. Method to return ActionType object for given string obj of action.

2. Resource
    i. It is a normal model with id variable.
    ii. Based on requirement we can add more variables to it.
    iii. In my scenario I am using only id for uniquely identify a resource.

3. Role
    i. Role is the class which defines which resources can be accessed with which actionTypes.
    ii. It has 2 variables id and resourceActionMap.
    iii. Id is for uniquely identify the role and resourceActionMap is mapping between resourceId and list of actionTypes associated to it.

4. User
    i. User class has 2 variables id and rolesMap.
    ii. rolesMap is a mapping between roleId and roleObject.
    iii. rolesMap makes easy for accessing roles and perform add or remove of roles from it.



Services And Its Implementation:
---------------------------------------------
1. UserService and UserServiceImpl
    i. Main functionalities are createUser(), getUser(), addRole(), removeRole().
    ii. We maintain a users map which contains all the users who are created in the form of Map<id , user>.
    iii. Whenever we createUser(), we also add that user to users map using private method called addUser().
    iv. For adding or removing of role we use put and remove methods respectively of map.

2. RolesService and RolesServiceImpl
    i. Main functionalities are createRole() and getRole().
    ii. Similar to users map we also maintain roles map in the form of Map<id, role>.
    iii. Whenever we createRole(), we also add that role ot roles map using private method call addRole().

3. ResourceService and ResourceServiceImpl are similar to above.


Helper
---------------------------------------------
1. RbacHelper
    i. Main functionalities are mainMenu, printList and readInput.
    ii. MainMenu() displays the menu card.
    iii. printList() is generic method for printing the list of objects.
    iv. readInput() takes displayStr based on it prints prompt and gets input from user.


RoleBasedAccessControl:
----------------------------------------------
1. Main functionalities are initializeSetup(), performOperations() and validateQuery.
2. During initializeSetup() we initialize all services, helpers and dummy data for users, resources, roles.
3. performOpertions() takes an integer as input and performs action associated with it.
4. RbacHelper mainMenu has more number of options but only concentrate on AddRole, RemoveRole and Validate Query operations.


validateQuery()
    i. It gets user obj based on userId. Then extracts all roleIds.
    ii. For each roleId we check in resourceAction map whether for that resourceId associated actionList has given action.
    iii. If given action is present in the list we return true saying "Has Access" else continue with search.
    iv. At end if not found we return false saying "Has No Access".
