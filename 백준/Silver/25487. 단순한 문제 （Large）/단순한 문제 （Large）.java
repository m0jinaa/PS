import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int a, b, c;

		int answer;

		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			answer = Math.min(a, Math.min(b, c));

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}
}