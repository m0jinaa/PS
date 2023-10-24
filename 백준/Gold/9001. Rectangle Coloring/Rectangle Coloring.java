import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Rectangle {
		int ind, lx, ly, rx, ry;
		ArrayList<Integer> intersectWith;

		public Rectangle(int ind, int lx, int ly, int rx, int ry) {
			super();
			this.ind = ind;
			this.lx = lx;
			this.ly = ly;
			this.rx = rx;
			this.ry = ry;
			this.intersectWith = new ArrayList<>();
		}

		public void intersect(Rectangle r) {
			// 점이 사각형 내부 또는 경계에 위치하는 경우
			if (contains(r.lx, r.ly) || contains(r.rx, r.ry) || contains(r.rx, r.ly) || contains(r.lx, r.ry)
					|| r.contains(this.lx, this.ly) || r.contains(this.rx, this.ly) || r.contains(this.lx, this.ry)
					|| r.contains(this.rx, this.ry)) {
				this.intersectWith.add(r.ind);
				r.intersectWith.add(this.ind);

			} else if ((this.lx < r.lx && r.rx < this.rx && r.ly < this.ly && this.ry < r.ry)
					|| (r.lx < this.lx && this.rx < r.rx && this.ly < r.ly && r.ry < this.ry)) {// 점이 내부 또는 경계에 존재하지는
				this.intersectWith.add(r.ind);
				r.intersectWith.add(this.ind);
			}

		}

		private boolean contains(int x, int y) {
			if (this.lx <= x && x <= this.rx && this.ly <= y && y <= this.ry)
				return true;
			return false;
		}
	}

	static int n;
	static Rectangle[] recs;
	static boolean[] v;
	static LinkedList<Integer> q;

	static void bfs(int x) {
		v[x] = true;
		q.clear();
		q.add(x);

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			for (int y : recs[now].intersectWith) {
				if (v[y])
					continue;
				v[y] = true;
				q.add(y);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());

		int lx, ly, rx, ry, cnt;

		q = new LinkedList<>();

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine().trim());

			recs = new Rectangle[n];
			v = new boolean[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				lx = Integer.parseInt(st.nextToken());
				ly = Integer.parseInt(st.nextToken());
				rx = Integer.parseInt(st.nextToken());
				ry = Integer.parseInt(st.nextToken());

				recs[i] = new Rectangle(i, lx, ly, rx, ry);

				for (int j = 0; j < i; j++) {
					recs[i].intersect(recs[j]);
				}
			}

			cnt = 0;

			for (int i = 0; i < n; i++) {
				if (!v[i]) {
					bfs(i);
					cnt++;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}