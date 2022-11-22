package com.training.accolite.week1;

import java.util.Scanner;

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

        if (step == example.length){
            if (errors != 0) {
                return 0;
            }

            for (int i = 1; i < s.length; i++){
                int numberOfErrorsInOnes = 0;
                for (int j = 0; j < example.length; j++){
                    if (ones[j] != s[i][j]){
                        numberOfErrorsInOnes++;
                    }
                }

                if (numberOfErrorsInOnes != c[i]){
                    return 0;
                }
            }

            return 1;
        }

        ones[step] = example[step];
        int res = go (step+1, errors, example);
        ones[step] = !example[step];
        if (errors != 0){
            res += go(step+1, errors-1, example);
        }

        return res;
	}
 
	public int run() {
		int result = solve();
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		new Backtracking().run();
	}
}
