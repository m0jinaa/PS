import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] cnt;
	static int[] sum;
	static int k, max, min;

	static void getAB() {
		int a = 0;
		int b = min;
		long total = 0;

		int s = 0;
		int e = 0;

		while (true) {
			if (total == k) {
				s = a;
				e = b;
				break;
			} else if (b >= 1000001)
				break;
			else if (total < k) {
				total += cnt[b++];

			} else {
				total -= cnt[a++];
			}
		}

		System.out.println(s + " " + e);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		cnt = new int[1000001];

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int a, b;
		min = Integer.MAX_VALUE;
		max = 0;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			min = Math.min(a, min);
			max = Math.max(max, b);

			for (int i = a; i < b; i++) {
				cnt[i]++;
			}
		}

		getAB();

	}
}