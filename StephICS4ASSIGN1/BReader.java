/*
 * 
 */
import java.io.*;
public class BReader {
	private BufferedReader br;
	BReader(Reader memes){
		br = new BufferedReader(memes);
	}

	public int readInt() {
		try{
			return Integer.parseInt(br.readLine());
		}
		catch(Exception ex){
			
			System.out.println("You must input a number.");
			System.out.println("Please try inputting again.");
			return readInt();
			//it'll eventually stack overflow at like 20000.
			//my fingers started hurting by like 400 though
		}
	}
	public String readLine() {
		try{
			return br.readLine();
		}
		catch (Exception ex) {
			System.out.println("You did something very wrong???");
			return readLine();
		}
		
	}

}
