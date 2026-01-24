import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] weight;
	static boolean[] possible;

	static void scale(int ind, int w) {
		if (ind == n) {
			if (w > 0)
				possible[w] = true;
		} else {
			scale(ind + 1, w);
			scale(ind + 1, w - weight[ind]);
			scale(ind + 1, w + weight[ind]);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		weight = new int[n];

		int s = 0;

		for (int i = 0; i < n; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			s += weight[i];
		}

		possible = new boolean[s + 1];

		scale(0, 0);

		int answer = 0;

		for (int i = 1; i <= s; i++) {
			if (possible[i])
				continue;
			answer++;
		}

		System.out.println(answer);
	}
}