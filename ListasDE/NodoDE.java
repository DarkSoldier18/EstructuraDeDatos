public class NodoDE<T> {
    private T dato;
    private NodoDE<T> sig;
    private NodoDE<T> ant;

    public NodoDE(T d){
        dato=d;
    }
    public T getDato(){
        return dato;
    }
    public NodoDE<T> getSig(){
        return sig;
    }
    public NodoDE<T> getAnt(){
        return ant;
    }
    public void setDato(T d){
        dato=d;
    }

    public void setSig(NodoDE<T> sig){
        this.sig=sig;
    }
    public void setAnt(NodoDE<T> n){
        ant=n;
    }
}