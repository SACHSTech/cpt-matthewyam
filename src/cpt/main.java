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
import javafx.scene.control.ListView;
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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import cpt.Reader;
import cpt.testfile;

public class Main extends Application{

    Reader dataGrabber;
    //ArrayList insuranceData = new ArrayList(Reader.returnAllData());
    //dataGrabber insuranceData = returnAllData().getData();
    static String tester = Reader.returnTEst();
    //ArrayList<String> listCountry = new ArrayList<String>(Reader.returnSendCountry());
    //List percent = new Reader().returnChartPercent();

    int count = 0;

    static boolean textTrigger = false;
    

    public static void main(String[] args) throws Exception{

        
        
        launch(args);

        System.out.println(tester.toString());
        if(tester == null){
            System.out.println("bruh");
        }

        

        System.out.println("test");

        textTrigger = true; 

    }

    
    @Override
    public void start(Stage stage) throws Exception {
        dataGrabber = new Reader();

        dataGrabber.returnSendCountry();
        dataGrabber.returnSendPercent();

        //Gridpane
        GridPane area = new GridPane();
        area.setMinSize(1000, 800); 
        area.setPadding(new Insets(10, 10, 10, 10)); 
        area.setVgap(5); 
        area.setHgap(5);
        area.setGridLinesVisible(false);
        area.setVisible(true);

        //Menu Buttons
        Menu charts = new Menu("Charts");
        Menu reset = new Menu("Reset");
        MenuItem bar = new MenuItem("Bar Chart");
        MenuItem pie = new MenuItem("Pie Chart");
        MenuItem both = new MenuItem("Both Charts");
        MenuItem confirmReset = new MenuItem("Confirm Reset");
        charts.getItems().add(bar);
        charts.getItems().add(pie);
        charts.getItems().add(both);
        reset.getItems().add(confirmReset);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(charts);
        menuBar.getMenus().add(reset);
        area.add(menuBar, 0, 0);

        
        //Text
        Text prompt = new Text();
        prompt.setText("←                               Pick a Chart");
        prompt.setFont(Font.font(50));
        area.add(prompt, 1, 0);
        prompt.setVisible(false);

        if(textTrigger = true){
            prompt.setVisible(true);
        }
        
        


       //Bar chart
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Percent");

        XYChart.Series series1 = new XYChart.Series();

        BarChart<String,Number> barc = new BarChart<String,Number>(xAxis,yAxis);

        barc.getData().addAll(series1);     
       
        for(int loop = 0; loop  < dataGrabber.returnSendCountry().size(); loop++){
            series1.getData().add(new XYChart.Data(dataGrabber.returnSendCountry().get(loop), dataGrabber.returnSendPercent().get(loop)));
        }
        

        barc.setTitle("Healthcare Coverage per Country");

        //Pie Chart

        //Piechart sample data
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        
        for(int pieLoop = 0; pieLoop < dataGrabber.returnSendCountry().size(); pieLoop++){
            pieChartData.add(new PieChart.Data (dataGrabber.returnSendCountry().get(pieLoop), dataGrabber.returnSendPercent().get(pieLoop)));
        }
        
        
        
        //new PieChart.Data("Oranges", 25));
        
        //Creates Piechart
        PieChart piec = new PieChart(pieChartData);
        piec.setData(pieChartData);
        piec.setTitle("Healthcare Coverage per Country");
        piec.setClockwise(true);

        area.add(barc, 1, 10);
        barc.setVisible(false);
        area.add(piec, 5, 10);
        piec.setVisible(false);

        bar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent showBar) {

                stage.setTitle("Bar Chart");
                piec.setVisible(false);
                barc.setVisible(true);
                prompt.setVisible(false);
                textTrigger = false;
                
            }
            
        });

        pie.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent show) {
                stage.setTitle("Pie Chart");
                
                piec.setVisible(true);
                barc.setVisible(false);
                prompt.setVisible(false);
                textTrigger = false;
            }
            
        });

        both.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent show) {
                stage.setTitle("Both Charts");
                
                piec.setVisible(true);
                barc.setVisible(true);
                prompt.setVisible(false);
                textTrigger = false;
            }
            
        });

        reset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent show) {

                piec.setVisible(false);
                barc.setVisible(false);
                prompt.setVisible(true);
                textTrigger = true;
            }
        });
       

       
        VBox bChart = new VBox(area);
        Scene scene = new Scene(bChart, 1000, 1000);
        stage.setTitle("Healthcare Coverage per Country");
        stage.setScene(scene);
        stage.setHeight(700);
        stage.setWidth(1400);

        piec.setLabelLineLength(50);
        piec.setLabelsVisible(true);
        piec.setStartAngle(180);
        
        stage.show();  
        
        
        
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

        
        


    }

    public static void ArrayReader(){
        for(int i = 0; i < Reader.returnSendCountry().size();i++){
            System.out.println("hi");

            insuranceData.add(Reader.returnAllData().get(i));
            System.out.println(i);
        }*/
    }
    
    

}