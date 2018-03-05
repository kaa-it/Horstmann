package com.akruglov.chapter06;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Pair<E extends Comparable<E>> {
    private E first;
    private E second;

    public Pair(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public E getFirst() {
        return first;
    }

    public E getSecond() {
        return second;
    }

    public E max() {
        if (first.compareTo(second) > 0) {
            return first;
        } else {
            return second;
        }
    }

    public E min() {
        if (first.compareTo(second) < 0) {
            return first;
        } else {
            return second;
        }
    }

    public static void main(String[] args) throws Exception {
        Arrays.testRepeat();
        Method m = Collections.class.getMethod("sort", List.class);
        System.out.println(Arrays.genericDeclaration(m));
        m = Arrays.class.getMethod("minmax", List.class, Comparator.class, List.class);
        System.out.println(Arrays.genericDeclaration(m));
    }
}

class Lists {
    public static void swap(List<?> elements, int i, int j) {
        swapHelper(elements, i, j);
    }

    public static <T> void swapHelper(List<T> elements, int i, int j) {
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
}

class Arrays {
    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<? extends E> a) {
        return new Pair<>(a.get(0), a.get(a.size() -1));
    }

    public static <E extends Comparable<E>> E min(ArrayList<? extends E> a) {
        E result = a.get(0);

        for (E e : a) {
            if (e.compareTo(result) < 0) {
                result = e;
            }
        }

        return result;
    }

    public static <E extends Comparable<E>> E max(ArrayList<? extends E> a) {
        E result = a.get(0);

        for (E e : a) {
            if (e.compareTo(result) > 0) {
                result = e;
            }
        }

        return result;
    }

    public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<? extends E> a) {
        return new Pair<>(min(a), max(a));
    }

    public static <T> void minmax(List<T> elements, Comparator<? super T> comp,
                                  List<? super T> result) {
        T min = elements.get(0);
        T max = elements.get(0);

        for (T e : elements) {
            if (comp.compare(e, min) < 0) {
                min = e;
            }
            if (comp.compare(e, max) > 0) {
                max = e;
            }
        }

        result.add(min);
        result.add(max);
    }

    public static <T> void maxmin(List<T> elements,
                                  Comparator<? super T> comp, List<? super T> result) {
        minmax(elements, comp, result);
        Lists.swap(result, 0, 1);
    }

    public static <T extends AutoCloseable> void closeAll(ArrayList<T> elems) throws Exception {

        Exception commonException = new Exception();

        for (T elem : elems) {
            try {
                elem.close();
            } catch (Exception e) {
                commonException.addSuppressed(e);
            }
        }

        if (commonException.getSuppressed().length > 0) {
            throw commonException;
        }
    }

    public static <T, R> ArrayList<R> map(ArrayList<T> elems, Function<T,R> func) {
        ArrayList<R> result = new ArrayList<>();

        for (T elem : elems) {
            result.add(func.apply(elem));
        }

        return result;
    }

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr) {
        T[] result = constr.apply(n);
        for (int i = 0; i < n; i++) {
            result[i] = obj;
        }
        return result;
    }

    public static void testRepeat() throws Exception {
        Integer[] array = repeat(10, 42, Integer[]::new);
        ArrayList<String> a = new ArrayList<>();
        //String[] astr = (String[])a.toArray();
        List<String>[] result = Arrays.<List<String>>construct(10);
        System.out.println(result.length);
        System.out.println(doWork(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "test";
            }
        }, Exception::new));
        System.out.println("Completed");
    }

    @SafeVarargs public static <T> T[] repeat(int n, T... objs) {
        T[] res = java.util.Arrays.copyOf(objs, n * objs.length);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < objs.length; j++) {
                res[j*i] = objs[j];
            }
        }

        return res;
    }

    @SafeVarargs public static <T> T[] construct(int n, T... objs) {
        T[] result = java.util.Arrays.copyOf(objs, n);

        for (int i = 0; i < n && i < objs.length; i++) {
            result[i] = objs[i];
        }

        return result;
    }

    /*
    public static <V, T extends Throwable> V doWork(Callable<V> c, T ex) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            ex.initCause(realEx);
            throw ex;
        }
    }
    */

    public static <V, T extends Throwable> V doWork(Callable<V> c, Supplier<T> func) throws T {
        try {
            return c.call();
        } catch (Throwable realEx) {
            //throw (RuntimeException) realEx;
            T ex = func.get();
            ex.initCause(realEx);
            throw ex;
        }
    }

    public static String genericDeclaration(Method m) {
        StringBuilder sb = new StringBuilder();
        sb.append(Modifier.toString(m.getModifiers()) + " <");
        TypeVariable<Method>[] vars = m.getTypeParameters();
        for (int i = 0; i < vars.length; i++) {
            sb.append(vars[i].toString());
            Type[] bounds = vars[i].getBounds();
            if (bounds.length > 0) {
                sb.append(" extends ");
            }
            for (int j = 0; j < bounds.length; j++) {
                sb.append(bounds[j].getTypeName());
                /*if (bound instanceof ParameterizedType) {
                    ParameterizedType p = (ParameterizedType) bound;
                    sb.append("<");
                    Type[] typeArguments = p.getActualTypeArguments();
                    for (Type typeArg : typeArguments) {
                        if (typeArg instanceof WildcardType) {
                            WildcardType t = (WildcardType) typeArg;
                            Type[] upper = t.getUpperBounds();
                            Type[] lower = t.getLowerBounds();
                            if (upper.length > 0) {
                                sb.append("? extends ");
                                for (Type u : upper) {
                                    sb.append(u.getTypeName() + " || ");
                                }
                            }
                            if (lower.length > 0) {
                                sb.append("? super ");
                                for (Type l : lower) {
                                    sb.append(l.getTypeName() + " || ");
                                }
                            }
                        } else {
                            sb.append(typeArg.getTypeName());
                        }
                        sb.append(", ");
                    }
                    sb.append(">");
                }*/
                if (j != bounds.length - 1) {
                    sb.append(" & ");
                }
            }
            if (i != vars.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("> ");
        sb.append(m.getReturnType().getCanonicalName() + " ");
        sb.append(m.getName());
        sb.append(java.util.Arrays.toString(m.getParameters()));
        return sb.toString();
    }
}
