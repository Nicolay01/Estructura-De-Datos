package lista_enlace_simple;

import nodo.Nodo;

public class Lista {

    private Nodo primero;
    private Nodo ultimo;
    private int tamanio;
    private Nodo a;

    public Lista() {
        primero = null;
        ultimo = null;
        a = null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void insertarNodoInicio(int informacion) {
        Nodo nuevoNodo = new Nodo(informacion);
        /* Si en caso que no exista un nodo, se hace necesario instanciar primero y ultimo apunte al nuevo nodo */
        if (esVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            a = nuevoNodo;
            /* Caso contrario que exista mas de un Nodo. Los Nodo insertado se ubicaran a la izquierda */
        } else {
            nuevoNodo.setLink(primero);
            primero = nuevoNodo;
            a = primero;
        }
        tamanio++;
    }

    public void insertarNodoFinal(int informacion) {
        Nodo nuevoNodo = new Nodo(informacion);
        if (esVacia()) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setLink(nuevoNodo);
            ultimo = nuevoNodo;
            ultimo.setLink(null);
        }
        tamanio++;
    }

    public boolean esVacia() {
        return (primero == null);
    }

    public int buscarNodoInformacion(int informacionBuscar) {
        Nodo auxiliar = primero;
        int count = 0;
        int i = 0;
        boolean encontrado = false;
        while (i < getTamanio() && !encontrado) {
            if (auxiliar.getInfo() == informacionBuscar) {
                return count;
            }
            i++;
            count++;
            auxiliar = auxiliar.getLink();
        }
        return count;
    }

    public boolean borrarNodoInicio() {
        /* Codigo es funcional pero tiene algo, es que puede lanzar una excepcion. Si el primer Nodo no tiene un enlace con el siguiente 
        Nodo lanza una excepcion o en cambio si no existe un Nodo lanzara una excepcion nos toca recurrir a estructura de control
        que se "verifique" de que exista o no un Nodo para que no lanze una excepcion*/
        if (esVacia()) {
            return false;
        }
        // fragmento se esta "borrando" el primero Nodo
        if (primero.getLink()== null) {
            primero = null;
            ultimo = null;
            return false;
        } else {
            Nodo auxiliar = primero;
            primero = primero.getLink();
            auxiliar.setLink(null);
            tamanio--;
            return true;
        }
    }

    public boolean borrarNodoFinal() {
        if (esVacia()) {
            return false;
        }
        if (primero.getLink()== null) {
            primero = null;
            ultimo = null;
            return false;
        } else {
            Nodo temporal = primero;
            Nodo auxiliar = primero;
            while (temporal.getLink()!= null) {
                auxiliar = temporal;
                temporal = temporal.getLink();
            }
            ultimo = auxiliar;
            ultimo.setLink(null);
            tamanio--;
            return true;
        }
    }

    public void recorrerLista() {
        Nodo temporal = primero;
//        do {
//            System.out.println(recorrerNodos.getInformacion());
//            recorrerNodos = recorrerNodos.getEnlace();
//        }while(recorrerNodos.getEnlace() != null);
//        while (temporal.getEnlace() != null) {
//            System.out.println(temporal.getInformacion());
//            temporal = temporal.getEnlace();
//        }
//        System.out.println(temporal.getInformacion());
        Nodo p = primero;
        do {
            System.out.println(p.getInfo());
            p = p.getLink();
        } while (p.getLink()!= null);
        System.out.println(p.getInfo());
    }

    public int buscarDatoMayor() {
        int posicion = 0;
        Nodo auxiliar = primero; // segundo nodo
        int number = auxiliar.getInfo();
        while (auxiliar.getLink()!= null) {
            auxiliar = auxiliar.getLink();
            if (number <= auxiliar.getInfo()) {
                number = auxiliar.getInfo();
                posicion = buscarNodoInformacion(number);
            }
        }
        return posicion;
    }

    public int buscarDatoMenor() {
//        int posicion = 0;
        Nodo auxiliar = primero; // segundo nodo
        int number = auxiliar.getInfo();
        while (auxiliar.getLink()!= null) {
            auxiliar = auxiliar.getLink();
            if (number > auxiliar.getInfo()) {
                number = auxiliar.getInfo();
//                posicion = buscarNodoInformacion(number);
            }
        }
        return number;
    }

    public int numeroRepetir(int number) {
        Nodo auxiliar = primero;
        int repeticiones = number == auxiliar.getInfo()? +1 : 0;
        while (auxiliar.getLink()!= null) {
            auxiliar = auxiliar.getLink();
            if (number == auxiliar.getInfo()) {
                repeticiones++;
            }
        }
        return repeticiones;
    }

    /* MI PROBLEMA
       Buscando alguna alternativa para no usar la referencia << primero >> este es un incoveniente si queremos recorer la lista nuevamente.
       De manera forsosa me senti con la obligacion de utilizar la referencia primero para dar solucion a este problema.
       * Si declaro una referencia local asignando la referencia << primero >> cada vez el dado caso de recursion esta volveres a ubicarse
       en el primer Nodo, lo cual generaria un Error de << stackOverflor >>.
       * Si declaro una variable global o de instancia, pues te en claro cada vez que se cree un nuevo Nodo la referencia primero podra
       recorrer la lista de Nodos, mas la variable auxiliar al instanciar objeto << Lista >> es inicializado como << null >>.
    
       POSIBLE SOLUCION
       * Declarar una variable de referencia static llamada << auxiliar >> asigna referencia primero.
         Evitamos varias cosas que primero despues del recorrido de los Nodos que aputando al ultimo Nodo.
     */
    public int sumaRecursiva() {
//        auxiliar = auxiliar.getEnlace();
        if (a.getLink()== null) {
            return a.getInfo();
        }
        int suma = a.getInfo();
        a = a.getLink();
        return suma + sumaRecursiva();
    }

