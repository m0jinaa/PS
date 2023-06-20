import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static boolean[] prime;
	static int[][] cnt;
	static int n;
	static Set<Integer> set;

	static void init() {
		prime = new boolean[4000001];

		Arrays.fill(prime, true);

		prime[0] = prime[1] = false;
		for (int i = 2; i < 4000001; i++) {
			if (!prime[i])
				continue;
			for (int j = i * 2; j < 4000001; j += i) {
				prime[j] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		init();

		int a, b, d;

		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		int cnt = 0;
		int k;
		for (int i = a; i <= b; i++) {
			if (!prime[i])
				continue;
			k = i;
			while (k > 0) {
				if (k % 10 == d) {
					cnt++;
					break;
				}
				k /= 10;
			}
		}
        
		System.out.println(cnt);
	}
}