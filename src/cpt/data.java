package cpt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
import javafx.scene.layout.HBox;




public class data extends Application{

    public static void main(String[] args) throws IOException{
        launch(args);
    }

    String[] worldData;
    //String[] addData;
    int counter = 0;
    String filler;
    ArrayList<String> country = new ArrayList<String>();
    ArrayList<Double> percent = new ArrayList<Double>();
    
   

    public void hpcFile() throws IOException{
        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
        String line = "";
       
        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");
            //double[] addDataTwo = new double[addData.length];
            
            //System.out.println(addData[1]);
            System.out.println(Double.parseDouble(addData[3]));
            country.add(addData[1]);
            percent.add(Double.parseDouble(addData[3]));

        }
    }
    
    @Override
    public void start(Stage stage) throws Exception {
       
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Percent");

        BarChart chartOne = new BarChart(xAxis, yAxis);
        XYChart.Series dataOne = new XYChart.Series();

        for(int i = 0; i < country.size(); i++){
            dataOne.getData().add(new XYChart.Data(country.get(i), percent.get(i)));
        }
        
        chartOne.getData().add(dataOne);

        
        VBox vbox = new VBox(chartOne);

        stage.setTitle("Bar Chart");
        stage.show();

        Scene scene = new Scene(vbox, 400, 400);

        stage.setScene(scene);
        
     



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