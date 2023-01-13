package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

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

import cpt.readFile;
import cpt.testfile;

public class main extends Application{

    //ArrayList  country = new testfile().chartData;
    //ArrayList percent = new testfile().chartDataPercent;

    ObservableList allData = new readFile().chartData;

    public static void main(String[] args) throws IOException{
        launch(args);
        
    }

    
    @Override
    public void start(Stage stage) throws Exception {

       
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Percent");

        XYChart.Series series1 = new XYChart.Series();

        BarChart<String,Number> barc = new BarChart<String,Number>(xAxis,yAxis);
        series1.setName("data");       
        //series1.getData().add(new XYChart.Data("test",123));
        

        series1.getData().addAll(new XYChart.Data(allData));
        barc.getData().addAll(series1);
        

        
        
        /**
        
        barChartData.getData().add(new XYChart.Data(readFile.data()));
        BarChart chartOne = new BarChart(xAxis, yAxis);
        chartOne.setData(barChartData);
        dataSeries.setData(dataGrabber);
        dataSeries.setName("test");
        stage.setTitle("Bar Chart");
        chartOne.getData().add(dataSet);
        */
        VBox vbox = new VBox(barc);
        Scene scene = new Scene(vbox, 400, 200);
        stage.setScene(scene);
        stage.setHeight(500);
        stage.setWidth(450);
        stage.show();              

    }

}