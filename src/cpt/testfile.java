package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import cpt.Reader;
import cpt.testfile;

public class testfile {
     
    //public ObservableList<datapoint> chartData = FXCollections.observableArrayList();
    private static ArrayList<Datapoint> allData = new ArrayList<Datapoint>();
    private static ArrayList sendCountry = new ArrayList();
    private static ArrayList sendPercent = new ArrayList();
    //private static String testSend = "Hi";
    
    public static void main(String[] args) throws Exception{


        

            BufferedReader read = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
 //   /** 
            String line = "";
            int counter = 0;
    
            
            while((line = read.readLine()) != null){
    
                String[] addData = line.split(",");

                //if(counter != 0){
                
                    for(int i = 0; i < 1; i++){
                        Double chartPercent = (Double.parseDouble(addData[1]));
                        String chartCountry = addData[0];
                        
                        
                        sendCountry.add(addData[0]);
                        sendPercent.add(Double.parseDouble(addData[1]));
                        
                    }
                //}
               // counter++;
                
                
            }
            System.out.println(sendCountry);
            //System.out.println(sendPercent);
            System.out.println(sendCountry);
            //read.close();
            
    //       */

          // System.out.println(read.toString());
    }
    
        
}


    