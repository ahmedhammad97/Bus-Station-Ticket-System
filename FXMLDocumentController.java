
package busstation;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


public class FXMLDocumentController implements Initializable {
    
    
     
     @FXML
    private Button addTripBtn;

    @FXML
    private PasswordField managerPassword;

    @FXML
    private GridPane customerGP;

    @FXML
    private TextField ticketsNum;

    @FXML
    private Pane customerLogin;

    @FXML
    private Button saveDriver;

    @FXML
    private Button buyTicket;

    @FXML
    private Button addVipBtn;

    @FXML
    private GridPane managerGP;

    @FXML
    private Button addVehicleBtn;

    @FXML
    private Pane addTripPane;

    @FXML
    private Button editTBtn;

    @FXML
    private GridPane welcome;

    @FXML
    private Pane managerLogin;

    @FXML
    private MenuButton chooseVehicle;

    @FXML
    private Pane addVipPane;

    @FXML
    private Button addDriverBtn;

    @FXML
    private Pane editTripPane;

    @FXML
    private Pane tripPane;

    @FXML
    private Pane addDriverPane;

    @FXML
    private TextField managerUsername;

    @FXML
    private MenuItem external;

    @FXML
    private TextField driverName;

    @FXML
    private Button saveTripBtn;

    @FXML
    private Label regularCustomerText;

    @FXML
    private MenuButton tripVehicle;

    @FXML
    private MenuButton tripInternal;

    @FXML
    private MenuItem miniBus1;

    @FXML
    private Button customerLoginBtn;

    @FXML
    private MenuItem Bus1;

    @FXML
    private Pane addVehiclePane;

    @FXML
    private TextField tripPrice;

    @FXML
    private TextField customerUsername;

    @FXML
    private MenuItem miniBus;

    @FXML
    private MenuItem Bus;

    @FXML
    private Pane manager;

    @FXML
    private TextField tripFrom;

    @FXML
    private TextField editTripText;

    @FXML
    private TextField tripTo;

    @FXML
    private ListView<String> tripList;

    @FXML
    private MenuItem oneway;

    @FXML
    private Button managerLoginBtn;

    @FXML
    private DatePicker tripDate;

    @FXML
    private PasswordField customerPassword;

    @FXML
    private TextField tripDriver;

    @FXML
    private Label VIP;

    @FXML
    private Pane customer;
    
    @FXML
    private Button editTripListPick;

    @FXML
    private MenuButton tripRounded;

    @FXML
    private ListView<String> editTripList;
    
    @FXML
    private Label buyTripLabel;
    
    @FXML 
    private Button editTripBtn;
    
    @FXML
    private Button addCustomerBtn;
    
    @FXML
    private TextField vipUsername;
    
    @FXML
    private PasswordField vipPassword;
    
    @FXML
    private ComboBox tripDriverBox;

    
     @FXML
    void onewayClick(ActionEvent event) {
        tripRounded.setText("One-way");
    }
    
    @FXML
    void RoundedClick(ActionEvent event) {
        tripRounded.setText("Rounded");
    }
    
    
   

    @FXML
    void InternalClick(ActionEvent event) {
        tripInternal.setText("Internal");
    }

    @FXML
    void ExternalClick(ActionEvent event) {
        tripInternal.setText("External");
    }

    @FXML
    void minBusClick(ActionEvent event) {
        tripVehicle.setText("MiniBus");
    }

    @FXML
    void BusClick(ActionEvent event) {
        tripVehicle.setText("Bus");
    }
    
    @FXML
    void microBusClick(ActionEvent event) {
        tripVehicle.setText("MicroBus");
    }


     @FXML
    void custLogin() {
         manager.setVisible(false);
         customerLogin.setVisible(true);
    }

    @FXML
    void manLogin() {
        customer.setVisible(false);
        managerLogin.setVisible(true);
    }
    
    @FXML
    void regularCustomerFunction(){
        VIP.setText("false");
        welcome.setVisible(false);
        customerGP.setVisible(true);
        Station s = new Station();
        tripList.setItems(s.getTripsAsStrings());    
    }
    
    @FXML
    void chooseMinibus(ActionEvent event) {
        chooseVehicle.setText("Minibus");
    }

    @FXML
    void chooseBus(ActionEvent event) {
         chooseVehicle.setText("Bus");
    }
    
     @FXML
    void chooseMicroBus(ActionEvent event) {
        chooseVehicle.setText("MicroBus");
    }


