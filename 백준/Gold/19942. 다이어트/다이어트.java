import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static class Ingredient {
		int p, f, s, v, c;

		public Ingredient(int p, int f, int s, int v, int c) {
			super();
			this.p = p;
			this.f = f;
			this.s = s;
			this.v = v;
			this.c = c;
		}
	}

	static final int INF = 1_000_000_007;
	static int n, mp, mf, ms, mv;
	static Ingredient[] ingredients;
	static int minCost = INF;
	static String answer = "-1";

	static void getCombi(int ind, int p, int f, int s, int v, int c, String combi) {

		if (p >= mp && f >= mf && s >= ms && v >= mv) {
			if (c < minCost) {
				minCost = c;
				answer = combi;
			}
		} else if (ind < n) {
			getCombi(ind + 1, p + ingredients[ind].p, f + ingredients[ind].f, s + ingredients[ind].s,
					v + ingredients[ind].v, c + ingredients[ind].c,
					"".equals(combi) ? ("" + (ind + 1)) : (combi + " " + (ind + 1)));
			getCombi(ind + 1, p, f, s, v, c, combi);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 재료 수
		n = Integer.parseInt(br.readLine());

		// 최소 영양
		st = new StringTokenizer(br.readLine(), " ");

		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());

		// 재료별 영양
		ingredients = new Ingredient[n];

		int p, f, s, v, c;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			p = Integer.parseInt(st.nextToken());
			f = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			ingredients[i] = new Ingredient(p, f, s, v, c);
		}

		getCombi(0, 0, 0, 0, 0, 0, "");

		if (minCost == INF) {
			sb.append(-1).append("\n");
		} else {
			sb.append(minCost).append("\n");
			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}