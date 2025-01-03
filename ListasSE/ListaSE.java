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

    public void eliminarTodo() {
        inicio = null;
    }

    public T eliminar(int pos) {
        T dato = null;
        if (pos < longitud()) {
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
        boolean eliminado = false;
        if (!vacia()) {
            if (inicio.getSig() == null) {
                inicio = null;
                eliminado = true;
            } else {
                NodoSE<T> actual = inicio;
                NodoSE<T> anterior = null;
                do {
                    if (actual.getDato().equals(d)) {
                        if (actual == inicio) {
                            inicio = inicio.getSig();
                        } else {
                            anterior.setSig(actual.getSig());
                        }
                        eliminado = true;
                        break;
                    } else {
                        anterior = actual;
                        actual = actual.getSig();
                    }
                } while (actual != null);
            }
        }
        return eliminado;
    }

    public T acceder(int pos) {
        T res = null;
        if (pos < longitud()) {
            if (!vacia()) {
                NodoSE<T> actual = inicio;
                int cont = 0;
                while (cont < pos) {
                    actual = actual.getSig();
                    cont++;
                }
                res = actual.getDato();
            }
        }
        return res;
    }

    public boolean buscar(T d) {
        boolean res = false;
        NodoSE<T> actual = inicio;
        while (actual != null) {
            if (actual.getDato().equals(d)) {
                res = true;
                break;
            } else {
                actual = actual.getSig();
            }
        }
        return res;
    }

    public int indiceDe(T d) {
        int cont = 0;
        NodoSE<T> actual = inicio;
        while (actual.getSig() != null) {
            if (actual.getDato() == d) {
                break;
            } else {
                cont++;
                actual = actual.getSig();
            }
        }
        return cont;
    }

    public void cambiarValor(T d, int pos) {
        NodoSE<T> actual = inicio;
        if (pos < longitud()) {
            int cont = 0;
            while (cont < pos) {
                cont++;
                actual = actual.getSig();
            }
            actual.setDato(d);
        }
    }

    public void intercambiar(int orig, int dest) {
        if (dest < longitud() && orig < longitud()) {
            T dato1 = acceder(orig);
            T dato2 = acceder(dest);
            cambiarValor(dato2, orig);
            cambiarValor(dato1, dest);
        }
    }

    public String serializar() {
        String res = "";
        if (!vacia()) {
            NodoSE<T> actual = inicio;
            do {
                res = res + actual.getDato();
                actual = actual.getSig();
            } while (actual != null);
        }
        return res;
    }

    public void insertar(Lista<T> l, int pos) {

    }

    public Lista<T> eliminar(int inf, int sup) {
        return null;
    }

    public Lista<T> eliminarTodas(T d) {
        return null;
    }

    public Lista<T> acceder(int inf, int sup) {
        return null;
    }

    public Lista<Integer> indiceDeTodas(T d) {
        return null;
    }

    public Lista<Lista<T>> split(int n) {
        return null;
    }
}