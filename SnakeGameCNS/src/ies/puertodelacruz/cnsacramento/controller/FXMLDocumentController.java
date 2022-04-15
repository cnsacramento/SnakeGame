/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.controller;

import ies.puertodelacruz.cnsacramento.model.Escenario;
import ies.puertodelacruz.cnsacramento.model.Partida;
import ies.puertodelacruz.cnsacramento.model.Serpiente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

/**
 *
 * @author christian
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Canvas escenarioCanvas;
    private GraphicsContext graficos;
    private Partida partida;
    private final double dimensionSerpiente = 10;
    private Serpiente serpiente;
    private Escenario escenario;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partida = new Partida();
        double ancho = escenarioCanvas.getWidth();
        double alto = escenarioCanvas.getHeight();
        //partida.empezarPartida(ancho, alto);
        escenario = new Escenario(ancho, alto, dimensionSerpiente);
        partida.setEscenario(escenario);
        //escenario = partida.getEscenario();
        escenario.generarManzana();
        //escenario.generarObstaculos();
        serpiente = escenario.getSerpiente();
        System.out.println("Escenario tamaño -> (" + escenario.getTamanioX() + "," + escenario.getTamanioY() + ")");
        graficos = escenarioCanvas.getGraphicsContext2D();
        dibujarSerpiente();
        dibujarManzana();
        //dibujarObstaculos();
        mostrarGraficos();
        System.out.println("MANZANA -> (" + escenario.getManzana().getPosicionX() + ", " + escenario.getManzana().getPosicionY() + ")");
    }

    /**
     * Metodo encargado de mantener dibujando la partida
     */
    public void mostrarGraficos() {
        final double VELOCIDAD_JUEGO = 60;
        Timeline fps = new Timeline();
        fps.setCycleCount(Animation.INDEFINITE);
        fps.getKeyFrames().add(new KeyFrame(Duration.millis(VELOCIDAD_JUEGO), (t) -> {
            if (serpiente.getEnMovimiento()) {
                escenario.detectarColision();
                if (escenario.getColisionDetectada()) {
                    fps.stop();
                    gameOver();
                } else {
                    continuarJuego();
                }
            }
        }));

        fps.play();
    }
    
    /***
     * Metodo encargado de dibujar el final de la partida
     */
    public void gameOver() {
        /*graficos.fillRect(
                serpiente.getCabeza().getPosicionAnteriorX(), serpiente.getCabeza().getPosicionAnteriorY(),
                dimensionSerpiente, dimensionSerpiente
        );*/
        dibujarSerpiente();
        dibujarManzana();
        //dibujarObstaculos();
        System.out.println("GAME OVER");
    }
    
    /***
     * Metodo encargado de refrescar el ultimo movimiento
     */
    public void continuarJuego() {
        graficos.clearRect(0, 0, escenarioCanvas.getWidth(), escenarioCanvas.getHeight());
        serpiente.continuarMoviendo();
        dibujarSerpiente();
        /*
        graficos.fillRect(serpiente.getCabeza().getPosicionX(), serpiente.getCabeza().getPosicionY()
            , dimensionSerpiente, dimensionSerpiente);*/
        dibujarManzana();
        //dibujarObstaculos();
        escenario.detectarColision();
    }

    /***
     * Metodo encargado de dibujar la serpiente en el canva
     */
    public void dibujarSerpiente() {
        for (int i = 0; i < serpiente.getCuerpo().size(); i++) {
            graficos.fillRect(
                    serpiente.getCuerpo().get(i).getPosicionX(), serpiente.getCuerpo().get(i).getPosicionY(),
                    dimensionSerpiente, dimensionSerpiente
            );
            System.out.println(
                    "COORDENADAS: \" " + i + "\" -> ("
                    + serpiente.getCuerpo().get(i).getPosicionAnteriorX()
                    + ", " + serpiente.getCuerpo().get(i).getPosicionAnteriorY()
            );
        }
    }
    
    /***
     * Metodo encargado de dibujar la manzana en el canvas
     */
    public void dibujarManzana() {
        graficos.fillOval(
                escenario.getManzana().getPosicionX(), escenario.getManzana().getPosicionY(),
                dimensionSerpiente, dimensionSerpiente
        );
    }
    
    /**
     * Metodo encargado de dibujar los obstaculos
     */
    public void dibujarObstaculos() {
        
        for (int i = 0; i < escenario.getObstaculos().length; i++) {
            graficos.fillRect(escenario.getObstaculos()[i].getPosicionX()
                    , escenario.getObstaculos()[i].getPosicionY()
                    , dimensionSerpiente, dimensionSerpiente);
        }
    }

    @FXML
    private void moverSerpiente(KeyEvent event) {

        KeyCode tecla = event.getCode();
        switch (tecla) {
            case UP:
                System.out.println("Subiendo...");
                serpiente.mover("UP");
                break;
            case DOWN:
                System.out.println("Bajando...");
                serpiente.mover("DOWN");
                break;
            case LEFT:
                System.out.println("Izquierda...");
                serpiente.mover("LEFT");
                break;
            case RIGHT:
                System.out.println("Derecha...");
                serpiente.mover("RIGHT");
                break;
            default:
                break;
        }
    }

}
