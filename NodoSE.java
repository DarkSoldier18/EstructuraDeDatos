
public class NodoSE<T> {
    private T dato;
    private NodoSE<T> sig;

    public NodoSE(T x) {
        dato = x;
        sig = null;
    }

    public T getDato() {
        return dato;
    }

    public NodoSE<T> getSig() {
        return sig;
    }

    public void setDato(T x) {
        dato = x;
    }

    public void setSig(NodoSE<T> y) {
        sig = y;
    }
}
