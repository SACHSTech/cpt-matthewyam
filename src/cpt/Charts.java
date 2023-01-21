package cpt;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;

public class Charts extends Application{

    Reader dataGrabber;

    int count = 0;

    static boolean textTrigger = false;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        //Pull data from bufferreader file
        dataGrabber = new Reader();
        dataGrabber.returnSendCountry();
        dataGrabber.returnSendPercent();

        //Creates a Gridpane to place objeccts
        GridPane area = new GridPane();
        area.setPadding(new Insets(10, 10, 10, 10)); 
        area.setHgap(1);
        area.setGridLinesVisible(false);
        area.setVisible(true);

        //Creates a Menu Bar and adds items to it
        Menu charts = new Menu("Charts");
        MenuItem bar = new MenuItem("Bar Chart");
        MenuItem pie = new MenuItem("Pie Chart");
        MenuItem both = new MenuItem("Both Charts");
        MenuItem confirmReset = new MenuItem("Confirm Reset");
        charts.getItems().add(bar);
        charts.getItems().add(pie);
        charts.getItems().add(both);
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(charts);
        menuBar.setMaxWidth(65);
        area.add(menuBar, 0, 0);

        Button clear = new Button("Reset");
        clear.setMaxWidth(65);
        area.add(clear, 0, 1);

        
        //Text
        Text prompt = new Text();
        Text pick = new Text();
        prompt.setText("Percentage of Population Covered by Health Insurance");
        pick.setText("  ↑ Select a Chart");
        pick.setFont(Font.font(30));
        area.add(pick, 0, 2);
        prompt.setVisible(true);
        pick.setVisible(true);

        if(textTrigger = true){
            pick.setVisible(true);
        }
        

       //Bar chart
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Percent");

        XYChart.Series series1 = new XYChart.Series();

        BarChart<String,Number> barc = new BarChart<String,Number>(xAxis,yAxis);

        barc.getData().addAll(series1);     
       
        for(int loop = 0; loop  < dataGrabber.returnSendCountry().size(); loop++){
            series1.getData().add(new XYChart.Data(dataGrabber.returnSendCountry().get(loop), dataGrabber.returnSendPercent().get(loop)));
        }

        
        for (final Series<String, Number> series : barc.getData()) {
            for (final Data<String, Number> data : series.getData()) {
                Tooltip barGrabber = new Tooltip(data.getXValue() +": " + data.getYValue() + "%");
                Tooltip.install(data.getNode(), barGrabber);			
            }
        }
        

        barc.setTitle("Percentage of Population Covered by Health Insurance");


        //Pie Chart

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        
        for(int pieLoop = 0; pieLoop < dataGrabber.returnSendCountry().size(); pieLoop++){
            pieChartData.add(new PieChart.Data(dataGrabber.returnSendCountry().get(pieLoop), dataGrabber.returnSendPercent().get(pieLoop)));
        }
        
        
        //Creates Piechart
        PieChart piec = new PieChart(pieChartData);
        piec.setData(pieChartData);
        piec.setTitle("Percentage of Population Covered by Health Insurance");
        piec.setClockwise(true);

        piec.getData().forEach(data -> {
            String percentGrabber = String.format("%.2f%%", data.getPieValue());
            Tooltip showPiePercent = new Tooltip(data.getName() +": " + percentGrabber);
            Tooltip.install(data.getNode(), showPiePercent);
        });

        
        piec.setLabelLineLength(50);
        piec.setLabelsVisible(true);
        piec.setStartAngle(180);


        area.add(barc, 0, 7);
        barc.setVisible(false);
        area.add(piec, 1, 7);
        piec.setVisible(false);
        piec.setMinSize(700,700);

        bar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent showBar) {

                stage.setTitle("Bar Chart");
                piec.setVisible(false);
                barc.setVisible(true);
                pick.setVisible(false);
                textTrigger = false;
                
            }
            
        });

        pie.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent show) {
                stage.setTitle("Pie Chart");
                
                piec.setVisible(true);
                barc.setVisible(false);
                pick.setVisible(false);
                textTrigger = false;
            }
            
        });

        both.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent show) {
                stage.setTitle("Both Charts");
                
                piec.setVisible(true);
                barc.setVisible(true);
                pick.setVisible(false);
                textTrigger = false;
            }
            
        });

        clear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent show) {

                piec.setVisible(false);
                barc.setVisible(false);
                pick.setVisible(true);
                textTrigger = true;
            }
        });


        
       

       
        VBox bChart = new VBox(area);
        Scene scene = new Scene(bChart, 1920, 1080);
        stage.setTitle("Insurance Coverage");
        stage.setScene(scene);
        stage.setHeight(785);
        stage.setWidth(1200);
        
        stage.show();  
 
    } 
}
