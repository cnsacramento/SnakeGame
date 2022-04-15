/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.model;


/**
 * Clase encargada de gestionar la partida que se juega
 * @author christian
 */
public class Partida {
    
    private Escenario escenario;
    
    /* CONSTRUCTORES */
    
    /**
     * Constructor por defecto sin parametros
     */
    public Partida() {}
    
    /* METODOS */
    
    /**
     * Metodo que empieza la partida
     * @param escenario Escenario sobre el que se juega la partida
     */
    public void empezarPartida(Escenario escenario) {
        
        this.escenario = escenario;
        escenario.generarObstaculos();
        escenario.generarVariasManzanas();
    }
    
    /* GETTERS Y SETTERS */
    
    public Escenario getEscenario() {
        return this.escenario;
    }
    
    public void setEscenario(Escenario escenario) {
        this.escenario = escenario;
    }
}
