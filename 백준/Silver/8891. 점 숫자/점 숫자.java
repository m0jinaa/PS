import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int MAX = 300;
	static int[] sum;

	static int getN(int x) {
		int s = 0;
		int e = MAX - 1;
		int m;
		int ret = -1;

		while (s <= e) {
			m = (s + e) / 2;
			if (sum[m] >= x) {
				ret = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 점 좌표 (r,c)
		// n = 1부터 n까지의 합이 점숫자 보다 같거나 작은 최댓값
		// c = 점숫자 - 1부터n까지의 합
		// r = n-c;
		// if c == 0 => r++;

		sum = new int[MAX];

		for (int i = 1; i < MAX; i++) {
			sum[i] = sum[i - 1] + i;
		}

		int tc = Integer.parseInt(br.readLine());

		int x, y;

		int answer;
		int n, a, b, c, d;

		int row;

		while (tc-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			n = getN(x);

			a = x - sum[n - 1];
			b = n - a + 1;

			n = getN(y);

			c = y - sum[n - 1];
			d = n - c + 1;

			row = a + b + c + d - 1;

			answer = sum[row - 1] + a + c;

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}