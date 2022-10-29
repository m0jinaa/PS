import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[] people;
	static int[][] dp;
	
	static int getMax(int i, int cnt) {
		if(i>=n || cnt>=3)
			return 0;
		else if(dp[i][cnt]!=-1)
			return dp[i][cnt];
		else {
			if(i+m>=n) {
				if(i==0)
					return dp[i][cnt] = Math.max(getMax(i+m,cnt+1)+people[n-1], getMax(i+1,cnt));
				else
					return dp[i][cnt] = Math.max(getMax(i+m,cnt+1)+people[n-1]-people[i-1], getMax(i+1,cnt));
					
			}
			else {
				if(i==0)
					return dp[i][cnt] = Math.max(getMax(i+m,cnt+1)+people[i+m-1], getMax(i+1,cnt));
				else
					return dp[i][cnt] = Math.max(getMax(i+m,cnt+1)+people[i+m-1]-people[i-1], getMax(i+1,cnt));
			}
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		people = new int[n];
		dp = new int[n][3];

		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			if(i==0)
				people[i] = Integer.parseInt(st.nextToken());
			else
				people[i] = Integer.parseInt(st.nextToken())+people[i-1];
			Arrays.fill(dp[i], -1);
		}
		m = Integer.parseInt(br.readLine());
		
		System.out.println(getMax(0,0));
	}
}