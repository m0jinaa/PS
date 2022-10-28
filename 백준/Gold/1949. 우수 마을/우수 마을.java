import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] people;
	static int[][] dp;
	static ArrayList<Integer>[] link;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		dp = new int[n+1][2];
		people = new int[n+1];
		link = new ArrayList[n+1];
		for(int i = 1;i<=n;i++) {
			Arrays.fill(dp[i], -1);
			people[i] = Integer.parseInt(st.nextToken());
			link[i] = new ArrayList<Integer>();
		}
		int a,b;
		for(int i = 0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			link[a].add(b);
			link[b].add(a);
		}
		
		System.out.println(Math.max(getMax(1,-1,1)+people[1], getMax(1,-1,0)));
	}
	private static int getMax(int i, int j, int k) {
		// TODO Auto-generated method stub
		if(dp[i][k]!=-1)
			return dp[i][k];
		int v = 0;
		
		for(int next:link[i]) {
			if(j==next)
				continue;
			if(k==1)
				v+=getMax(next,i,0);
			else
				v+=Math.max(getMax(next,i,1)+people[next], getMax(next,i,0));
		}
		return dp[i][k] = v;
	}
}
