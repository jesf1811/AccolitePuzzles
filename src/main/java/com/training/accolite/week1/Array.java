package com.training.accolite.week1;

import java.util.*;
import java.io.*;
import java.math.*;
 
public class Array {
	static long INF = (long)1e18;
    static int maxn = (int)1e6+5;
    static int mod= 1000000321 ;
    private final Scanner sc;

	
	public Array() {
		this(new Scanner(System.in));
	}

	public Array(Scanner sc) {
		this.sc  = sc;
	}
    public static void main(String[] args) {
        new Array().run();
    }
    
    public int run() {
		int result = solve();
		System.out.println(result);
		return result;
	}
 
    
    
    
    int solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a = new int[2*n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            a[i+n] = a[i];
        }
        
        int[] b = new int[maxn];
        for (int i = 1; i <= m; i++) {
            b[sc.nextInt()] = i;
        }
        
        int ans = 0, max = 0;

        for (int j : a) {
            if (b[j] != 0) {
                ans++;
                if (max < ans){
                    max = ans;
                }
            } else {
                ans = 0;
            }
        }

        ans = max;
        return ans;
    }

}
