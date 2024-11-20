public class ListaSEC<T> {
    private NodoSE<T> inicio;
    private NodoSE<T> ultimo;

    public boolean vacia() {
        return inicio == null;
    }

    public void insertar(T dato) {
        NodoSE<T> nuevo = new NodoSE<T>(dato);
        if (vacia()) {
            inicio = nuevo;
            inicio.setSig(inicio);
            ultimo = nuevo;
        } else {
            NodoSE<T> actual = inicio;
            while (actual.getSig() != inicio) {
                actual = actual.getSig();
            }
            actual.setSig(nuevo);
            nuevo.setSig(inicio);
            ultimo = nuevo;
        }
    }

    public int longitud() {
        int lon = 0;
        if (!vacia()) {
            NodoSE<T> actual = inicio;
            do {
                lon++;
                actual = actual.getSig();
            } while (actual != inicio);
        }
        return lon;
    }

    public void insertar(T dato, int pos) {
        if (pos < longitud()) {
            NodoSE<T> nuevo = new NodoSE<T>(dato);
            if (vacia()) {
                inicio = nuevo;
                inicio.setSig(inicio);
                ultimo = inicio;
            } else {
                if (pos == 0) {
                    ultimo.setSig(nuevo);
                    nuevo.setSig(inicio);
                    inicio = nuevo;
                } else {
                    NodoSE<T> actual = inicio;
                    for (int i = 0; i < pos - 1; i++) {
                        actual = actual.getSig();
                    }
                    NodoSE<T> aux = actual.getSig();
                    if (aux.getSig() == ultimo) {
                        actual.setSig(nuevo);
                        nuevo.setSig(aux);
                        ultimo = nuevo;
                    } else {
                        nuevo.setSig(aux);
                        actual.setSig(nuevo);
                    }
                }
            }
        }
    }

    public void insertarInicio(T dato) {
        NodoSE<T> nuevo = new NodoSE<T>(dato);
        if (vacia()) {
            inicio = nuevo;
            inicio.setSig(inicio);
            ultimo = inicio;
        } else {
            nuevo.setSig(inicio);
            ultimo.setSig(nuevo);
            inicio = nuevo;
        }
    }

    public T eliminar(int pos) {
        T dato = null;
        if (pos < longitud()) {
            if (pos == 0) {
                dato = inicio.getDato();
                inicio = inicio.getSig();
                ultimo.setSig(inicio);
            } else {
                NodoSE<T> actual = inicio;
                NodoSE<T> anterior = null;
                for (int i = 0; i < pos; i++) {
                    anterior = actual;
                    actual = actual.getSig();
                }
                dato = actual.getDato();
                if (actual.getSig() == inicio) {
                    anterior.setSig(inicio);
                    ultimo = anterior;
                } else {
                    anterior.setSig(actual.getSig());
                }
            }
        }
        return dato;
    }

    public boolean eliminar(T dato) {
        boolean eliminado = false;
        if (!vacia()) {
            if (inicio == ultimo) {
                inicio = null;
                ultimo = null;
                eliminado = true;
            } else {
                NodoSE<T> actual = inicio;
                NodoSE<T> anterior = null;
                do {
                    if (actual.getDato().equals(dato)) {
                        if (anterior == null) {
                            inicio = inicio.getSig();
                            ultimo.setSig(inicio);
                        } else {
                            if (actual == ultimo) {
                                anterior.setSig(inicio);
                            } else {
                                anterior.setSig(actual.getSig());
                            }
                        }
                        eliminado = true;
                        break;
                    } else {
                        anterior = actual;
                        actual = actual.getSig();
                    }
                } while (actual != inicio);
            }
        }
        return eliminado;
    }

    public void eliminarTodo() {
        if (!vacia()) {
            inicio = null;
            ultimo = null;
        }
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
        do {
            if (actual.getDato().equals(d)) {
                res = true;
                break;
            } else {
                actual = actual.getSig();
            }
        } while (actual != inicio);
        return res;
    }

    public int indiceDe(T d) {
        int cont = 0;
        NodoSE<T> actual = inicio;
        while (actual.getSig() != inicio) {
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
            } while (actual != inicio);
        }
        return res;
    }
}
