package servidor;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class Servidor {
    /**
     * Instituto Tecnológico de Costa Rica
     * Ingeniería en Computadores
     * Algoritmos y Estructuras de Datos 1
     * Proyecto 1
     * profesor: Luis Diego Nogera Mena
     * estudiante: Ismael Arnesto Mena Briones
     * carné: 2020426050
     *
     * En esta clase se desarrolla el servidor, el cual posee un puerto de conexión
     * número 5000 y tambien el buffer el cual está encargado de el almacenamiento de datos
     * a enviar o recibir, a su vez se tiene que implementar una excepción para el tratamiento
     * de errores, dentro de esta excepción tenemos la parte funcional del servidor, el cual
     * obtiene los mensajes y los manipula, para que estos sean reenviados o almacenados.
     *
     * A su vez tenemos la interfaz gráfica la cual en un principio pregunta los nombres de los
     * jugadores y luego debe almacenarlos e iniciar el juego.
     * */

    public static void main(String[] args) {

        JFrame ventanaServidor = new JFrame("Vetana Servidor");
        ventanaServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaServidor.setSize(800,600);

        JPanel jugadores = new JPanel();
        JTextField jugador1 = new JTextField();
        jugador1.setSize(400,20);
        JTextField jugador2 = new JTextField();
        jugador2.setSize(400,20);
        JLabel jug1 = new JLabel();
        JLabel jug2 = new JLabel();
        jug1.setText("Jugador 1:");
        jug2.setText("Jugador 2:");

        jugadores.add(jug1);
        jugadores.add(jugador1);
        jugadores.add(jug2);
        jugadores.add(jugador2);

        ventanaServidor.getContentPane().add(BorderLayout.CENTER,jugadores);

        ventanaServidor.setVisible(true);

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
