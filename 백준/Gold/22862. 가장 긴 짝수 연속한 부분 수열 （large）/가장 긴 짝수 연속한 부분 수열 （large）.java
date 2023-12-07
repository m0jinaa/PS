import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] a;

	static int find() {
		int l = 0;
		int r = 0;
		int max = 0;
		int c = 0;

		while (true) {
			if (c > k) {
				if (a[l] % 2 == 1) {
					c -= 1;
				}
				l += 1;
			} else if (r >= n) {
				break;
			} else {
				if (a[r] % 2 == 1) {
					c += 1;
				}
				r += 1;
			}
			if (c <= k) {
				max = Math.max(max, r - l - c);
			}

		}

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		a = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int answer = find();

		System.out.println(answer);
	}
}