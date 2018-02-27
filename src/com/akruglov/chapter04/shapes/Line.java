package com.akruglov.chapter04.shapes;

import com.akruglov.chapter04.points.Point;

/**
 * Created by akruglov on 28.03.17.
 */
public class Line extends Shape {

    private Point to;

    public Line(Point from, Point to) {
        super(from);
        this.to = to;
    }

    @Override
    public Point getCenter() {
        double x = getPoint().getX() + (to.getX() - getPoint().getX()) / 2;
        double y = getPoint().getY() + (to.getY() - getPoint().getY()) / 2;

        return new Point(x, y);
    }

    @Override
    public Line clone() throws CloneNotSupportedException {
        Line newLine = (Line) super.clone();
        newLine.to = to.clone();
        return newLine;
    }

    @Override
    public void moveBy(double dx, double dy) {
        super.moveBy(dx, dy);
        to = new Point(to.getX() + dx, to.getY() + dy);
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
                "to=" + to +
                "}";
    }
}
