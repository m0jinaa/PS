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

		int[] next = new int[n];

		for (int i = 0; i < n; i++) {
			next[i] = Integer.parseInt(br.readLine());
		}

		int now = 0;

		int answer = -1;

		boolean[] v = new boolean[n];

		v[0] = true;

		int c = 0;

		while (now != k) {
			c++;
			now = next[now];

			if (v[now])
				break;
			v[now] = true;
		}

		if (now == k) {
			answer = c;
		}

		System.out.println(answer);
	}
}