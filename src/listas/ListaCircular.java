package listas;

public class ListaCircular {
    /**
     * Instituto Tecnológico de Costa Rica
     * Ingeniería en Computadores
     * Algoritmos y Estructuras de Datos 1
     * Proyecto 1
     * profesor: Luis Diego Nogera Mena
     * estudiante: Ismael Arnesto Mena Briones
     * carné: 2020426050
     *
     * En esta clase se encuentra la lista circular encargada de manipular las categorias
     * de imagenes, esta funciona mediante la utilización de un nodo el cual almacena infor-
     * mación y la posición siguiente, a su vez obtiene el nombre de cola y cabeza para delimitar
     * su inicio y su fin.
     * Al momento de añadir un nuevo nodo se crea en la posición siguiente a la cola y este nuevo
     * nodo obtiene el nombre de "cola" una vez es creado.
     *
     * */


    //Se crea la clase nodo
    public class Node{
        int data;
        Node siguiente;

        public Node(int data){// hay que cambiar el int por un String
            this.data = data;
        }

    }
    //Se declara los apuntadores como nulos
    public Node cabeza = null;
    public Node cola =  null;
    //Esta función añadirá un nuevo nodo al final de la lista
    public void añadir(int data) {
        //Crea un nuevo nodo
        Node nuevoNodo = new Node(data);
        //Revisa si la list está vacía
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            nuevoNodo.siguiente = cabeza;

        } else {
            //La cola apunt al nuevo nodo
            cola.siguiente = nuevoNodo;
            //Nuevo nodo se convierte en la nueva cola
            cola = nuevoNodo;
            //Como es circular la cola apuntará a la cabeza
            cola.siguiente = cabeza;


        }
    }
    public void demostrar(){
        Node actual = cabeza;
        if (cabeza == null){
            System.out.println("La lista está vacía");

        }else{
            System.out.println("Nodos de la lista circular:" );
            do {
                //imprime cada nodo al incrementar un puntero
                System.out.print(" "+actual.data);
                actual = actual.siguiente;
            }while (actual != cabeza);
        }
    }

    public static void main(String[] args) {
        ListaCircular lC = new ListaCircular();
        lC.añadir(1);
        lC.añadir(1);
        lC.añadir(1);
        lC.añadir(1);
        lC.añadir(1);
        lC.demostrar();
    }
}
