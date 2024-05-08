import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		long s = Long.parseLong(st.nextToken());
		long bef = s;
		long now;

		long cost = 0;

		for (int i = 1; i < n; i++) {
			now = Long.parseLong(st.nextToken());

			if (now - bef <= k) {
				bef = now;
			} else {
				cost += bef - s + 1 + k;
				s = now;
				bef = s;
			}
		}

		cost += bef - s + 1 + k;

		System.out.println(cost);
	}
}