import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static int[] a;
	static int[] cnt = new int[100001];

	static int find(int l, int r) {
		if (r >= n) {
			return 0;
		}
		int c;
		int max = 0;
		if (++cnt[a[r]] > k) {
			while (--cnt[a[l++]] != k)
				;
		}
		c = r - l + 1;
		max = Math.max(c, find(l, r + 1));

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

		int answer = find(0, 0);

		System.out.println(answer);
	}
}
