import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static double[] per;
	static int n;
	static int r;
	static boolean[][] v;
	static double answer = 0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	static void dfs(int a, int b, double p,int cnt) {
		if(cnt==n) {
			answer+=p;
			return;
		}
		int x,y;
		for(int i = 0;i<4;i++) {
			x = a+dx[i];
			y = b+dy[i];
			if(!v[x][y]) {
				v[x][y] = true;
				dfs(x,y,p*per[i],cnt+1);
				v[x][y] = false;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		per = new double[4];
		n = Integer.parseInt(st.nextToken());
		for(int i = 0;i<4;i++) {
			per[i] = Integer.parseInt(st.nextToken())/100.0;
		}
		
		r = 2*n+1;
		v = new boolean[r][r];
		v[n][n] = true;
		dfs(n,n,1,0);
		
		System.out.println(answer);
	}
}
