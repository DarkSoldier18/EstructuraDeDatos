public interface Lista<T>{
    public boolean vacia();
    public void insertar(T d);
    public void insertar(T d, int pos);
    public void insertarInicio(T d);
    public void insertar(Lista<T> l, int pos);
    
    public T eliminar(int pos);
    public boolean eliminar(T d);
    public void eliminarTodo();
    public Lista<T> eliminar(int inf, int sup);
    public Lista<T> eliminarTodas(T d);
    
    public T acceder(int pos);
    public Lista<T> acceder(int inf, int sup);
    
    public int longitud();
    public boolean buscar(T d);
    public int indiceDe(T d);
    public Lista<Integer> indiceDeTodas(T d);

    public void establecer(T d, int pos);
    public void intercambiar(int orig, int dest);
    public String serializar();
    public Lista< Lista <T> > split(int n);
}