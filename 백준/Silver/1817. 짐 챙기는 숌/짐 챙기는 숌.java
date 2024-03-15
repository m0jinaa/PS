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

		int answer = 0;

		if (n != 0) {
			answer++;
			st = new StringTokenizer(br.readLine(), " ");
			int sum = 0;
			int x;
			for (int i = 0; i < n; i++) {
				x = Integer.parseInt(st.nextToken());
				if (sum + x > m) {
					sum = x;
					answer++;
				} else {
					sum += x;
				}
			}
		}

		System.out.println(answer);
	}
}