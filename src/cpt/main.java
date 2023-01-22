package cpt;

/**
 * This program creates two charts using JavaFX to display insurance coverage data around the world
 * @author matthewyam
 */

import javafx.application.Application;

public class Main {

    public static void main(String[] args) throws Exception{

        //Pulls charts and scene from charts
        Application.launch(Charts.class,args);
    }

}