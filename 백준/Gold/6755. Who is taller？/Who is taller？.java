import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static LinkedList<Integer>[] canGo;
	static LinkedList<Integer> q;
	static boolean[] v;

	static boolean check(int s, int e) {
		q.clear();
		Arrays.fill(v, false);

		q.add(s);
		v[s] = true;

		int x;

		while (!q.isEmpty()) {
			x = q.poll();

			if (x == e) {
				return true;
			}

			for (int y : canGo[x]) {
				if (v[y])
					continue;
				v[y] = true;
				q.add(y);
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		q = new LinkedList<>();

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new LinkedList[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new LinkedList<>();
		}

		int a, b, s, e;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
		}

		st = new StringTokenizer(br.readLine(), " ");

		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		String answer = check(s, e) ? "yes" : check(e, s) ? "no" : "unknown";

		System.out.println(answer);
	}
}