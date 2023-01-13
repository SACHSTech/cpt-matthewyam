package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;


public class readFile {
    
    public ObservableList<datapoint> chartData = FXCollections.observableArrayList();
    
    public void data() throws Exception{
    
        
        //ArrayList<dataset> chartData1 = new ArrayList();

        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");

            if(counter != 0){
                
                for(int i=0; i < 1; i++){

                    double chartPercent = (Double.parseDouble(addData[1]));
                    datapoint collectedData = new datapoint(addData[0], chartPercent);
                    chartData.add(collectedData);
                }

            }
            counter++;
        }
        System.out.println(chartData);
       
    }

    public ObservableList returnArrList(ObservableList chartData) {
        return chartData;
    }


}

