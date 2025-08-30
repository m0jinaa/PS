import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Apple {
		int time;
		int weight;

		public Apple(int time, int weight) {
			super();
			this.time = time;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int l = Integer.parseInt(st.nextToken());
		int td = Integer.parseInt(st.nextToken());
		int th = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		if (td >= th) {
			// Diana가 Humperdonkey보다 느리거나 같은 속도로 달리는 경우
			sb.append("Diana marries Humperdonkey\n");
		} else {
			int w, x;
			// 사과를 주워도 되는 시간의 총량 = 둘의 달리는 속도차 * 달려야하는 거리
			int time = (th - td) * l;

			int[] dp = new int[time];

			Apple[] apples = new Apple[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				w = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());

				// 사과를 주우면 종착점까지 달리는데 늘어나는 시간
				// => 종착지까지 남은 거리 * 무게 * 무게당 늘어나는 시간당 속도
				apples[i] = new Apple((l - x) * w * d, w);
			}

			for (Apple apple : apples) {
				for (int i = time - 1; i >= apple.time; i--) {
					dp[i] = Math.max(dp[i], dp[i - apple.time] + apple.weight);
				}
			}

			// 1초라도 빨라야함
			sb.append(dp[time - 1]).append("\n");
		}

		System.out.print(sb.toString());
	}
}