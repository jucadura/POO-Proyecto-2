/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyecto2p;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modelo.Fase;
import modelo.partido;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ConsultaPartidosController implements Initializable {

    @FXML
    private ComboBox<Fase> faseBox;
    @FXML
    private ComboBox<Fase> grupoBox;
    @FXML
    private ComboBox<String> equipo1Box;
    @FXML
    private ComboBox<String> equipo2Box;
    @FXML
    private Button bConsultar;
    @FXML
    private VBox vBoxGrande;
    @FXML
    private VBox vBoxShow;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mostrarFases();
    }    
    
    public void mostrarFases(){
        faseBox.getItems().setAll(App.fases);
    }
    
    @FXML
    private void mostrarGrupos(ActionEvent event) {
        ArrayList<String> equipos = new ArrayList<>();
        for(Fase f: App.groups){
            if (f.getNombre().equals(grupoBox.getValue().getNombre())){
                for (partido p: f.getPartidos()){
                    if(equipos.contains(p.getNombreLocal())==false)
                        equipos.add(p.getNombreLocal());
                    if(equipos.contains(p.getNombreVisita())==false)
                        equipos.add(p.getNombreVisita());
                }
            }                    
        }
        Collections.sort(equipos);
        equipo1Box.getItems().setAll(equipos);
    }        
    
    

    @FXML
    private void obtenerEquipo2(ActionEvent event) {
        String equipo1 = equipo1Box.getValue();
        ArrayList<partido> jugados = new ArrayList<>();
        ArrayList<String> equipos2 = new ArrayList<>();
        for(partido p:faseBox.getValue().getPartidos()){
            if(p.getNombreLocal().equals(equipo1)){
                jugados.add(p);
                if(equipos2.contains(p.getNombreVisita())==false)
                    equipos2.add(p.getNombreVisita());
            }
            else if(p.getNombreVisita().equals(equipo1)){
                jugados.add(p);
                if(equipos2.contains(p.getNombreLocal())==false)
                    equipos2.add(p.getNombreLocal());
            }
        }
        Collections.sort(equipos2);
        equipo2Box.getItems().setAll(equipos2);
    }

    @FXML
    private void consultarPartido(ActionEvent event) {
        vBoxShow.getChildren().removeAll(vBoxShow.getChildren());
        String e1 = equipo1Box.getValue();
        String e2 = equipo2Box.getValue();
        partido par = null;
        for(partido p: faseBox.getValue().getPartidos()){
            if (p.getNombreLocal().equals(e1)&&p.getNombreVisita().equals(e2))
                par = p;
            else if(p.getNombreLocal().equals(e2)&&p.getNombreVisita().equals(e1))
                par = p;
        }
       Label lr = new Label("Resultados del Partido");
       vBoxShow.getChildren().add(lr);
       Label lf = new Label(par.getFecha());
       Label fase = new Label(par.getFase());
       Label city = new Label(par.getCiudad());
       Label estadio = new Label(par.getEstadio());
       HBox fecha = new HBox();
       fecha.getChildren().add(lf);
       fecha.setAlignment(Pos.CENTER_LEFT);
       fecha.setPadding(new Insets(0,0,0,20));
       vBoxShow.getChildren().add(fecha);
       Label linea = new Label("_______________________________________________________________________________________________________");
       vBoxShow.getChildren().add(linea);
       VBox descrip = new VBox();
       descrip.getChildren().add(fase);
       descrip.getChildren().add(estadio);
       descrip.getChildren().add(city);
       HBox part = new HBox();
       VBox puntaje = new VBox();
       HBox goles = new HBox();
       Label f = new Label("Final Del Partido");
       Label l1 = new Label(par.getNombreLocal());
       Label l2 = new Label(par.getNombreVisita());
       Label score = new Label(String.valueOf(par.getGolLocal())+"-"+String.valueOf(par.getGolVisita())); 
       goles.getChildren().add(l1);
       goles.getChildren().add(score);
       goles.getChildren().add(l2);
       goles.setSpacing(20);
       part.setSpacing(50);
       goles.setAlignment(Pos.CENTER);
       part.setPadding(new Insets(0,0,0,20));
       part.getChildren().add(descrip);
       puntaje.getChildren().add(f);
       puntaje.getChildren().add(goles);
       puntaje.setAlignment(Pos.CENTER);
       part.getChildren().add(puntaje);
       vBoxShow.getChildren().add(part);
       vBoxShow.setAlignment(Pos.CENTER);
       vBoxShow.setPadding(new Insets(0,0,0,20));
    }

    @FXML
    private void mostrarEquipos(ActionEvent event) {
        if(faseBox.getValue().getNombre().equals("Groups")){
            grupoBox.getItems().setAll(App.groups);
        }    
        else {                
            grupoBox.getItems().removeAll(grupoBox.getItems());
            ArrayList<String> equipos = new ArrayList<>();
            for(Fase f: App.fases){
                if (f.getNombre().equals(faseBox.getValue().getNombre())){
                    for (partido p: f.getPartidos()){
                        if(equipos.contains(p.getNombreLocal())==false)
                            equipos.add(p.getNombreLocal());
                        if(equipos.contains(p.getNombreVisita())==false)
                            equipos.add(p.getNombreVisita());
                    }
                           
                }                    
            }
            Collections.sort(equipos);
            equipo1Box.getItems().setAll(equipos);
            }
    }

   
}
