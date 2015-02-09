package edu.uniandes.ecos;

import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        LinkedList<Double> x = new LinkedList<Double>();
        x.add(130.0);
        x.add(650.0);
        x.add(99.0);
        x.add(150.0);
        x.add(128.0);
        x.add(302.0);
        x.add(95.0);
        x.add(945.0);
        x.add(368.0);
        x.add(961.0);
        LinkedList<Double> y = new LinkedList<Double>();
        /* y.add(163.0);
         y.add(765.0);
         y.add(141.0);
         y.add(166.0);
         y.add(137.0);
         y.add(355.0);
         y.add(136.0);
         y.add(1206.0);
         y.add(433.0);
         y.add(1130.0);
        */
        y.add(186.0);
        y.add(699.0);
        y.add(132.0);
        y.add(272.0);
        y.add(291.0);
        y.add(331.0);
        y.add(199.0);
        y.add(1890.0);
        y.add(788.0);
        y.add(1601.0);
        
        
        Calculos cal = new Calculos(x, y);
        System.out.println("Hello World!  B1:" + cal.getB1()+"  B0:  "+cal.getB0());
    }
}
