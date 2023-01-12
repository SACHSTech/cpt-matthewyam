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

public class filereader {

    private ObservableList<XYChart.Series<String, Double>> getChartData() {
        ObservableList<String> chartData = FXCollections.observableArrayList();
        Series<String, Double> series = new Series<String, Double>();

        series.setName("test");
        ;

        for(int i =0; i<100;i++){
            series.getData().add(new XYChart.Data(Integer.toString(i), 10));
        }

        chartData.add(series);
        return chartData;


        return hi;


    }
}

