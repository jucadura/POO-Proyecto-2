/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import ec.edu.espol.proyecto2p.App;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Fase {
    private String nombre;
    private ArrayList<partido> partidos;
    
    public static ArrayList<Fase> obtenerFases(){
        ArrayList<Fase> fases = new ArrayList<>();
        ArrayList<String> nombres = new ArrayList<>();
        Fase Groups = new Fase("Groups",new ArrayList<>());
        fases.add(Groups);
        for(partido p: App.partidos){
            if(nombres.contains(p.getFase())==false){
                if(p.getFase().startsWith("Group")==false){
                    fases.add(new Fase(p.getFase(),crearFase(p.getFase())));
                    nombres.add(p.getFase());
                }
                else Groups.getPartidos().addAll(crearFase(p.getFase()));
            }
        }
        return fases;
    }

    public Fase(String nombre, ArrayList<partido> partidos) {
        this.nombre = nombre;
        this.partidos = partidos;
    }
    
    public static ArrayList<String> obtenerGrupos(){
        ArrayList<String> grupos = new ArrayList<>();
        for (partido f: App.partidos){
            if(grupos.contains(f.getFase())==false){
                if (f.getFase().startsWith("Group"))
                    grupos.add(f.getFase());
            }
        }
        return grupos;
    }
    public static ArrayList<partido> crearFase(String nombreFase){
        ArrayList<partido> fase = new ArrayList<>();
        for (partido p:App.partidos){
            if(p.getFase().equals(nombreFase))
                fase.add(p);
        }
        return fase;
    }
    public static ArrayList<Fase> crearGrupos(){
        ArrayList<Fase> grupos = new ArrayList<>();
        for(String g:App.grupos){
            ArrayList<partido> partidosG = new ArrayList<>();
            for (partido p: App.partidos){
                if(p.getFase().equals(g))
                    partidosG.add(p);
            }
            Fase gr = new Fase(g,partidosG);
            grupos.add(gr);
        }
        return grupos;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<partido> partidos) {
        this.partidos = partidos;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
    
    
    
    
}
