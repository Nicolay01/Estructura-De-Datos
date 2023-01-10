package stack;

import nodo.Nodo;

/**
 * @author Nicolay
 * @version 1
 * Date = 10/01/2023
 * 
 * Mas adelante las clases contendran tipos **Genericos**.
*/

public class Stack {
    /* pila modela la estructura, este contiene una colecion de instancias(objetos) tipo Nodo. */
    
    // hace referencia al ultimo nodo, es decir apunta a una instancia de su mismo tipo //
    private Nodo tope;
    
    public Stack() {
        tope = null;
    }
    
    private boolean isEmpety() {
        return tope == null;
    }
    
    public void push(int info) {        
        if(isEmpety()) { // si esta vacia la pila
            this.tope = new Nodo(info);
            this.tope.setLink(null); // referencia al proximo nodo.
        } else {
            Nodo nodo = new Nodo(info);
            nodo.setLink(tope); // setLink(); crea un nuevo enlace con nuevo y tope.
            tope = nodo; // tope s ubica ha nuevo nodo.
        }
    }
    
    public boolean pop() {
        if(isEmpety()) {
            return false;
        } else {
            Nodo auxiliarPop = tope;
            tope = tope.getLink();
            auxiliarPop.setLink(null); // corta el enlace entre auxiliarPop y tope.
            return true;         
        }
    }
    
    public String loopStack() {
        Nodo auxiliarLoop = tope;
        String stackData = "";
        if(isEmpety()) {
            return "battery is empty";
        } else {
            while(auxiliarLoop != null) {
                stackData += " " + auxiliarLoop.getInfo();
                auxiliarLoop = auxiliarLoop.getLink();
            }
        }
        return "["+ stackData +" ]";
    }
}
