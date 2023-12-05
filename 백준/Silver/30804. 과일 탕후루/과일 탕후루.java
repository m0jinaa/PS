import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] stick;
	static int[] cnt = new int[10];

	static int find(int l, int r, int c, int k) {
		if (r >= n) {
			return 0;
		}

		c++;

		if (cnt[stick[r]]++ == 0) {
			k++;
		}

		if (k > 2) {
			if (--cnt[stick[l++]] == 0) {
				k--;
			}
			c--;
		}

		int max = Math.max(c, find(l, r + 1, c, k));

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		stick = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			stick[i] = Integer.parseInt(st.nextToken());
		}

		int answer = find(0, 0, 0, 0);

		System.out.println(answer);
	}
}