import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int INF = 1_000_000_007;

		int np, nm, n0, r;

		int time, answer;

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			np = Integer.parseInt(st.nextToken());
			nm = Integer.parseInt(st.nextToken());
			n0 = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			if (np == 0 && nm == 0 && n0 == 0 && r == 0)
				break;

			answer = INF;

			// t시간동안 do it을 외쳤을 때
			for (int t = 0; t <= 100; t++) {
				time = 0;

				// n+인 사람들이 일을 마치는데 걸리는 시간 구하기
				if (t * (r + 2) >= 100) {
					time += np * (int) Math.ceil(100.0 / (r + 2));
				} else {
					time += (t + (int) Math.ceil((100 - (r + 2) * t) * 1.0 / r)) * np;
				}

				// n-인 사람들이 일을 마치는데 걸리는 시간 구하기
				if (t * (r - 1) >= 100) {
					time += nm * (int) Math.ceil(100.0 / (r - 1));
				} else {
					time += (t + (int) Math.ceil((100 - (r - 1) * t) * 1.0 / r)) * nm;
				}

				// n0인 사람들이 일을 마치는데 걸리는 시간 구하기

				time += n0 * (int) Math.ceil(100.0 / r);

				answer = Math.min(answer, time);
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}