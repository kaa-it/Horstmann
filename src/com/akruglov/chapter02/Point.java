package com.akruglov.chapter02;

/**
 * Class <code>Point</code> describes a point on plane.
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructs a point by coordinates.
     * @param x coordinate by X-axis
     * @param y coordinate by Y-axis
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns a coordinate of point by X-axis.
     * @return coordinate by X-axis
     */
    public double getX() {
        return x;
    }

    /**
     * Returns a coordinate of point by Y-axis.
     * @return coordinate by Y-axis
     */
    public double getY() {
        return y;
    }

    /**
     * Sets a new coordinate of point by X-axis.
     * @param x new coordinate by X-axis
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Sets a new coordinate of point by Y-axis.
     * @param y new coordinate by Y-axis
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Translates a point along X-axis and Y-axis.
     * @param dx offset along X-axis
     * @param dy offset along Y-axis
     */
    public void translate(double dx, double dy) {
        x += dx;
        y += dy;
    }

    /**
     * Scales point coordinates by given coefficient.
     * @param factor coefficient for scaling
     */
    public void scale(double factor) {
        x *= factor;
        y *= factor;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point p = new Point(3, 4);
        p.translate(1, 3);
        p.scale(0.5);
        System.out.println(p);
    }
}
