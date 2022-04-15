/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase encargada del escenario
 *
 * @author christian
 */
public class Escenario {

    private Serpiente serpiente;
    private double tamanioX;
    private double tamanioY;
    private Bloque manzana;
    private boolean colisionDetectada = false;
    private ArrayList<Bloque> manzanas;
    private Bloque[][] obstaculos;
    private int anchoObstaculos;
    private int numeroObstaculos;
    private int numeroManzanas;
    

    /* CONSTRUCTORES */
    /**
     * Constructor por defecto sin parametros
     */
    public Escenario() {}

    /**
     * Constructor con dos parametros
     *
     * @param tamanioX Ancho del escenario
     * @param tamanioY Alto del escenario
     */
    public Escenario(double tamanioX, double tamanioY) {

        this.tamanioX = tamanioX;
        this.tamanioY = tamanioY;
        double posicionCentralX = this.tamanioX / 2;
        double posicionCentralY = this.tamanioY / 2;
        serpiente = new Serpiente(posicionCentralX, posicionCentralY);
    }

    /**
     * Constructor que recibe 3 parametros
     *
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
    
    /**
     * Metodo encargado de generar la posicion de la manzana
     */
    public Bloque generarManzana() {
        Random rnd = new Random();
        boolean posicionLimpia = true;
        double manzanaX = rnd.nextInt((int) (tamanioX / serpiente.getPasos())) * serpiente.getPasos();
        double manzanaY = rnd.nextInt((int) (tamanioY / serpiente.getPasos())) * serpiente.getPasos();
        for (int i = 0; i < serpiente.getCuerpo().size(); i++) {
            if(serpiente.getCuerpo().get(i).getPosicionAnteriorX() == manzanaX
                    && serpiente.getCuerpo().get(i).getPosicionAnteriorY() == manzanaY) {
                posicionLimpia = false;
                break;
            }
        }
        for (Bloque[] obstaculo : obstaculos) {
            for (Bloque bloque : obstaculo) {
                if(bloque.getPosicionX() == manzanaX && bloque.getPosicionY() == manzanaY) {
                    posicionLimpia = false;
                    break;
                }
            }
        }
        if(posicionLimpia) {
            return manzana = new Bloque(manzanaX, manzanaY);
        }else {
            return generarManzana();
        }
    }
    
    /**
     * Metodo encargado de generar las manzanas al principio de manera aleatoria
     */
    public void generarVariasManzanas() {
        
        Random rnd = new Random();
        this.numeroManzanas = rnd.nextInt(3) + 1;
        manzanas = new ArrayList<>();
        
        for (int i = 0; i < this.numeroManzanas; i++) {
            manzanas.add(generarManzana());
        }
        
    }

    /**
     * Metodo encargado de generar los obstaculos
     */
    public void generarObstaculos() {
        Random rnd = new Random();
        this.anchoObstaculos = 3;
        this.numeroObstaculos = rnd.nextInt(10) + 1;
        
        obstaculos = new Bloque[numeroObstaculos][anchoObstaculos];
        for (int i = 0; i < obstaculos.length; i++) {
            double obstaculoX = rnd.nextInt((int) (tamanioX / serpiente.getPasos())) * serpiente.getPasos();
            double obstaculoY = rnd.nextInt((int) (tamanioY / serpiente.getPasos())) * serpiente.getPasos();
            double ancho = obstaculoX + serpiente.getPasos();
            for (int j = 0; j < obstaculos[i].length; j++) {
                obstaculos[i][j] = new Bloque(ancho,obstaculoY);
                ancho += serpiente.getPasos();
            }
        }
    }

    /*
    * Metodo encargado de detectar colisiones 
     */
    public void detectarColision() {

        detectarAutochoque();
        detectarMuro();
        detectarObstaculo();
        detectarDigestion();
    }

    /**
     * Metodo encargado de detectar cuando la serpiente come
     */
    public void detectarDigestion() {
        
        for (int i = 0 ; i < manzanas.size() ; i++) {
            if (serpiente.getCabeza().getPosicionX() == manzanas.get(i).getPosicionX() 
                    && serpiente.getCabeza().getPosicionY() == manzanas.get(i).getPosicionY()) {
                manzanas.set(i, generarManzana());
                serpiente.aumentarTamanio();
            }
        }

    }

    /**
     * Metodo que detecta colision con limite de la ventana
     */
    public void detectarMuro() {

        if (serpiente.getCabeza().getPosicionX() >= this.tamanioX || serpiente.getCabeza().getPosicionX() < 0) {
            this.colisionDetectada = true;
            serpiente.bloquearMovimiento("TECLAS");
        } else if (serpiente.getCabeza().getPosicionY() >= this.tamanioY || serpiente.getCabeza().getPosicionY() < 0) {
            this.colisionDetectada = true;
            serpiente.bloquearMovimiento("TECLAS");
        }
    }

    /**
     * Metodo que detecta si la serpiente se choca consigo misma
     */
    public void detectarAutochoque() {

        for (int i = 1; i < serpiente.getCuerpo().size(); i++) {
            if (serpiente.getCabeza().getPosicionX()
                    == serpiente.getCuerpo().get(i).getPosicionX() && serpiente.getCabeza().getPosicionY()
                    == serpiente.getCuerpo().get(i).getPosicionY()) {
                this.colisionDetectada = true;
                serpiente.bloquearMovimiento("TECLAS");
            }
        }
    }
    
    public void detectarObstaculo() {
        
        for(Bloque[] obstaculo : obstaculos) {
            for(Bloque obs : obstaculo) {
                if(serpiente.getCabeza().getPosicionX() == obs.getPosicionX() 
                        && serpiente.getCabeza().getPosicionY() == obs.getPosicionY()) {
                    
                    this.colisionDetectada = true;
                    serpiente.bloquearMovimiento("TECLAS");
                }
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

    public ArrayList<Bloque> getManzanas() {
        return manzanas;
    }

    public void setManzanas(ArrayList<Bloque> manzanas) {
        this.manzanas = manzanas;
    }

    public Bloque[][] getObstaculos() {
        return obstaculos;
    }

    public void setObstaculos(Bloque[][] obstaculos) {
        this.obstaculos = obstaculos;
    }
    
    public boolean getColisionDetectada() {
        return this.colisionDetectada;
    }

    public void setColisionDetectada(boolean colisionDetectada) {
        this.colisionDetectada = colisionDetectada;
    }
}
