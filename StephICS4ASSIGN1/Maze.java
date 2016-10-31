import java.io.*;

/*this class will create the maze object and allow access through the accessors 
 *
 * 
 */
public class Maze {
	
	private final int LENGTH = 7, WIDTH = 11;
	private char[][] maze;
	private BReader br;
	public Maze() {
		try{
			br = new BReader(new FileReader("MazeLayout.txt"));
		}
		catch(Exception e){
			
			
		}
		maze = new char [LENGTH][WIDTH];
		maze = readLayout(maze);
	}

	/**
	 * 
	 * @param maze
	 * @return
	 */
	private char[][] readLayout(char[][] maze) {
		String line;
		for(int l = 0; l < LENGTH; l++){
			line = br.readLine();
			for(int w = 0; w < WIDTH;w++){
				maze[l][w] = line.charAt(w);
			}
		}
		return maze;
	}

	/**
	 * 
	 */
	public void print(){
	printLayout(maze);
	}

	/**
	 * 
	 * @param maze
	 */
	private void printLayout(char[][] maze){
		for(int l = 0; l < LENGTH; l++){
			for(int w = 0; w < WIDTH; w++){
				System.out.print(" "+ maze[l][w]);
			}
			System.out.println("");
		}

	}

	public char getCoord(int x , int y){
		return maze[y][x];//because of the way the maze is read(per line), y will come first.
		//This does not affect the way the maze is laid out.
	}
	
	public void modifyLayout(int x, int y, char c){
		maze[y][x] = c;
		
	}
	public boolean checkStart(int x, int y){
		if(x >= WIDTH || y >= LENGTH){
			System.out.println("Invalid coordinates! They are out of bounds.");
			return true; // conflict detected, starting coordinate is out of bounds
		}
		else if(maze[y][x] == 'B'){
			System.out.println("Invalid coordinates! They are on a wall.");
			return true;// conflict detected, starting coordinate is on a barrier.
		}
		else
			return false;
	}
	
}