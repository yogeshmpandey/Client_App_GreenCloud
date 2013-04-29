/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BlackPearl
 */
public class LoginPassword {
  
     String username;
     String password;
    
    public String getuserName() {
        return username;
    }
    public void setuserName(String username) {
        this.username = username;
        
    }
    
    public String getpassWord() {
        return password;
    }

    public void setpassWord(String password) {
        this.password = password;
    }

    void setpassWord(char[] password) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    

    
}
