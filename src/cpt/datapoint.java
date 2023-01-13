package cpt;

public class datapoint extends readFile{

    private String country;
    private double percent;

    public datapoint(String land, double percentage){
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
