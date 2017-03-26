package com.akruglov.test;

public interface MyInterface {

	boolean hasNext();

	int next();

	default void remove() {
		throw new UnsupportedOperationException();
	}

	void foreachRemaining();
}
