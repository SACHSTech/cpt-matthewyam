package cpt;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class barchart{

    public static void main(String[] args) throws Exception{

        ArrayList<String> country = new ArrayList<>();
        ArrayList<Double> percent = new ArrayList<>();

        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
        String line = "";
       
        while((line = readData.readLine()) != null){
            
            String[] addData = line.split(",");
            
            
            //String dataCollector = addData[1];
            country.add(addData[1]);
            
            //Double numCollector = (Double.parseDouble(addData[3]));
            percent.add(Double.parseDouble(addData[3]));

            
        }

        System.out.println(country);
        System.out.println(percent);
        //System.out.println(country);
        //System.out.println(percent);

        
    }

}


