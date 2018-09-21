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
		System.out.println("Fill in the matrix row by row");
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i< row;i++){
			System.out.println("Please input "+column+" numbers in row "+(i+1)+":");
			for(int j = 0; j< column; j++){
				main[i][j] = scan.nextInt();
				scan.nextLine();
			}
		}
	}

	public Matrix multiplyMatrix(Matrix x){
		Matrix finalMatrix = new Matrix(row,1);
		int temp = -1;
		for(int i = 0; i<row; i++){
			temp = 0;
			for(int j = 0; j<column; j++){
				temp = temp + (main[i][j] * x.get(j,0));
			}
			finalMatrix.set(i,0,temp);
		}
		return finalMatrix;
	}

	public int getRows(){
		return row;
	}

	public int getColumns(){
		return column;
	}

	public int get(int n, int m){
		return main[n][m];
	}

	public void set(int n, int m, int value){
		main[n][m] = value;
	}

}