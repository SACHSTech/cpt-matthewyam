package cpt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class filereader {

    public static List<String> country = new ArrayList<>();
    static ArrayList<Double> percent = new ArrayList<>();
    String line = ""; 

    public void hpcFile() throws IOException{
        BufferedReader readData = new BufferedReader(new FileReader("src/cpt/hpc.csv"));
        while((line = readData.readLine()) != null){           
            String[] addData = line.split(",");
        }  
    }
}

