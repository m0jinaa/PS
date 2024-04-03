import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int[] xor = new int[n + 1];

		int x;

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());

			xor[i] = xor[i - 1] ^ x;
		}

		int answer = 0;

		int s, e;

		int v;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());

			v = xor[e] ^ xor[s - 1];

			answer ^= v;
		}

		System.out.println(answer);
	}
}