package com.learning._02_synchronization.without;

/* This class is not synchronized and two threads are tring to use the print method of class PrintTable simultaneously 
 * So Here we face the problem of inconsistense data .
 * 
 */
public class CountDownWithoutSynchronization {

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

public void printTable(int number) {
	
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

