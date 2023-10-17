import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[] tree;

	static class Album implements Comparable<Album> {
		int d, s;

		public Album(int d, int s) {
			super();
			this.d = d;
			this.s = s;
		}

		@Override
		public int compareTo(Album album) {
			if (this.d == album.d)
				return this.s - album.s;
			else
				return this.d - album.d;
		}

	}

	static void update(int x) {

		while (x <= n) {
			tree[x]++;
			x += (x & (-x));
		}
	}

	static int get(int x) {
		int ret = 0;

		while (x > 0) {
			ret += tree[x];
			x -= (x & (-x));
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sbb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		int x, cnt, temp;
		Album[] albums;

		while (tc-- > 0) {

			n = Integer.parseInt(br.readLine());
			tree = new int[n + 1];
			cnt = 0;
			albums = new Album[n];

			for (int i = 0; i < n; i++) {
				x = Integer.parseInt(br.readLine());

				albums[i] = new Album(x, i + 1);
			}

			Arrays.sort(albums);

			for (int i = 0; i < n; i++) {
				temp = i - get(albums[i].s);

				update(albums[i].s);

				if (temp == 0)
					continue;
				cnt++;

				sbb.append(albums[i].d).append("\n");
			}

			sb.append(cnt).append("\n").append(sbb.toString());
			sbb.setLength(0);
		}
		System.out.print(sb.toString());

	}
}