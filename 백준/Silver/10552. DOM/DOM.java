import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		LinkedList<Integer> q = new LinkedList<>();

		boolean[] v = new boolean[m + 1];

		int[] change = new int[m + 1];

		int a, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (change[b] == 0)
				change[b] = a;
		}

		v[p] = true;
		q.add(p);

		int x;
		int answer = -1;
		int cnt = 0;
		while (!q.isEmpty()) {
			x = q.poll();
			if (change[x] == 0) {
				answer = cnt;
				break;
			}
			if (v[change[x]])
				break;
			v[change[x]] = true;
			cnt++;
			q.add(change[x]);
		}

		System.out.println(answer);
	}
}