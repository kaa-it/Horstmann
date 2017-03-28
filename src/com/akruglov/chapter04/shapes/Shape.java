package com.akruglov.chapter04.shapes;

import com.akruglov.chapter04.points.Point;
import sun.security.provider.SHA;

/**
 * Created by akruglov on 28.03.17.
 */
public abstract class Shape implements Cloneable {
    private Point point;

    Shape(Point point) {
        this.point = point;
    }

    protected Point getPoint() {
        return point;
    }

    public void moveBy(double dx, double dy) {
        point = new Point(point.getX() + dx, point.getY() + dy);
    }

    public abstract Point getCenter();

    public Shape clone() throws CloneNotSupportedException {
        Shape newShape = (Shape) super.clone();
        newShape.point = point.clone();
        return newShape;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "point=" + point +
                '}';
    }
}
