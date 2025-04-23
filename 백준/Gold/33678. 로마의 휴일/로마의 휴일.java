import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k, x;
	static int[] A;

	static boolean isPossible(int d) {
		int money;

		boolean possible = false;

		for (int i = 1; i + d - 1 <= n; i++) { // i번째 날부터 d일동안 휴가를 다녀올 때 k만큼의 돈을 벌 수 있는지 확인.
			// i-1일까지는 일급 * x 만큼의 돈을 벌고 휴가를 다녀온 뒤에는 일급만 받는다.
			money = A[i - 1] * x + A[n] - A[i + d - 1];

			if (money < k)
				continue;

			// 가능한지 아닌지만 체크하면 되니까 탈출.
			possible = true;
			break;
		}

		return possible;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		A = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
		}

		int answer = -1;

		int s = 1, e = n - 1;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (isPossible(m)) {
				answer = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		System.out.println(answer);
	}
}