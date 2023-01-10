package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.stage.Stage;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.layout.HBox;


public class main extends Application{

    public static void main(String[] args) throws IOException{
        launch(args);
        
    }

    String[] worldData;
    int counter = 0;
    String filler;
    List<String> country = filereader.getCountry();
    List<Double> percent = filereader.percent;
  
    /**
    ArrayList<String> country = new ArrayList<>();
    ArrayList<Double> percent = new ArrayList<>();
    String line = ""; 

    public void hpcFile() throws IOException{
        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");
            country.add(addData[1]);
            percent.add(Double.parseDouble(addData[3]));

        }  
    }
    */

    public void test (String[] args1) throws IOException{
        System.out.print(country);
        launch(args1);
    }
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
       /**
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Percent");

        BarChart chartOne = new BarChart(xAxis, yAxis);
        XYChart.Series dataOneSeries = new XYChart.Series();
        dataOneSeries.setName("testing");
        stage.setTitle("Bar Chart");
        
        for(int i = 0; i < filereader.country.size(); i++){
        
            dataOneSeries.getData().add(new XYChart.Data(country.get(i), percent.get(i)));
                
        }
        
        chartOne.getData().add(dataOneSeries);
        
        VBox vbox = new VBox(chartOne);
        Scene scene = new Scene(vbox, 400, 200);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(450);
        stage.show();              
*/
    }

}