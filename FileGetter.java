package busstation;


import java.io.File;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class FileGetter {
    private Scanner x;
    
    FileGetter(String path){
        try{
            x = new Scanner(new File(path));
        }catch(Exception e){System.out.println("cannt open file"  + path);}
    }
    
    public ObservableList<String> getArr(){
        ObservableList temp = FXCollections.observableArrayList();
        while(x.hasNextLine()){
            temp.add(x.nextLine());
        }
        return temp;
    }
}
