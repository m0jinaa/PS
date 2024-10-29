import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] width = new int[n + 1];

		// 상단 장애물위치-하단장애물위치 = 장애물 틈새의 너비
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			width[i] = Integer.parseInt(st.nextToken());
		}

		width[0] = Integer.MAX_VALUE;

		// width[i] = i번째 틈새까지 지나갈 수 있는 플래피 버드의 최대 크기

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			width[i] -= Integer.parseInt(st.nextToken());

			width[i] = Math.min(width[i - 1], width[i]);
		}

		int q = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int s, e, m;
		int w, answer;

		while (q-- > 0) {
			w = Integer.parseInt(st.nextToken());

			s = 1;
			e = n;
			answer = 0;

			while (s <= e) {
				m = (s + e) / 2;

				if (width[m] >= w) {
					answer = m;
					s = m + 1;
				} else {
					e = m - 1;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}