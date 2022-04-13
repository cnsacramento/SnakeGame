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
    private double posicionAnteriorX;
    private double posicionAnteriorY;
    private boolean enMovimiento = false;
    private LinkedList<Integer> cuerpo;
    
    /* CONSTRUCTORES */
    
    /**
     * Constructor por defecto sin parametros
     */
    public Serpiente(){}
    
    /**
     * Constructor con 2 parametros
     * @param posicionX Posicion X inicial
     * @param posicionY Posicion Y inicial
     */
    public Serpiente(double posicionX, double posicionY) {
        
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    /* METODOS */
    
    /**
     * Metodo encargado del movimiento de la serpiente
     * @param accion Direccion de la serpiente
     * @param pasos Pixeles de movimiento
     */
    public void mover(String accion, double pasos) {
        
        this.enMovimiento = true;
        switch(accion) {
            case "UP": 
                this.posicionAnteriorY = this.posicionY;
                this.posicionY -= pasos;
                this.posicionAnteriorX = this.posicionX;
                break;
            case "DOWN":
                this.posicionAnteriorY = this.posicionY;
                this.posicionY += pasos;
                this.posicionAnteriorX = this.posicionX;
                break;
            case "LEFT":
                this.posicionAnteriorX = this.posicionX;
                this.posicionX -= pasos;
                this.posicionAnteriorY = this.posicionY;
                break;
            case "RIGHT":
                this.posicionAnteriorX = this.posicionX;
                this.posicionX += pasos;
                this.posicionAnteriorY = this.posicionY;
                break;
            default:
                break;
        }
    }
    
    /**
     * Metodo encargado de mantener en movimiento la serpiente
     * @param pasos Cantidad de pasos que se mueve la serpiente
     */
    public void continuarMoviendo(double pasos) {
        
        if(this.posicionX < this.posicionAnteriorX) {
            this.posicionAnteriorX = this.posicionX;
            this.posicionX -= pasos;
        }else if (this.posicionX > this.posicionAnteriorX) {
            this.posicionAnteriorX = this.posicionX;
            this.posicionX += pasos;
        }else if(this.posicionY < this.posicionAnteriorY) {
            this.posicionAnteriorY = this.posicionY;
            this.posicionY -= pasos;
        }else if(this.posicionY > this.posicionAnteriorY) {
            this.posicionAnteriorY = this.posicionY;
            this.posicionY += pasos;
        }
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
    
    public double getPosicionAnteriorX() {
        return this.posicionAnteriorX;
    }
    
    public void setPosicionAnteriorX(double posicionAnteriorX) {
        this.posicionAnteriorX = posicionAnteriorX;
    }
    
    public double getPosicionAnteriorY() {
        return this.posicionAnteriorY;
    }
    
    public void setPosicionAnteriorY(double posicionAnteriorY) {
        this.posicionAnteriorY = posicionAnteriorY;
    }
    
    public boolean getEnMovimiento(){
        return this.enMovimiento;
    }
    
    public void setEnMovimiento(boolean enMovimiento) {
        this.enMovimiento = enMovimiento;
    }
    
    public LinkedList<Integer> getTamanio() {
        return this.cuerpo;
    }
    
    public void setTamanio(LinkedList<Integer> tamanio) {
        this.cuerpo = tamanio;
    }
}
