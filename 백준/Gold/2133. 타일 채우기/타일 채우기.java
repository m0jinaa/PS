import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N%2==0) {
			int[] dp = new int[N+1];
			
			dp[0] = 1;
			dp[2] = 3;
			for(int i = 4;i<=N;i+=2) {
				dp[i] = dp[i-2]*dp[2];
				for(int j = i-4;j>0;j-=2)
					dp[i]+=dp[j]*2;
				dp[i]+=2;
			}
			System.out.println(dp[N]);	
		}
		else {
			System.out.println(0);
		}
	}

}
