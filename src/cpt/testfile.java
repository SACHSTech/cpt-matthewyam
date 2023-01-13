package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

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

public class testfile {
    
    /**
    public static void main(String[] args) throws IOException {
        ObservableList<datapoint> chartData = FXCollections.observableArrayList();
        ArrayList<datapoint> chartData1 = new ArrayList();
        LinkedHashSet<datapoint> set = new LinkedHashSet<>(chartData1);  
        ArrayList<datapoint> chartData1Clean = new ArrayList<>(set);
        

        

        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");

            if(counter != 0){

                for(int i=0; i < 1; i++){
                    
                    double chartPercent = (Double.parseDouble(addData[1]));
                    datapoint myData = new datapoint(addData[0], chartPercent);
                    chartData.add(myData);
                    
                    
                }

            }
            counter++;

            
            
        }
        System.out.println(chartData);
        
        
    }
    */
    
   // public static ObservableList<String> chartData = FXCollections.observableArrayList();
   // public static ObservableList<Double> chartDataPercent = FXCollections.observableArrayList();

    public static ArrayList<String> chartData = new ArrayList();
    public static ArrayList<Double> chartDataPercent = new ArrayList();
    public static ObservableList<datapoint> allMyData = FXCollections.observableArrayList();
        
    
    
    //public void data() throws Exception{
    public static void main(String[] args) throws IOException{
    
        
        //ArrayList<dataset> chartData1 = new ArrayList();

        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");

            if(counter != 0){
                
                for(int i=0; i < 1; i++){

                    double chartPercent = (Double.parseDouble(addData[1]));
                    datapoint collectedData = new datapoint(addData[0], chartPercent);
                    String collectData1 = new String(addData[0]);
                    
                    chartData.add(collectData1);
                    chartDataPercent.add(chartPercent);
                    allMyData.add(collectedData);

                }

            }
            counter++;
        }
       // System.out.println(chartData);
       // System.out.println(chartDataPercent);
        System.out.println(allMyData);
       
    }

    public ArrayList returnArrList(ArrayList chartData) {
        return chartData;
    }
}
