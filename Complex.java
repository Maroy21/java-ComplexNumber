package com.company;

public class Complex {

    double re, im;

    Complex() {
        this.re = 0;
        this.im = 0;
    }
    Complex(double x) {
        this.re = x;
        this.im = 0;
    }
    Complex(double x, double y) {
        this.re = x;
        this.im = y;
    }
    double re() {return re;}
    double im() {return im;}

    void Print () {
        System.out.println(this.re() + " + i" + this.im());
    }

    double getModule () {
        return Math.sqrt(this.re * this.re + this.im * this.im);
    }

    double GetArg() {
        if (this.re > 0) {
            return Math.atan(im / re);
        } else {
            if (re < 0 && im > 0) {
                return Math.PI + Math.atan(im / re);
            } else {
                return -Math.PI + Math.atan(im / re);
            }
        }
    }

    public static Complex sum(Complex cn1, Complex cn2) {
        return new Complex(cn1.re() + cn2.re(), cn1.im() + cn2.im());
    }

    public static Complex multiply(Complex cn1, Complex cn2) {
        return new Complex(cn1.re() * cn2.re() - cn1.im() * cn2.im(), cn1.re() * cn2.im() + cn1.im() * cn2.re());
    }

    public static Complex subtract(Complex cn1, Complex cn2) {
        return new Complex(cn1.re() - cn2.re(), cn1.im() - cn2.im());
    }

    public static Complex divide(Complex cn1, Complex cn2) {
        Complex temp = new Complex(cn2.re(), (-1) * cn2.im());
        temp = Complex.multiply(cn1, temp);
        double denominator = cn2.re() * cn2.re() + cn2.im() * cn2.im();
        return new Complex(temp.re() / denominator, temp.im() / denominator);
    }
}
