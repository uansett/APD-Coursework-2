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
        for(int i = 0;i<n;i++){
            terms[i] = 0;
        }
        terms[n] = c;
        deg = n;
    }
    
    private Poly (int n){
        terms = new int[n+1];
        deg = n;
    }
    
    public int degree(){
        return deg;
    }
    
    public int coeff(int d){
        if(d<0 || d > deg) {
            return 0;
        }else{
            return terms[d];
        }
        
        
    }
    
    public Poly sub(Poly q) throws NullPointerException{
            return add(q.minus());
        }
       
    public Poly minus(){
        Poly r = new Poly(deg);
        for(int i=0;i<deg;i++){
            r.terms[i] = -terms[i];
        }
        return r;
    }
    public Poly add(Poly q) throws NullPointerException{
        Poly la,sm;
        if(deg > q.deg){
            la = this; sm = q;
        }else{
            la = q; sm = this;
        }
        int newdeg = la.deg;
        if(deg == q.deg){
            for(int k = deg; k>0;k--){
                if(terms[k] + q.terms[k] != 0){
                    break;
                }else{
                    newdeg--;
                }
            }
        }
        Poly r = new Poly(newdeg);
        int i;
        for(i=0;i<=sm.deg && i <= newdeg;i++){
            r.terms[i] = sm.terms[i] + la.terms[i];
        }
        for(int j = i;j<=newdeg;j++){
            r.terms[j] = la.terms[j];
        }
        return r;
    }
    
    public Poly mul(Poly q) throws NullPointerException{
        if((q.deg == 0 && q.terms[0] == 0) ||
            (deg == 0 && terms[0] == 0)){
            return new Poly();
        }
        Poly r = new Poly(deg+q.deg);
        r.terms[deg+q.deg] = 0;
        for(int i=0;i<=deg;i++){
            for(int j=0;j<=q.deg;j++){
                r.terms[i+j] = r.terms[i+j] + terms[i]*q.terms[j];
            }
        }
        return r;
        
        
    }
    
}