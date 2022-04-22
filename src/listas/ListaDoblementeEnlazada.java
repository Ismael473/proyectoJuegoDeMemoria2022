package listas;

import org.w3c.dom.Node;

public class ListaDoblementeEnlazada {

    /**
     * Instituto Tecnológico de Costa Rica
     * Ingeniería en Computadores
     * Algoritmos y Estructuras de Datos 1
     * Proyecto 1
     * profesor: Luis Diego Nogera Mena
     * estudiante: Ismael Arnesto Mena Briones
     * carné: 2020426050
     *
     * En esta clase se manipulan las imagenes que fueron almacenadas en sus respectivas
     * categorías me diante la implementación de un nodo el cual almacena datos y la posición
     * siguiente y anterior, debido al tipo de lista que es, a su vez es conciente de su cabeza
     * y cola, para tener un mejor desplazamiento por los datos de la lista.
     *
     * */

    // Se crea la clase nodo
   class Node{
       int data;
       Node anterior;
       Node siguiente;

       public Node(int data){// cambiar int por un string
           this.data = data;
       }
   }
   //Se determina que la cabeza y la cola serán nulas
   Node cabeza, cola = null;

   //añadeNode() añadirá otro nodo a la lista
    public void añadeNode(int data){
        //Crea el nuevo nodo
        Node nuevoNodo = new Node(data);

        //Si la lista está vacía
        if (cabeza == null){
            //Ambos cabeza y cola apuntarán al nuevo nodo
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            //El anterior de la cabeza será nulo y el siguiente de la cola tambien
            cabeza.anterior = null;
            cola.siguiente = null;

        }else{
            //NuevoNodo será añadio despues de la cola de tal forma el siguiente punto de la cola será el nuevoNodo
            cola.siguiente = nuevoNodo;
            //El anterior del nuevoNodo apuntará a la cola
            nuevoNodo.anterior = cola;
            //El nuevoNodo ahora será la cola
            cola = nuevoNodo;
            //Y el ultimo nodo será null
            cola.siguiente = null;
        }


    }
    //va a demostrar los nodos de la lista
    public void demostrar(){
        //El nodo actual apuntará a la cabeza
        Node actual = cabeza;
        if (cabeza == null){
            System.out.println("La lista está vacía");
        }
        System.out.println("Nodos de la lista doblemente enlazada");
        while(actual != null){
            // Imprime todos los nodos al incrementar un puntero
            System.out.println(actual.data +" ");
            actual = actual.siguiente;

        }
    }

    public static void main(String[] args) {
        ListaDoblementeEnlazada dLista = new ListaDoblementeEnlazada();
        // se añaden nodos a la lista
        dLista.añadeNode(1);
        dLista.añadeNode(1);
        dLista.añadeNode(1);
        dLista.añadeNode(1);
        dLista.añadeNode(1);
        dLista.demostrar();


    }
}
