/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.model;

import java.util.LinkedList;

/**
 * 
 * @author christian
 */
public class Serpiente {
    
    private int posicionX;
    private int posicionY;
    private LinkedList<Integer> tamanio;
    
    
    /* METODOS */
    
    /**
     * Metodo encargado del movimiento de la serpiente
     */
    public void mover() {
        
    }
    
    /**
     * Metodo encargado de aumentar el tamanio de la serpiente 
     */
    public void aumentarTamnio() {
        
    }
    
    
    /* GETTERS Y SETTERS */
    
    public int getPosicionX() {
        return this.posicionX;
    }
    
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }
    
    public int getPosicionY() {
        return this.posicionY;
    }
    
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
    public LinkedList<Integer> getTamanio() {
        return this.tamanio;
    }
    
    public void setTamanio(LinkedList<Integer> tamanio) {
        this.tamanio = tamanio;
    }
}
