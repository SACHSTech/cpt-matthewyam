package cpt;

public class dataset {

    private String country;
    private double percent;

    public dataset(String land, double percentage){
        country = land;
        percent = percentage;
    }
    
    public String getCountry(){
        return country;
    }

    public double getPercent(){
        return percent;
    }
}
