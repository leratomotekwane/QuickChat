/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchart;


class Login {
    // Stores the registered user details
    static User registeredUser = new User();
    
    // Checks if username is valid (must contain "_" and be max 5 characters)
    static boolean checkUserName(String username){
        return !(username.length() > 5 || !username.contains("_"));
    }
    
    // Checks if password meets complexity rules
    static boolean checkPasswordComplexity(String password){
        if(password.length() < 8) return false; // must be at least 8 characters
        if(password.equals(password.toLowerCase())) return false; // must have uppercase letter
        if(!password.matches(".*[!@#$%^&()_+].*")) return false; // must have special character
        if(!password.matches(".*\\d.*")) return false; // must have a number
        return true;
    }
    
    // Checks if cellphone number is valid (+27 followed by 9 digits)
    static boolean checkCellPhoneNumber(String cellphone){
        if(cellphone.startsWith("+27") && cellphone.length() == 12){
            String numbers = cellphone.substring(3);
            if(numbers.matches("\\d+")){ // check if remaining characters are digits
                return true;
            }
        }
        return false;
    }
    
    // Registers a new user and returns success or error messages
    static String registerUser(String firstName, String username, String password, String cellphone, String lastName){
        String errors = "";
        
        // Validate username
        if(!checkUserName(username)){
            errors += "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters length.\n";
        }
        
        // Validate password
        if(!checkPasswordComplexity(password)){
            errors += "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.\n";
        }
        
        // Validate cellphone
        if(!checkCellPhoneNumber(cellphone)){
            errors += "Cellphone is not correctly formatted or does not contain international code.\n";
        }
        
        // Return errors if any exist
        if(!errors.isEmpty()){
            return errors;
        }
        
        // Success messages
        String success = "";
        success += "Username successfully captured\n";
        success += "Password successfully captured\n";
        success += "Cellphone successfully captured\n";
        success += "Welcome " + firstName + " " + lastName + " it is great to see you.";
        
        // Save user details
        registeredUser.username = username;
        registeredUser.password = password;
        registeredUser.firstName = firstName;
        registeredUser.lastName = lastName;
        registeredUser.cellphone = cellphone;
        
        return success;
    }
    
    // Checks login credentials
    static boolean loginUser(String username, String password){
        if(username.equals(registeredUser.username) && 
           password.equals(registeredUser.password)){
            return true; // login successful
        }else{
            return false; // login failed
        }
    }
    
    // Returns login message based on status
    static String returnLoginStatus(boolean isLoggedIn) {
        if(isLoggedIn) {
            // Get stored names (avoid null values)
            String firstName = registeredUser.firstName != null ? registeredUser.firstName : "";
            String lastName = registeredUser.lastName != null ? registeredUser.lastName : "";
            
            return "Welcome Back " + firstName + " " + lastName + " it is great to see yo again";
        } else {
            return "Loggin has failed";
        }
    }
}