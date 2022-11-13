package com.training.accolite.week1;

import java.util.Scanner;

public class PnC {
	private static final int mod = 1000000007;
	private static final int max_n = 400040;
	private static int[] f = new int[max_n];
	private static int[] df = new int[max_n];
    private final Scanner sc;
	
	public PnC() {
		this(new Scanner(System.in));
	}

	public PnC(Scanner sc) {
		this.sc  = sc;
	}
	
    public static void main(String[] args) {        
        new PnC().run();
    }
    
    public int run() {
    	prep();
        int n = sc.nextInt();
        int ans = 0 ;
        for(int i=0;i<=n;++i){
            int a = sc.nextInt();
            if(a==0) break;
            ans += C(i,a);
        }
        System.out.println(ans);
        return ans;
    }
	
    /*
        function to sum all the nCk where k is fixed and n <= n < n+k
     */
    static int C(int n,int k){
	int result = 0;
	for (int i = n; i < (n+k); i++){
		result += nCr(i,n);
	}
	return result;
    }
	
	
    /*
        function to calculate nCr
     */
    static int nCr (int n, int r){
        return (f[n] / (factorial(r)  * factorial(n-r)));
    }

    /*
        function to calculate n! (where n is the input)
     */
    static int factorial (int n){
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
	
    /*
        pre-calculates the factorial of numbers from 0 to max_n - 1
     */
    static void prep(){
        f[0] = df[0] = 1;
        for(int i=1;i<max_n;++i){
            f[i] = (int)((1l*f[i-1]*i)%mod);
        }
    }
	
}
