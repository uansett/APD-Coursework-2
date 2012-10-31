/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package johansen.stian.apd.cw2;

/**
 *
 * @author stian
 */
public class NegativeExponentException extends Exception{

    NegativeExponentException(String msg) {
        System.out.println("NegativeExponentException: "+msg+"\n");
    }
    
}
