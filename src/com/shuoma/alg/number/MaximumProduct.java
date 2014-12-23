package com.shuoma.alg.number;
/***
 * Given an integer n, find a1...am, a decomposition of n
 * (i.e. a1+...+am=n and  a1~am are positive integers)
 * where a1*a2*...*am is the largest
 *
 */
public class MaximumProduct {

	public static void main(String[] args) {
		new MaximumProduct().main();
	}

	public void main(){

		for(int n=2;n<20;n++)
			System.out.println(n+":"+getMaxProduct1(n));
	}

	/**
	 * basic dp
	 */
	public long getMaxProduct0(int n){
		if(n<2) return -1;
		long[] dp=new long[n+1];
		dp[1]=1;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i-1;j++)
				dp[i]=Math.max(dp[i], Math.max(dp[j],j)*(i-j) );
			System.out.println(i+":"+dp[i]);
		}
		return dp[n];
	}

	/***
	 * Decompose n into the form of 2^x+3^y
	 */
	public long getMaxProduct1(int n){
		if(n<2) return -1;
		if(n==2) return 1;

		int x,y;
		x=y=0;
		switch(n%3){
		case 0:
			x=0;y=n/3;
			break;
		case 1:
			x=2; y=(n-4)/3;
			break;
		case 2:
			x=1;y=(n-2)/3;
			break;
		}

		return (long) (Math.pow(2, x)*Math.pow(3, y));
	}

}