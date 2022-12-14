/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import ec.edu.espol.proyecto2p.App;
import static ec.edu.espol.proyecto2p.App.pathFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class partido {
//    Year|Datetime|Stage|Stadium|City|Home Team Name|Home Team Goals|Away Team Goals|Away Team Name|
//    Win conditions|Attendance|Half-time Home Goals|Half-time Away Goals|Referee|Assistant 1|Assistant 2
//    |RoundID|MatchID|Home Team Initials|Away Team Initials
    private int anio;
    private String fecha;
    private String fase;
    private String estadio;
    private String ciudad;
    private String nombreLocal;
    private int golLocal;
    private int golVisita;
    private String nombreVisita; 
    private String condicion;
    private int expectadores;
    private int mitadGolLocal;
    private int mitadGolVisita;
    private String arbitro;
    private String asistente1;
    private String asistente2;
    private String idRonda;
    private String idPartido;
    private String inicialesLocal;
    private String inicialesVisita;

    public partido(int anio, String fecha, String fase, String estadio, String ciudad, String nombreLocal, int golLocal, int golVisita, String nombreVisita, String condicion, int expectadores, int mitadGolLocal, int mitadGolVisita, String arbitro, String asistente1, String asistente2, String idRonda, String idPartido, String inicialesLocal, String inicialesVisita) {
        this.anio = anio;
        this.fecha = fecha;
        this.fase = fase;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.nombreLocal = nombreLocal;
        this.golLocal = golLocal;
        this.golVisita = golVisita;
        this.nombreVisita = nombreVisita;
        this.condicion = condicion;
        this.expectadores = expectadores;
        this.mitadGolLocal = mitadGolLocal;
        this.mitadGolVisita = mitadGolVisita;
        this.arbitro = arbitro;
        this.asistente1 = asistente1;
        this.asistente2 = asistente2;
        this.idRonda = idRonda;
        this.idPartido = idPartido;
        this.inicialesLocal = inicialesLocal;
        this.inicialesVisita = inicialesVisita;
    }

    public partido(int anio, String fecha, String fase, String estadio, String ciudad, String nombreLocal, int golLocal, int golVisita, String nombreVisita, String idRonda, String idPartido) {
        this.anio = anio;
        this.fecha = fecha;
        this.fase = fase;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.nombreLocal = nombreLocal;
        this.golLocal = golLocal;
        this.golVisita = golVisita;
        this.nombreVisita = nombreVisita;
        this.idRonda = idRonda;
        this.idPartido = idPartido;
    }
    

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreLocal() {
        return nombreLocal;
    }

    public void setNombreLocal(String nombreLocal) {
        this.nombreLocal = nombreLocal;
    }

    public int getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(int golLocal) {
        this.golLocal = golLocal;
    }

    public int getGolVisita() {
        return golVisita;
    }

    public void setGolVisita(int golVisita) {
        this.golVisita = golVisita;
    }

    public String getNombreVisita() {
        return nombreVisita;
    }

    public void setNombreVisita(String nombreVisita) {
        this.nombreVisita = nombreVisita;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public int getExpectadores() {
        return expectadores;
    }

    public void setExpectadores(int expectadores) {
        this.expectadores = expectadores;
    }

    public int getMitadGolLocal() {
        return mitadGolLocal;
    }

    public void setMitadGolLocal(int mitadGolLocal) {
        this.mitadGolLocal = mitadGolLocal;
    }

    public int getMitadGolVisita() {
        return mitadGolVisita;
    }

    public void setMitadGolVisita(int mitadGolVisita) {
        this.mitadGolVisita = mitadGolVisita;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public String getAsistente1() {
        return asistente1;
    }

    public void setAsistente1(String asistente1) {
        this.asistente1 = asistente1;
    }

    public String getAsistente2() {
        return asistente2;
    }

    public void setAsistente2(String asistente2) {
        this.asistente2 = asistente2;
    }

    public String getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(String idRonda) {
        this.idRonda = idRonda;
    }

    public String getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(String idPartido) {
        this.idPartido = idPartido;
    }

    public String getInicialesLocal() {
        return inicialesLocal;
    }

    public void setInicialesLocal(String inicialesLocal) {
        this.inicialesLocal = inicialesLocal;
    }

    public String getInicialesVisita() {
        return inicialesVisita;
    }

    public void setInicialesVisita(String inicialesVisita) {
        this.inicialesVisita = inicialesVisita;
    }
    
    
        
    public static ArrayList<partido> obtenerPartidos(){
        ArrayList<partido> partidos = new ArrayList<>();
        try{
            Scanner sc = new Scanner(new File(App.pathFile+"WorldCupMatchesBrasil2014.csv"));
                while(sc.hasNextLine()){
                       String line = sc.nextLine();
                    if (line.startsWith("2014")){
                        String[] linea = line.split("|");
                        String l=null;
                        StringBuilder sb = new StringBuilder();
                        for(int i=0;i<linea.length;i++){
                            if(linea[i].equals("|"))
                                sb.append(";");
                            else sb.append(linea[i]);
                            
                        }
                        l = sb.toString();
                        String[] lineas = l.split(";");
                        //(int anio 0, String fecha1, String fase2, String estadio3, String ciudad4, String nombreLocal5, int golLocal6, int golVisita7, String nombreVisita8, String idRonda 16, String idPartido17
                        partido p = new partido(Integer.valueOf(lineas[0].trim()),lineas[1].trim(),lineas[2].trim(),lineas[3].trim(),lineas[4].trim(),lineas[5].trim(),Integer.valueOf(lineas[6].trim()),Integer.valueOf(lineas[7].trim()),lineas[8].trim(),lineas[16].trim(),lineas[17].trim());
                        partidos.add(p);
                    }
                }
                sc.close();
            }catch (FileNotFoundException e){
                System.out.println("no se encontro el archivo");
            }
            return partidos;
    }
    
    
    
    
}
