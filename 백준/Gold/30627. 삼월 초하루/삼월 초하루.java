import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static class Water {
		int ind, temp;

		public Water(int ind, int temp) {
			super();
			this.ind = ind;
			this.temp = temp;
		}

		public Water move() {
			return new Water(ind, temp - 1);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Water other = (Water) obj;
			if (ind != other.ind)
				return false;
			if (temp != other.temp)
				return false;
			return true;
		}
	}

	static class TeaPot {
		Water x, y, z;
		int e;
		String log;

		public TeaPot(Water x, Water y, Water z, int e, String log) {
			super();
			this.x = x; // 1번숙우
			this.y = y; // 2번숙우
			this.z = z; // 3번숙우
			this.e = e; // 비어있는 숙우번호
			this.log = log;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] target = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i < n; i++) {
			target[i] = Integer.parseInt(st.nextToken()) / 5;
		}

		st = new StringTokenizer(br.readLine(), " ");

		int tt;
		tt = Integer.parseInt(st.nextToken());
		Water ex = new Water(tt, target[tt]);

		tt = Integer.parseInt(st.nextToken());
		Water ey = new Water(tt, target[tt]);

		tt = Integer.parseInt(st.nextToken());
		Water ez = new Water(tt, target[tt]);

		boolean[][][][][][] v = new boolean[3][21][3][21][3][21];

		LinkedList<TeaPot> q = new LinkedList<>();
		q.add(new TeaPot(new Water(1, 20), new Water(2, 20), new Water(0, 0), 3, ""));

		TeaPot t;
		Water tem = new Water(0, 0);
		Water nx, ny, nz;
		String nlog;

		String answer = "-1";

		while (!q.isEmpty()) {
			t = q.poll();

			if (t.x.equals(ex) && t.y.equals(ey) && t.z.equals(ez)) {
				answer = t.log;
				break;
			}

			for (int i = 1; i <= 3; i++) {
				if (i == t.e)
					continue;

				if (t.x.temp != 0 && i == 1 && t.e == 2) {
					ny = t.x.move();
					nx = tem;
					nz = t.z;
					nlog = t.log + "1 2\n";
				} else if (t.x.temp != 0 && i == 1 && t.e == 3) {
					nz = t.x.move();
					nx = tem;
					ny = t.y;
					nlog = t.log + "1 3\n";
				} else if (t.y.temp != 0 && i == 2 && t.e == 1) {
					nx = t.y.move();
					ny = tem;
					nz = t.z;
					nlog = t.log + "2 1\n";
				} else if (t.y.temp != 0 && i == 2 && t.e == 3) {
					nz = t.y.move();
					ny = tem;
					nx = t.x;
					nlog = t.log + "2 3\n";
				} else if (t.z.temp != 0 && i == 3 && t.e == 1) {
					nx = t.z.move();
					nz = tem;
					ny = t.y;
					nlog = t.log + "3 1\n";
				} else if (t.z.temp != 0 && i == 3 && t.e == 2) {
					ny = t.z.move();
					nz = tem;
					nx = t.x;
					nlog = t.log + "3 2\n";
				} else {
					continue;
				}

				if (v[nx.ind][nx.temp][ny.ind][ny.temp][nz.ind][nz.temp])
					continue;

				v[nx.ind][nx.temp][ny.ind][ny.temp][nz.ind][nz.temp] = true;

				q.add(new TeaPot(nx, ny, nz, i, nlog));
			}
		}
		if(!"-1".equals(answer))
			System.out.println(40 - target[0] - target[1] - target[2]);
		System.out.print(answer);
	}
}