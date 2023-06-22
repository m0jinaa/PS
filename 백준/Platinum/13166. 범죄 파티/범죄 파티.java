import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static boolean[] used;
	static final int INF = 1_000_000_000;
	static int[] A, B;
	static int[] level;
	static ArrayList<Integer>[] canMatch;

	static boolean match(int x) {
		for (int y : canMatch[x]) {
			if (B[y] == 0 || (level[B[y]] == level[x] + 1 && match(B[y]))) {
				used[x] = true;
				B[y] = x;
				A[x] = y;
				return true;
			}
		}
		return false;
	}

	public static void setLevel() {
		LinkedList<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (!used[i]) {
				level[i] = 0;
				q.add(i);
			} else {
				level[i] = INF;
			}
		}

		int x;
		while (!q.isEmpty()) {
			x = q.poll();
			for (int y : canMatch[x]) {
				if (B[y] != 0 && level[B[y]] == INF) {
					level[B[y]] = level[x] + 1;
					q.add(B[y]);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		int m = 2 * n;

		used = new boolean[n + 1];
		canMatch = new ArrayList[n + 1];
		level = new int[n + 1];

		A = new int[n + 1];
		B = new int[m + 1];

		int[][][] friends = new int[n + 1][2][2];

		int a, b, ak, bk;

		for (int i = 1; i <= n; i++) {

			canMatch[i] = new ArrayList<>();

			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			ak = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			bk = Integer.parseInt(st.nextToken());

			friends[i][0][0] = a;
			friends[i][0][1] = ak;
			friends[i][1][0] = b;
			friends[i][1][1] = bk;
		}

		int s = 0;
		int e = 1_000_000;
		int answer = INF;
		int k, cnt;

		while (s <= e) {
			k = (s + e) / 2;

			for (int i = 1; i <= n; i++) {
				canMatch[i].clear();
				for (int[] friend : friends[i]) {
					if (friend[1] <= k) {
						canMatch[i].add(friend[0]);
					}
				}
			}

			int c;

			Arrays.fill(used, false);
			Arrays.fill(A, 0);
			Arrays.fill(B, 0);

			cnt = 0;

			while (true) {
				setLevel();

				c = 0;
				for (int i = 1; i <= n; i++) {
					if (!used[i] && match(i))
						c++;
				}

				if (c == 0)
					break;
				cnt += c;
			}

			if (cnt == n) {
				answer = Math.min(answer, k);
				e = k - 1;
			} else {
				s = k + 1;
			}
		}

		System.out.println(answer == INF ? -1 : answer);
	}
}