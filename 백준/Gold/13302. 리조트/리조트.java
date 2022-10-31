import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n,m;
	static final int INF = 1000000;
	static final int ONE = 10000;
	static final int THREE = 25000;
	static final int FIVE = 37000;
	static boolean[] date;
	static int[][] dp;
	public static int getMax(int day, int t) {
		if(day>n)
			return 0;
		else if(dp[day][t]!=-1)
			return dp[day][t];
		else if(date[day])
			return dp[day][t] = getMax(day+1,t);
		else{
			int v = INF;
			v = Math.min(v, ONE+getMax(day+1,t));
			v = Math.min(v, THREE+getMax(day+3,t+1));
			v = Math.min(v, FIVE+getMax(day+5,t+2));
			if(t>=3) {
				v = Math.min(v, getMax(day+1,t-3));
			}
			return dp[day][t] = v;
		}
	}
	public static void main(String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dp = new int[n+1][51];
		date = new boolean[n+1];
		if(m!=0) {
			st =  new StringTokenizer(br.readLine()," ");
			for(int i = 0;i<m;i++) {
				date[Integer.parseInt(st.nextToken())] = true;
			}			
		}
		
		for(int i = 0;i<=n;i++)
			Arrays.fill(dp[i], -1);
		
		System.out.println(getMax(1,0));	
	}
}