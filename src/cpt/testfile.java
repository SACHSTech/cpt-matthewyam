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
     
    //public ObservableList<datapoint> chartData = FXCollections.observableArrayList();
    private List<String> chartData = new ArrayList<>();
    private List<Double> chartPercentage = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
    
        
        //ArrayList<dataset> chartData1 = new ArrayList();

        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");

            if(counter != 0){
                
                for(int i=0; i < 1; i++){

                    double chartPercent = (Double.parseDouble(addData[1]));
                    String chartCountry = addData[0];
                    //datapoint collectedData = new datapoint(chartCountry, chartPercent);
                    chartData.add(chartCountry);
                    chartPercentage.add(chartPercent);
                }

            }
            counter++;
        }
        returnChartData();
        returnChartPercent();
        
       
    }

    public static List returnChartData() {
        System.out.println(chartData);
        return chartData;
        

    }

    public static List returnChartPercent(){
        System.out.println(chartPercentage);
        return chartPercentage;
    }

    
}