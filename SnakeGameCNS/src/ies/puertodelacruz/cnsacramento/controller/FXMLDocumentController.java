/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package ies.puertodelacruz.cnsacramento.controller;

import ies.puertodelacruz.cnsacramento.model.Bloque;
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
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
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
    private final double dimensionSerpiente = 20;
    private Serpiente serpiente;
    private Escenario escenario;
    @FXML
    private Button bordes;
    @FXML
    private Text txtPuntuacion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partida = new Partida();
        double ancho = escenarioCanvas.getWidth();
        double alto = escenarioCanvas.getHeight();
        //partida.empezarPartida(ancho, alto);
        escenario = new Escenario(ancho, alto, dimensionSerpiente);
        partida.setEscenario(escenario);
        //escenario = partida.getEscenario();
        escenario.generarObstaculos();
        escenario.generarVariasManzanas();
        serpiente = escenario.getSerpiente();
        System.out.println("Escenario tamaño -> (" + escenario.getTamanioX() + "," + escenario.getTamanioY() + ")");
        escenarioCanvas.setStyle("-fx-background-color : red");
        graficos = escenarioCanvas.getGraphicsContext2D();
        dibujarFondo();
        dibujarObstaculos();
        dibujarSerpiente();
        dibujarManzana();
        mostrarGraficos();
    }
    

    /**
     * Metodo encargado de mantener dibujando la partida
     */
    public void mostrarGraficos() {
        final double VELOCIDAD_JUEGO = 80;
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
    private Rectangle serp;
    public void gameOver() {
        graficos.setFill(Color.RED);
        graficos.fillRect(
                serpiente.getCabeza().getPosicionAnteriorX(), serpiente.getCabeza().getPosicionAnteriorY(),
                dimensionSerpiente, dimensionSerpiente
        );
        dibujarObstaculos();
        dibujarManzana();
        System.out.println("GAME OVER");
    }
    
    /***
     * Metodo encargado de refrescar el ultimo movimiento
     */
    public void continuarJuego() {
        graficos.clearRect(0, 0, escenarioCanvas.getWidth(), escenarioCanvas.getHeight());
        serpiente.continuarMoviendo();
        dibujarFondo();
        dibujarObstaculos();
        dibujarSerpiente();
        dibujarManzana();
        escenario.detectarColision();
    }

    /***
     * Metodo encargado de dibujar la serpiente en el canva
     */
    public void dibujarSerpiente() {
        for (int i = 0; i < serpiente.getCuerpo().size(); i++) {
            if(i*2 > 255) {
                graficos.setFill(Color.rgb(50, 255, 255));
            }else {
                graficos.setFill(Color.rgb(50,50 + (i*2),100 + (i*2)));
            }
            graficos.fillRect(
                    serpiente.getCuerpo().get(i).getPosicionX(), serpiente.getCuerpo().get(i).getPosicionY(),
                    dimensionSerpiente, dimensionSerpiente
            );
        }
    }
    
    /***
     * Metodo encargado de dibujar la manzana en el canvas
     */
    public void dibujarManzana() {
        graficos.setFill(Color.RED);
        for (Bloque manzana : escenario.getManzanas()) {
            graficos.fillOval(
                    manzana.getPosicionX(), manzana.getPosicionY(),
                    dimensionSerpiente, dimensionSerpiente
            );
        }
        int puntuacion = serpiente.getCuerpo().size() - 1;
        txtPuntuacion.setText("" + puntuacion);
    }
    
    /**
     * Metodo encargado de dibujar los obstaculos
     */
    public void dibujarObstaculos() {
        graficos.setFill(Color.web("#003333"));
        for (Bloque[] blo : escenario.getObstaculos()) {
            for (Bloque bloque : blo) {
                graficos.fillRect(
                        bloque.getPosicionX(), bloque.getPosicionY(),
                        dimensionSerpiente, dimensionSerpiente
                );
            }
        }
    }
    
    /**
     * Metodo que dibuja el fondo del escenario
     */
    public void dibujarFondo() {
        for (int columnas = 0; columnas < escenarioCanvas.getWidth() / dimensionSerpiente; columnas++) {
            for (int filas = 0; filas < escenarioCanvas.getWidth() / dimensionSerpiente; filas++) {
                if ((columnas + filas) % 2 == 0) {
                    graficos.setFill(Color.web("AAD751"));
                } else {
                    graficos.setFill(Color.web("A2D149"));
                }
                graficos.fillRect(columnas * dimensionSerpiente, filas * dimensionSerpiente, dimensionSerpiente, dimensionSerpiente);
            }
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
