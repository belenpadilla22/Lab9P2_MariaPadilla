/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p2_mariabelen;

import java.awt.TextArea;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;

/**
 *
 * @author belen
 */
public class AdmiArchivo {
      private File archivo = null;
      private JTextArea text;
      

    public AdmiArchivo() {
    }
     public AdmiArchivo(String path,JTextArea texto) {
        archivo = new File(path);
        this.text= texto;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public JTextArea getText() {
        return text;
    }

    public void setText(JTextArea text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "AdmiArchivo{" + "archivo=" + archivo + ", text=" + text + '}';
    }
      
      
       public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
       String texto=text.getText();
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
                bw.write(texto);
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() { 
      //  String texto=text.getText();
        String t="";
        Scanner sc = null;
        
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    
                t+= sc.next();
                   
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
    
}
