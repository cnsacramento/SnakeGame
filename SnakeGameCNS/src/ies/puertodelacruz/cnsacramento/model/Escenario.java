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
    private Bloque manzana;
    //private double manzanaX;
    //private double manzanaY;
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
        
        detectarAutochoque();
        detectarMuro();
        detectarDigestion();
    }
    
    
    /**
     * Metodo encargado de generar la posicion de la manzana
     */
    public void generarManzana() {
        Random rnd = new Random();
        double manzanaX = rnd.nextInt( (int) (tamanioX / serpiente.getPasos()) ) * serpiente.getPasos();
        double manzanaY = rnd.nextInt((int) (tamanioY / serpiente.getPasos()) ) * serpiente.getPasos();
        manzana = new Bloque(manzanaX,manzanaY);
    }
    
    /**
     * Metodo encargado de detectar cuando la serpiente come
     */
    public void detectarDigestion() {
        
        if(serpiente.getCabeza().getPosicionX() == manzana.getPosicionX() && serpiente.getCabeza().getPosicionY() == manzana.getPosicionY()) {
            generarManzana();
            serpiente.aumentarTamanio();
        }else if(serpiente.getCabeza().getPosicionX() == manzana.getPosicionX() && serpiente.getCabeza().getPosicionY() == manzana.getPosicionY()) {
            generarManzana();
            serpiente.aumentarTamanio();
        }
    }
    
    /**
     * Metodo que detecta colision con limite de la ventana
     */
    public void detectarMuro() {
        
        if(serpiente.getCabeza().getPosicionX() >= this.tamanioX || serpiente.getCabeza().getPosicionX() < 0){
            this.colisionDetectada = true;
            serpiente.bloquearMovimiento("TECLAS");
        }else if(serpiente.getCabeza().getPosicionY() >= this.tamanioY || serpiente.getCabeza().getPosicionY() < 0) {
            this.colisionDetectada = true;
            serpiente.bloquearMovimiento("TECLAS");
        }
    }
    
    /**
     * Metodo que detecta si la serpiente se choca consigo misma
     */
    public void detectarAutochoque() {
        
        for (int i = 1; i < serpiente.getCuerpo().size(); i++) {
            if (serpiente.getCabeza().getPosicionX() == serpiente.getCuerpo().get(i).getPosicionX() && serpiente.getCabeza().getPosicionY() == serpiente.getCuerpo().get(i).getPosicionY()) {
                this.colisionDetectada = true;
                serpiente.bloquearMovimiento("TECLAS");
            }
        }
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

    public Bloque getManzana() {
        return manzana;
    }

    public void setManzana(Bloque manzana) {
        this.manzana = manzana;
    }
    
    
    /*
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
    }*/
    
    public boolean getColisionDetectada() {
        return this.colisionDetectada;
    }
    
    public void setColisionDetectada(boolean colisionDetectada) {
        this.colisionDetectada = colisionDetectada;
    } 
}
