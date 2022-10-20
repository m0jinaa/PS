import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int N;
	static int[][] D;
	static int[][] dp;
	static int INF = 99999999;
	public static int fill(int ind, int f) {
		if(ind == N)
			return 0;
		else if(dp[ind][f]!=0)
			return dp[ind][f];
		else {
			int v = INF;
			for(int i = 0;i<N;i++) {
				if((f & (1<<i)) !=0)
					continue;
				v = Math.min(v, D[ind][i]+fill(ind+1,f|(1<<i)));
			}
			return dp[ind][f] = v;
			
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		D = new int[N][N];
		dp = new int[N][1<<N];
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<N;j++) {
				D[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(fill(0,0));
	}

}
