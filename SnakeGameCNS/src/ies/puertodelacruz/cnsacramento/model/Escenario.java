/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.model;

import java.util.Random;

/**
 * Clase encargada del escenario
 * @author christian
 */
public class Escenario {
    
    private Serpiente serpiente;
    private double tamanioX;
    private double tamanioY;
    private double manzanaX;
    private double manzanaY;
    private boolean colisionDetectada = false;
    
    
    /* CONSTRUCTORES */
    
    /**
     * Constructor por defecto sin parametros
     */
    public Escenario(){}
    
    /**
     * Constructor con dos parametros
     * @param tamanioX Ancho del escenario
     * @param tamanioY Alto del escenario
     */
    public Escenario(double tamanioX, double tamanioY) {
        
        this.tamanioX = tamanioX;
        this.tamanioY = tamanioY;
        double posicionCentralX = this.tamanioX / 2;
        double posicionCentralY = this.tamanioY / 2;
        serpiente = new Serpiente(posicionCentralX,posicionCentralY);
    }
    
    /**
     * Constructor que recibe 3 parametros
     * @param tamanioX Ancho del escenario
     * @param tamanioY Alto del escenario
     * @param pasosSerpiente Cantidad de pasos que se mueve la serpiente
     */
    public Escenario(double tamanioX, double tamanioY, double pasosSerpiente) {
        this.tamanioX = tamanioX;
        this.tamanioY = tamanioY;
        double posicionCentralX = this.tamanioX / 2;
        double posicionCentralY = this.tamanioY / 2;
        serpiente = new Serpiente(posicionCentralX, posicionCentralY, pasosSerpiente);
    }
    
    /* METODOS */
    
    /*
    * Metodo encargado de detectar colisiones 
    */
    public void detectarColision() {
        
        if(serpiente.getPosicionX() >= this.tamanioX || serpiente.getPosicionX() < 0){
            this.colisionDetectada = true;
        }else if(serpiente.getPosicionY() >= this.tamanioY || serpiente.getPosicionY() < 0) {
            this.colisionDetectada = true;
        }
        
        if(serpiente.getPosicionX() == manzanaX && serpiente.getPosicionY() == manzanaY) {
            generarManzana();
        }
    }
    
    
    /**
     * Metodo encargado de generar la posicion de la manzana
     */
    public void generarManzana() {
        Random rnd = new Random();
        manzanaX = rnd.nextInt( (int) (tamanioX / serpiente.getPasos()) ) * serpiente.getPasos();
        manzanaY = rnd.nextInt((int) (tamanioY / serpiente.getPasos()) ) * serpiente.getPasos();
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
    
    public double getTamanioX() {
        return this.tamanioX;
    } 
    
    public void setTamanioX(int tamanioX) {
        this.tamanioX = tamanioX;
    }
    
    public double getTamanioY() {
        return this.tamanioY;
    }
    
    public void setTamanioY(int tamanioY) {
        this.tamanioY = tamanioY;
    }

    public double getManzanaX() {
        return manzanaX;
    }

    public void setManzanaX(double manzanaX) {
        this.manzanaX = manzanaX;
    }

    public double getManzanaY() {
        return manzanaY;
    }

    public void setManzanaY(double manzanaY) {
        this.manzanaY = manzanaY;
    }
    
    public boolean getColisionDetectada() {
        return this.colisionDetectada;
    }
    
    public void setColisionDetectada(boolean colisionDetectada) {
        this.colisionDetectada = colisionDetectada;
    } 
}
