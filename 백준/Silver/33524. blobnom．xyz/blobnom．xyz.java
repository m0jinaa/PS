import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, b = 317;
	static int[] problems;
	static int[] gameboard;

	static void init() {
		Arrays.sort(problems);

		gameboard = new int[b];

		for (int i = 1; i < b; i++) {
			gameboard[i] = 3 * i * (i - 1) + 1;
		}
	}

	// 사용자가 풀수있는 문제 개수 구하기
	static int getMaxProblem(int x) {
		int s = 0;
		int e = n - 1;

		int ret = 0;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (problems[m] <= x) {
				ret = m + 1;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		return ret;
	}

	// 사용자가 풀 수 있는 문제수로 만들 수 있는 가장 큰 보드판의 크기 구하기
	static int getMaxBoard(int x) {
		int s = 0;
		int e = b - 1;

		int ret = 0;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (gameboard[m] <= x) {
				ret = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		problems = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			problems[i] = Integer.parseInt(st.nextToken());
		}

		init();

		st = new StringTokenizer(br.readLine(), " ");

		int x, p, c;

		while (m-- > 0) {
			x = Integer.parseInt(st.nextToken());

			p = getMaxProblem(x);

			c = getMaxBoard(p);

			sb.append(c).append(" ");
		}

		System.out.println(sb.toString());
	}
}