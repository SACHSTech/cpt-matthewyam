package cpt;

public class Datapoint extends Reader{

    private String country;
    private double percent;

    public Datapoint(String land, Double people) throws Exception{
        land = country;
        people = percent;
    }
    
    public String getCountry(){
        return country;
    }

    public double getPercent(){
        return percent;
    }

    public String toString(){
        return country + " " + percent;
    }
}