package nodo;

/**
 *
 * @author Nicolay
 * @version 1
 * Date : 10/01/2023
 */
public class Nodo {
    // referencia al siguiente nodo.
    private Nodo link;
    private int info;
    
    public Nodo() {
        this(0);
        link = null;    
    }
    
    public Nodo(int info) {
        this.info = info;
        link = null;
    }

    public Nodo getLink() {
        return link;
    }

    public void setLink(Nodo link) {
        this.link = link;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }        
}
