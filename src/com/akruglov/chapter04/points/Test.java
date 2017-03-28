package com.akruglov.chapter04.points;

import com.akruglov.chapter04.shapes.Circle;
import com.akruglov.chapter04.shapes.Line;
import com.akruglov.chapter04.shapes.Rectangle;

/**
 * Created by akruglov on 28.03.17.
 */
public class Test {

    public static void main(String[] args) {
        Point point = new Point(5, 6);
        LabeledPoint labeledPoint = new LabeledPoint("gggg", 8, 9);
        Circle circle = new Circle(point, 60);
        Rectangle rectangle = new Rectangle(point, 70, 80);
        Line line = new Line(point, new Point(80, 90));

        try {
            Point point2 = point.clone();
            System.out.println(point2);
            LabeledPoint labeledPoint2 = labeledPoint.clone();
            System.out.println(labeledPoint2);
            Circle circle2 = circle.clone();
            circle.moveBy(10, 10);
            System.out.println(circle2);
            Rectangle rectangle2 = rectangle.clone();
            rectangle.moveBy(10, 10);
            System.out.println(rectangle2);
            Line line2 = line.clone();
            line.moveBy(10, 10);
            System.out.println(line2);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(point);
        System.out.println(labeledPoint);

    }
}
