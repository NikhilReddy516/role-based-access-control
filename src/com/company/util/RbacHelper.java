package com.company.util;


import java.util.List;
import java.util.Scanner;

/**
 * @Author: Nikhil Reddy (nikoth)
 * @Date: 11/6/19, Tue
 **/
public class RbacHelper {

    private Scanner sc;

    public RbacHelper(){
        sc = new Scanner(System.in);
    }
    public int mainMenu(){

        int choice;
        boolean isFirst = true;

        do{
            System.out.print(isFirst?"":"Previous Input is Invalid\n\n");
            System.out.println("RoleBasedAccessControl Menu");
            System.out.println("1. Users");
            System.out.println("2. Resources");
            System.out.println("3. Roles");
            System.out.println("4. Assign Role To User");
            System.out.println("5. Remove Role From User");
            System.out.println("6. Validate Query");
            System.out.println("7. Exit");
            System.out.print("Enter your choice(1-7): ");
            choice = sc.nextInt();
            isFirst = false;
        }while(choice<1 || choice>7);

        return choice;
    }


    public <T> void printList(List<T> objList){
        objList.forEach(obj -> {
            System.out.println(obj);
        });
    }

    public String readInput(String displayStr){
        System.out.println("Enter "+displayStr+" :");
        return sc.nextLine();
    }

}
