package listas;

import org.w3c.dom.Node;

public class ListaDoblementeEnlazada {

    // Se crea la clase nodo
   class Node{
       int data;
       Node anterior;
       Node siguiente;

       public Node(int data){
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

        //va a demostrar los nodos de la lista
        public void demostrar(){
            //El nodo actual apuntará a la cabeza
            if (cabeza == null){
                System.out.println();
            }
        }
    }

}
