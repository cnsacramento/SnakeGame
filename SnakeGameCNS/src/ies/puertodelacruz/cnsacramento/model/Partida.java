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
    
    private String estado;
    private Escenario escenario;
    
    /* CONSTRUCTORES */
    
    /**
     * Constructor por defecto sin parametros
     */
    public Partida() {}
    
    /* METODOS */
    
    /**
     * Metodo que empieza la partida
     * @param tamanioX ancho del escenario
     * @param tamanioY alto del escenario
     */
    public void empezarPartida(double tamanioX, double tamanioY) {
        
        escenario = new Escenario(tamanioX,tamanioY);
    }
    
    /**
     * Metodo que finaliza la partida
     */
    public void finalizarPartida() {
        
    }
    
    /***
     * Metodo que indica que la partida se gano
     */
    public void ganarPartida() {
        
    }
    
    /**
     * Metodo que indica que la partida se perdio
     */
    public void perderPartida() {
        
    }
}
