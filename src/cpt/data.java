package cpt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;



public class data extends main{

    String[] worldData;
   

    public static void hpcFile() throws IOException{
        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
        String line;
        while((line = readData.readLine()) != null){
            
            String[] worldData = line.split(",");
            System.out.println(worldData);
            
        }
    }
    

    private PieChart chart;

    //@Override 
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createData()));
        primaryStage.show();
        ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList(
            new PieChart.data = worldData[0];
        );
    }

   

    }

    public Parent createData(){
        chart = new PieChart(worldData);
    }
    
    
    public static void main(String[] args) throws IOException{
        
    }
}