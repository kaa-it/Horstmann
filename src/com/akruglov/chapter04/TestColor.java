package com.akruglov.chapter04;

/**
 * Created by akruglov on 28.03.17.
 */

enum Color {
    BLACK(0xFFFFFFFF), RED(0xFFFF0000), BLUE(0xFF0000FF),
    GREEN(0xFF00FF00), CYAN(0xFF00FFFF), MAGENTA(0xFFFF00FF),
    YELLOW(0xFFFFFF00), WHITE(0xFF000000);

    private int color;

    Color(int color) {
        this.color = color;
    }

    public int getRed() {
        return (this.color & 0x00FF0000) >> 16;
    }

    public int getGreen() {
        return (this.color & 0x0000FF00) >> 8;
    }

    public int getBlue() {
        return (this.color & 0x000000FF);
    }
}


public class TestColor {
    public static void main(String[] args) {
        System.out.println(Color.MAGENTA.getRed());
    }
}