    public String sumaParesRecursiva() {
        if (a.getLink()== null) {
            return "" + (a.getInfo()% 2 == 0 ? a.getInfo(): "");
        }
        String sumaPares = (a.getInfo()% 2 == 0 ? a.getInfo(): 0) + " ";
        a = a.getLink();
        return sumaPares + sumaParesRecursiva();
    }

    public String numerosPrimosLista() {
        /* Mostrar los numeros primos quizas de manera recursiva    
            CASO BASE -> TOTAL = 2
            CASO RECURSIVO -> TOTAL = 1
         */

        int number = esPrimo(a.getInfo()) ? a.getInfo(): 0;
        if (a.getLink()== null) {
            return number + "";
        }
        a = a.getLink();
        return number + " " + numerosPrimosLista();
    }

    private boolean esPrimo(int numeroAEvaluar) {
        boolean primo = true;
        for (int i = 2; i < numeroAEvaluar && numeroAEvaluar > 2; i++) {
            if (numeroAEvaluar % i == 0) {
                primo = false;
                break;
            }
        }
        return numeroAEvaluar > 2 && primo ? primo : false;
    }

    /* FASE 1: ORDENAMIENTO (ALGORITMO LINEAL) */
    public void ordenarInformacion() {
        Nodo prim = primero;
        Nodo segu = primero;
        Nodo aux = primero;
        while (aux.getLink()!= null) {
            while (segu.getLink()!= null) {
                segu = segu.getLink();
                if (prim.getInfo() < segu.getInfo()) {
                    int number = segu.getInfo();
                    segu.setInfo(prim.getInfo());
                    prim.setInfo(number);
                }
                prim = prim.getLink();
            }
            segu = primero;
            prim = primero;
            aux = aux.getLink();
        }
    }

    public void invertirOrdenLista() {
        int longitud = getTamanio() - 1;
        Nodo auxiliar = primero;

        for (int contador = 0; contador != longitud; contador++) {
            auxiliar.setInfo(buscaNodoIndice(longitud, auxiliar.getInfo()));
            auxiliar = auxiliar.getLink();
            longitud--;
        }

    }

    public int buscaNodoIndice(int indice, int valor) {
        Nodo auxiliar = primero;
        int numero = 0;

//        while (auxiliar.getEnlace() != null && (numero != datoABuscar)) {
//            numero = numero == auxiliar.getInformacion() ? auxiliar.getInformacion() : 0;                      
//            auxiliar = auxiliar.getEnlace();            
//        }
        for (int i = 0; i < getTamanio(); i++) {
            if (i == indice) {
                numero = auxiliar.getInfo();
                auxiliar.setInfo(valor);
                break;
            }
            auxiliar = auxiliar.getLink();
        }

        return numero;
    }
    
    public int buscaNodoIndice(int indice) {
        Nodo auxiliar = primero;              
        for (int i = 0; i < getTamanio(); i++) {
            if (i == indice) {              
               return a.getInfo();                   
            }
            auxiliar = auxiliar.getLink();
        }
        return 0;
    }
    
    public int buscarDatoRecursivamente(int dato) {
//        Nodo p = primero;
//        int numero = 0;
//        while(p.getEnlace() != null) {
//            System.out.println("i :" + p.getInformacion());
//            numero += dato == p.getInformacion() ? +1 : 0;
//            p = p.getEnlace();
//        }
//        
//        return numero;        
        if (a.getLink()== null) {
            return dato == a.getInfo()? +1 : 0;
        }
        int comprobar = dato == a.getInfo()? +1 : 0;
        a = a.getLink();
        return comprobar + buscarDatoRecursivamente(dato);
    }

    public boolean borrarNodoRecursivamente(int dato) {
//        if(dato == a.getInformacion() && a.getEnlace() != null) {
//            a.setInformacion(0);
//            return true;
//        }        
//        a = a.getEnlace();
//        return borrarNodoRecursivamente(dato);      
        if (dato != a.getInfo()&& a.getLink() != null) {            
            a = a.getLink();
            return borrarNodoRecursivamente(dato);
        }
        boolean comprobar = dato == a.getInfo();
        a.setInfo(0);       
        return comprobar;
    }
    
    public Nodo getPrimerNodo() {
        return primero;
    }
    
    public void duplicarLista(Lista lista) {
        Nodo auxiliar = lista.getPrimerNodo();
        int counterIndice =  0;//;
//        System.out.println("I : " + counterIndice);
        while(auxiliar.getLink()!= null) {
            insertarNodoInicio(auxiliar.getInfo());
            counterIndice++;
            auxiliar = auxiliar.getLink();                      
        }
        insertarNodoInicio(auxiliar.getInfo());
    }
}
/* OBJETOS son entidades que representa cosas del mundo. Entidades logicas*/
