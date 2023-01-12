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
    


    static ObservableList chartData = FXCollections.observableArrayList();
    ObservableList<Double> chartPercent = FXCollections.observableArrayList();
    int counter = 0;
    static String line = "";
    double addDataNum;
    
    public static void data (String[] addData){
        
        dataset myData = new dataset(addData[1], Double.parseDouble(addData[3]));
        chartData.add(myData);

    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
        while((line = readData.readLine()) != null){
            
            data(line.split(","));

        }
        System.out.println(chartData.toString());
        
        
    }

}
