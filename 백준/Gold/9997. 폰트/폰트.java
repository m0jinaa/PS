import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] words;
	static int n, answer;
	static final int FULL = (1 << 26) - 1;

	public static void select(int ind, int key) {
		if (key == FULL) {
			answer += (1 << (n - ind));
		} else if (ind == n) {
			return;
		} else {
			select(ind + 1, key | words[ind]);
			select(ind + 1, key);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		words = new int[n];

		char[] word;
		int x;
		for (int i = 0; i < n; i++) {
			word = br.readLine().toCharArray();
			x = 0;
			for (char c : word) {
				x |= (1 << (c - 'a'));
			}
			words[i] = x;
		}

		answer = 0;

		select(0, 0);

		System.out.println(answer);
	}
}