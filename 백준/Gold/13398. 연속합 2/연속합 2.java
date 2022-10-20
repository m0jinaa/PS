import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static final int INF = -987654321;
	static int N;
	static int[] nums;
	static int[][] dp;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		nums = new int[N];
		dp = new int[N][2];
		for(int i = 0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			dp[i][0] = nums[i];
		}
		int answer = dp[0][0];
		for(int i = 1;i<N;i++) {
			dp[i][0] = Math.max(dp[i][0], dp[i-1][0]+nums[i]);
			answer = answer<dp[i][0]?dp[i][0]:answer;
			dp[i][1] = Math.max(dp[i-1][1]+nums[i], dp[i-1][0]);
			answer = answer<dp[i][1]?dp[i][1]:answer;
			
		}
		
		System.out.println(answer);	
	}
}