import java.io.*;
/* Handed in: October 27th, 2016
 * Welcome to Steph's Recursive assignment. This assignment contains the solutions to two problems:
 * 1. A recursive solution to the N-Queens problem
 * 2. A recursive solution to a generic maze problem
 * This assignment contains three classes: the Maze class, the NQueens class and the main class.
 */
public class Assignment1Main {
	private BReader br;
	public Assignment1Main(){
		br = new BReader(new InputStreamReader(System.in));
	}
	
	/**
	 * The main method will contain the basic interface that will allow the user to choose between
	 * either the maze solver or the queen solver.
	 * @param args
	 */
	public static void main(String[] args){
		Assignment1Main aM = new Assignment1Main();

		int input;
		System.out.println("Hello! Welcome to the program for Assignment 1");
		System.out.println("Input 1 for the queens question");
		System.out.println("Input 2 for the maze question");

		input = aM.br.readInt();

		if(input == 1)
			aM.queenSolutions();
		else if(input == 2)
			aM.mazeSolver();
		else
			System.out.println("Since you did not enter either 1 or 2, I will now go away.");
		System.out.println("Bye!");
	}
	
	/**
	 * This method will solve for N amount of queens. After inputting a number, preferably below 15, 
	 * the method will call the enumerate The highest I have been able to go on my
	 * computer is 29.
	 */
	private void queenSolutions(){
		NQueens nQ = new NQueens();
		int numQueens;
		int[] queens;
		System.out.println("Welcome to the Queens Problem Solver! \n"
				+ "It will generate solutions for a N by N board filled with \n"
				+ "N number of queens where none of the queens are adjacent, \n"
				+ "above, below, or diagonal to each other. \n");
		System.out.println("Please input the number of queens that you wish to solve for.");
		System.out.println("I highly advise you choose a number below 15, \n"
				+ "as the number of potential solutions gets ridiculous. \n"
				+ "An example: 15 Queens on a 15 by 15 board will have 2279184 possible solutions.");
		
		
		
		numQueens = br.readInt();
		queens = new int[numQueens];
		
		nQ.enumerate(queens, 0);
		
		nQ.printSolutions();
	}
	/**
	 * This method will navigate through the maze by use of recursion. The method will begin by first
	 * calling the getCoord method from the Maze class to determine the char stored within those
	 * indexes. Then the method will determine whether the char is an obstacle, 
	 * @param mz A maze object that is the maze currently trying to be solved.
	 * @param x The x-coordinate of the maze.
	 * @param y The y-coordinate of the maze.
	 * @return A boolean that determines whether the exit has been found or not.
	 */
	private boolean navigate(Maze mz, int x ,int y) {
		if(mz.getCoord(x, y) == 'X'){
			System.out.println("The solution to the maze is:");
			return true;
		}
		else if(mz.getCoord(x,y) == 'B' || mz.getCoord(x,y) == 'o' ){
			return false;
		}
		mz.modifyLayout(x, y, 'o');

		if (navigate(mz, x, y-1) == true){//North
			return true;
		}
		else if (navigate(mz, x+1, y) == true){//East
			return true;
		}
		else if (navigate(mz, x, y+1) == true){//South
			return true;
		}
		else if (navigate(mz, x-1, y) == true){//West
			return true;
		}
		mz.modifyLayout(x, y, '.');
		return false;
	}

	/**
	 * Prints the current layout of the maze by calling the print method in the passed Maze object.
	 * @param mz The maze being printed
	 */
	private void printMaze(Maze mz){
		mz.print();
	}
	/**
	 * This method will solve a generic maze. The maze is stored in the Maze object.
	 */
	private void mazeSolver(){
		Maze mz = new Maze();
		int startX, startY;
		boolean exitTrue = false;

		printMaze(mz);
		System.out.println("Welcome to the maze solver! This is a 7x11 maze.");
		System.out.println("The x-coordinates range from 0 to 10.");
		System.out.println("The y-coordinates range from 0 to 6.");

		do{
			System.out.println("Please enter a set of coordinates.");
			System.out.println("Please input the x-coordinate.");	
			startX = br.readInt();
			System.out.println("Please input the y-coordinate.");
			startY = br.readInt();
		}while(mz.checkStart(startX, startY));
			// if the checkStart method returns false
			//start coordinates are not out of bounds.

		exitTrue = navigate(mz, startX, startY);
		if(exitTrue){//if exit has been found, assign the index of the start coordinate 
					 //to 'S'.
			setStart(mz, startX, startY);
			
		}
		else{
			System.out.println("The solution to your coordinates could not be found. Please try again.");
		}
	}
	/**
	 * This method will set the value of the 2D maze layout array at the index specified by the passed coordinates
	 * to the char 'S'.
	 * This is used to mark the starting position after a solution is found for a clearer solution.
	 * @param mz The maze object of the maze that is currently being solved.
	 * @param startX The x-coordinate that the user started with
	 * @param startY The y-coordinate that the user started with
	 */
	private void setStart(Maze mz, int startX, int startY) {
		mz.modifyLayout(startX, startY, 'S');
		mz.print();
		System.out.println("Congratulations!");
		
	}
}


