import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] goesTo;
	static int[] out;
	static double[] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		out = new int[n + 1];
		goesTo = new ArrayList[n + 1];
		dp = new double[n + 1];

		for (int i = 1; i <= n; i++) {
			goesTo[i] = new ArrayList<>();
		}

		int v, w;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			goesTo[v].add(w);
			out[v]++;
		}

		dp[1] = 100;
		
		for(int i = 1;i<=n;i++) {
			for(int j : goesTo[i]) {
				dp[j]+=dp[i]/out[i];
			}
		}
		
		
		double max = 0;

		for(int i = 1;i<=n;i++) {
			if(goesTo[i].size()!=0)
				continue;
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}
}