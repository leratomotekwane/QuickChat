/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchart;


class Login {
    static User registeredUser = new User();
    
    static boolean checkUserName(String username){
        return !(username.length() > 5 || !username.contains("_"));
    }
    
    static boolean checkPasswordComplexity(String password){
        if(password.length() < 8) return false;
        if(password.equals(password.toLowerCase())) return false;
        if(!password.matches(".*[!@#$%^&()_+].*")) return false;
        if(!password.matches(".*\\d.*")) return false;
        return true;
    }
    
    static boolean checkCellPhoneNumber(String cellphone){
        if(cellphone.startsWith("+27") && cellphone.length() == 12){
            String numbers = cellphone.substring(3);
            if(numbers.matches("\\d+")){
                return true;
            }
        }
        return false;
    }
    
    static String registerUser(String firstName, String username, String password, String cellphone, String lastName){
        String errors = "";
        
        if(!checkUserName(username)){
            errors += "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters length.\n";
        }
        
        if(!checkPasswordComplexity(password)){
            errors += "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.\n";
        }
        
        if(!checkCellPhoneNumber(cellphone)){
            errors += "Cellphone is not correctly formatted or does not contain international code.\n";
        }
        
        if(!errors.isEmpty()){
            return errors;
        }
        
        String success = "";
        success += "Username successfully captured\n";
        success += "Password successfully captured\n";
        success += "Cellphone successfully captured\n";
        success += "Welcome " + firstName + " " + lastName + " it is great to see you.";
        
        registeredUser.username = username;
        registeredUser.password = password;
        registeredUser.firstName = firstName;
        registeredUser.lastName = lastName;
        registeredUser.cellphone = cellphone;
        
        return success;
    }
    
    static boolean loginUser(String username, String password){
        
        if(username.equals(registeredUser.username) && 
           password.equals(registeredUser.password)){
            return true;
        }else{
            return false;
        }
    }
    
    static String returnLoginStatus(boolean isLoggedIn) {
        if(isLoggedIn) {
            
            String firstName = registeredUser.firstName != null ? registeredUser.firstName : "";
            String lastName = registeredUser.lastName != null ? registeredUser.lastName : "";
            return "Welcome Back " + firstName + " " + lastName;
        } else {
            return "Loggin has failed";
        }
    }
}
