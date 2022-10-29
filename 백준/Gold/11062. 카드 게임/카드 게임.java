import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] nums;
	static int[][][] dp;
	
	public static int getMax(int s, int e , int t) {
		if(s>e)
			return  0;
		else if(s==e) {
			if(t==1)
				return dp[s][e][t] = nums[s];
			else
				return dp[s][e][t] = 0;
		}
		else if(dp[s][e][t]!=-1) {
			return dp[s][e][t];
		}
		else {
			if(t==1) {
				return dp[s][e][t] = Math.max(nums[s]+getMax(s+1,e,0), nums[e]+getMax(s,e-1,0));
			}
			else {
				return dp[s][e][t] = Math.min(getMax(s+1,e,1), getMax(s,e-1,1));
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0;t<tc;t++) {
			n = Integer.parseInt(br.readLine());
			
			dp = new int[n][n][2];
			nums = new int[n];
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<n;i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				for(int j = 0;j<n;j++)
					Arrays.fill(dp[i][j], -1);
			}
			
			sb.append(getMax(0,n-1,1)).append("\n");
		}
		System.out.println(sb.toString());
	}
}