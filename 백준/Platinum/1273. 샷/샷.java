import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] h;
	static int[] tree;

	static final int MAX_HEIGHT = 3000000;

	static int init(int l, int r, int k) {

		if (l == r)
			return tree[k] = 1;

		int mid = (l + r) >> 1;

		return tree[k] = init(l, mid, 2 * k) + init(mid + 1, r, 2 * k + 1);

	}

	static int update(int l, int r, int ind, int v, int k) {

		if (l > ind || r < ind)
			return tree[k];

		if (l == r)
			return tree[k] += v;

		int mid = (l + r) >> 1;

		return tree[k] = update(l, mid, ind, v, 2 * k) + update(mid + 1, r, ind, v, 2 * k + 1);

	}

	static int getInd(int l, int r, int v, int k) {

		if (l == r)
			return l;

		int mid = (l + r) >> 1;

		if (v <= tree[2 * k])
			return getInd(l, mid, v, 2 * k);

		else
			return getInd(mid + 1, r, v - tree[2 * k], 2 * k + 1);

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		h = new int[MAX_HEIGHT + 1];

		int n = Integer.parseInt(br.readLine());

		int N = (int) Math.pow(2, (int) Math.ceil(Math.log10(MAX_HEIGHT) / Math.log10(2)) + 1);

		int[] score = new int[] { 1, 2, 5 };

		int[] tower = new int[MAX_HEIGHT];

		tree = new int[N];

		init(0, MAX_HEIGHT - 1, 1);

		boolean[] v = new boolean[MAX_HEIGHT];

		int c;
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			for (int j = 0; j < n; j++) {
				c = Integer.parseInt(st.nextToken());

				tower[h[j]] += score[i];
				tower[h[j] + c] -= score[i];

				h[j] += c;
			}
		}

		for (int i = 1; i < MAX_HEIGHT; i++) {
			tower[i] += tower[i - 1];
		}

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int t, target;

		while (m-- > 0) {
			t = Integer.parseInt(st.nextToken());

			target = Math.min(MAX_HEIGHT - 1, getInd(0, MAX_HEIGHT - 1, t, 1));

			if (!v[target]) {
				v[target] = true;
				sb.append(tower[target]).append("\n");
				update(0, MAX_HEIGHT - 1, target, -1, 1);
			} else {
				sb.append("0\n");
			}
		}

		System.out.println(sb.toString());
	}
}