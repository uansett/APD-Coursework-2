package johansen.stian.apd.cw2;

public class Poly {

    private Pair[] terms;
    private int deg;
    // 2x^2 + 2x^2

    public Poly() {
        terms = new Pair[1];
        terms[0] = new Pair(0, 0);
        deg = terms[0].exp;
    }

    public Poly(int m, int n) throws NegativeExponentException {
        if (n < 0) {
            throw new NegativeExponentException("Poly(int,int) constructor");
        }
        if (m == 0) {
            terms = new Pair[1];
            terms[0] = new Pair(0, 0);
            deg = terms[0].exp;
            return;
        }
        terms = new Pair[1];
        terms[0] = new Pair(m, n);
        deg = n;
    }

    private Poly(Poly p, int n) {
        terms = new Pair[p.terms.length];
        terms[p.terms.length - 1] = new Pair(0, n);
        deg = n;
    }

    public int degree() {
        return deg;
    }

    public int coeff(int d) {
        for (int i = 0; i < terms.length; i++) {
            Pair p = (Pair) terms[i];
            if (p.exp == d) {
                return p.coeff;
            }
        }
        return 0;


    }

    public Poly sub(Poly q) throws NullPointerException {
        return add(q.minus());
    }
    // poly1.minus();

    public Poly minus() {
        Poly r = new Poly(this, deg);
        for (int i = 0; i < r.terms.length; i++) {
            r.terms[i].coeff = -terms[i].coeff;
        }
        return r;
    }

    public Poly add(Poly q) throws NullPointerException {

        Poly largest, smallest;
        if (q.terms.length > terms.length) {
            largest = q;
            smallest = this;
        } else {
            largest = this;
            smallest = q;
        }
        Poly r = new Poly(largest, Math.max(deg, q.deg));
        for (int i = 0; i < r.terms.length; i++) {
            r.terms[i].coeff += largest.terms[i].coeff;
            r.terms[i].coeff += smallest.terms[i].coeff;
        }
        return r;
    }

    public Poly mult(Poly q) throws NullPointerException {
        if ((q.deg == 0 && q.terms[0].coeff == 0)
                || (deg == 0 && terms[0].coeff == 0)) {
            return new Poly();
        }

        Poly r = new Poly(this, deg + q.deg);
        for (Pair p : r.terms) {
            if (p.exp == deg + q.deg) {
                p.coeff = 0;
            }
        }
        for (int i = 0; i < r.terms.length; i++) {
            for (int j = 0; j < q.terms.length; j++) {
                r.terms[i + j].coeff = r.terms[i + j].coeff + terms[i].coeff * q.terms[j].coeff;
            }
        }
        return r;
    }

    @Override
    public String toString() {
        String returnValue = "";
        for (Pair p : terms) {
            returnValue += p.coeff + "X^" + p.exp + "";
        }


        return returnValue;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Poly)) {
            return false;
        }
        Poly a = (Poly) o;
        if (this.deg == a.deg && a.terms.length == this.terms.length) {
            for (int i = 0; i < terms.length; i++) {
                if (!this.terms[0].equals(a.terms[0])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    class Pair {

        int coeff;
        int exp;

        Pair(int c, int n) {
            coeff = c;
            exp = n;
        }

        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }
            if (!(o instanceof Pair)) {
                return false;
            }
            Pair a = (Pair) o;
            if (a.coeff == this.coeff && a.exp == this.exp) {
                return true;
            }
            return false;
        }
    }
}