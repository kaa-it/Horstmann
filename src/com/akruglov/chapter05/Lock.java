package com.akruglov.chapter05;

import java.util.concurrent.locks.ReentrantLock;

public class Lock {

    private static AutoCloseable useLock(ReentrantLock lock) {
        class RLock implements AutoCloseable {
            private ReentrantLock lock;

            private RLock(ReentrantLock lock) {
                this.lock = lock;
            }

            private void lock() {
                lock.lock();
            }

            private void unlock() {
                lock.unlock();
            }

            @Override
            public void close() throws Exception {
                unlock();
            }
        }

        RLock smartLock = new RLock(lock);
        smartLock.lock();
        return smartLock;
    }

    public static void main(String[] args) {
        try (AutoCloseable lock = useLock(new ReentrantLock())) {
            // write concurrent secure code
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
