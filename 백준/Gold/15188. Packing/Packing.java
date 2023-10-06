import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n,w1,w2;
	static int[][] dp;
	static Present[] presents;
	
	static class Present{
		int w,v;

		public Present(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}	
	}
	
	static int getMax() {
		
		for(Present p : presents) {
			for(int i = w1;i>=0;i--) {
				for(int j = w2;j>=0;j--){
					if(i-p.w>=0) {
						dp[i][j] = Math.max(dp[i][j], dp[i-p.w][j]+p.v);
					}
					
					if(j-p.w>=0) {
						dp[i][j] = Math.max(dp[i][j], dp[i][j-p.w]+p.v);
					}
				}
			}
		}
		
		return dp[w1][w2];
	}
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1;t<=tc;t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			
			n = Integer.parseInt(st.nextToken());
			w1 = Integer.parseInt(st.nextToken());
			w2 = Integer.parseInt(st.nextToken());
			
			dp = new int[w1+1][w2+1];
			
			presents = new Present[n];
			
			st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 0;i<n;i++) {
				presents[i] = new Present(Integer.parseInt(st.nextToken()),0);
			}
			
			st = new StringTokenizer(br.readLine()," ");
			
			for(int i = 0;i<n;i++) {
				presents[i].v = Integer.parseInt(st.nextToken());
			}
			
			sb.append("Problem ").append(t).append(": ").append(getMax()).append("\n");
		}
		
		System.out.print(sb.toString());
	}
}