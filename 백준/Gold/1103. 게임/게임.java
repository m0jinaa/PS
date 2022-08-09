import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int n;
	static int m;
	static boolean[][] v;
	static int[][] dp;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean inRange(int a, int b) {
		if(a<0||a>=n||b<0||b>=m)
			return false;
		return true;
	}
	static int dfs(int a, int b) {
		if(dp[a][b]==-2) {
			v[a][b] = true;
			int cnt = 0;
			for(int i = 0;i<4;i++) {
				int x = a+map[a][b]*dx[i];
				int y = b+map[a][b]*dy[i];
				if(inRange(x,y)&&map[x][y]!=-1) {
					if(v[x][y]&&dp[x][y] ==-2) {
						dp[a][b] = -1;
						return -1;
					}
					int val = dfs(x,y);
					if(val == -1) {
						dp[a][b] = -1;
						return -1;
					}
					cnt = Math.max(cnt,val);
				}
			}
			dp[a][b] = cnt+1;
		}
		return dp[a][b];
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map= new int[n][m];
		dp = new int[n][m];
		for(int i = 0;i<n;i++) {
			Arrays.fill(dp[i], -2);
		}
		
		v = new boolean[n][m];
		
		for(int i = 0;i<n;i++) {
			char[] s = br.readLine().toCharArray();
			for(int j = 0;j<m;j++) {
				if(s[j] == 'H')
					map[i][j] = -1;
				else
					map[i][j] = s[j]-'0';
			}
		}
		int answer = dfs(0,0);

		System.out.println(answer);
	}
}
