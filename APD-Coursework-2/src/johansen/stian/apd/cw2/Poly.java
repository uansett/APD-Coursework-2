package johansen.stian.apd.cw2;

public class Poly {
    private int[] terms;
    private int deg;
    
    public Poly(){
        terms = new int[1];
        deg = 0;
    }
    
    public Poly(int c, int n) throws NegativeExponentException{
        if (n<0) {
            throw new NegativeExponentException("Poly(int,int) constructor");
        }
        if(c == 0){
            terms = new int[1];
            deg = 0;
            return;
        }
        terms = new int[n+1];
        for(int i;i<n;i++){
            terms[i] = 0;
        }
        terms[n] = c;
        deg = n;
    }
    
    private Poly (int n){
        terms = new int[n+1];
        deg = n;
    }
    
    
}