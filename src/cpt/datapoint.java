package cpt;

public class Datapoint extends Reader{

    private String country;
    private double percent;

    public Datapoint(String land, double percentage) throws Exception{
        this.country = land;
        this.percent = percentage;
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
