package ua.edu.nuos.web_lab3_jakartaee.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Tabulation {
    private final double a;   // Початок
    private final double b;   // Кінець
    private final double h;   // Крок

    private final List<Point> points;
    private final Function func;

    public Tabulation(double a, double b, double h, Function func) {
        this.a = a;
        this.b = b;
        this.h = h;

        this.func = func;
        this.points = generatePoints();
    }

    // Розрахунок кількості кроків табуляції
    public int calcNumberTabulationSteps(){
        return (int) Math.round((b - a) / h) + 1;
    }

    // Генерації табульованого списку точок (x, y)
    private List<Point> generatePoints(){
        int n = calcNumberTabulationSteps();
        List<Point> p = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            double x = a + i * h;
            double y = func.calculate(x);
            p.add(new Point(x, y));
        }
        return p;
    }

    // Знаходження індексів мінімального та максимального елементів списку
    private ListValue getExtremumValue(String type){
        int index = 0;
        Point extremumVal = points.getFirst();
        for(int i = 0; i < points.size(); i++){
            if(Objects.equals(type, "max") && points.get(i).y() > extremumVal.y()){
                extremumVal = points.get(i);
                index = i;
            }
            if(Objects.equals(type, "min") && points.get(i).y() < extremumVal.y()){
                extremumVal = points.get(i);
                index = i;
            }
        }
        return  new ListValue(index, extremumVal);
    }
    public ListValue getMax() {
        return getExtremumValue("max");
    }
    public ListValue getMin() {
        return getExtremumValue("min");
    }
}