import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int t = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] plum = new int[t+1];
		plum[0] = -1;
		for(int i = 1;i<=t;i++) {
			plum[i] = Integer.parseInt(br.readLine());
		}
		
		int[][][] dp = new int[t+1][w+1][3];
		int answer = 0;
		for(int i = 1;i<=t;i++) {
			for(int j = 0;j<=w;j++) {
				if(plum[i]==1) {
					if(j==0) {
						dp[i][j][1] = dp[i-1][j][1]+1;
						continue;
					}
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2])+1;
					dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);
				}
				else { 
					if(j == 0) {
						dp[i][j][1] = dp[i-1][j][1];
						continue;
					}
					dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1])+1;
					dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
				}
				answer = Math.max(dp[i][j][1], dp[i][j][2]);
			}
		}
		System.out.println(answer);	
	}	
}