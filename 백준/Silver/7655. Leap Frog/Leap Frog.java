import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;
		int[] X;

		// 질과 잭의 위치 인덱스
		int a, b;

		int cnt, na;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			X = new int[n];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}

			a = 0;
			b = 1;
			cnt = 0;

			// 도착지점에 도착할 때까지 반복
			// a < b 임을 보장할 것
			while (b != n - 1) {
				cnt++;

				// 도착지점에 도달할 수 있으면 탈출
				if (X[n - 1] <= X[a] + 10)
					break;

				na = b;

				while (X[na + 1] <= X[a] + 10) {
					na++;
				}

				// b가 건너뛸 수 없는 경우 고려
				if (X[na + 1] > X[b] + 10)
					na--;

				if (na <= b) {
					cnt = -1;
					break;
				} else {
					a = b;
					b = na;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString());
	}
}