import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static ArrayList<Integer>[] canGo;
	static boolean[] v;

	static int bfs() {
		LinkedList<Integer> q = new LinkedList<>();

		v[1] = true;
		q.add(1);

		int x;
		int t = 0;
		int answer = -1;
		int qsize;

		end: while (!q.isEmpty()) {
			qsize = q.size();
			while (qsize-- > 0) {
				x = q.poll();

				if (x == n) {
					answer = t;
					break end;
				}

				for (int y : canGo[x]) {
					if (v[y])
						continue;
					v[y] = true;
					q.add(y);
				}
			}
			t++;
		}

		return answer;

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		canGo = new ArrayList[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int x, y;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			canGo[x].add(y);
		}

		int answer = bfs();

		System.out.println(answer);
	}
}