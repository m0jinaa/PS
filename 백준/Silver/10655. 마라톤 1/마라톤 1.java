import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int INF = 1_000_000_007;

		int n = Integer.parseInt(br.readLine());

		int[][] locations = new int[n][2];

		int dist = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			locations[i][0] = Integer.parseInt(st.nextToken());
			locations[i][1] = Integer.parseInt(st.nextToken());

			if (i > 0) {
				dist += Math.abs(locations[i][0] - locations[i - 1][0])
						+ Math.abs(locations[i][1] - locations[i - 1][1]);
			}
		}

		int answer = INF;

		int skipDist;

		// i번 포인트를 건너뛸때의 거리
		for (int i = 1; i + 1 < n; i++) {
			skipDist = dist
					- (Math.abs(locations[i][0] - locations[i - 1][0])
							+ Math.abs(locations[i][1] - locations[i - 1][1]))
					- (Math.abs(locations[i][0] - locations[i + 1][0])
							+ Math.abs(locations[i][1] - locations[i + 1][1]))
					+ (Math.abs(locations[i + 1][0] - locations[i - 1][0])
							+ Math.abs(locations[i + 1][1] - locations[i - 1][1]));

			answer = Math.min(answer, skipDist);
		}

		System.out.println(answer);
	}
}