import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] cola = new int[n + 1];
		int[] s = new int[n + 1];
		int[] e = new int[n + 1];

		int[] hamburger = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			hamburger[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		int t;

		for (int i = 0; i < k; i++) {
			t = Integer.parseInt(st.nextToken());
			s[t]++;
			if (t + l <= n)
				e[t + l]++;
		}

		for (int i = 1; i <= n; i++) {
			cola[i] = cola[i - 1] + s[i] - e[i];
		}

		Arrays.sort(cola);
		Arrays.sort(hamburger);

		long answer = 0;

		for (int i = 1; i <= n; i++) {
			answer += hamburger[i] / (int) Math.pow(2, cola[i]);
		}

		System.out.println(answer);
	}
}