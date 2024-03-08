import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] calendar = new int[367];

		int s, e;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			for (int j = s; j <= e; j++) {
				calendar[j]++;
			}
		}

		int d = 0;
		int c = 0;
		int answer = 0;

		for (int i = 0; i <= 366; i++) {
			if (calendar[i] == 0) {
				answer += d * c;
				c = 0;
				d = 0;
			} else {
				c = Math.max(c, calendar[i]);
				d++;
			}
		}

		System.out.println(answer);
	}
}