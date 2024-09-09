import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] isPrime;
	static int[] cnt;

	static void init() {
		isPrime = new boolean[1001];
		cnt = new int[1001];

		Arrays.fill(isPrime, true);

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i < 1001; i++) {

			cnt[i] = cnt[i - 1];

			if (!isPrime[i])
				continue;

			cnt[i] += 1;

			for (int j = i * i; j < 1001; j += i) {
				isPrime[j] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		init();

		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int e = 1, f = 1;

		if (a <= c && c <= b) {
			e = c;
			f = Math.min(b, d);
		} else if (c <= a && a <= d) {
			e = a;
			f = Math.min(b, d);
		}

		int duplicated = cnt[f] - cnt[e - 1];

		int yongtae = cnt[b] - cnt[a - 1] - duplicated + duplicated / 2 + (duplicated % 2 == 0 ? 0 : 1);
		int yujin = cnt[d] - cnt[c - 1] - duplicated + duplicated / 2;

		String answer = (yongtae > yujin) ? "yt" : "yj";

		System.out.println(answer);

	}
}