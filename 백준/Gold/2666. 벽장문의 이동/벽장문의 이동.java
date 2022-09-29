import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n,m;
	static int[][][] dp;
	static int[] open;
	static int closet(int ind,int x, int y) {
		if(ind>=m)
			return 0;
		if(dp[ind][x][y]!=-1)
			return dp[ind][x][y];
		return dp[ind][x][y] = Math.min(Math.abs(x-open[ind])+closet(ind+1,open[ind],y), Math.abs(y-open[ind])+closet(ind+1,x,open[ind]));
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		int a,b;
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		open = new int[m];
		dp = new int[m][n+1][n+1];
		
		for(int i = 0;i<m;i++) {
			open[i] = Integer.parseInt(br.readLine());
			for(int j = 1;j<=n;j++)
				Arrays.fill(dp[i][j], -1);
		}
		
		System.out.println(closet(0,a,b));
	}
}