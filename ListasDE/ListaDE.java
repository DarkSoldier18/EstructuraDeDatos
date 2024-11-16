public class ListaDE<T> {
    private NodoDE<T> inicio;

    public ListaDE() {
        inicio = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public int longitud() {
        int cont = 0;
        if (!vacia()) {
            NodoDE<T> actual = inicio;
            while (actual.getSig() != null) {
                cont++;
                actual = actual.getSig();
            }
        }
        return cont;
    }

    public void insertar(T d) {
        NodoDE<T> nuevo = new NodoDE<T>(d);
        if (vacia()) {
            inicio = nuevo;
        } else {
            NodoDE<T> actual = inicio;
            while (actual.getSig() != null) {
                actual = actual.getSig();
            }
            actual.setSig(nuevo);
            nuevo.setAnt(actual);
        }
    }

    public void insertarInicio(T d) {
        NodoDE<T> nuevo = new NodoDE<T>(d);
        if (vacia()) {
            inicio = nuevo;
        } else {
            inicio.setAnt(nuevo);
            nuevo.setSig(inicio);
            inicio = nuevo;
        }
    }

    public void insertar(T d, int pos) {
        if (pos < longitud()) {
            NodoDE<T> nuevo = new NodoDE<T>(d);
            if (!vacia()) {
                if (pos == 0) {
                    insertarInicio(d);
                } else {
                    NodoDE<T> actual = inicio;
                    for (int i = 0; i < pos - 1; i++) {
                        actual = actual.getSig();
                    }
                    nuevo.setSig(actual.getSig());
                    nuevo.setAnt(actual);
                    actual.setSig(nuevo);
                    NodoDE<T> aux = actual.getSig();
                    aux.setAnt(nuevo);
                }
            }
        }
    }

    public void insertar(Lista<T> l, int pos) {

    }

    public T eliminar(int pos) {
        T dato = null;
        if (pos < longitud() && !vacia()) {
            NodoDE<T> actual = inicio;
            if (pos == 0) {
                dato = inicio.getDato();
                actual = actual.getSig();
                inicio = null;
                inicio = actual;
            } else {
                for (int i = 0; i < pos - 1; i++) {
                    actual = actual.getSig();
                }
                dato = actual.getDato();
                NodoDE<T> aux = actual.getSig();
                actual.setSig(aux);
                aux.setAnt(actual);
            }
        }
        return dato;
    }

    public void eliminarTodo() {
        inicio = null;
        
    }
    
}
