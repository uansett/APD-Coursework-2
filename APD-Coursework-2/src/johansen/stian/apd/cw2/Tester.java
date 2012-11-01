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
        Poly p1 = null;
        p1 = new Poly(2,1);
        p1 = p1.add(new Poly(12,1));
        p1 = p1.add(new Poly(3,3));
        System.out.println("Poly p1: "+p1.toString()+"(degree: "+2+")");

    }
}
