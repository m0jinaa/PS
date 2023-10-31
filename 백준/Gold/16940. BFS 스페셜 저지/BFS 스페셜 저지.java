import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] canGo;
	static boolean[] v;
	static int ind;
	static int[] order;

	static boolean check() {
		if (order[0] != 1)
			return false;

		LinkedList<Integer> q = new LinkedList<>();

		q.add(1);

		v[1] = true;

		ind = 1;

		int x;

		int cnt;
		boolean[] child = new boolean[n + 1];

		boolean correct = true;

		end: while (!q.isEmpty()) {
			x = q.poll();
			cnt = 0;

			for (int y : canGo[x]) {
				if (v[y])
					continue;
				cnt++;
				child[y] = true;
			}

			while (cnt-- > 0) {
				if (child[order[ind]]) {
					q.add(order[ind]);
					v[order[ind]] = true;

					child[order[ind]] = false;
					ind++;
				} else {
					correct = false;
					break end;
				}
			}
		}

		return correct;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		int a, b;

		canGo = new ArrayList[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			canGo[a].add(b);
			canGo[b].add(a);
		}

		order = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}
		ind = 1;

		System.out.println(check() ? 1 : 0);

	}
}