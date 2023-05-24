import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int[][][] dp;
	static int answer = 61;
	static final int INF = 10000;
	static void check(int a, int b, int c, int cnt) {
		if(a<=0 && b<=0 && c<=0) {
			answer = Math.min(answer, cnt);
		}
		else {
			if(a<0)
				a = 0;
			if(b<0)
				b = 0;
			if(c<0)
				c = 0;
			
			if(dp[a][b][c]<=cnt)
				return;
			dp[a][b][c] = cnt;
			
			check(a-9,b-3,c-1,cnt+1);
			check(a-9,b-1,c-3,cnt+1);
			check(a-3,b-9,c-1,cnt+1);
			check(a-1,b-9,c-3,cnt+1);
			check(a-3,b-1,c-9,cnt+1);
			check(a-1,b-3,c-9,cnt+1);
		}
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] scv = new int[3];
		
		int n = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine()," ");
		
		for(int i = 0;i<n;i++) {
			scv[i] = Integer.parseInt(st.nextToken());
		}
		
		dp = new int[scv[0]+1][scv[1]+1][scv[2]+1];
		
		for(int i = 0;i<=scv[0];i++) {
			for(int j = 0;j<=scv[1];j++) {
				for(int k = 0;k<=scv[2];k++) {
					dp[i][j][k] = INF;
				}
			}
		}
		
		check(scv[0],scv[1],scv[2],0);
		
		System.out.println(answer);
	}
}