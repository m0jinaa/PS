import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		char[] A, B;
		int cnt = 0;
		int n;
		int a, b;

		int answer;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			A = st.nextToken().toCharArray();
			B = st.nextToken().toCharArray();

			n = A.length;

			cnt = 0;
			a = 0;
			b = 0;

			for (int i = 0; i < n; i++) {
				if (A[i] != B[i])
					cnt++;
				if (A[i] == '1')
					a++;
				if (B[i] == '1')
					b++;
			}

			answer = Math.abs(a - b);
			answer += (cnt - answer) / 2;

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}