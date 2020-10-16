package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Controller {
    @FXML Label lblLineas;
    @FXML TextArea txtReceta;
    @FXML protected void initialize(){
        try {
            File f=new File("./src/archivo.txt");
            BufferedReader br=new BufferedReader((new FileReader(f)));
            String texto="";
            while ((texto=br.readLine())!=null){
                txtReceta.appendText("\n"+texto);
            }
        }catch (Exception e){
            txtReceta.setText(e.getMessage());
        }
    }
    public void procesar(ActionEvent event){
        String[] arreglolinea=txtReceta.getText().split("\n");
        lblLineas.setText("Lineas: "+arreglolinea.length);
        boolean encontro=false;
        for (int x=0;x<arreglolinea.length;x++){
            if(arreglolinea[x].contains("Queso")){
                String[] arreglo2=arreglolinea[x].split(" ");
                System.out.println(arreglo2[0]);
            }
            if (arreglolinea[x].contains("manzanas")){
                String[] arreg2=arreglolinea[x].split(" ");
                System.out.println("Manzanas"+arreg2[1]);
            }
            if (encontro){
                System.out.println(arreglolinea[x]);
            }
            if (arreglolinea[x].contains("***")){
                encontro=true;
            }
        }
    }//llave Procesar

}
