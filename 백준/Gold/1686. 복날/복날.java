import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static long limit;
	static int n, ind;
	static boolean[][] canGo;
	static boolean[] v;

	static class Node {
		int ind;
		int cnt;

		public Node(int ind, int cnt) {
			super();
			this.ind = ind;
			this.cnt = cnt;
		}
	}

	static int bfs() {

		LinkedList<Node> q = new LinkedList<>();

		q.add(new Node(0, 0));
		v[0] = true;

		int answer = -1;

		Node now;

		while (!q.isEmpty()) {
			now = q.poll();
			if (now.ind == 1) {
				answer = now.cnt - 1;
				break;
			}

			for (int i = 0; i < ind; i++) {
				if (now.ind == i || !canGo[now.ind][i] || v[i])
					continue;
				v[i] = true;
				q.add(new Node(i, now.cnt + 1));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		double[][] loc = new double[1002][2];
		ind = 0;

		st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		limit = 1L * V * m * 60;

		String input;
		while ((input = br.readLine()) != null && !input.isEmpty()) {
			st = new StringTokenizer(input, " ");
			loc[ind][0] = Double.parseDouble(st.nextToken());
			loc[ind][1] = Double.parseDouble(st.nextToken());
			ind++;
		}

		canGo = new boolean[ind][ind];
		v = new boolean[ind];
		double d;
		for (int i = 0; i < ind; i++) {
			for (int j = 0; j < i; j++) {
				d = Math.sqrt(Math.pow(loc[i][0] - loc[j][0], 2) + Math.pow(loc[i][1] - loc[j][1], 2));

				if (d >= limit)
					continue;
				canGo[i][j] = true;
				canGo[j][i] = true;
			}
		}

		int answer = bfs();

		if (answer == -1) {
			sb.append("No.");
		} else {
			sb.append("Yes, visiting ").append(answer).append(" other holes.");
		}

		System.out.println(sb.toString());

	}
}