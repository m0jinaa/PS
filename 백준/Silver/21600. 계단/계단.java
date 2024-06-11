import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int bef = 0;

		st = new StringTokenizer(br.readLine(), " ");

		int answer = 0;

		int x;

		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());
			if (bef < x) {
				bef++;
			} else {
				bef = Math.min(bef, x);
			}

			answer = Math.max(answer, bef);
		}

		System.out.println(answer);
	}
}