    @FXML
     //@SuppressWarnings("empty-statement")
    void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource()==managerLoginBtn){
            try{
                
            LoginChecker a = new LoginChecker("./src/busstation/files/managers.txt");
                if(a.check(managerUsername.getText(), managerPassword.getText())){
                    welcome.setVisible(false);
                    managerGP.setVisible(true);
                    Station s = new Station();
                    tripDriverBox.setItems(s.getDriversAsString());
                }
                else{
                    managerUsername.setText("Invaild Access! .. Try again.");
                }
            }
            catch(Exception e){
                    System.out.println("Error opening file managers.txt");
            }
        }   
        
        
        if(event.getSource()==customerLoginBtn){
            try{
            //LoginChecker a = new LoginChecker("./src/busstation/files/customers.txt");
                Station a = new Station();
                if(a.checkCustomerLogin(customerUsername.getText(), customerPassword.getText())){
                    VIP.setText("true");
                    welcome.setVisible(false);
                    customerGP.setVisible(true);
                    Station s = new Station();
                    tripList.setItems(s.getTripsAsStrings());
                    
                    
                }
                else{
                    customerUsername.setText("Invaild Access! .. Try again.");
                }
            }
            catch(Exception e){
                    System.out.println("Error opening file customers.txt");
            }
        }
        
        
        
        if(event.getSource()==addTripBtn){
            //System.out.println("Test");
            
            Station s = new Station();
            tripDriverBox.setItems(s.getDriversAsString());
                
            addTripPane.setVisible(true);
            editTripPane.setVisible(false);
            addDriverPane.setVisible(false);
            addVehiclePane.setVisible(false);
            addVipPane.setVisible(false);            
        }
        if(event.getSource()==editTBtn){
            Station s = new Station();
            editTripList.setItems(s.getTripsAsStrings());
            
            
            addTripPane.setVisible(false);
            editTripPane.setVisible(true);
            addDriverPane.setVisible(false);
            addVehiclePane.setVisible(false);
            addVipPane.setVisible(false);            
        }
        if(event.getSource()==addDriverBtn){
            addTripPane.setVisible(false);
            editTripPane.setVisible(false);
            addDriverPane.setVisible(true);
            addVehiclePane.setVisible(false);
            addVipPane.setVisible(false);            
        }
        if(event.getSource()==addVehicleBtn){
            addTripPane.setVisible(false);
            editTripPane.setVisible(false);
            addDriverPane.setVisible(false);
            addVehiclePane.setVisible(true);
            addVipPane.setVisible(false);            
        }
        if(event.getSource()==addVipBtn){
            addTripPane.setVisible(false);
            editTripPane.setVisible(false);
            addDriverPane.setVisible(false);
            addVehiclePane.setVisible(false);
            addVipPane.setVisible(true);         
        }
        
        if(event.getSource()==buyTicket){
            //System.out.println("Buy Ticket Button Pressed");
            if(tripList.getSelectionModel().getSelectedIndex() !=-1){
                Station s = new Station();
                if(s.checkTicketQuantity(tripList.getSelectionModel().getSelectedIndex(),Integer.parseInt(ticketsNum.getText()))){
                    buyTripLabel.setText("Purchase done successfully");
                }
                else{
                    buyTripLabel.setText("No enough tickets, Sorry!");
                }
                buyTripLabel.setVisible(true);
                s.save();
            }
        }
        
        if(event.getSource()==saveTripBtn){
            Random rn = new Random();
            int stops = rn.nextInt(3);
            String[] st = {"No-stops","One-stops","Many-Stops"};
            int seats=0;
            if(tripVehicle.getText().equals("MicroBus")){seats=15;}
            else if(tripVehicle.getText().equals("MiniBus")){seats=25;}
            else if(tripVehicle.getText().equals("Bus")){seats=50;}
            
            try{
            Trip temp1 = new Trip(tripFrom.getText(),tripTo.getText(),tripDate.getValue().toString(),tripVehicle.getText(), (String) tripDriverBox.getValue(),tripInternal.getText(),tripRounded.getText(),tripPrice.getText(),st[stops],seats);
            Station x = new Station();
            x.addTrip(temp1);
            x.save();
            }catch(Exception e){System.out.println("Manafa3sh ne3mel trip walahy");}
        }
        
        if(event.getSource()==editTripListPick){
            editTripText.setText(editTripList.getSelectionModel().getSelectedItem());
        }
        
        if(event.getSource()==editTripBtn){
            Station s = new Station();
            s.editTrip(editTripText.getText(), editTripList.getSelectionModel().getSelectedIndex());
            if(editTripText.getText().isEmpty()){editTripText.setText("Trip deleted successfuly");}
            else{editTripText.setText("Trip edited successfuly");}
            editTripList.setItems(s.getTripsAsStrings());
            s.save();
            
        }
        
        if(event.getSource()==saveDriver){
            Station s = new Station();
            s.addDriver(driverName.getText());
            s.save();
        }
        
        
        if(event.getSource()==addCustomerBtn){
            Station s = new Station();
            s.addCustomer(vipUsername.getText(), vipPassword.getText());
            s.save();
        }
        
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
