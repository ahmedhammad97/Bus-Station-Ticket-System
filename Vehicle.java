
package busstation;


public abstract class Vehicle implements iVehicle ,java.io.Serializable {
    private int seats;
    private Driver drvier;

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setDrvier(Driver drvier) {
        this.drvier = drvier;
    }

    public int getSeats() {
        return seats;
    }

    public Driver getDrvier() {
        return drvier;
    }

    public Vehicle(int seats, Driver drvier) {
        this.seats = seats;
        this.drvier = drvier;
    }
    
    @Override
    public void add(){
        Station s = new Station();
        s.addVehicle(this);
    }
}
