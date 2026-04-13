/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchart;

import java.util.Scanner;


public class QuickChart {

    public static void main(String[] args) {
          
        Scanner scan = new Scanner(System.in);
    System.out.println("Enter first name: ");
    String firstName = scan.next();
    
    System.out.println("Enter last name: ");
    String lastName = scan.next();
    
    System.out.println("Enter username: ");
    String username = scan.next();
    
    System.out.println("Enter password: ");
    String password = scan.next();
    
    System.out.println("Enter cellphone: ");
    String cellphone = scan.next();
        
    String result = Login.registerUser(firstName, username, password, cellphone, lastName);
    

    System.out.println(result);

    
    if(result.contains("not correctly")){
  
    return; 
    }
   
    System.out.println("Enter username to Login:");
    String loginUsername = scan.next();
    
    System.out.println("enter password to Login:");
    String loginPassword = scan.next();
    
    
    boolean loginresult = Login.loginUser(loginUsername, loginPassword);
   
    System.out.println(Login.returnLoginStatus(loginresult));
    
     
        
       
    }
}
