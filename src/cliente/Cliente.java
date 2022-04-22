package cliente;

import javax.swing.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;


public class Cliente {
    /**
     * Instituto Tecnológico de Costa Rica
     * Ingeniería en Computadores
     * Algoritmos y Estructuras de Datos 1
     * Proyecto 1
     * profesor: Luis Diego Nogera Mena
     * estudiante: Ismael Arnesto Mena Briones
     * carné: 2020426050
     *
     * En esta clase se desarrolla el cliente, el cual se conecta al servidor
     * mediante un protocolo UDP, el cliente para conectarse al servidor unicamente
     * ocupa el puerto de acceso y el servidor está planteado para siempre escuchar
     * las solicitudes del cliente. En este metodo main se encuentra una excepción
     * que es en la cual se desarrolla debido a que es ahí donde se tiene control
     * de errores mediante los catch el cliente, aparte de tener la conexión al puerto
     * tambien tiene un buffer, el cual es el encargado de almacenar los datos que
     * serán enviados o los datos que serán recibidos desde el servidor.
     *
     * Aparte de su funcionalidad como cliente tambien posee una interfaz gráfica de
     * usuario, la cual le mostrará información reelevante al usuario.
     * */
    public static void main(String[] args) {
        //Ventana de cliente
        JFrame ventanaCliente = new JFrame("Cliente");
        ventanaCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaCliente.setSize(800,600);

        //Imagenes
        JLabel imagen1 = new JLabel();








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


        ventanaCliente.setVisible(true);
    }
}
