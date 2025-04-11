import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Building implements Comparable<Building> {
		int x, y, c;

		public Building(int x, int y, int c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public int compareTo(Building b) {
			// 모든 건물의 x좌표가 다르므로 x로만 비교해도 됨.
			return this.x - b.x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Building[] buildings = new Building[n];

		int x, y, c;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			buildings[i] = new Building(x, y, c);
		}

		Arrays.sort(buildings);

		// dp[i][0] -> 왼쪽위에서 오른쪽 아래로 내려오는 대각선
		// dp[i][1] -> 오른쪽위에서 왼쪽 아래로 내려오는 대각선
		int[][] dp = new int[n][2];

		// x로 정렬되었고, 모든 건물의 x좌표가 다르기 때문에
		// y만 비교해서 왼쪽에서 내려오는 대각선인지 오른쪽에서 내려오는 대각선인지 구분 가능.

		int answer = 0;

		for (int i = 0; i < n; i++) {
			// 최소값은 이 빌딩이 대각선의 시작점인 경우
			dp[i][0] = buildings[i].c;
			dp[i][1] = buildings[i].c;
			for (int j = 0; j < i; j++) {
				if (buildings[j].y < buildings[i].y) {
					// 왼쪽상단->오른쪽하단
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + buildings[i].c);
				} else {
					// 오른쪽상단->왼쪽하단
					dp[i][1] = Math.max(dp[i][1], dp[j][1] + buildings[i].c);
				}
			}
            //i번째 빌딩을 대각선의 마지막 지점이라고 생각하고 최대값 구하기
			answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
		}

		System.out.println(answer);
	}
}