package cliente;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class Cliente {



    public static void main(String[] args) {
        //puerto del Servidor
        final int puertoServer = 5000;
        //Buffer de almacenamiento de mensajes
        byte[] buffer = new byte[1024];

        try{
            //Obtención de localización de localHost
            InetAddress serverAddress = InetAddress.getByName("localhost");

            //Creación del socket UDP
            DatagramSocket socketUDP = new DatagramSocket();

            String msg = "Hola Server, soy cliente";

            //Converción de String a Bytes
            buffer = msg.getBytes();

            //Creación del datagrama
            DatagramPacket pregunta = new DatagramPacket(buffer, buffer.length, serverAddress, puertoServer);

            //Se envia
            System.out.println("Envio el datagrama");
            socketUDP.send(pregunta);

            //Se obtienen los datos y se muestran
            msg = new String(pregunta.getData());
            System.out.println(msg);

            //Cierro el socket
            socketUDP.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
