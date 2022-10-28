import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N,K;
	static long[][] dp;
	static final int MOD = 1_000_000_003;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		dp = new long[N+1][K+1];
		for(int i = 0;i<=N;i++) {
			Arrays.fill(dp[i], -1);
		}
		long answer = 0;
		if(K==1)
			answer = N;
		else if(N==1)
			answer = 1;
		else {
			answer = (getCnt(N-3,K-1)+getCnt(N-1,K))%MOD;
		}
		System.out.println(answer);
	}
	private static long getCnt(int n, int k) {
		if(k<0||n<0)
			return 0;
		else if(dp[n][k]!=-1)
			return dp[n][k];
		else if(k==1) {
			return dp[n][k] = n;
		}
		else if(n+1<k*2)
			return dp[n][k] = 0;
		else {
			return dp[n][k] = (getCnt(n-1,k)+getCnt(n-2,k-1))%MOD;
		}
	}
}