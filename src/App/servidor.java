
package App;
import java.io.*;
import java.net.*;

public class servidor {

    
    public static void main(String[] args) {
       
         System.out.println("Servidor en Funcionamiento");
        
        try {
            DatagramSocket server = new DatagramSocket(5001);
            byte[] buffer = new byte[1024];
            
              while (true) {   
                
                DatagramPacket peticion = new DatagramPacket(buffer,buffer.length);
                server.receive(peticion);
                
                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();           
              
                byte [] buf = new byte[1024];
                
                String mensaje = new String(peticion.getData()); 
                
                buf = mensaje.getBytes();
                
                DatagramPacket res = new DatagramPacket(buf, mensaje.length(), direccion, puertoCliente);
                server.send(res);
                
            }
            
        } catch (SocketException e) {
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        
        
    }
    
}
