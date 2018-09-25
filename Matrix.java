import java.util.Scanner;

public class Matrix{

	private int row;
	private int column;
	private double[][] main;

	public Matrix(){
		row = 0;
		column = 0;
	}

	public Matrix(int m, int n){
		//make sure cant have 0 rows or 0 columns
		row = m;
		column = n;
		main = new double[row][column];
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
				main[i][j] = scan.nextDouble();
				scan.nextLine();
			}
		}
	}

	public Matrix multiplyMatrix(Matrix x){
		Matrix finalMatrix = new Matrix(row,1);
		double temp = -1.0;
		for(int i = 0; i<row; i++){
			temp = 0.0;
			for(int j = 0; j<column; j++){
				temp = temp + (main[i][j] * x.get(j,0));
			}
			finalMatrix.set(i,0,temp);
		}
		return finalMatrix;
	}

	//Make sure this can handle one row matrix
	public void reduceMatrix(){
		//Sort rows leading coefficent from bottom to top
		for(int i = 0; i< row-1;i++){
			int max = i;
			for(int j = i+1;j< row;j++){
				if(main[max][0]>main[j][0]){
					max = j;
				}
			}
			swapRow(i,max);
		}
		//Goes from top to bottom reducing 



	}

	public void swapRow(int firstRow, int secondRow){
		double temp;

		for(int i = 0; i < column; i++){ 
			temp = main[firstRow][i];
			main[firstRow][i] = main[secondRow][i];
			main[secondRow][i] = temp;
		}
	}
	//need this for next step of the reduction method
	public void rowAddition(int rowWithBiggerNumber, int rowWithSmallerNumber){
		int temp;
		double multiplier;
		multiplier = main[rowWithBiggerNumber][0] / main[rowWithSmallerNumber][0];
		for(int i = 0; i<column;i++){
			main[rowWithBiggerNumber][i] = main[rowWithBiggerNumber][i] - (multiplier * main[rowWithSmallerNumber][i]);
		}
	}

	public int getRows(){
		return row;
	}

	public int getColumns(){
		return column;
	}

	public double get(int n, int m){
		return main[n][m];
	}

	public void set(int n, int m, double value){
		main[n][m] = value;
		return;
	}

}