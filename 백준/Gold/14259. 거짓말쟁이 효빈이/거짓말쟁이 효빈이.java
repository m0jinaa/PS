import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, k, a;
	static boolean[] attacked;

	static boolean canDeploy() {
		int cnt = 0;
		int c = 0;

		// 함선과 함선은 최소 한칸 떨어져있어야함.
		for (int i = 1; i <= n;) {
			if (attacked[i]) {
				c = 0;
				i++;
				continue;
			} else {
				c++;

				if (c == a) {
					cnt++;
					c = 0;
					i += 2;
				} else {
					i++;
				}
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
		a = Integer.parseInt(st.nextToken());

		attacked = new boolean[n + 1];

		int m = Integer.parseInt(br.readLine());
		int[] missile = new int[m + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= m; i++) {
			missile[i] = Integer.parseInt(st.nextToken());
		}

		int bef = 0;

		int answer = -1;

		int s = 1;
		int e = m;
		int mid;

		while (s <= e) {
			mid = (s + e) / 2;

			// 공격당한 곳 체크
			if (bef < mid) {
				while (bef + 1 <= mid) {
					attacked[missile[++bef]] = true;
				}
			} else {
				while (bef > mid) {
					attacked[missile[bef--]] = false;
				}
			}
			bef = mid;

			// 전함 k개 배치할 수 있는지 체크
			if (canDeploy()) {
				s = mid + 1;
			} else {
				answer = mid;
				e = mid - 1;
			}
		}

		System.out.println(answer);
	}
}