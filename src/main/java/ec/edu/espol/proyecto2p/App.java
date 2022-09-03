package ec.edu.espol.proyecto2p;

import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;
import modelo.partido;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;
    
    public static String pathImg = "src/main/resources/Images/";
    public static String pathFile = "src/main/resources/files/";
    public static ArrayList<partido> partidos; 
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmLoader=new FXMLLoader(App.class.getResource("VentanaInicio.fxml"));
        
        Parent root=fxmLoader.load();
        scene=new Scene(root,640,600);
        stage.setScene(scene);
        stage.show();
        
        
    }
    
    public static void main(String[] args) {
        try{
        FileInputStream input = new FileInputStream(new File(App.pathFile+"WorldCupMatchesBrasil2014.csv"));
        
        } catch (IOException e){
            e.printStackTrace();
        }
        
        launch();
    }
    
    
}