package ua.edu.nuos.web_lab3_jakartaee.model;

public class Function {
    public double calculate(double x) {
        double EPS = 1e-6;
        return (x > 3.4 + EPS) ?
                Math.sin(x) * Math.log10(x) :       // x > 3.4
                Math.cos(x) * Math.cos(x);          // x <= 3.4
    }
}
