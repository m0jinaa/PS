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
	static boolean[] used;

	static void getCombi(int ind, int p, int f, int s, int v, int c) {
		// 최소영양조건 체크
		if (p >= mp && f >= mf && s >= ms && v >= mv) {
			// 비용 비교
			if (c < minCost) {
				minCost = c;

				StringBuilder sbb = new StringBuilder();

				for (int i = 0; i < n; i++) {
					if (used[i]) {
						if (sbb.length() != 0) {
							sbb.append(" ");
						}
						sbb.append(i + 1);
					}
				}
				answer = sbb.toString();
			}
		} else if (ind < n) {
			// ind+1번 재료 사용
			used[ind] = true;
			getCombi(ind + 1, p + ingredients[ind].p, f + ingredients[ind].f, s + ingredients[ind].s,
					v + ingredients[ind].v, c + ingredients[ind].c);
			used[ind] = false;

			// ind+1번 재료 미사용
			getCombi(ind + 1, p, f, s, v, c);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

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

		// 재료별 사용여부 체크용
		used = new boolean[n];

		getCombi(0, 0, 0, 0, 0, 0);

		// 조건 미충족 체크
		if (minCost == INF) {
			sb.append(-1).append("\n");
		} else {
			sb.append(minCost).append("\n");
			sb.append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}