import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static HashMap<Integer, Integer> map, rev;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int a, b;
		int[][] time = new int[n][2];

		ArrayList<Integer> t = new ArrayList<>();

		map = new HashMap<>();
		rev = new HashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken()) - 1;

			t.add(a);
			t.add(b);
			t.add(a - 1);
			t.add(b + 1);

			time[i][0] = a;
			time[i][1] = b;
		}

		Collections.sort(t);

		int ind = 0;
		for (int x : t) {
			if (map.containsKey(x))
				continue;
			map.put(x, ind);
			rev.put(ind++, x);
		}

		int N = ind;
		int[] cnt = new int[N];

		int d = cnt[0];

		for (int[] m : time) {
			a = map.get(m[0]);
			b = map.get(m[1] + 1);

			cnt[a] += 1;
			cnt[b] -= 1;
		}

		ind = 0;

		while (ind < N) {
			d = (cnt[ind++] += d);
		}

		int s = -1, e = -1, v = 0;
		boolean c = false;

		for (int i = 0; i < N; i++) {
			if (cnt[i] > v) {
				s = rev.get(i);
				e = rev.get(i) + 1;
				c = true;
				v = cnt[i];
			} else if (cnt[i] == v && c) {
				e = rev.get(i) + 1;
			} else if (c) {
				c = false;
			}
		}
		sb.append(v).append("\n");
		sb.append(s).append(" ").append(e).append("\n");
		System.out.println(sb.toString());
	}
}