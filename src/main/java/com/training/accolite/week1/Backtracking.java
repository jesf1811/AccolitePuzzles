package com.training.accolite.week1;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;

import com.training.accolite.AccoliteApplication;
 
public class Backtracking {
	boolean[] ones;
	private boolean[][] s;
	private int[] c;
	private final Scanner sc;
	
	public Backtracking() {
		this(new Scanner(System.in));
	}

	public Backtracking(Scanner sc) {
		this.sc  = sc;
	}
	
	int solve() {
		int n = sc.nextInt();
		int m = sc.nextInt();
		s = new boolean[m][n];
		c = new int[m];
		for (int i = 0; i < m; i++) {
			String str = sc.next();
			for (int j = 0; j < n; j++)
				s[i][j] = str.charAt(j) == '1';
			c[i] = sc.nextInt();
		}
		sc.close();
		ones = new boolean[n];
		return go(0, c[0], s[0]);
	}
 
	private int go(int step, int errors, boolean[] example) {
		System.out.println("step: " + step);

        if (step == example.length){
            System.out.println("Inside if");
            if (errors != 0) {
                System.out.println("Returning 0 - 1st");
                return 0;
            }

            System.out.println("Inside for loop");
            System.out.println("Ones - " + Arrays.toString(ones));
            System.out.println("s[1] - " + Arrays.toString(s[1]));
            for (int i = 1; i < s.length; i++){
                int numberOfErrorsInOnes = 0;
                for (int j = 0; j < example.length; j++){
                    if (ones[j] != s[i][j]){
                        System.out.println("Adding...");
                        numberOfErrorsInOnes++;
                    }
                }

                if (numberOfErrorsInOnes != c[i]){
                    System.out.println("Returning 0 - 2nd");
                    return 0;
                }
            }

            System.out.println("Returning 1");
            return 1;
        }

        ones[step] = example[step];
        System.out.println("Recurse - 1st part started");
        int res = go (step+1, errors, example);
        System.out.println("Recurse - 1st part ended");
        System.out.println("Before:");
        System.out.println("Ones - " + Arrays.toString(ones));
        System.out.println("Example - " + Arrays.toString(example));
        ones[step] = !example[step];
        System.out.println("After:");
        System.out.println("Ones - " + Arrays.toString(ones));
        System.out.println("Example - " + Arrays.toString(example));
        System.out.println("Errors - " + errors);
        if (errors != 0){
            System.out.println("Recurse - 2nd part started");
            res += go(step+1, errors-1, example);
            System.out.println("Recurse - 2nd part ended");
        }

        System.out.println("Resultant: " + res);
        return res;
	}
 
	public int run() {
		int result = solve();
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		//new Backtracking().run();
		
		Backtracking backtracking = new Backtracking();
        backtracking.s = new boolean[][]{{false, false, false, false, false, false,}, {false, true, false, true, false, false}};
        backtracking.c = new int[]{2,4};
        backtracking.ones = new boolean[6];
        System.out.println("Result: " + backtracking.go(0, backtracking.c[0], backtracking.s[0]));
    
	}	
}
