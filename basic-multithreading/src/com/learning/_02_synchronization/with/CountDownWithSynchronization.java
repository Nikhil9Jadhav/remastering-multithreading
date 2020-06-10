package com.learning._02_synchronization.with;

/* 
 * This class is synchronized so here result will always consistent
 * 
 */
public class CountDownWithSynchronization {

	public static void main(String[] args) {

		PrintTable printTable = new PrintTable();
		TableGenerator generate10Table = new TableGenerator(printTable,10);
		TableGenerator generate11Table = new TableGenerator(printTable, 11);
		generate10Table.start();
		generate11Table.start();
		
	}
	
	


}

//Create the shared class
class PrintTable {
private int i;

public synchronized void printTable(int number) {
	
	for(i = 1 ; i <= 10 ; i++) {
		System.out.println(Thread.currentThread().getName() + " is saying " + number + " * " +  i + " = " +number*i );
		
	}
	
}

}

//The Thread class
class TableGenerator extends Thread{
	
	private PrintTable printTable;
	private int number;
	
	public TableGenerator(PrintTable printTable, int number) {
		this.printTable = printTable;
		this.number = number;
	}
	
	public void run() {
		printTable.printTable(number);
	}
}

