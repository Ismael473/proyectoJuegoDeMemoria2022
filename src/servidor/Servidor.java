package servidor;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Servidor {

    public static void main(String[] args) {
        final int puerto = 5000;
        byte[] buffer = new byte[1024];

        try{
            System.out.println("Iniciando el servidor UDP");
            //Se crea el socket
            DatagramSocket socketUDP = new DatagramSocket(puerto);

            //While true para que siempre atienda solicitudes
            while (true) {

                //Preparación de respuesta
                DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length);

                //Recepción del datagrama
                socketUDP.receive(pregunta);
                System.out.println("Recepción de información del cliente");

                //Se recibe y se muestra el mensaje
                String msg = new String(pregunta.getData());
                System.out.println(msg);

                //Se obtiene el puerto y la dirección de origen
                //Si no se quiere responder, no es necesario
                int puertoCliente = pregunta.getPort();
                InetAddress direccion = pregunta.getAddress();

                msg = "Hola cliente, soy servidor";
                buffer = msg.getBytes();

                //Se crea el datagrama
                DatagramPacket respuesta = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);

                //Se envia la información
                System.out.println("Enviando información al cliente");
                socketUDP.send(respuesta);

            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
