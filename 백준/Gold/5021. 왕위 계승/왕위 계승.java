import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static double[] dp;
	public static HashMap<String, Integer> map;
	public static int ind = 1;
	public static int[][] parents;

	public static int getInd(String name) {
		if (!map.containsKey(name))
			map.put(name, ind++);
		return map.get(name);
	}

	public static double calculate(int x) {
		if (x == 0)
			return 0;
		else if (dp[x] != -1)
			return dp[x];
		else if (x == 1)
			return dp[x] = 1;
		else {
			return dp[x] = (calculate(parents[x][0]) + calculate(parents[x][1])) / 2;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new HashMap<>();

		String king = br.readLine();

		getInd(king);

		int c, p1, p2;
		String child, dad, mom;
		parents = new int[3 * n + 1][2];
		dp = new double[3 * n + 1];
		Arrays.fill(dp, -1);
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			child = st.nextToken();
			dad = st.nextToken();
			mom = st.nextToken();
			c = getInd(child);
			p1 = getInd(dad);
			p2 = getInd(mom);

			parents[c][0] = p1;
			parents[c][1] = p2;

		}

		double max = 0;
		String candidate;
		String answer = "";
		int cind;
		double v;
		while (m-- > 0) {
			candidate = br.readLine();
			cind = getInd(candidate);
			v = calculate(cind);
			if (v > max) {
				answer = candidate;
				max = v;
			}
		}

		System.out.println(answer);
	}
}