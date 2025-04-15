import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] maxTree; // 구간최댓값 저장하는 tree;

	// Bottom-Up 방식으로 저장
	static void update(int x, int v) {
		while (x != 0) {
			// 현재 구간의 최댓값이 v값보다 크다면 더 진행할 필요 없음
			if (maxTree[x] >= v)
				break;

			maxTree[x] = v;

			// 부모노드로 이동
			x >>= 1;
		}
	}

	static int get(int s, int e, int l, int r, int x) {
		if (e < l || r < s)
			return 0;
		else if (l <= s && e <= r)
			return maxTree[x];
		else {
			int m = (s + e) / 2;

			return Math.max(get(s, m, l, r, 2 * x), get(m + 1, e, l, r, 2 * x + 1));
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		// 각 원소가 처음 나온 위치 저장하는 배열로 어느 구간을 봐야할지 정할 때 사용.
		int[] loc;

		int N;
		int a;

		boolean answer;

		while (tc-- > 0) {
			answer = true;

			n = Integer.parseInt(br.readLine());

			loc = new int[n + 1];
			Arrays.fill(loc, -1);

			// n개를 표현하기위에 필요한 세그먼트트리의 노드 수 = 2^(log2(n)+1))
			N = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)) + 1);

			maxTree = new int[N];

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				a = Integer.parseInt(st.nextToken());

				update(N / 2 + i, a);

				if (loc[a] != -1) { // 같은 원소 들어온 적 있음
					// 제일 처음 들어온 위치와 지금 위치 사이의 값 중 최댓값이 현재 값을 넘으면 이상한 배열 아님.
					if (get(0, N / 2 - 1, loc[a], i, 1) <= a) {
						continue;
					}
					answer = false;
					break;

				} else {// 같은 원소 들어온 적 없음
					loc[a] = i;
				}
			}

			sb.append(answer ? "Yes\n" : "No\n");
		}

		System.out.print(sb.toString());
	}
}