/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab9p2_mariabelen;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author belen
 */
public class HiloFecha implements Runnable{
   private JLabel fecha;
   
     public HiloFecha(JLabel fecha) {
        this.fecha = fecha;
    }        
   

    @Override
    public void run() {
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(fechaActual);
        fecha.setText(fechaFormateada);
        try {
             Thread.sleep(1000);
        } catch (Exception e) {
        }
    }
    
}
