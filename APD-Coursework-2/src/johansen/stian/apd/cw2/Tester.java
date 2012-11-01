/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package johansen.stian.apd.cw2;

/**
 *
 * @author stian
 */
public class Tester {
    public static void main(String[] args) throws NegativeExponentException {
        // Poly p0 = new Poly(1,-14) - throws NegativeExponentException
        Poly p0 = new Poly();
        System.out.println("Zero-polynomial: "+p0.toString());
        Poly p1 = new Poly(5,10);
        System.out.println("Poly 1: "+p1.toString());
        Poly p2 = new Poly(1,2);
        System.out.println("Poly 2: "+p2.toString());
        Poly p3 = p1.add(p2);
        System.out.println("Poly 3(1+2): "+p3.toString());
        Poly p3mul = p1.mult(p2);
        System.out.println("Poly 1*2: "+p3mul.toString());
        Poly p3min = p3.sub(p1);
        System.out.println("Poly 3-1: "+p3min.toString());
        Poly p4 = new Poly(1,2);
        System.out.println("Similarity: "+p2.toString()+" == "+p4.toString() + " is "+p2.equals(p4));
        System.out.println("Similarity: "+p3.toString()+" == "+p4.toString() + " is "+p3.equals(p4));

    }
}
