import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Move implements Comparable<Move> {
		int s, e;

		public Move(int s, int e) {
			super();
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Move move) {
			if (this.s != move.s) {
				return this.s - move.s;
			} else {
				return this.e - move.e;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		LinkedList<Move> moves = new LinkedList<>();

		int n, s, e;

		int last;
		int c, size;
		Move m;
		while (t-- > 0) {
			moves.clear();

			n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());

				if (s < e)
					moves.add(new Move((s + 1) / 2, (e + 1) / 2));
				else {
					moves.add(new Move((e + 1) / 2, (s + 1) / 2));
				}
			}

			Collections.sort(moves);

			last = -1;
			c = 0;

			while (!moves.isEmpty()) {
				c++;
				size = moves.size();
				last = -1;

				while (size-- > 0) {
					m = moves.poll();

					if (m.s <= last) {
						moves.add(m);
					} else {
						last = m.e;
					}
				}
			}

			sb.append(c * 10).append("\n");
		}

		System.out.println(sb.toString());
	}
}