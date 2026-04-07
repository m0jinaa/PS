import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int p = Integer.parseInt(st.nextToken());
		int ns = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		LinkedList<Integer> q = new LinkedList<>();

		int deep = 0;

		int[] parent = new int[p + 1];

		int[][] branches = new int[p + 1][2];

		int n, b1, b2;

		while (ns-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			b1 = Integer.parseInt(st.nextToken());
			b2 = Integer.parseInt(st.nextToken());

			parent[b1] = n;
			parent[b2] = n;

			branches[n][0] = b1;
			branches[n][1] = b2;
		}

		q.add(1);

		int qsize;

		int now;

		end: while (!q.isEmpty()) {
			deep++;

			qsize = q.size();

			while (qsize-- > 0) {
				now = q.poll();

				if (now == t) {
					break end;
				}

				if (branches[now][0] == 0)
					continue;
				q.add(branches[now][0]);
				q.add(branches[now][1]);
			}
		}

		Stack<Integer> track = new Stack<>();

		while (t != 0) {
			track.add(t);
			t = parent[t];
		}

		sb.append(deep).append("\n");

		while (!track.isEmpty()) {
			sb.append(track.pop()).append("\n");
		}

		System.out.print(sb.toString());
	}
}