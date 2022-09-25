import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	static int[][] graph;
	static int[][] dp;
	static int INF = 987654321;
	static int FIN;
	static int tsp(int start, int f) {
		if(f==FIN) {
			if(graph[start][0]==0)
				return INF;
			return graph[start][0];			
		}
		
		if(dp[start][f]!=-1)
			return dp[start][f];
		dp[start][f] = INF;
		for(int i = 0;i<n;i++) {
			if((graph[start][i]==0 ||(f & (1<<i))!=0))
				continue;
			dp[start][f] = Math.min(dp[start][f], graph[start][i]+tsp(i,f|(1<<i)));
				
		}
		return dp[start][f];
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		graph = new int[n][n];
		dp = new int[n][1<<n];
		FIN = (1<<n)-1;
		
		for(int i = 0;i<n;i++) {
			Arrays.fill(dp[i], -1);
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<n;j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = 0;
		answer =tsp(0,1);
		System.out.println(answer);
	}
}