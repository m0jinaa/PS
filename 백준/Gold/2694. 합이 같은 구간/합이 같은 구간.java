import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] A;

	static boolean check(int x) {

		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += A[i];

			if (sum > x)
				return false;
			else if (sum == x)
				sum = 0;

		}

		return sum == 0;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int m;
		int ind, v, max, s;
		int answer;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			m = (int) Math.ceil(1.0 * n / 10);

			A = new int[n];
			ind = 0;
			max = 0;
			s = 0;

			while (m-- > 0) {
				st = new StringTokenizer(br.readLine(), " ");
				while (st.hasMoreTokens()) {
					A[ind] = Integer.parseInt(st.nextToken());
					max = Math.max(max, A[ind]);
					s += A[ind++];
				}
			}

			answer = 0;

			v = 0;

			for (int i = 0; i < n; i++) {
				v += A[i];
				if (max > v || s % v != 0)
					continue;
				else if (check(v)) {
					answer = v;
					break;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}