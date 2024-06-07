import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[][] map = new int[n + 1][3];
		int[][] min = new int[2][3];
		int[][] max = new int[2][3];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int t;

		for (int i = 1; i <= n; i++) {
			t = i % 2;

			min[t][0] = Math.min(min[1 - t][0], min[1 - t][1]) + map[i][0];
			min[t][1] = Math.min(min[1 - t][0], Math.min(min[1 - t][1], min[1 - t][2])) + map[i][1];
			min[t][2] = Math.min(min[1 - t][1], min[1 - t][2]) + map[i][2];

			max[t][0] = Math.max(max[1 - t][0], max[1 - t][1]) + map[i][0];
			max[t][1] = Math.max(max[1 - t][0], Math.max(max[1 - t][1], max[1 - t][2])) + map[i][1];
			max[t][2] = Math.max(max[1 - t][1], max[1 - t][2]) + map[i][2];

		}

		int minimum = Math.min(min[n % 2][0], Math.min(min[n % 2][1], min[n % 2][2]));
		int maximum = Math.max(max[n % 2][0], Math.max(max[n % 2][1], max[n % 2][2]));

		sb.append(maximum).append(" ").append(minimum);

		System.out.println(sb.toString());
	}
}