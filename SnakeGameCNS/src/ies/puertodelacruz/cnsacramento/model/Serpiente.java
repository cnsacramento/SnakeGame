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
    
    private double posicionX;
    private double posicionY;
    private LinkedList<Integer> cuerpo;
    
    /* CONSTRUCTORES */
    
    /**
     * Constructor por defecto sin parametros
     */
    public Serpiente(){}
    
    
    public Serpiente(double posicionX, double posicionY) {
        
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    /* METODOS */
    
    /**
     * Metodo encargado del movimiento de la serpiente
     */
    public void mover() {
        
    }
    
    /**
     * Metodo encargado de aumentar el tamanio de la serpiente 
     */
    public void aumentarTamanio() {
        
    }
    
    
    /* GETTERS Y SETTERS */
    
    public double getPosicionX() {
        return this.posicionX;
    }
    
    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }
    
    public double getPosicionY() {
        return this.posicionY;
    }
    
    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
    
    public LinkedList<Integer> getTamanio() {
        return this.cuerpo;
    }
    
    public void setTamanio(LinkedList<Integer> tamanio) {
        this.cuerpo = tamanio;
    }
}
