
package busstation;


public class Driver extends Employee implements java.io.Serializable{
    
    public Driver(String name){
        super(name);
    }
    
    public String get(){
        return super.getName();
    }
    
}
