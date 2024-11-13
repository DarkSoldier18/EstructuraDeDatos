
public class ListaSE<T> implements Lista<T> {
    private NodoSE<T> inicio;

    public ListaSE() {
        inicio = null;
    }

    public boolean vacia() {
        return inicio == null;
    }

    public void insertar(T dato) {
        NodoSE<T> nuevo = new NodoSE<T>(dato);
        if (vacia()) {
            inicio = nuevo;
        } else {
            NodoSE<T> ac = inicio;
            while (ac.getSig() != null) {
                ac = ac.getSig();// avanzar
            }
            ac.setSig(nuevo);
        }
    }

    public void insertar(T dato, int pos) {
        if (pos <= longitud()) {
            NodoSE<T> nuevo = new NodoSE<T>(dato);
            if (vacia()) {
                inicio = nuevo;
            } else {
                if (pos == 0) {
                    nuevo.setSig(inicio);
                    inicio = nuevo;
                } else {
                    NodoSE<T> ac = inicio;
                    while (ac.getSig() != null && pos > 1) {
                        ac = ac.getSig();
                        pos--;
                    }
                    nuevo.setSig(ac.getSig());
                    ac.setSig(nuevo);

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
        return null;
    }

    public boolean eliminar(T d) {
        boolean res = false;
        if (!vacia()) {
            NodoSE<T> ac = inicio, ant = null;
            while (!res && ac != null) {
                if (d.equals(ac.getDato())) {
                    res = true;
                    if (ac == inicio)
                        inicio = inicio.getSig();
                    else {
                        ant.setSig(ac.getSig());
                    }
                } else {
                    ant = ac;
                    ac = ac.getSig();
                }
            }
        }
        return res;
    }

    public void eliminarTodo() {
    }

    public Lista<T> eliminar(int inf, int sup) {
        return null;
    }

    public Lista<T> eliminarTodas(T d) {
        return null;
    }

    public T acceder(int pos) {
        T res = null;
        if (pos < longitud()) {
            NodoSE<T> ac = inicio;
            while (pos > 0) {
                ac = ac.getSig();
                pos--;
            }
            res = ac.getDato();
        }
        return res;
    }

    public Lista<T> acceder(int inf, int sup) {
        return null;
    }

    public int longitud() {
        int res = 0;
        if (!vacia()) {
            NodoSE<T> ac = inicio;
            while (ac != null) {
                res = res + 1;
                ac = ac.getSig();
            }
        }
        return res;
    }

    public boolean buscar(T d) {
        boolean encontrado = false;
        if (!vacia()) {
            NodoSE<T> ac = inicio;
            do {
                if (d.equals(ac.getDato())) {
                    encontrado = true;
                } else {
                    ac = ac.getSig();
                }
            } while (!encontrado && ac != null);
        }
        return encontrado;
    }

    public int indiceDe(T d) {
        return -1;
    }

    public Lista<Integer> indiceDeTodas(T d) {
        return null;
    }

    public void establecer(T d, int pos) {
        if (pos < longitud()) {
            NodoSE<T> ac = inicio;
            while (pos > 0) {
                ac = ac.getSig();
                pos--;
            }
            ac.setDato(d);
        }
    }

    public void intercambiar(int orig, int dest) {
        if (orig < dest && dest < longitud()) {
            T dOrigen = acceder(orig), dDestino = acceder(dest);
            establecer(dDestino, orig);
            establecer(dOrigen, dest);
        }
    }

    public String serializar() {
        return "";
    }

    public Lista<Lista<T>> split(int n) {
        Lista<Lista<T>> res = new ListaSE<Lista<T>>();
        return res;
    }
}