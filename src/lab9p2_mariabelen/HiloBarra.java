
package lab9p2_mariabelen;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class HiloBarra implements Runnable{
    private JProgressBar barra;
    JTextArea text;
    

    public HiloBarra() {
    }

    public HiloBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public HiloBarra(JProgressBar barra, JTextArea text) {
        this.barra = barra;
        this.text = text;
    }
    
    
    @Override
    public void run() {
        FileReader fr = null;
        File fichero = null;
        BufferedReader br = null;
        text.setText("");
            JFileChooser jfc = new JFileChooser("./");// donde quiero que arramque
            FileNameExtensionFilter filtro = 
                    new FileNameExtensionFilter(
                            "Archivos de Texto", "txt");
            jfc.setFileFilter(filtro);
            int seleccion = jfc.showOpenDialog(null);
        while (true){
            barra.setValue(barra.getValue()+1);
            if (barra.getValue()==100){
                break;
                
            }
            
            try {
                Thread.sleep(50);
            } catch (Exception e) {
            }
        
        
        }
        if (seleccion == JFileChooser.APPROVE_OPTION)
            {
               fichero = jfc.getSelectedFile();
            try {
                fr = new FileReader(fichero);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HiloBarra.class.getName()).log(Level.SEVERE, null, ex);
            }
               br=new BufferedReader(fr);
               String linea;
               text.setText("");
            try {                    
                while(  (linea=br.readLine()) !=null  ){
                    text.append(linea);
                    text.append("\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(HiloBarra.class.getName()).log(Level.SEVERE, null, ex);
            }
            } 
        
    }
   
    
}
