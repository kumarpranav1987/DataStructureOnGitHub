package com.pranav.geeksforgeeks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Try {
	private static Lock l = new ReentrantLock();

	public static void main(String[] args) {
		m(1);
	}

	public static void m(int i) {
		try {
			l.lock();
			System.out.println(i);
			m(i+1);
			
		} finally {
			l.unlock();
		}

	}
}
