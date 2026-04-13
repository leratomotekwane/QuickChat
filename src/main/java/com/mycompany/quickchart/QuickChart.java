/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quickchart;

import java.util.Scanner;


public class QuickChart {

    public static void main(String[] args) {
          
        Scanner scan = new Scanner(System.in);
    System.out.print("Enter first name: ");
    String firstName = scan.next();
    
    System.out.print("Enter last name: ");
    String lastName = scan.next();
    
    System.out.print("Enter username: ");
    String username = scan.next();
    
    System.out.print("Enter password: ");
    String password = scan.next();
    
    System.out.print("Enter cellphone: ");
    String cellphone = scan.next();
        
    String result = Login.registerUser(firstName, username, password, cellphone, lastName);
    

    System.out.println(result);

    
    if(result.contains("not correctly")){
  
    return; 
    }
   
    System.out.print("Enter username to Login: ");
    String loginUsername = scan.next();
    
    System.out.print("Enter password to Login: ");
    String loginPassword = scan.next();
    
    
    boolean loginresult = Login.loginUser(loginUsername, loginPassword);
   
    System.out.println(Login.returnLoginStatus(loginresult));
    
     
        
       
    }
}
