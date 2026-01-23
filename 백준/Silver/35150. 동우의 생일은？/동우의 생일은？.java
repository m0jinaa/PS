import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 최대넓이 = 모든 상자를 꼭짓점에서 만나게 대각선으로 위치한 경우
		// 상자의 가로 세로는 최대한 차이가 적어야 넓이가 넓음

		int tc = Integer.parseInt(br.readLine());

		int a, b, n, t;
		long w, h;
		long space;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			if (a < b) {
				t = a;
				a = b;
				b = t;
			}

			w = (a + b) * (n / 2) + (n % 2 != 0 ? a : 0);
			h = (a + b) * (n / 2) + (n % 2 != 0 ? b : 0);

			space = w * h;

			sb.append(space).append("\n");
		}

		System.out.println(sb.toString());
	}
}