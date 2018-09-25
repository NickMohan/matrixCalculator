//Nicholas Mohan
//September 2018
//CSE 389 Web Systems Arch

import java.util.Scanner;

public class MatrixCalc{
	public static void main(String[] args){
		int [] temp;
		
		temp = welcomeAndInput();
		Matrix main = new Matrix(temp[0],temp[1]);
		Matrix second = new Matrix(main.getColumns(),1);

		main.fillMatrix();
		second.fillMatrix();

		main.printMatrix();
		second.printMatrix();

		//main.reduceMatrix();
		main.rowAddition(1,0);

		main.printMatrix();


		main.multiplyMatrix(second).printMatrix();




	}
	public static int[] welcomeAndInput(){
		int [] mBYn = new int[2];
		System.out.println("Welcome to Matrix Calculator");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please input number of rows:");
		mBYn[0] = scan.nextInt();
		scan.nextLine();
		System.out.println("Please input number of columns:");
		mBYn[1] = scan.nextInt();
		return mBYn;
	}

}

