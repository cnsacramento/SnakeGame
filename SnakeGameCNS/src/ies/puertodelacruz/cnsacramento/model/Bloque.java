/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.model;

/**
 *
 * @author christian
 */
public class Bloque {
    
    private double posicionX;
    private double posicionY;
    private double posicionAnteriorX;
    private double posicionAnteriorY;

    public Bloque(){}
    
    public Bloque(double posicionX, double posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public Bloque(double posicionX, double posicionY, double posicionAnteriorX, double posicionAnteriorY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.posicionAnteriorX = posicionAnteriorX;
        this.posicionAnteriorY = posicionAnteriorY;
    }
    
    

    public double getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(double posicionX) {
        this.posicionX = posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(double posicionY) {
        this.posicionY = posicionY;
    }

    public double getPosicionAnteriorX() {
        return posicionAnteriorX;
    }

    public void setPosicionAnteriorX(double posicionAnteriorX) {
        this.posicionAnteriorX = posicionAnteriorX;
    }

    public double getPosicionAnteriorY() {
        return posicionAnteriorY;
    }

    public void setPosicionAnteriorY(double posicionAnteriorY) {
        this.posicionAnteriorY = posicionAnteriorY;
    }
    
    
    
    
}
