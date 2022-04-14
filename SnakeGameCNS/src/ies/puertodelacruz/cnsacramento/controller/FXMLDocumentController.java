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
        escenario = new Escenario(ancho,alto,dimensionSerpiente);
        partida.setEscenario(escenario);
        //escenario = partida.getEscenario();
        escenario.generarManzana();
        serpiente = escenario.getSerpiente();
        System.out.println("Escenario tamaño -> (" + escenario.getTamanioX() + "," + escenario.getTamanioY() + ")");
        graficos = escenarioCanvas.getGraphicsContext2D();
        graficos.fillRect(
                serpiente.getCabeza().getPosicionX(), serpiente.getCabeza().getPosicionY(), 
                dimensionSerpiente, dimensionSerpiente
        );
        graficos.fillOval(escenario.getManzanaX(), escenario.getManzanaY(), dimensionSerpiente, dimensionSerpiente);
        mostrarGraficos();
        System.out.println("MANZANA -> (" + escenario.getManzanaX() + ", " + escenario.getManzanaY() + ")");
    }

    
    public void mostrarGraficos() {
        final double VELOCIDAD_JUEGO = 100;
        Timeline fps = new Timeline();
        fps.setCycleCount(Animation.INDEFINITE);
        fps.getKeyFrames().add(new KeyFrame(Duration.millis(VELOCIDAD_JUEGO), (t) -> {
            if(serpiente.getEnMovimiento()) {
                
                escenario.detectarColision();
                if (escenario.getColisionDetectada()) {
                    graficos.fillRect(
                            serpiente.getCabeza().getPosicionAnteriorX(), serpiente.getCabeza().getPosicionAnteriorY()
                            , dimensionSerpiente, dimensionSerpiente
                    );
                    graficos.fillOval(escenario.getManzanaX(), escenario.getManzanaY(), dimensionSerpiente, dimensionSerpiente);
                    fps.stop();
                    System.out.println("GAME OVER");
                }else {
                    graficos.clearRect(0, 0, escenarioCanvas.getWidth(), escenarioCanvas.getHeight());
                    serpiente.continuarMoviendo();
                    graficos.fillRect(serpiente.getCabeza().getPosicionX(), serpiente.getCabeza().getPosicionY()
                            , dimensionSerpiente, dimensionSerpiente);
                    graficos.fillOval(escenario.getManzanaX(), escenario.getManzanaY(), dimensionSerpiente, dimensionSerpiente);
                    escenario.detectarColision();
                }
            }
           
        }));
        
        fps.play();
        
    }
    
    @FXML
    private void moverSerpiente(KeyEvent event) {
        
        KeyCode tecla = event.getCode();
        switch(tecla) {
            case UP:
                System.out.println("Subiendo...");
                serpiente.mover("UP");
                System.out.println("Posicion serpiente -> (" + serpiente.getCabeza().getPosicionX() + ", " + serpiente.getCabeza().getPosicionY() + ")");
                break;
            case DOWN:
                System.out.println("Bajando...");
                serpiente.mover("DOWN");
                System.out.println("Posicion serpiente -> (" + serpiente.getCabeza().getPosicionX() + ", " + serpiente.getCabeza().getPosicionY() + ")");
                break;
            case LEFT:
                System.out.println("Izquierda...");
                serpiente.mover("LEFT");
                System.out.println("Posicion serpiente -> (" + serpiente.getCabeza().getPosicionX() + ", " + serpiente.getCabeza().getPosicionY() + ")");
                break;
            case RIGHT:
                System.out.println("Derecha...");
                serpiente.mover("RIGHT");
                System.out.println("Posicion serpiente -> (" + serpiente.getCabeza().getPosicionX() + ", " + serpiente.getCabeza().getPosicionY() + ")");
                break;
            default:
                break;
        }
    }
    
}
