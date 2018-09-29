import java.util.Scanner;

public class Matrix{

	private int row;
	private int column;
	private double[][] main;

	//Default constructor
	public Matrix(){
		row = 0;
		column = 0;
	}
	//Constructor that checks for illegal 
	public Matrix(int m, int n) throws IllegalArgumentException {
		try{
			if(m <= 0 || n <= 0){
				throw new IllegalArgumentException("Input of Matrix Size cannot be 0");
			}
		}
		catch(IllegalArgumentException x){
			System.out.println("Input of Matrix Size cannot be 0");
			System.exit(0);
		}
		row = m;
		column = n;
		main = new double[row][column];
	}
	//Print Matrix Function
	public void printMatrix(){
		System.out.println("");
		for(int i = 0; i<row;i++){
			System.out.print("|");
			for(int j = 0; j<column;j++){
				if(main[i][j] == -0.0){
					System.out.print("0.00");
				}
				else{
					System.out.printf("%.2f", main[i][j]);
				}
				if(j != column-1){System.out.print(", ");}
			}
			System.out.println("|");
		}
	}
	//Fill Matrix goes through the matrix filling each spot of the matrix with a double 
	public void fillMatrix(){
		System.out.println("Fill in the matrix row by row\n(After Every Number Entered Hit Enter)");
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i< row;i++){
			System.out.println("Please input "+column+" numbers in row "+(i+1)+":");
			for(int j = 0; j< column; j++){
				main[i][j] = scan.nextDouble();
				scan.nextLine();
			}
		}
	}
	//Takes two matrixes and multiplies them together returning the final matrix
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
	//This reduces a matrix to reduced row echeleon form
	//This implements the gaussian-jordan reduction method
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
		//Goes from top to bottom and left to right reducing
		for(int i = 0; i<row; i++){
			rowRatio(i);
			for(int j = i+1; j<row; j++){
				rowAddition(j,i);
			}
		}
		//Does the final reductions 
		reShapeRows();
		for(int i = row-1; i>0; i--){
			for(int j = i-1; j>=0; j--){
				rowAddition(j,i);
			}
			rowRatio(i);
		}
	}
	//Swaps two rows of the matrix
	public void swapRow(int firstRow, int secondRow){
		double temp;

		for(int i = 0; i < column; i++){ 
			temp = main[firstRow][i];
			main[firstRow][i] = main[secondRow][i];
			main[secondRow][i] = temp;
		}
	}
	//Adds two rows together with to replace one of them and the other has a multiplier
	public void rowAddition(int rowWithBiggerNumber, int rowWithSmallerNumber){
		int z = 0;
		while(main[rowWithSmallerNumber][z] == 0){
			z++;
		}
		double multiplier;
		multiplier = main[rowWithBiggerNumber][z] / main[rowWithSmallerNumber][z];
		for(int i = 0; i<column;i++){
			main[rowWithBiggerNumber][i] = main[rowWithBiggerNumber][i] - (multiplier * main[rowWithSmallerNumber][i]);
		}
	}
	//This makes a row have a leading coefficent of one and resizes the rest of the row
	public void rowRatio(int row) {
		int z = 0;
		while(main[row][z] == 0){
			z++;
		}
		double ratio = main[row][z];
		for(int i = 0; i < column; i++){
			main[row][i] = main[row][i] / ratio;
		}
	}
	//This takes the final rows and put them in cascading order down
	public void reShapeRows(){
		for(int i = 0; i<row-1; i++){
			int temp1 = 0, temp2 = 0, rowSave;
			while(main[i][temp1] == 0){temp1++;}
			rowSave = i;
			for(int j = i+1;j<row; j++){
				while(main[j][temp2] == 0){temp2++;}
				if(temp1 > temp2){
					rowSave = j;
				}
			}
			swapRow(i, rowSave);
		}
	}
	//Below are all the getters and setters for this class
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