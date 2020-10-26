package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

public class Controller {
    @FXML VBox vBox;
    @FXML TextField txtMensaje, txtUsuario;

    public void enter(KeyEvent e){
        if(e.getCode()== KeyCode.ENTER){
            //Pregunta usuario
            Label label=new Label(txtUsuario.getText()+" dice: "+txtMensaje.getText());
            vBox.getChildren().add(label);
            //Respuesta computadora
            String respuesta=chatBot(txtMensaje.getText().toLowerCase());
            Label label2=new Label(respuesta);
            vBox.getChildren().add(label2);
        }
    }
    boolean pidioPieza=false;
    public String chatBot(String mensaje){
        String respuesta="ChatBot: Disculpa, ¿puedes repetir la pregunta?";
        if (mensaje.contains("hola")){
            respuesta="ChatBot: Hola, ¿En qué puedo ayudarte?";
        }else if(mensaje.contains("pieza")){
            respuesta="ChatBot: Por favor, escribe la marca, modelo y pieza que necesitas.";
            pidioPieza=true;
        }else if(pidioPieza){
            String[] datos=mensaje.split(" ");
            String modelo=datos[1];
            int indice1=mensaje.indexOf(modelo)+modelo.length();
            int indice2=mensaje.length();
            String pieza=mensaje.substring(indice1, indice2);
            respuesta="ChatBot: La pieza, "+pieza+", del auto "+datos[0]+" "+datos[1]+", si esta en existencia.";
            pidioPieza=false;

        }

        return respuesta;
    }
}
