import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int gcd(int x, int y) {
		if (x < y) {
			int t = x;
			x = y;
			y = t;
		}
		int t;
		while (y != 0) {
			t = x % y;
			x = y;
			y = t;
		}

		return x + y;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int[] estimate1 = new int[n];
		int[] estimate2 = new int[n];
		int[] first = new int[n];
		int[] second = new int[n];

		for (int i = 0; i < n; i++) {
			first[i] = Integer.parseInt(st.nextToken());
		}
		int r = first[0];
		for (int i = 1; i < n; i++) {
			r = gcd(r, first[i]);
		}

		long ans = 0;

		for (int i = 0; i < n; i++) {
			estimate1[i] = first[i] / r;
			ans += estimate1[i];
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			second[i] = Integer.parseInt(st.nextToken());
		}
		r = second[0];
		for (int i = 1; i < n; i++) {
			r = gcd(r, second[i]);
		}

		long answer = 0;
		int v = 1;
        
		for (int i = 0; i < n; i++) {
			estimate2[i] = second[i] / r;
			answer += estimate2[i];
			if (estimate2[i] < estimate1[i]) {
				v = Math.max(v, (int) Math.ceil(estimate1[i] * 1.0 / estimate2[i]));
			}
		}

		answer *= v;

		System.out.println(ans + " " + answer);
	}
}