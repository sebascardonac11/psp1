/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.model;

import java.util.LinkedList;

/**
 *
 * @author sebascardonac11
 */
public class Calculos {

    private LinkedList<Double> x;

    private LinkedList<Double> y;

    private double Xavg;
    private double Yavg;

    private double SumXY = 0;
    private double SumXX = 0;
    private double SumYY = 0;

    private double SumX = 0;
    private double SumY = 0;

    private double B0;
    private double B1;

    private double r1;
    private double r2;

    public Calculos(LinkedList<Double> x, LinkedList<Double> y) {
        this.x = x;
        this.y = y;
        this.calculosI();
        this.calB1();
        this.calB0();
        this.calR1();
        this.calR2();
    }

    private void calculosI() {
        for (Object dataI1 : this.x) {
            this.Xavg += ((Double) dataI1);
        }
        this.SumX = this.Xavg;
        this.Xavg = this.Xavg / this.x.size();
        for (Object dataI1 : this.y) {
            this.Yavg += ((Double) dataI1);
        }
        this.SumY = this.Yavg;
        this.Yavg = this.Yavg / this.y.size();

    }

    private void calB0() {
        try {
            this.B0 = this.Yavg - (this.B1 * this.Xavg);
        } catch (Exception e) {
            System.out.println("UPS!! falle en calB1");
        }
    }

    private void calB1() {

        for (int i = 0; i < this.x.size(); i++) {
            SumXY += this.x.get(i) * this.y.get(i);
            SumXX += this.x.get(i) * this.x.get(i);
            SumYY += this.y.get(i) * this.y.get(i);
        }
        this.B1 = (SumXY - (this.x.size() * this.Xavg * this.Yavg))
                / (SumXX - (this.x.size() * (this.Xavg * this.Xavg)));
    }

    private void calR1() {
        int n=this.x.size();
        this.r1 = ((n * this.SumXY) - (this.SumX * this.SumY))
                / (Math.sqrt(
                        ((n*this.SumXX)-(this.SumX*this.SumX))     *       ((n*this.SumYY)-(this.SumY*this.SumY))    
                ));
    }
    
    private void calR2(){
        this.r2 = this.r1 * this.r1;
    }
    
    public double getYK(double XK){
        return this.B0+(this.B1*XK);
    }

    public Double getB0() {
        return this.B0;
    }

    public Double getB1() {
        return this.B1;
    }

    public Double getR1() {
        return this.r1;
    }

    public Double getR2() {
        return this.r2;
    }
}
