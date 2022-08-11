import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int[][] dp;
	static int n;
	static int l;
	static int[] score;
	static int[] calory;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1;t<=tc;t++) {
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			score = new int[n+1];
			calory = new int[n+1];
			for(int i = 1;i<=n;i++) {
				st = new StringTokenizer(br.readLine()," ");
				score[i] = Integer.parseInt(st.nextToken());
				calory[i] = Integer.parseInt(st.nextToken());
			}
			
			dp = new int[n+1][l+1];
			int c,s;
			for(int i = 1;i<=n;i++) {
				for(int j = 1;j<=l;j++) {
					c = calory[i];
					s = score[i];
					if(j<c)
						dp[i][j] = dp[i-1][j];
					else {
						dp[i][j] = Math.max(dp[i-1][j-c]+s, dp[i-1][j]);
					}
					
				}
			}
			
			sb.append('#').append(t).append(' ').append(dp[n][l]).append("\n");
//			for(int[] row:dp) {
//				System.out.println(Arrays.toString(row));
//			}
		}
		System.out.println(sb);
	}

}
