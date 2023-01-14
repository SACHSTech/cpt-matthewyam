package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;


public class readFile {
    
    //public ObservableList<datapoint> chartData = FXCollections.observableArrayList();
    private List<String> chartData = new ArrayList<String>();
    private List<Double> chartPercentage = new ArrayList<Double>();
    
    public void data() throws Exception{
    

        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");

            if(counter != 0){
                
                for(int i=0; i < 1; i++){

                    double chartPercent = (Double.parseDouble(addData[1]));
                    String chartCountry = addData[0];
                    chartData.add(chartCountry);
                    chartPercentage.add(chartPercent);
                }

            }
            counter++;
        }
        System.out.println(chartData);
       
    }

    public List returnChartData() {
        return chartData;

    }

    public List returnChartPercent(){
        return this.chartPercentage;
    }


}

