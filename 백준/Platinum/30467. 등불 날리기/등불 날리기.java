import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, s;
	static int[] tree;
	static int[] ind;

	static void update(int x, int v) {
		while (x <= n) {
			tree[x] += v;
			x += (x & (-x));
		}
	}

	static int get(int x) {
		int sum = 0;
		while (x > 0) {
			sum += tree[x];
			x -= (x & (-x));
		}

		return sum;
	}

	static int getInd(int x) {
		int s = 0;
		int e = n - 1;
		int m;
		int answer = -1;

		while (s <= e) {
			m = (s + e) / 2;
			if (ind[m] >= x) {
				answer = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return answer + 1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		int[] order = new int[n];
		tree = new int[n + 1];
		ind = new int[n];

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(st.nextToken());
			order[i] = x;
			ind[i] = x;
		}

		Arrays.sort(ind);
		long answer = 0;

		long sum = 0;

		int index;
		for (int i = 0; i < n; i++) {
			if (i >= s) {
				index = getInd(order[i - s]);
				sum -= (s - get(index));
				update(index, -1);
			}
			index = getInd(order[i]);
			sum += get(index - 1);
			answer = Math.max(answer, sum);

			update(index, 1);
		}

		System.out.println(answer);
	}
}