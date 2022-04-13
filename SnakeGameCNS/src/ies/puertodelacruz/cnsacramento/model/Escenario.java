/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.model;

/**
 * Clase encargada del escenario
 * @author christian
 */
public class Escenario {
    
    private Serpiente serpiente;
    private double tamanioX;
    private double tamanioY;
    
    
    /* CONSTRUCTORES */
    
    /**
     * Constructor por defecto sin parametros
     */
    public Escenario(){}
    
    public Escenario(double tamanioX, double tamanioY) {
        
        this.tamanioX = tamanioX;
        this.tamanioY = tamanioY;
        double posicionCentralX = tamanioX / 2;
        double posicionCentralY = tamanioY / 2;
        serpiente = new Serpiente(posicionCentralX,posicionCentralY);
    }
    /* METODOS */
    
    /*
    * Metodo encargado de detectar colisiones 
    */
    public void detectarColision() {
        
    }
    
    /**
     * Metodo encargado de detectar cuando la serpiente come
     */
    public void detectarDigestion() {
        
    }
    
    /* GETTERS Y SETTERS */
    
    public Serpiente getSerpiente() {
        return this.serpiente;
    }
    
    public void setSerpiente(Serpiente serpiente) {
        this.serpiente = serpiente;
    }
    
    public int getTamanioX() {
        return this.tamanioX;
    } 
    
    public void setTamanioX(int tamanioX) {
        this.tamanioX = tamanioX;
    }
    
    public int getTamanioY() {
        return this.tamanioY;
    }
    
    public void setTamanioY(int tamanioY) {
        this.tamanioY = tamanioY;
    }
}
