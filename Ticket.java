
package busstation;


public class Ticket implements java.io.Serializable{
    private int number;
    private int sold;
    
    public Ticket(int number){
        this.number = number;
        this.sold = 0;
    }
    
    public int getLeft(){
        return number-sold;
    }
    
    public void setSold(int num){
        this.sold+=num;
    }
    
}
