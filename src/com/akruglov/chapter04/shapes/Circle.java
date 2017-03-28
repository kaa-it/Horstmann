package com.akruglov.chapter04.shapes;

import com.akruglov.chapter04.points.Point;

/**
 * Created by akruglov on 28.03.17.
 */
public class Circle extends Shape {

    private double radius;

    public Circle(Point center, double radius) {
        super(center);
        this.radius = radius;
    }

    @Override
    public Point getCenter() {
        return getPoint();
    }

    @Override public Circle clone() throws CloneNotSupportedException {
        return (Circle) super.clone();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }
}
