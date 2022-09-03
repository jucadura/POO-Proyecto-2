/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto2p;

import static ec.edu.espol.proyecto2p.App.pathImg;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class VentanaInicioController implements Initializable {

    @FXML
    private ImageView imgCopa;
    @FXML
    private ImageView imgPortada;
    @FXML
    private Button consPartidosB;
    @FXML
    private Button consMundB;
    @FXML
    private VBox root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarImagenes();
        root.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public void cargarImagenes(){
        try{
            FileInputStream inputC = new FileInputStream(App.pathImg+"copa.png");
            Image imgC = new Image(inputC);
            imgCopa.setImage(imgC);
            FileInputStream inputP = new FileInputStream(App.pathImg+"portada.jpg");
            Image imgP = new Image(inputP);
            imgPortada.setImage(imgP);
        }catch (Exception e){
            e.printStackTrace();
            
        }
            
    }

    @FXML
    private void consultarPartidos(ActionEvent event) {
        try{
            FXMLLoader fxloader = new FXMLLoader(App.class.getResource("ConsultaPartidos.fxml"));
            Parent root = fxloader.load();
            Scene s = new Scene(root,640,400);
            Stage st = new Stage();
            st.setScene(s);
            st.show();
        }catch (IOException e){
            System.out.println("No se pudo crear la ventana");
        }
    }
    
}
