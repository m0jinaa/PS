import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int h;
	static Hoof[] hoofs;

	static class Hoof {
		int ind, x, y;
		ArrayList<Integer> canMove;

		public Hoof(int ind, int x, int y) {
			super();
			this.ind = ind;
			this.x = x;
			this.y = y;
			this.canMove = new ArrayList<>();
		}

		public void check(Hoof h) {
			double dist = Math.sqrt(Math.pow(this.x - h.x, 2) + Math.pow(this.y - h.y, 2));

			if (dist > 1000)
				return;
			this.canMove.add(h.ind);
			h.canMove.add(this.ind);
		}
	}

	static int[] v;
	static LinkedList<Integer> q;

	static int bfs() {
		int answer = -1;
		int x;

		while (!q.isEmpty()) {
			x = q.poll();
			if (hoofs[x].y + 1000 >= h) {
				answer = v[x];
				break;
			}

			for (int y : hoofs[x].canMove) {
				if (v[y] != 0)
					continue;
				v[y] = v[x] + 1;
				q.add(y);
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		h = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		hoofs = new Hoof[f + 1];
		v = new int[f + 1];
		q = new LinkedList<>();

		int x, y;

		for (int i = 1; i <= f; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			if (y <= 1000) {
				q.add(i);
				v[i] = 1;
			}

			hoofs[i] = new Hoof(i, x, y);

			for (int j = 1; j < i; j++) {
				hoofs[i].check(hoofs[j]);
			}
		}

		int answer = bfs();

		System.out.println(answer);
	}
}