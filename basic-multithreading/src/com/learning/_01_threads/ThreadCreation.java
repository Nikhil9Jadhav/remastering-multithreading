package com.learning._01_threads;

public class ThreadCreation {
	
	
	public static void main(String[] args) {
		
//		1. Thread by extending Thread class.
		MyFirstThread myFirstThread = new MyFirstThread("First Thread");
		myFirstThread.start();
		
//		2. Thread by implementing Runnable interface.
		Thread firstRunnableThread = new Thread(new MyFirstRunnable());
		firstRunnableThread.setName("My First Runnable thread");
		firstRunnableThread.start();
		
//		3. Lamda way of creating a anonymous thread.
		new Thread(()-> System.out.println("This is thread using lamda")).start();
	}
	
}


class MyFirstThread extends Thread{
	
	public MyFirstThread(String threadName) {
		super(threadName);
	}
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " is running");
	}
	
	
}

class MyFirstRunnable implements Runnable{
	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is running");
		
	}
}