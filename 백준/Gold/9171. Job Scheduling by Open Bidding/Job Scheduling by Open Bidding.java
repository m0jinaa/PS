import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Job {
		int s, c;

		public Job(int s, int c) {
			super();
			this.s = s;
			this.c = c;
		}
	}

	static Job[] jobs;
	static int time;
	static int[] dp;

	static int getMax() {
		Arrays.fill(dp, -1);
		dp[0] = 0;
		
		for (Job job : jobs) {
			for (int x = time; x >= job.s; x--) {
				if(dp[x-job.s] == -1)
					continue;
				dp[x] = Math.max(dp[x], dp[x - job.s] + job.c);
			}
		}
		
		int max = 0;
		int answer = 0;
		for (int i = time; i >= 0; i--) {
			if (dp[i] > max) {
				answer = i;
				max = dp[i];
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int s, c;
		for (int t = 1; t <= tc; t++) {
			int n = Integer.parseInt(br.readLine());

			jobs = new Job[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				s = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken().replaceAll("\\.", ""));

				jobs[i] = new Job(s, c);
			}

			time = Integer.parseInt(br.readLine());

			dp = new int[time + 1];
			int scheduled = getMax();
			sb.append("Problem ").append(t).append(": ").append(scheduled).append(" seconds scheduled for $")
					.append(dp[scheduled] * 1.0 / 100).append("\n");
		}

		System.out.println(sb.toString());
	}
}