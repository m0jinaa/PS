import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		int zero = 0;
		int one = 0;
		int now = 0;

		long answer = 0;

		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());

			now += x;

			if (now % 2 == 0) {
				answer += one;
				zero++;
			} else {
				answer += zero + 1;
				one++;
			}
		}

		System.out.println(answer);
	}
}