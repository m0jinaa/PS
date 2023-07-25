import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] wins;
	static ArrayList<Integer>[] loses;
	static boolean[] v;

	static int up(int x) {
		int cnt = 1;
		v[x] = true;

		for (int y : loses[x]) {
			if (v[y])
				continue;
			cnt += up(y);
		}
		return cnt;
	}

	static int down(int x) {
		int cnt = 1;
		v[x] = true;
		for (int y : wins[x]) {
			if (v[y])
				continue;
			cnt += down(y);
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		wins = new ArrayList[n + 1];
		loses = new ArrayList[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			wins[i] = new ArrayList<>();
			loses[i] = new ArrayList<>();
		}
		int a, b;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			wins[a].add(b);
			loses[b].add(a);
		}

		int w = n + 1 - down(x);

		Arrays.fill(v, false);

		int l = up(x);

		System.out.println(l + " " + w);

	}
}