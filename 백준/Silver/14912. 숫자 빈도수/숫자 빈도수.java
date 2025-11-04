import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int answer = 0;
		int x;
		for (int i = 1; i <= n; i++) {
			x = i;
			while (x > 0) {
				if (x % 10 == d) {
					answer++;
				}

				x /= 10;
			}
		}

		System.out.println(answer);
	}
}