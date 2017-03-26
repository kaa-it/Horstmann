package com.akruglov.chapter02;

/**
 * Created by kruglovs on 23.03.17.
 */
public class ImmutablePoint {

    private double x;
    private double y;

    public ImmutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public ImmutablePoint translate(double dx, double dy) {
        return new ImmutablePoint(x + dx, y + dy);
    }

    public ImmutablePoint scale(double factor) {
        return new ImmutablePoint(x * factor, y * factor);
    }

    @Override
    public String toString() {
        return "ImmutablePoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        ImmutablePoint p = new ImmutablePoint(3, 4).translate(1, 3).scale(0.5);
        System.out.println(p);
    }
}
