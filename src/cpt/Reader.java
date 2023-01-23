package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart.Data;


public class Reader{

    /**
     * @param sendCountry - country name
     * @param sendPerdent - percent of people vaccinated
     */

    //Creates arrrays for my two values
    private ArrayList<String> sendCountry;
    private ArrayList<Double> sendPercent;
    private ArrayList<Datapoint> insuranceData;
    


    //Reader class
    public Reader() throws Exception{ 

        //Initialize my Arrays
        sendCountry = new ArrayList<String>();
        sendPercent = new ArrayList<Double>();
        insuranceData = new ArrayList<Datapoint>();


        //BufferReader to read data from my file
        BufferedReader read = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        //Loop to read my data until it reaches the end of the fie
        while((line = read.readLine()) != null){

            
            String[] addData = line.split(",");
           

            //Loop to add data to my arrays
            if(counter != 0){
                for(int i=0; i < 1; i++){
                    Double chartPercent = (Double.parseDouble(addData[1]));
                    String chartCountry = addData[0];
                    sendCountry.add(chartCountry);
                    sendPercent.add(chartPercent);
                }
              
            }
            counter++;
        }
        read.close();
}

    //Return my arrays
    public ArrayList<String> returnSendCountry(){
        return this.sendCountry;
    }
    public ArrayList<Double> returnSendPercent(){
        return this.sendPercent;
    }
    public List<Datapoint> returnInsuranceData(){
        return this.insuranceData;
    }

}
