//used to be readfile

package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;


public class Reader {
    
    private static ArrayList<Datapoint> allData;
    
    public Reader() throws Exception{ 

        BufferedReader read = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = read.readLine()) != null){

            String[] addData = line.split(",");

            Double chartPercent = (Double.parseDouble(addData[1]));
            String chartCountry = addData[0];
            
            Datapoint combinedData = new Datapoint(chartCountry, chartPercent);
            allData.add(combinedData);
        }
        read.close();
       
    }

    public static ArrayList returnAllData(){
        return allData;
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

