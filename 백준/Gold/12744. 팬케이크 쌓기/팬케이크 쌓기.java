import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static String targetO, targetF;
	static HashSet<String> set;

	static class Cake {
		int n;
		String order;
		String face;
		int cnt;

		public Cake(int n, String order, String face, int cnt) {
			super();
			this.n = n;
			this.order = order;
			this.face = face;
			this.cnt = cnt;
		}

		public Cake(int n) {
			super();
			this.n = n;
			this.order = "";
			this.face = "";
			this.cnt = 0;
		}

		public Cake flip(int x) {
			Cake ret = new Cake(n);
			char[] t1 = new char[n];
			char[] t2 = new char[n];
			char[] o = this.order.toCharArray();
			char[] f = this.face.toCharArray();
			for (int i = 0; i <= x / 2; i++) {
				t1[i] = o[x - i];
				t1[x - i] = o[i];

				t2[i] = f[x - i] == '1' ? '0' : '1';
				t2[x - i] = f[i] == '1' ? '0' : '1';
			}
			for (int i = x + 1; i < n; i++) {
				t1[i] = o[i];
				t2[i] = f[i];
			}

			ret.order = String.valueOf(t1);
			ret.face = String.valueOf(t2);
			ret.cnt = this.cnt + 1;
			return ret;
		}

		public boolean check() {
			return targetO.equals(this.order) && targetF.equals(this.face);
		}

		@Override
		public String toString() {
			return this.order + this.face;
		}
	}

	public static int bfs(String o, String f) {
		LinkedList<Cake> q = new LinkedList<>();
		set = new HashSet<>();

		Cake start = new Cake(n, o, f, 0);
		q.add(start);
		set.add(start.toString());

		int answer = 0;

		Cake now;
		Cake next;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now.check()) {
				answer = now.cnt;
				break;
			}

			for (int i = 0; i < n; i++) {
				next = now.flip(i);
				if (set.contains(next.toString()))
					continue;
				q.add(next);
				set.add(next.toString());
			}
		}
		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		targetO = "";
		targetF = "";
		String o = "";
		String f = "";

		for (int i = 0; i < n; i++) {
			targetO += (i + 1);
			targetF += 1;

			st = new StringTokenizer(br.readLine(), " ");
			o += st.nextToken();
			f += ("+".equals(st.nextToken()) ? "1" : "0");
		}

		int answer = bfs(o, f);

		System.out.println(answer);
	}
}