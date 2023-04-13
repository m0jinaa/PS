import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static int[] rat;
	static boolean[] done;

	static class Loc {
		double x, y;

		public Loc(double x, double y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static double dist(Loc a, Loc b) {
		return Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2);
	}

	static boolean dfs(int x) {
		for (int i : canGo[x]) {
			if (done[i])
				continue;
			done[i] = true;
			if (rat[i] == 0 || dfs(rat[i])) {
				rat[i] = x;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		rat = new int[m+1];
		canGo = new ArrayList[n+1];
		done = new boolean[m+1];

		Loc[] rats = new Loc[n+1];
		Loc[] caves = new Loc[m+1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rats[i] = new Loc(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			caves[i] = new Loc(Double.parseDouble(st.nextToken()), Double.parseDouble(st.nextToken()));
		}

		// 시간이 s이하인 땅굴만 canGo에 넣기
		double d = Math.pow(s * v, 2);
		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<Integer>();
			for (int j = 1; j <= m; j++) {
				if (dist(rats[i], caves[j]) <= d) {
					canGo[i].add(j);
				}
			}
		}

		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			Arrays.fill(done, false);
			if (dfs(i)) {
				cnt++;
			}
		}

		System.out.println(n-cnt);
	}
}