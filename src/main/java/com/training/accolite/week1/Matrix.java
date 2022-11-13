package com.training.accolite.week1;

import java.util.Arrays;
import java.util.Scanner;

public class Matrix {
	
	private final Scanner sc;
	
	public int[][] solve(int[][] A) {
		int[][] resultantBoard = new int[A.length][A.length-1];

		for (int i = 0; i < A.length; i++){
		    for (int j = 0; j < A[i].length; j++){
			int aliveCount = count(A, i, j, A.length,A[i].length);
			if (A[i][j] == 0 && aliveCount == 3){
			    resultantBoard[i][j] = 1;
			} else if (A[i][j] == 1){
			    if (aliveCount == 2 || aliveCount == 3){
				resultantBoard[i][j] = 1;
			    } else if (aliveCount < 2){
				resultantBoard[i][j] = 0;
			    } else {
				resultantBoard[i][j] = 0;
			    }
			}
		    }
		}

		return resultantBoard;
	}

	int dis[][]={{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};

	int count(int[][] A,int i,int j,int m,int n){
	    int cnt=0;
	    for(int k=0;k<8;k++){
	        int x= i+dis[k][0], y= j+dis[k][1];
	        if(x>=0 && y>=0 && x<m && y<n && Math.abs(A[x][y])==1) cnt++;
	    }
	    return cnt;
	}
	
	public Matrix() {
		this(new Scanner(System.in));
	}

	public Matrix(Scanner sc) {
		this.sc  = sc;
	}
	
	public int[][] run() {
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][]result= new int[m][n];
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				result[i][j]=sc.nextInt();
			}
		}
		result = solve(result);
		for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
		return result;
	}
	
	public static void main(String[] args) {
		new Matrix().run();
	}
	
	
}
