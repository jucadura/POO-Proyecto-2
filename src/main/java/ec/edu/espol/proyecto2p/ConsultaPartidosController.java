/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto2p;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsultaPartidosController implements Initializable {

    @FXML
    private ComboBox<String> faseBox;
    @FXML
    private ComboBox<String> grupoBox;
    @FXML
    private ComboBox<String> equipo1Box;
    @FXML
    private ComboBox<String> equipo2Box;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarFases();
    }    
    
    public void mostrarFases(){
        faseBox.getItems().setAll("Grupos","Ronda de 16", "Cuartos de Final","Semifinales","Final");
    }
}
