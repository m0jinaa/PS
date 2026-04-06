import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	static int n;
	static int[] next;
	static boolean[] v;
	static LinkedList<Integer> q;

	static int getMax(int x) {
		int c = 0;
		q.clear();
		Arrays.fill(v, false);

		q.add(x);
		v[x] = true;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (v[next[now]])
				continue;
			v[next[now]] = true;
			q.add(next[now]);
			c++;
		}

		return c;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		v = new boolean[n + 1];
		next = new int[n + 1];
		q = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			next[i] = Integer.parseInt(br.readLine());
		}

		int max = 0;
		int answer = -1;

		int ret;

		for (int i = 1; i <= n; i++) {
			ret = getMax(i);
			if (ret > max) {
				answer = i;
				max = ret;
			}
		}

		System.out.println(answer);
	}
}