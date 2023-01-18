//used to be readfile

package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.XYChart.Series;


public class Reader{
    
    private ArrayList<Datapoint> allData;
    private ArrayList<String> sendCountry;
    private ArrayList<Double> sendPercent;
    
    private static String testSend = "Hi";
    static XYChart.Series dataImporter = new XYChart.Series();

    
    public Reader() throws Exception{ 

        allData = new ArrayList<Datapoint>();
        sendCountry = new ArrayList<String>();
        sendPercent = new ArrayList<Double>();

        BufferedReader read = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = read.readLine()) != null){

            String[] addData = line.split(",");

            if(counter != 0){
                for(int i=0; i < 1; i++){
                    Double chartPercent = (Double.parseDouble(addData[1]));
                    String chartCountry = addData[0];
                    
                    Datapoint combinedData = new Datapoint(chartCountry, chartPercent);
                    allData.add(combinedData);
                    sendCountry.add(chartCountry);
                    sendPercent.add(chartPercent);
                    dataImporter.getData().add(new XYChart.Data(chartCountry,chartPercent));
                    
                }
              
            }
            counter++;
        }
        read.close();
       
    }

    public ArrayList<Datapoint> returnAllData(){
        return this.allData;
    }

    public static String returnTEst(){
        return testSend;
    }

    public ArrayList<String> returnSendCountry(){
        return this.sendCountry;
    }
    public  ArrayList<Double> returnSendPercent(){
        return this.sendPercent;
    }

    public XYChart.Series returnExWhy(){
        return dataImporter;
    }

/**
 
    public void data() throws Exception{ 

        BufferedReader read = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = read.readLine()) != null){
            
            String[] addData = line.split(",");

            if(counter != 0){
                
                for(int i=0; i < 1; i++){

                    double chartPercent = (Double.parseDouble(addData[1]));
                    String chartCountry = addData[0];
                    Datapoint combinedData = new Datapoint(chartCountry, chartPercent);
                    allData.add(combinedData);
                }

            }
            counter++;
        }
        //  System.out.println(chartData);




         if(counter != 0){
                
                for(int i=0; i < 1; i++){

                    chartPercent = (Double.parseDouble(addData[1]));
                    chartCountry = addData[0];
                    
                    allData.add(combinedData);
                }

            }
            counter++;
       
    }
    */
}

