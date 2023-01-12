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
import javafx.scene.chart.XYChart.Series;
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

    
    @Override
    public void start(Stage stage) throws Exception {
       
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Percent");

        BarChart chartOne = new BarChart(xAxis, yAxis);
        XYChart.Series dataSeries = new XYChart.Series();
        

        dataSeries.setName("test");
        stage.setTitle("Bar Chart");

        chartOne.getData().add(dataSeries);
        
        VBox vbox = new VBox(chartOne);
        Scene scene = new Scene(vbox, 400, 200);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(450);
        stage.show();              

    }

}