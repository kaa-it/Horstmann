package com.akruglov.chapter04.shapes;

import com.akruglov.chapter04.points.Point;

/**
 * Created by akruglov on 28.03.17.
 */
public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        return new Point(getPoint().getX() + width / 2, getPoint().getY() - height / 2);
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        return (Rectangle) super.clone();
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "width=" + width +
                ", height=" + height +
                "}";
    }
}
