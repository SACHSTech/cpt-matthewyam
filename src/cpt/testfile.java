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

public class testfile {
    
    static ObservableList<String> chartData = FXCollections.observableArrayList();
    static ObservableList<Double> chartPercent = FXCollections.observableArrayList();
    static ArrayList testData = new ArrayList();
    static int counter = 0;
    static String line = "";
    static double addDataNum;
    
    
    


    public static void main(String[] args) throws IOException {
        String[] addData = line.split(",");
        //ObservableList<String> testArray = FXCollections.observableArrayList();
        //testArray.addAll("hellow", "hit");
        
        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
        while((line = readData.readLine()) != null){
            
            
            counter++;
            chartData.add(addData[1]);
            chartPercent.add(Double.parseDouble(addData[3]));
            
        }

        for(int i = 0;i<counter;i++){
            dataset myDataset = new dataset(addData[1], Double.parseDouble(addData[3]));
            myDataset.add(testData);
        }

        System.out.println(chartData);
        System.out.print(chartPercent);
        
        
    }

}
