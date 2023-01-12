package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class filereader {

    public static void main (String[] args) throws IOException{
        
        ObservableList<dataset> chartData = FXCollections.observableArrayList();

        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));

        String line = "";
        int counter = 0;

        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");

            if(counter!=0){

                for(int i=0; i < addData.length;i++){
                    double chartPercent = (Double.parseDouble(addData[3]));
                    dataset myData = new dataset(addData[1], chartPercent);
                    chartData.add(myData);
                }
            }
            counter++;
        }
        System.out.println(chartData);
    }
}

