import java.util.Scanner;

public class Matrix{

	private int row;
	private int column;
	private int[][] main;

	public Matrix(){
		row = 0;
		column = 0;
	}

	public Matrix(int m, int n){
		//When matrix is initialized make everything in it all zeros
		row = m;
		column = n;
		main = new int[row][column];
	}

	public void printMatrix(){
		System.out.println("");
		for(int i = 0; i<row;i++){
			System.out.print("|");
			for(int j = 0; j<column;j++){
				System.out.print(main[i][j]);
				if(j != column-1){System.out.print(", ");}
				
			}
			System.out.println("|");
		}
	}

	public void fillMatrix(){
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i< row;i++){
			System.out.println("Please input numbers in row "+(i+1)+":");
			for(int j = 0; j< column; j++){
				main[i][j] = scan.nextInt();
				scan.nextLine();
			}
		}
	}

	//public int[] returnCol(int i){
		//Do this
	//}

	//public int[] returnRow(int i){
		//do this
	//}



}