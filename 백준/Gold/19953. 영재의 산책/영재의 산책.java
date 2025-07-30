import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int[] dx = new int[] { 0, 1, 0, -1 };
		final int[] dy = new int[] { 1, 0, -1, 0 };

		st = new StringTokenizer(br.readLine(), " ");

		int v = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int x = 0;
		int y = 0;

		// t를 4의 배수로 만들기 위해 나머지부분 먼저 진행
		// 4의 배수일 때는 초기 v값이 규칙에서 벗어날 수 있기 때문에 4번 진행
		int i = 0;
		for (; i == 0 || i % 4 != t % 4; i++) {
			x += dx[i] * v;
			y += dy[i] * v;

			v = (v * m) % 10;
		}

		for (int j = 0; j < 4; j++) {
			x += dx[(i + j) % 4] * v * ((t - i) / 4);
			y += dy[(i + j) % 4] * v * ((t - i) / 4);

			v = (v * m) % 10;
		}

		sb.append(x).append(" ").append(y);

		System.out.println(sb.toString());
	}
}