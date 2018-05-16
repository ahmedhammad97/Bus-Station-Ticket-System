
package busstation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginChecker {
    private Scanner x;
    LoginChecker(String fileName) throws FileNotFoundException{
        x = new Scanner(new File(fileName));
    }
    
    boolean check(String username, String password){
        while(x.hasNext()){
            String user = x.next();
            String pass = x.next();
            if(user.equals(username) && pass.equals(password)){x.close();return true;}
        }
        x.close();
        return false;
    }
    
}
