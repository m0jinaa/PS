import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n,m,k;
	static int[][] cost;
	static int[][] dp;
	static final int INF = Integer.MIN_VALUE;
	public static int getMax(int now, int cnt) {
		if(now==n)
			return 0;
		else if(cnt>=m)
			return INF;
		else if(dp[now][cnt]!=0)
			return dp[now][cnt];
		else {
			int max = INF;
			for(int i = now+1;i<=n;i++) {
				if(cost[now][i]!=0)
					max = Math.max(max, cost[now][i]+getMax(i,cnt+1));
			}
			return dp[now][cnt] = max;
		}	
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		cost = new int[n+1][n+1];
		dp = new int[n+1][m+1];
		
		int a,b,c;
		
		for(int i = 0;i<k;i++) {
			st = new StringTokenizer(br.readLine()," ");
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if(b<a)
				continue;
			cost[a][b] = cost[a][b]<c?c:cost[a][b];
		}
		
		System.out.println(getMax(1,1));		
	}
}
