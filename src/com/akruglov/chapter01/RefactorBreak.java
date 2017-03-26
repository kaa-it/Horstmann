package com.akruglov.chapter01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.function.Function;

/**
 * Created by akruglov on 22.03.17.
 */
public class RefactorBreak {

    private static class MyCompletableFuture<T> {

        volatile Object result;

        final <S> boolean uniApply(MyCompletableFuture<S> a,
                                   Function<? super S, ? extends T> f,
                                   UniApply<S, T> c) {
            Object r;
            Throwable x;
            if (a == null || (r = a.result) == null || f == null)
                return false;
            tryComplete:
            if (result == null) {
                if (r instanceof AltResult) {
                    if ((x = ((AltResult) r).ex) != null) {
                        completeThrowable(x, r);
                        break tryComplete;
                    }
                    r = null;
                }
                try {
                    if (c != null && !c.claim())
                        return false;
                    @SuppressWarnings("unchecked") S s = (S) r;
                    completeValue(f.apply(s));
                } catch (Throwable ex) {
                    completeThrowable(ex);
                }
            }
            return true;
        }

        private void completeThrowable(Throwable ex) {
        }

        private void completeValue(T apply) {
        }

        private void completeThrowable(Throwable x, Object r) {
        }

        private static class UniApply<S, T> {
            public boolean claim() {
                return false;
            }
        }

        private static class AltResult {
            public Throwable ex;
        }
    }

    private static class MyRefactoredCompletableFuture<T> {

        volatile Object result;

        final <S> boolean uniApply(MyRefactoredCompletableFuture<S> a,
                                   Function<? super S, ? extends T> f,
                                   UniApply<S, T> c) {
            Object r;
            Throwable x;
            if (a == null || (r = a.result) == null || f == null)
                return false;

            if (result == null) {
                if (r instanceof AltResult) {
                    if ((x = ((AltResult) r).ex) != null) {
                        completeThrowable(x, r);
                        return true;
                    }
                    r = null;
                }
                try {
                    if (c != null && !c.claim())
                        return false;
                    @SuppressWarnings("unchecked") S s = (S) r;
                    completeValue(f.apply(s));
                } catch (Throwable ex) {
                    completeThrowable(ex);
                }
            }
            return true;
        }

        private void completeThrowable(Throwable ex) {
        }

        private void completeValue(T apply) {
        }

        private void completeThrowable(Throwable x, Object r) {
        }

        private static class UniApply<S, T> {
            public boolean claim() {
                return false;
            }
        }

        private static class AltResult {
            public Throwable ex;
        }
    }

    public static void main(String[] args) {

    }
}
