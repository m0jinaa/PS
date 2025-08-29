import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st, stt;

		int n, answer;
		boolean[] printed;

		while ((n = Integer.parseInt(br.readLine())) != 0) {

			answer = 0;
			printed = new boolean[n + 1];

			st = new StringTokenizer(br.readLine(), ",");

			int a, b;

			while (st.hasMoreTokens()) {
				stt = new StringTokenizer(st.nextToken(), "-");

				if (stt.countTokens() == 1) {
					a = Integer.parseInt(stt.nextToken());
					b = a;
				} else {
					a = Integer.parseInt(stt.nextToken());
					b = Integer.parseInt(stt.nextToken());
				}

				for (int i = a; i <= b && i <= n; i++) {
					if (printed[i])
						continue;
					printed[i] = true;
					answer++;
				}
			}

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}