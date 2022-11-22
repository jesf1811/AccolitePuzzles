package com.training.accolite.week1;

import java.util.*;

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

        int ans = 0;
        /*
            stores the longest substring possible
         */
        int max = 0;

        /*
            iterating through the first array
         */
        for (int i=1;i<a.length;i++) {
            if (b[a[i]] == 0){
                ans = 0;
                continue;
            }

            if (b[a[i-1]] < b[a[i]]){
                ans++;
            } else if (i == n + 1 && b[a[i-1]] > b[a[i]]){
                ans++;
            } else if (i != (a.length - 1) && b[a[i+1]] > b[a[i]]) {
                ans++;
            } else {
                ans = 0;
            }
            max = Math.max(ans,max);
        }

        ans = max;
        return ans;
    }

}