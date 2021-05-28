
package App;

import java.io.*;
import java.net.*;

public class cliente {

     
    public static void main(String[] args) {
      
        try {
            
            DatagramSocket UDP = new DatagramSocket();
            int puerto = 5001;
            InetAddress host = InetAddress.getByName("localhost");
            String cadena;
            
            do{
                
                
                BufferedReader tec = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Ingrese una cadena: ");
                cadena = tec.readLine();
                
                byte [] mensaje= cadena.getBytes();
            
                DatagramPacket peticion = new DatagramPacket(mensaje, cadena.length(), host, puerto);
                UDP.send(peticion);

                DatagramPacket resp = new DatagramPacket(mensaje, cadena.length());
                UDP.receive(resp);

                System.out.println("Eco Server: " + new String(resp.getData(), 0, resp.getLength()));
                
            }while(!"".equals(cadena));          
            
        } catch (SocketException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
   }
        
    }
    
}
