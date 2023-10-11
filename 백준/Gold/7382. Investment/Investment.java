import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int money, year;
	static int MAX;
	static int[] dp;
	static Bond[] bonds;

	static class Bond {
		int v, interest;

		public Bond(int v, int interest) {
			super();
			this.v = v;
			this.interest = interest;
		}
	}

	static void getMax() {
		MAX = (int) (Math.pow(1.1, year - 1) * money) / 1000;
		dp = new int[MAX + 1];
	}

	static void fill() {
		for (Bond b : bonds) {
			for (int i = b.v; i <= MAX; i++) {
				dp[i] = Math.max(dp[i], dp[i - b.v] + b.interest);
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int d, v, interest;
		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			money = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());

			getMax();

			d = Integer.parseInt(br.readLine());

			bonds = new Bond[d];

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				v = Integer.parseInt(st.nextToken()) / 1000;
				interest = Integer.parseInt(st.nextToken());

				bonds[i] = new Bond(v, interest);
			}

			fill();

			while (year-- > 0) {
				money += dp[money / 1000];
			}

			sb.append(money).append("\n");

		}
		System.out.println(sb.toString());
	}
}