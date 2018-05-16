
package busstation;



public class Trip implements java.io.Serializable{
    private String from;
    private String to;
    private String date;
    private String vehicle;
    private String driver;
    private String internal;
    private String rounded;
    private String price;
    private String flavor;
    private Ticket ticket;

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setInternal(String internal) {
        this.internal = internal;
    }

    public void setRounded(String rounded) {
        this.rounded = rounded;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDate() {
        return date;
    }

    public String getVehicle() {
        return vehicle;
    }
    public String getDriver(){
        return driver;
    }

    public String getInternal() {
        return internal;
    }

    public String getRounded() {
        return rounded;
    }

    public String getPrice() {
        return price;
    }

    public String getFlavor() {
        return flavor;
    }

    public Trip(String from, String to, String date, String vehicle, String driver, String internal, String rounded, String price, String flavor, int number) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.vehicle = vehicle;
        this.driver = driver;
        this.internal = internal;
        this.rounded = rounded;
        this.price = price;
        this.flavor = flavor;
        this.ticket = new Ticket(number);
    }
    
    public int getTripLeftQuantity(){
        System.out.println(ticket.getLeft() + "Tickets Left");
        return ticket.getLeft();
    }
    
    public void sell(int num){
        ticket.setSold(num);
    }   
}
