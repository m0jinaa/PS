import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static double[] num;
	static double[] dp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		num = new double[n];
		dp = new double[n];
		for(int i = 0;i<n;i++) {
			num[i] = Double.parseDouble(br.readLine());
		}
		
		dp[0] = num[0];
		double max = 0;
		for(int i = 1;i<n;i++) {
			if(dp[i-1]*num[i]>num[i]) {
				dp[i] = dp[i-1]*num[i];
			}
			else
				dp[i] = num[i];
			max = max<dp[i]?dp[i]:max;
		}
		System.out.printf("%.3f\n",max);
	}
}