//Nicholas Mohan
//September 2018
//CSE 389 Web Systems Arch

import java.util.Scanner;
import java.util.ArrayList;

public class MatrixCalc{
	public static void main(String[] args){
		//Initialze variables
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int selection;
		int counter = 0;
		Scanner scan = new Scanner(System.in);
		//Welcome and fill the matrix
		temp = welcomeAndInput();
		Matrix mainMat = new Matrix(temp.get(0),temp.get(1));
		mainMat.fillMatrix();
		mainMat.reduceMatrix();
		mainMat.printMatrix();
		System.out.println("What do you want to do?\n-Type 1 to Multiply\n-Type 2 to Reduce\n-Type 3 to change the matrix\n-Type -1 to End");
		selection = scan.nextInt();
		scan.nextLine();
		//Do while loop to loop through asking what you want to do each number goes to a different if statement
		do{
			if(counter != 0){
				System.out.println("Do you want to perform another action or end?\n-Type 1 to Multiply\n-Type 2 to Reduce\n-Type 3 to change the matrix\n-Type -1 to End");
				selection = scan.nextInt();
				scan.nextLine();
				if(selection == -1){
					System.exit(0);
				}
			}
			if(selection == 1){
				multiply(mainMat);
			}
			else if(selection == 2){
				reduce(mainMat);
			}
			else if(selection == 3){
				System.out.println("Do you want to use the "+mainMat.getRows()+"x"+mainMat.getColumns()+" or use a new array?\n-Type 1 for same\n-Type 2 for Different");
				int changeArray = scan.nextInt();
				scan.nextLine();
				//This if statement goes if you want the same size matrix or different size matrix
				if(changeArray == 1){
					mainMat.fillMatrix();
					mainMat.printMatrix();
				}
				if(changeArray == 2){
					int newRow, newCol;
					System.out.println("Please input row size");
					newRow = scan.nextInt();
					scan.nextLine();
					System.out.println("Please input column size");
					newCol = scan.nextInt();
					scan.nextLine();
					mainMat = new Matrix(newRow, newCol);
					mainMat.fillMatrix();
					mainMat.printMatrix();
				}
				else{
					System.out.println("Invalid Input Please Try Again");
				}
			}
			if(selection != 1 && selection != 2 && selection != 3 && selection != -1) {
				System.out.println("Invalid Input Please Try Again");
			}
			counter++;
		}while(selection != -1);
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
	//Function to run multiply and print the matrix
	public static void multiply(Matrix x){
		Matrix second = new Matrix(x.getColumns(),1);
		second.fillMatrix();
		x.printMatrix();
		second.printMatrix();
		x.multiplyMatrix(second).printMatrix();
	}
	//Function to run reduce and print out the matrix
	public static void reduce(Matrix x){
		x.printMatrix();
		x.reduceMatrix();
		x.printMatrix();
	}
}

