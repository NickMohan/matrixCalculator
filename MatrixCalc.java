//Nicholas Mohan
//September 2018
//CSE 389 Web Systems Arch

import java.util.Scanner;
import java.util.ArrayList;

public class MatrixCalc{
	public static void main(String[] args){
		ArrayList<Integer> temp = new ArrayList<Integer>();

		temp = welcomeAndInput();
			
		Matrix main = new Matrix(temp.get(0),temp.get(1));

		Matrix second = new Matrix(main.getColumns(),1);

		main.fillMatrix();
		//second.fillMatrix();

		main.printMatrix();
		//second.printMatrix();

		main.reduceMatrix();
		
		main.printMatrix();


	}
	//Welcome and input for the program
	public static ArrayList<Integer> welcomeAndInput(){
		ArrayList<Integer> mBYn = new ArrayList<Integer>();
		System.out.println("Welcome to Matrix Calculator");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input number of rows:");
		mBYn.add(scan.nextInt());
		scan.nextLine();
		System.out.println("Please input number of columns:");
		mBYn.add(scan.nextInt());
		return mBYn;
	}

}

