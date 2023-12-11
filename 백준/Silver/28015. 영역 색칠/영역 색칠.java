import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int one = 0;
		int two = 0;

		int x;
		int answer = 0;
		int bef = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				x = Integer.parseInt(st.nextToken());
				if (x == 1 && bef != 1) {
					one++;
				} else if (x == 2 && bef != 2) {
					two++;
				}

				bef = x;
				if (x == 0 || j == m - 1) {
					if (one != 0 || two != 0) {
						answer += (Math.min(one, two) + 1);
					}
					one = 0;
					two = 0;
					bef = 0;
				}
			}
		}

		System.out.println(answer);
	}
}