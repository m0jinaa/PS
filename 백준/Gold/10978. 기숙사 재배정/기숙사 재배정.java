import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] dp;
	static long combi(int k) {
		if(k==0)
			return 1;
		if(k==1)
			return 0;
		else {
			if(dp[k]==0)
				dp[k] = (k-1)*(combi(k-1)+combi(k-2));
			return dp[k];
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		dp = new long[21];
		dp[0] = 1;
		dp[1] = 0;
		
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(combi(n)).append("\n");
		}
		System.out.print(sb);
	}
}