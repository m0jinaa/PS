import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int s, c, a, r;

		int answer = 0;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			if (s >= 1000 || c >= 1600 || a >= 1500 || (r != -1 && r <= 30)) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}