/*
 * This class contains the majority of components needed to solve the NQueens problem. 
 */
public class NQueens {

	public int solutions; // class level variable used to track the number of solutions.
	
	/**
	 * Default constructor for the NQueens class.
	 */
	NQueens(){
		solutions = 0;
	}
	
	/**
	 * This method will take an array of a set size that is equal to the amount of queens
	 * that the user wishes to solve for, and an integer value equal to the current queen that
	 * is to be placed. The integer value will always start at 0, to represent the first queen.
	 * @param queens A one-dimensional array that is the size of the number of queens to be solved for.
	 * @param queenNum The current queen to be placed.
	 */
	public void enumerate(int[] queens, int queenNum) {
		int totalQueens = queens.length;
		if (queenNum == totalQueens){//if queenNum = totalQueens, all queens have been placed.
			solutions++;
			if(solutions <= 3)//if number of solutions currently found is less than 4, print solution.
				//The printQueens method will only be called for the first three solutions.
				//This ensures that the console isn't overloaded with over 50 solutions.

				printQueens(queens);//calls the printQueens method.
		}
		else {
			for (int column = 0; column < totalQueens; column++) {//This for loop will increment
				//The starting column of the queen to try for all possible placements
				queens[queenNum] = column;//assigns index of array 
				//Attempts to place the current queen n at column i.
				if (queensCheck(queens, queenNum) == true) 
					enumerate(queens, queenNum+1);
				//If the queen n is able to be placed at column i,
				//a solution will be attempted for the next queen by calling
				//the enumerate method again while increasing n, the value of the current queen.
			}
		}
	}  
	/**
	 * This method prints the number of solutions found.
	 */
	public void printSolutions(){
		System.out.println("Number of solutions found: " + solutions);

	}
	
	/**
	 * This method will check to see if the current queen being placed conflicts with previous
	 * queens.
	 * @param queens
	 * @param queenNum
	 * @return
	 */
	public boolean queensCheck(int[] queens, int queenNum) {
		for (int oldQueenNum = 0; oldQueenNum < queenNum; oldQueenNum++) {
			//Checks the current queen to be placed by incrementing the
			if (queens[oldQueenNum] == queens[queenNum])
				return false;
			// Queens are on the same column.
			if ((queens[oldQueenNum] - queens[queenNum]) == (queenNum - oldQueenNum))
				return false;   
			// Queens are on the same major diagonal.
			if ((queens[queenNum] - queens[oldQueenNum]) == (queenNum - oldQueenNum))
				return false;   
			// Queens are on the same minor diagonal.
		}
		return true;
	}

	public void printQueens(int[] queens) {
		int n = queens.length;//assign variable n to the value of queens.length
		// this will set the dimensions of the board to equal the number of queens.
		for (int row = 0; row < n; row++) {//increments the row number
			for (int column = 0; column < n; column++) {//increments the column number
				if (queens[row] == column)
					//if the value of the queens array at the index of 
					//the current row number is equal to the column number,
					//print Q.
					System.out.print("Q ");
				else
					System.out.print("* ");
				//The characters are printed out with a space afterwards for formatting purposes.
			}
			System.out.println("");//Separates the rows.
		}  
		System.out.println("");//Separates the solutions.
	}






}

