import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		long n = Long.parseLong(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		long x = Long.parseLong(st.nextToken());

		int[] price = new int[m];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < m; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		long l, r, mid;

		long c;

		int ind = 0;

		while (ind < m) {
			l = 0;
			r = n;
			c = 0;
			while (n != 0 && l <= r) {
				mid = (l + r) / 2;
				if (x - mid * price[ind] >= (n - mid) * price[m - 1]) {
					c = mid;
					l = mid + 1;
				} else {
					r = mid - 1;
				}
			}

			sb.append(c).append(" ");
			x -= c * price[ind];
			n -= c;
			ind++;
		}

		System.out.println(sb.toString());
	}
}