package com.akruglov.chapter01;

/**
 * Created by akruglov on 22.03.17.
 */
public class PrintUnicode {
    public static void main(String[] args) {
        String value = "AF ảbvỌỀ";

        for (int codePoint : value.codePoints().toArray()) {
            if (codePoint > 256) {
                System.out.printf("%s : \\u%x\n",
                        new String(new int[] { codePoint }, 0, 1),
                        codePoint);
            }
        }


    }
}
