
package busstation;


public abstract class Employee implements java.io.Serializable{
    private String name;
    
    public Employee(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}
