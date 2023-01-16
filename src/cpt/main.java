package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import cpt.Reader;
import cpt.testfile;

public class Main extends Application{

    
    //List country = new Reader().returnChartData();
    //List percent = new Reader().returnChartPercent();
    static int count = 0;

    public void importData() throws Exception{
        
        for(int i = 0; i < 100;i++){

            count++;
        }
        System.out.println(count);
    }

    

    public static void main(String[] args) throws IOException{
        launch(args);
        
        //System.out.println(country);
        System.out.println("test");


    }

    
    @Override
    public void start(Stage stage) throws Exception {


        //Gridpane and Menu Button
        GridPane area = new GridPane();
        area.setMinSize(1000, 800); 
        area.setPadding(new Insets(10, 10, 10, 10)); 
        area.setVgap(5); 
        area.setHgap(5);
        area.setGridLinesVisible(false);
        area.setVisible(true);

        Menu charts = new Menu("Charts");
        MenuItem bar = new MenuItem("Bar Chart");
        MenuItem pie = new MenuItem("Pie Chart");
        charts.getItems().add(bar);
        charts.getItems().add(pie);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(charts);
        area.add(menuBar, 0, 0);


        
        

       //Bar chart
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Percent");

        XYChart.Series series1 = new XYChart.Series();

        BarChart<String,Number> barc = new BarChart<String,Number>(xAxis,yAxis);

        barc.getData().addAll(series1);     
        series1.getData().add(new XYChart.Data("test",123));
        series1.getData().add(new XYChart.Data("hello",12));
        barc.setTitle("Healthcare Coverage per Country");

        //Pie Chart
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
        new PieChart.Data("Grapefruit", 13),
        new PieChart.Data("Oranges", 25));
        PieChart piec = new PieChart(pieChartData);
        piec.setData(pieChartData);

        piec.setTitle("Healthcare Coverage per Country");
        piec.setClockwise(true);

        area.add(barc, 45, 30);
        barc.setVisible(false);
        area.add(piec,45,30);
        piec.setVisible(false);

        bar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent showBar) {

                stage.setTitle("Bar Chart");
                piec.setVisible(false);
                barc.setVisible(true);
                
            }
            
        });

        pie.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent show) {
                stage.setTitle("Pie Chart");
                
                piec.setVisible(true);
                barc.setVisible(false);
            }
            
        });

       

        
     

        //for(int i = 0; i < 20; i++){
            
            //series1.getData().add(new XYChart.Data());
    
        //}
    
        

        

        //series1.getData().addAll(new XYChart.Data());
        
        

        
        
        
        /**
        barChartData.getData().add(new XYChart.Data(readFile.data()));
        BarChart chartOne = new BarChart(xAxis, yAxis);
        chartOne.setData(barChartData);
        dataSeries.setData(dataGrabber);
        dataSeries.setName("test");
        stage.setTitle("Bar Chart");
        chartOne.getData().add(dataSet);

        */

        //Pie Chart
       
        VBox bChart = new VBox(area);
        Scene scene = new Scene(bChart, 1000, 1000);
        stage.setTitle("Healthcare Coverage per Country");
        stage.setScene(scene);
        stage.setHeight(800);
        stage.setWidth(1100);

        piec.setLabelLineLength(50);
        piec.setLabelsVisible(true);
        piec.setStartAngle(180);
        
        stage.show();  
        
        
        
        
        


    }
    

}