import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k;
	static long[] country;
    
    // x개의 그룹을 만들 수 있는지 체크
	static boolean isPossible(long x) {
		long i = 0;

		int cnt = 0;

		for (long c : country) {
			if (c >= x) {
				cnt++;
			} else {
				i += c;

				cnt += (i / x);
				i %= x;
			}
		}

		return cnt >= k;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		country = new long[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			country[i] = Long.parseLong(st.nextToken());
		}

		long s = 1L;
		long e = Long.MAX_VALUE;

		long mid;

		long answer = 0;

		while (s <= e) {
			mid = (s + e) / 2;

			if (isPossible(mid)) {
				answer = mid;
				s = mid + 1;
			} else {
				e = mid - 1;
			}
		}

		System.out.println(answer);
	}
}