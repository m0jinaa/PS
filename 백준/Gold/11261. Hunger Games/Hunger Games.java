import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, w;
	static int[] dp;
	static Weapon[] weapons;

	static class Weapon {
		int w, p;

		public Weapon(int w, int p) {
			this.w = w;
			this.p = p;
		}
	}

	static int getMax() {

		for (Weapon weapon : weapons) {
			for (int i = w; i >= weapon.w; i--) {
				dp[i] = Math.max(dp[i], dp[i - weapon.w] + weapon.p);
			}
		}

		return dp[w];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		int weight, preference;

		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			w = Integer.parseInt(br.readLine());

			dp = new int[w + 1];

			weapons = new Weapon[n];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				weight = Integer.parseInt(st.nextToken());
				weapons[i] = new Weapon(weight, 0);
			}

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < n; i++) {
				preference = Integer.parseInt(st.nextToken());
				weapons[i].p = preference;
			}

			sb.append(getMax()).append("\n");
		}

		System.out.print(sb.toString());
	}
}