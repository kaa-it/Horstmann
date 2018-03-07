package com.akruglov.chapter08;

import java.util.stream.Stream;

public class Streams {

    public static void testPeek() {
        Stream<String> stream = Stream.of("sasas", "ss", "qassdfgf", "s", "dfdfdf", "ds",
                "ddfdfd", "ghjh", "gg", "fsgfgfdgd", "dfsf", "dsfdsfsf");

        Stream<String> filtered = stream.filter(x -> { System.out.println("filter"); return x.length() > 4;}).peek(x -> System.out.println(x)).limit(5);

        filtered.forEach(x -> { System.out.println("x = " + x);});
    }

    public static void main(String[] args) {
        testPeek();
    }
}
