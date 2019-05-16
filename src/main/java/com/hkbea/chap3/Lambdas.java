package com.hkbea.chap3;

public class Lambdas {

	public static void main(String[] args) {
		//Runnable r = () -> System.out.println("hello world");
		Thread t = new Thread(() -> {try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		System.out.println("hello world"); }, "hello");
		t.start();
		System.out.println(Thread.currentThread().getName());
	}

}
