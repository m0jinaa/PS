import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][][] dp;
	static char[] A,B,C;
	static int a,b,c;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine().toCharArray();
		B = br.readLine().toCharArray();
		C = br.readLine().toCharArray();
		a = A.length;
		b = B.length;
		c = C.length;
		
		dp = new int[a+1][b+1][c+1];
		
		for(int i = 0;i<a;i++) {
			for(int j = 0;j<b;j++) {
				for(int k = 0;k<c;k++) {
					if(A[i]==B[j]&&B[j]==C[k]) {
						dp[i+1][j+1][k+1] = Math.max(dp[i][j][k]+1, Math.max(dp[i][j+1][k+1],Math.max(dp[i+1][j][k+1],dp[i+1][j+1][k])));
					}
					else {
						dp[i+1][j+1][k+1] = Math.max(dp[i][j+1][k+1],Math.max(dp[i+1][j][k+1],dp[i+1][j+1][k]));						
					}
				}
			}
		}
		System.out.println(dp[a][b][c]);
	}
}
