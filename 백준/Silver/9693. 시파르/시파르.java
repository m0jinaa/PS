import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n, m, t, answer;
		t = 0;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			m = 5;
			answer = 0;
			t++;

			while (m <= n) {
				answer += n / m;
				m *= 5;
			}

			sb.append("Case #").append(t).append(": ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}