import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static ArrayList<Integer> nums;
	static int[] dp;
	static final int INF = 20001;

	static void fill() {

		for (int x : nums) {
			for (int j = x; j < INF; j++) {
				dp[j] = Math.min(dp[j], dp[j - x] + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		nums = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			if(st.hasMoreTokens())
				nums.add(Integer.parseInt(st.nextToken()));
		}

		dp = new int[INF];

		Arrays.fill(dp, INF);

		dp[0] = 0;

		fill();

		int answer = 0;
		int s = 1;
		
		for (int i = 1; i < INF; i++) {
			if (dp[i] > m || dp[i] == INF) {
				answer = Math.max(answer, i-s);
				s = i+1;
			}		
		}

		System.out.println(answer);
	}
}