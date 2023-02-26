package business;

import com.gcu.model.LoginModel;

public class ThreeValidLogins implements SecurityServiceInterface{

    @Override
    public boolean isAuthenticated(LoginModel loginModel) {
        

        // create a list of valid login names and passwords
        String[][] validLogins = new String [][]{
            {"root","root"},
            {"caden","silvey"},
            {"Caden","Silvey"}
        };

        // check to see if the login matches any username/pass combos
        boolean success = false;
        for(int i=0; i < validLogins.length; i++){
            if(loginModel.getUsername().equals(validLogins[i][0]) && loginModel.getPassword().equals(validLogins[i][1]) ){
                success = true;
            }
        }
        if (success){
            // login success. Send them to the success page to show what they entered
            return true;    
        }
        else{
            // login failed 
            return false;
        }     
    }
    
}
