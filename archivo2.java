public class archivo2 {
    public static void main(String[] args) {
        System.out.println("hola");
    }

    public int factorial(int n){
        if(n<=1){
            return 1;
        }else{
            return n*factorial(n-1);
        }
    }
}
