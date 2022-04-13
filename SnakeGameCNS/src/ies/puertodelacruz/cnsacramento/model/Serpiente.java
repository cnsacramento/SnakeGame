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
    private boolean bloquearContinuar = false;
    private boolean bloqueoUD = false;
    private boolean bloqueoLR = false;
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
                if(!bloqueoUD) {
                    this.posicionAnteriorY = this.posicionY;
                    this.posicionY -= pasos;
                    this.posicionAnteriorX = this.posicionX;
                    this.bloquearContinuar = true;
                }
                bloquearMovimiento("UD");
                break;
            case "DOWN":
                if(!bloqueoUD) {
                    this.posicionAnteriorY = this.posicionY;
                    this.posicionY += pasos;
                    this.posicionAnteriorX = this.posicionX;
                    this.bloquearContinuar = true;
                }
                bloquearMovimiento("UD");
                break;
            case "LEFT":
                if(!bloqueoLR) {
                    this.posicionAnteriorX = this.posicionX;
                    this.posicionX -= pasos;
                    this.posicionAnteriorY = this.posicionY;
                    this.bloquearContinuar = true;
                }
                bloquearMovimiento("LR");
                break;
            case "RIGHT":
                if(!bloqueoLR) {
                    this.posicionAnteriorX = this.posicionX;
                    this.posicionX += pasos;
                    this.posicionAnteriorY = this.posicionY;
                    this.bloquearContinuar = true;
                }
                bloquearMovimiento("LR");
                break;
            default:
                break;
        }
    }
    
    /**
     * Metodo que bloquea el movimiento segun la direccion de la serpiente
     * @param movimiento Movimiento que hace la serpiente 
     */
    public void bloquearMovimiento(String movimiento) {
        
        switch(movimiento) {
            case "UD":
                this.bloqueoUD = true;
                this.bloqueoLR = false;
                break;
            case "LR":
                this.bloqueoUD = false;
                this.bloqueoLR = true;
                break;
            case "CONT":
                this.bloquearContinuar = false;
            default:
                break;
        }
    }
    
    
    /**
     * Metodo encargado de mantener en movimiento la serpiente
     * @param pasos Cantidad de pasos que se mueve la serpiente
     */
    public void continuarMoviendo(double pasos) {
        
        if(!bloquearContinuar) {
            if (this.posicionX < this.posicionAnteriorX) {
                this.posicionAnteriorX = this.posicionX;
                this.posicionX -= pasos;
            } else if (this.posicionX > this.posicionAnteriorX) {
                this.posicionAnteriorX = this.posicionX;
                this.posicionX += pasos;
            } else if (this.posicionY < this.posicionAnteriorY) {
                this.posicionAnteriorY = this.posicionY;
                this.posicionY -= pasos;
            } else if (this.posicionY > this.posicionAnteriorY) {
                this.posicionAnteriorY = this.posicionY;
                this.posicionY += pasos;
            }
        }
        
        bloquearMovimiento("CONT");
        
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

    public boolean isBloqueoUD() {
        return bloqueoUD;
    }

    public void setBloqueoUD(boolean bloqueoUD) {
        this.bloqueoUD = bloqueoUD;
    }

    public boolean isBloqueoLR() {
        return bloqueoLR;
    }

    public void setBloqueoLR(boolean bloqueoLR) {
        this.bloqueoLR = bloqueoLR;
    }

    public boolean isBloquearContinuar() {
        return bloquearContinuar;
    }

    public void setBloquearContinuar(boolean bloquearContinuar) {
        this.bloquearContinuar = bloquearContinuar;
    }

    public LinkedList<Integer> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(LinkedList<Integer> cuerpo) {
        this.cuerpo = cuerpo;
    }
}
