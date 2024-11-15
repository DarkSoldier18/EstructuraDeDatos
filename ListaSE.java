public class ListaSE<T> implements Lista<T> {
    private NodoSE<T> inicio;

    public ListaSE() {
        inicio = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public int longitud() {
        int res = 0;
        if (!vacia()) {
            NodoSE<T> aux = inicio;
            while (aux.getSig() != null) {
                res++;
                aux = aux.getSig();
            }
        }
        return res + 1;
    }

    public void insertar(T d) {
        NodoSE<T> nuevo = new NodoSE<>(d);
        if (vacia()) {
            inicio = nuevo;
        } else {
            NodoSE<T> aux = inicio;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
        }
    }

    public void insertar(T d, int pos) {
        if (pos <= longitud()) {
            NodoSE<T> nuevo = new NodoSE<T>(d);
            if (vacia()) {
                inicio = nuevo;
            } else {
                if (pos == 0) {
                    nuevo.setSig(inicio);
                    inicio = nuevo;
                } else {
                    NodoSE<T> actual = inicio;
                    for (int i = 0; i < pos - 1; i++) {
                        actual = actual.getSig();
                    }
                    NodoSE<T> auxi = actual.getSig();
                    nuevo.setSig(auxi);
                    actual.setSig(nuevo);
                }
            }
        }
    }

    public void insertarInicio(T dato) {
        NodoSE<T> nuevo = new NodoSE<T>(dato);
        if (!vacia()) {
            nuevo.setSig(inicio);
        }
        inicio = nuevo;
    }

    public void insertar(Lista<T> l, int pos) {

    }

    public T eliminar(int pos) {
        T dato = null;
        if (pos < longitud() - 1) {
            if (!vacia()) {
                if (pos == 0) {
                    dato = inicio.getDato();
                    inicio = inicio.getSig();
                } else {

                    NodoSE<T> actual = inicio;
                    for (int i = 0; i < pos - 1; i++) {
                        actual = actual.getSig();
                    }
                    NodoSE<T> auxi = actual.getSig();
                    actual.setSig(auxi.getSig());
                    dato = auxi.getDato();
                }
            }
        }
        return dato;
    }

    public boolean eliminar(T d) {
        boolean res = false;
        NodoSE<T> actual = inicio;
        NodoSE<T> anterior = inicio;
        while (actual.getSig() != null) {
            if (actual.getDato() == d) {
                res = true;
                break;
            } else {
                anterior = actual;
                actual = actual.getSig();
            }
        }
        NodoSE<T> sig = actual.getSig();
        if (sig.getDato() == d) {
            res = true;
        }
        if (res) {
            anterior.setSig(actual.getSig());
        }
        return res;
    }
    public void eliminarTodo(){
        inicio=null;
    }
    public T acceder(int pos){                      //metodo para acceder a los datos de la lista
        T res=null;
        if (pos<longitud()) {                       // verifica que la posicion solicitada este dentro de la lista
            if (!vacia()) {                         // verifica que la lista no este vacia
                NodoSE<T> actual=inicio;            // actual es un puntero que ira avanzando nodo por nodo hasta llegar a la posicion
                int cont=0;
                while(cont<=pos){                   //esta iteracion hace que el puntero se desplace hasta la posicion que queremos
                    actual=actual.getSig();
                }
                res=actual.getDato();               // esta variable almacena el dato que hay en el puntero
            }
        }
        return res;                                 // devuelve el dato almacenado en res
    }
    public boolean buscar(T d){                     // busca un elemento en la lista
        boolean res=false;                          // variable bandera que indica que el dato existe en la lista
        NodoSE<T> actual = inicio;                  // Nodo puntero que avanza en la lista con cada iteracion
        while (actual.getSig()!=null) {             // itera hasta llegar al final de la lista
            if (actual.getDato()==d) {              // si el dato se encuentra en el puntero actualiza la variable bandera y sale del bucle
                res=true;
                break;
            }else{                                  //si no, el puntero avanza al siguiente nodo
                actual=actual.getSig();
            }
        }
        return res;
    }

    public int indiceDe(T d){
        int cont=0;
        NodoSE<T> actual = inicio;
        while (actual.getSig()!=null){
            if (actual.getDato()==d) {
                break;
            }else{
                cont++;
                actual=actual.getSig();
            }
        }
        return cont;
    }
    public void cambiarValor(T d, int pos){
        NodoSE<T> actual=inicio;
        if (pos<longitud()){
            int cont=0;
            while (cont<=pos) {
                cont++;
                actual=actual.getSig();
            }
        }
        actual.setDato(d);
    }
    public void intercambiar(int orig, int dest){
        if (dest<longitud() && orig<longitud()) {
            T dato1= acceder(orig);
            T dato2= acceder(dest);
            cambiarValor(dato2,orig);
            cambiarValor(dato1, dest);
        }
    }
    public String serializar(){
        String res="";
        if (!vacia()) {
            NodoSE<T> actual=inicio;
            while (actual.getSig()!=null) {
                res=res+actual.getDato();
                actual=actual.getSig();
            }
        }
        return res;
    }
    public Lista<T> eliminar(int inf, int sup){
        return null;
    }

    public Lista<T> eliminarTodas(T d){
        return null;
    }
    public Lista<T> acceder(int inf, int sup){
        return null;
    }
    public Lista<Integer> indiceDeTodas(T d){
        return null;
    }
    public Lista< Lista <T> > split(int n){
        return null;
    }
}