import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		for(int i = 4;i<5001;i+=2) {
			for(int j = 0;j<i;j+=2) {
				dp[i]+=dp[j]*dp[i-j-2];
				dp[i]%=1000000007L;
			}
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
	}

}
