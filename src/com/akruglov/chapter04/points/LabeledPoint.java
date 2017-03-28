package com.akruglov.chapter04.points;

/**
 * Created by akruglov on 28.03.17.
 */
public class LabeledPoint extends Point {

    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LabeledPoint that = (LabeledPoint) o;

        return label != null ? label.equals(that.label) : that.label == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (label != null ? label.hashCode() : 0);
        return result;
    }

    @Override
    public LabeledPoint clone() throws CloneNotSupportedException {
        return (LabeledPoint) super.clone();
    }
}
