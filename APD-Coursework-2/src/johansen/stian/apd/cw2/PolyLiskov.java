package johansen.stian.apd.cw2;

public class PolyLiskov {
    private int[] terms;
    private int deg;
    
    public PolyLiskov(){
        terms = new int[1];
        deg = 0;
    }
    
    public PolyLiskov(int c, int n) throws NegativeExponentException{
        if (n<0) {
            throw new NegativeExponentException("PolyLiskov(int,int) constructor");
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
    
    private PolyLiskov (int n){
        terms = new int[n+1];
        deg = n;
    }
    
    @Override
    public String toString(){
        String returnval = "";
        for(int i=0;i<degree();i++){
            returnval += terms[i];
        }
        return returnval;
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
    
    public PolyLiskov sub(PolyLiskov q) throws NullPointerException{
            return add(q.minus());
        }
       
    public PolyLiskov minus(){
        PolyLiskov r = new PolyLiskov(deg);
        for(int i=0;i<deg;i++){
            r.terms[i] = -terms[i];
        }
        return r;
    }
    public PolyLiskov add(PolyLiskov q) throws NullPointerException{
        PolyLiskov la,sm;
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
        PolyLiskov r = new PolyLiskov(newdeg);
        int i;
        for(i=0;i<=sm.deg && i <= newdeg;i++){
            r.terms[i] = sm.terms[i] + la.terms[i];
        }
        for(int j = i;j<=newdeg;j++){
            r.terms[j] = la.terms[j];
        }
        return r;
    }
    
    public PolyLiskov mul(PolyLiskov q) throws NullPointerException{
        if((q.deg == 0 && q.terms[0] == 0) ||
            (deg == 0 && terms[0] == 0)){
            return new PolyLiskov();
        }
        PolyLiskov r = new PolyLiskov(deg+q.deg);
        r.terms[deg+q.deg] = 0;
        for(int i=0;i<=deg;i++){
            for(int j=0;j<=q.deg;j++){
                r.terms[i+j] = r.terms[i+j] + terms[i]*q.terms[j];
            }
        }
        return r;
        
        
    }
    
}