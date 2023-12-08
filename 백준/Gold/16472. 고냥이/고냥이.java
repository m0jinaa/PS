import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n, m;
	static int[] word;
	static int[] cnt = new int[26];

	static int find(int l, int r, int c, int k) {
		if (r >= n) {
			return 0;
		}
		c++;

		if (cnt[word[r]]++ == 0) {
			k++;
		}

		if (k > m) {
			if (--cnt[word[l++]] == 0) {
				k--;
			}
			c--;
		}

		int max = Math.max(c, find(l, r + 1, c, k));

		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		m = Integer.parseInt(br.readLine());

		char[] input = br.readLine().toCharArray();

		n = input.length;

		word = new int[n];
		for (int i = 0; i < n; i++) {
			word[i] = input[i] - 'a';
		}

		int answer = find(0, 0, 0, 0);

		System.out.println(answer);
	}
}