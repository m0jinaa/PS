import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] target;
	static int[] now;
	static ArrayList<Integer>[] canGo;
	static boolean[] v;

	static int getMin(int x) {
		v[x] = true;
		int cost = Math.max(0, target[x] - now[x]);

		int have = Math.max(0, now[x] - target[x]);

		int need;

		for (int y : canGo[x]) {
			if (v[y])
				continue;
			need = getMin(y);

			if (have >= need) {
				have -= need;
			} else {
				need -= have;
				have = 0;
				cost += need;
			}
		}

		return cost;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		now = new int[n + 1];
		target = new int[n + 1];

		canGo = new ArrayList[n + 1];
		v = new boolean[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			now[i] = Integer.parseInt(st.nextToken());
			canGo[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			target[i] = Integer.parseInt(st.nextToken());
		}

		int x, y;

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canGo[x].add(y);
			canGo[y].add(x);
		}

		System.out.println(getMin(p));
	}
}