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
    
    /*private double posicionX;
    private double posicionY;
    private double posicionAnteriorX;
    private double posicionAnteriorY;*/
    private Bloque cabeza;
    private double pasos;
    private boolean enMovimiento = false;
    private boolean bloquearContinuar = false;
    private boolean bloqueoUD = false;
    private boolean bloqueoLR = false;
    private boolean bloquearTeclas = false;
    private LinkedList<Bloque> cuerpo = new LinkedList<Bloque>();
    
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
        
        cabeza = new Bloque(posicionX,posicionY);
        cuerpo.add(cabeza);
    }
    
    /**
     * Constructor que recibe 3 parametros
     * @param posicionX Posicion X inicial
     * @param posicionY Posicion Y inicial
     * @param pasos Numero de pasos que avanza la serpiente
     */
    public Serpiente(double posicionX, double posicionY, double pasos) {
        this(posicionX,posicionY);
        this.pasos = pasos;
    }
    
    /* METODOS */
    
    /**
     * Metodo encargado del movimiento de la serpiente
     * @param accion Direccion de la serpiente
     */
    public void mover(String accion) {
        
        this.enMovimiento = true;
        
        if(!bloquearTeclas) {
            
            switch(accion) {
                case "UP": 
                    if(!bloqueoUD) {
                        cabeza.setPosicionAnteriorY(cabeza.getPosicionY());
                        cabeza.setPosicionY(cabeza.getPosicionY() - pasos);
                        cabeza.setPosicionAnteriorX(cabeza.getPosicionX());
                        refrescarPosiciones();
                        this.bloquearContinuar = true;
                    }
                    bloquearMovimiento("UD");
                    break;
                case "DOWN":
                    if(!bloqueoUD) {
                        cabeza.setPosicionAnteriorY(cabeza.getPosicionY());
                        cabeza.setPosicionY(cabeza.getPosicionY() + pasos);
                        cabeza.setPosicionAnteriorX(cabeza.getPosicionX());
                        refrescarPosiciones();
                        this.bloquearContinuar = true;
                    }
                    bloquearMovimiento("UD");
                    break;
                case "LEFT":
                    if(!bloqueoLR) {
                        cabeza.setPosicionAnteriorX(cabeza.getPosicionX());
                        cabeza.setPosicionX(cabeza.getPosicionX() - pasos);
                        cabeza.setPosicionAnteriorY(cabeza.getPosicionY());
                        refrescarPosiciones();
                        this.bloquearContinuar = true;
                    }
                    bloquearMovimiento("LR");
                    break;
                case "RIGHT":
                    if(!bloqueoLR) {
                        cabeza.setPosicionAnteriorX(cabeza.getPosicionX());
                        cabeza.setPosicionX(cabeza.getPosicionX() + pasos);
                        cabeza.setPosicionAnteriorY(cabeza.getPosicionY());
                        refrescarPosiciones();
                        this.bloquearContinuar = true;
                    }
                    bloquearMovimiento("LR");
                    break;
                default:
                    break;
            }
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
                break;
            case "TECLAS":
                this.bloquearTeclas = true;
                break;
            default:
                break;
        }
    }
    
    
    /**
     * Metodo encargado de mantener en movimiento la serpiente
     */
    public void continuarMoviendo() {
        
        if(!bloquearContinuar) {
            if (cabeza.getPosicionX() < cabeza.getPosicionAnteriorX()) {
                cabeza.setPosicionAnteriorX(cabeza.getPosicionX());
                cabeza.setPosicionX(cabeza.getPosicionX() - pasos);
                refrescarPosiciones();
            } else if (cabeza.getPosicionX() > cabeza.getPosicionAnteriorX()) {
                cabeza.setPosicionAnteriorX(cabeza.getPosicionX());
                cabeza.setPosicionX(cabeza.getPosicionX() + pasos);
                refrescarPosiciones();
            } else if (cabeza.getPosicionY() < cabeza.getPosicionAnteriorY()) {
                cabeza.setPosicionAnteriorY(cabeza.getPosicionY());
                cabeza.setPosicionY(cabeza.getPosicionY() - pasos);
                refrescarPosiciones();
            } else if (cabeza.getPosicionY() > cabeza.getPosicionAnteriorY()) {
                cabeza.setPosicionAnteriorY(cabeza.getPosicionY());
                cabeza.setPosicionY(cabeza.getPosicionY() + pasos);
                refrescarPosiciones();
            }
        }
        
        bloquearMovimiento("CONT");
        
    }
    
    /**
     * Metodo encargado de aumentar el tamanio de la serpiente 
     */
    public void aumentarTamanio() {
        
        double posUltimoBloX = cuerpo.get(cuerpo.size() - 1).getPosicionAnteriorX();
        double posultimoBloY = cuerpo.get(cuerpo.size() - 1).getPosicionAnteriorY();
        cuerpo.add( new Bloque(posUltimoBloX, posUltimoBloX,posUltimoBloX,posultimoBloY ));
    }
    
    public void refrescarPosiciones() {
        
        for (int i = 1; i < cuerpo.size(); i++) {
            cuerpo.get(i).setPosicionAnteriorX(cuerpo.get(i).getPosicionX());
            cuerpo.get(i).setPosicionAnteriorY(cuerpo.get(i).getPosicionY());
            cuerpo.get(i).setPosicionX(cuerpo.get(i - 1).getPosicionAnteriorX());
            cuerpo.get(i).setPosicionY(cuerpo.get(i - 1).getPosicionAnteriorY());
        }
    }
    
    
    public void asignarPosAnterior() {
        
        for (int i = 1; i < cuerpo.size(); i++) {
            double diferenciaPosX = cuerpo.get(i).getPosicionX() - cuerpo.get(i).getPosicionAnteriorX();
            double diferenciaPosY = cuerpo.get(i).getPosicionY() - cuerpo.get(i).getPosicionAnteriorY();
            if (cuerpo.get(i).getPosicionX() < cuerpo.get(i).getPosicionAnteriorX() && diferenciaPosX > pasos) {
                cuerpo.get(i).setPosicionAnteriorX(cuerpo.get(i).getPosicionX() - pasos);
            } else if (cuerpo.get(i).getPosicionX() > cuerpo.get(i).getPosicionAnteriorX()) {
                cuerpo.get(i).setPosicionAnteriorX(cuerpo.get(i).getPosicionX() + pasos);
            }else if (cuerpo.get(i).getPosicionY() < cuerpo.get(i).getPosicionAnteriorY() && diferenciaPosY > pasos) {
                cuerpo.get(i).setPosicionAnteriorY(cuerpo.get(i).getPosicionY() - pasos);
            } else if (cuerpo.get(i).getPosicionY() > cuerpo.get(i).getPosicionAnteriorY()) {
                cuerpo.get(i).setPosicionAnteriorY(cuerpo.get(i).getPosicionY() + pasos);
            }
        }
    }
    
    /* GETTERS Y SETTERS */

    public Bloque getCabeza() {
        return cabeza;
    }

    public void setCabeza(Bloque cabeza) {
        this.cabeza = cabeza;
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

    public boolean isBloquearTeclas() {
        return bloquearTeclas;
    }

    public void setBloquearTeclas(boolean bloquearTeclas) {
        this.bloquearTeclas = bloquearTeclas;
    }

    public double getPasos() {
        return pasos;
    }

    public void setPasos(double pasos) {
        this.pasos = pasos;
    }

    public LinkedList<Bloque> getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(LinkedList<Bloque> cuerpo) {
        this.cuerpo = cuerpo;
    }
}
