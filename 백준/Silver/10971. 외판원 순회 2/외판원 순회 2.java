import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] cost;
	static int start;
	static int answer = Integer.MAX_VALUE;
	static boolean[] v;
	public static void travel(int last, int sum, int cnt) {
		if(cnt==n) {
			if(cost[last][start]==0)
				return;
			sum +=cost[last][start];
			answer = answer>sum?sum:answer;
			return;
		}
		else {
			for(int i = 0;i<n;i++) {
				if(v[i]||cost[last][i] == 0)
					continue;
				v[i] = true;
				travel(i,sum+cost[last][i],cnt+1);
				v[i] = false;
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		v = new boolean[n];
		StringTokenizer st;
		cost = new int[n][n];
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<n;j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			start = 0;
			v[0] = true;
			travel(0,0,1);
		System.out.println(answer);
	}
}