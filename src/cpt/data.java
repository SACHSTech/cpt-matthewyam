package cpt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

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




public class data extends Application{

    public static void main(String[] args) throws IOException{
        launch(args);
    }

    String[] worldData;
    //String[] addData;
    int counter = 0;
    String filler;
    ArrayList<String> country = new ArrayList();
    ArrayList<Double> percent = new ArrayList();
    
   

    public void hpcFile() throws IOException{
        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
        String line = "";
        
       
        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");
            System.out.print(addData[1]);

            String dataCollector = addData[1];
            country.add(dataCollector);
            
            Double numCollector = (Double.parseDouble(addData[3]));
            percent.add(numCollector);

            counter++;


        }
        
    }
    
    @Override
    public void start(Stage stage) throws Exception {
       
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Percent");

        BarChart chartOne = new BarChart(xAxis, yAxis);
        XYChart.Series dataOneSeries = new XYChart.Series();
        dataOneSeries.setName("testing");
        stage.setTitle("Bar Chart");

        chartOne.getData().add(dataOneSeries);
        
        for(int i = 0; i < country.size(); i++){
            dataOneSeries.getData().add(new XYChart.Data(country.get(i), percent.get(i)));
            
        }
        
        VBox vbox = new VBox(chartOne);
        Scene scene = new Scene(vbox, 400, 200);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(450);
        stage.show();        
        

        /**
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
           
            //new PieChart.Data(worldData[1],1),
            //new PieChart.Data(worldData[2],2),
            //new PieChart.Data(worldData[1],3)
        );

       
      
        PieChart chart = new PieChart(FXCollections.observableArrayList(pieChartData));
        Group group = new Group(chart);
        stage.setScene(new Scene(group, 500, 300));
        */
        

        

    }


}