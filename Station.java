
package busstation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Station {
    private static ArrayList<Vehicle> vehicles;
    private static ArrayList<Driver> drivers = new ArrayList<Driver>();
    private static ArrayList<Employee> employees = new ArrayList<Employee>();
    private static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static ArrayList<Trip> trips = new ArrayList<Trip>();
    
    
   public boolean checkTicketQuantity(int index,int toPurchase){
           if(trips.get(index).getTripLeftQuantity()- toPurchase >= 0){
               trips.get(index).sell(toPurchase);
               return true;
           }
           else{return false;}
   }
   
   public void addTrip(Trip t){
       trips.add(t);
   }
   
   public void save() throws FileNotFoundException, IOException{
       if(!trips.isEmpty()){
       FileOutputStream fi = new FileOutputStream("./src/busstation/files/trips.tmp");
       ObjectOutputStream out = new ObjectOutputStream(fi);
       out.writeObject(trips);
       fi.close();
       out.close();
       }
       
       if(!customers.isEmpty()){
       FileOutputStream fi1 = new FileOutputStream("./src/busstation/files/customers.tmp");
       ObjectOutputStream out1 = new ObjectOutputStream(fi1);
       out1.writeObject(customers);
       fi1.close();
       out1.close();
       }
       
       if(!drivers.isEmpty()){
       FileOutputStream fi2 = new FileOutputStream("./src/busstation/files/drivers.tmp");
       ObjectOutputStream out2 = new ObjectOutputStream(fi2);
       out2.writeObject(drivers);
       fi2.close();
       out2.close();
       }
       
   }
   
   public void addVehicle(Vehicle v){
       vehicles.add(v);
   }
   
   public void load() throws FileNotFoundException, IOException, ClassNotFoundException{
       FileInputStream f = new FileInputStream("./src/busstation/files/trips.tmp");
       if(f.available()!=0){
            ObjectInputStream in = new ObjectInputStream(f);
            trips = (ArrayList<Trip>) in.readObject();
             f.close();
             in.close();
        }
       
       FileInputStream f1 = new FileInputStream("./src/busstation/files/customers.tmp");
       if(f1.available()!=0){
       ObjectInputStream in1 = new ObjectInputStream(f1);
       customers = (ArrayList<Customer>) in1.readObject();
       f1.close();
       in1.close();
       }
       
       FileInputStream f2 = new FileInputStream("./src/busstation/files/drivers.tmp");
       if(f2.available()!=0){
       ObjectInputStream in2 = new ObjectInputStream(f2);
       drivers = (ArrayList<Driver>) in2.readObject();
       f2.close();
       in2.close();
       }
       
   }
   
   public ObservableList<String> getTripsAsStrings(){
       ObservableList temp = FXCollections.observableArrayList();
       for(int i=0;i<trips.size();i++){
           String s = trips.get(i).getFrom() + "    " + trips.get(i).getTo() + "    " + trips.get(i).getDate() + "    " + trips.get(i).getVehicle() + "    " + 
            trips.get(i).getDriver()  + "    " + trips.get(i).getInternal() + "    " + trips.get(i).getRounded() + "    " + trips.get(i).getFlavor() + "    " + trips.get(i).getPrice();
       temp.add(s);
       }
       return temp;
   }
   
   public ObservableList<String> getDriversAsString(){
       ObservableList temp = FXCollections.observableArrayList();
       for(int i=0;i<drivers.size();i++){
           temp.add(drivers.get(i).get());
       }
       return temp;
   }
   
   public void editTrip(String s, int n){
       if(s.isEmpty()){deleteTrip(n);return;}
       String[] arr = s.split("\\s+");
       trips.get(n).setFrom(arr[0]);
       trips.get(n).setTo(arr[1]);
       trips.get(n).setDate(arr[2]);
       trips.get(n).setVehicle(arr[3]);
       trips.get(n).setDriver(arr[4]);
       trips.get(n).setInternal(arr[5]);
       trips.get(n).setRounded(arr[6]);
       trips.get(n).setFlavor(arr[7]);
       trips.get(n).setPrice(arr[8]);
       
   }
   public void deleteTrip(int index){
       trips.remove(index);
   }
   
   
   public void addDriver(String s){
       Driver temp = new Driver(s.trim());
       drivers.add(temp);
   }
   
   public void addCustomer(String username, String password){
       Customer temp = new Customer(username,password);
       customers.add(temp);
   }
   
   public boolean checkCustomerLogin(String username, String password){
       for(int i=0;i<customers.size();i++){
           //System.out.println(customers.get(i).getUsername() + "+" + customers.get(i).getPassword() + "   " + username+"+"+password);
           if(customers.get(i).getUsername().equals(username) && customers.get(i).getPassword().equals(password)){return true;}
       }
       return false;
   }
    
    
}
