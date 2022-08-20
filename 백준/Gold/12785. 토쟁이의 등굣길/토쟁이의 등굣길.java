import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int w,h,x,y;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine()," ");
		x = Integer.parseInt(st.nextToken())-1;
		y = Integer.parseInt(st.nextToken())-1;
		dp = new long[h][w];
		
		Arrays.fill(dp[0], 1);
		for(int i = 0;i<h;i++) {
			dp[i][0] = 1;
		}
		for(int i = 1;i<h;i++) {
			for(int j = 1;j<w;j++) {
				dp[i][j] = dp[i-1][j]+dp[i][j-1];
				dp[i][j]%=1000007;
			}
		}
		System.out.println((dp[y][x]*dp[h-1-y][w-1-x])%1000007);
	}
}
