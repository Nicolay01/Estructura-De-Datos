package lista_enlace_simple;

/**
 *
 * @author decaro
 */
public class Main {
    /* PENSAMIENTO RECURSIV0 */
    public static void main(String[] args) {
        Lista lista = new Lista();
        
        /* REFERENCIA PRIMERO Y ULTIMO INTERCAMBIAN VALORES
           * Una referencia se ubicara en el segundo nodo
           * Una referencia buscara el Nodo penultimo del ultimo Nodo (quizas con tamaño e ir disminuyendo - cree un metodo que retorne 
            el valor de esa posicion - se puede crear una variable que contadora inicializada con = 0 y otra que asigne
            el tamaño de la lista(el que tiene el tamaño de la lista va ir disminuyendo y el otro aumentando cuando este teng aun valor
            casi parejo llegan el fin))
        */
        // 9 - 1 = 8
        lista.insertarNodoInicio(4); // tercero nodo 
        lista.insertarNodoInicio(7); // segundo nodo
        lista.insertarNodoInicio(17);// primer nodo
        lista.insertarNodoInicio(22);
        lista.insertarNodoInicio(33);
        lista.insertarNodoInicio(1);
        lista.insertarNodoInicio(12);
        lista.insertarNodoInicio(31);
        lista.insertarNodoInicio(55);
        /* CREAR OTRO PROYECTO SOLO CON LOS METODOS RECURSIVOS PARA Y INSERTAR NODO INICIO */
//        System.out.println(lista.numerosPrimosLista());
//        System.out.println(lista.sumaParesRecursiva());
//        lista.ordenarInformacion();
//        lista.recorrerLista();
//        System.out.println(lista.buscaNodoIndice(8, 9) + "\n");
//        lista.invertirOrdenLista();
//        lista.recorrerLista();
//        System.out.println(lista.borrarNodoRecursivamente(55));
//        System.out.println(lista.borrarNodoRecursivamente(311));
//        System.out.println(lista.borrarNodoRecursivamente(120));
//        lista.recorrerLista();
        System.out.println("Lista 2\n");
        Lista listaPrueba = new Lista();
        listaPrueba.duplicarLista(lista);
        lista.recorrerLista();
        System.out.println("\nLista 1\n");
        lista.recorrerLista();
    }
}
