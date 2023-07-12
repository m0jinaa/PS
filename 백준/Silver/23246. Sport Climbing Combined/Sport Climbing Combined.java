import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Player implements Comparable<Player> {
		int num;
		int mul, sum;
		int p, q, r;

		public Player(int num, int p, int q, int r) {
			super();
			this.num = num;
			this.p = p;
			this.q = q;
			this.r = r;
			this.mul = p * q * r;
			this.sum = p + q + r;
		}

		@Override
		public int compareTo(Player player) {
			if (this.mul != player.mul) {
				return this.mul - player.mul;
			} else if (this.sum != player.sum) {
				return this.sum - player.sum;
			} else {
				return this.num - player.num;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		Player[] players = new Player[n];
		int p, q, r, num;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			num = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());

			players[i] = new Player(num, p, q, r);
		}

		Arrays.sort(players);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 3; i++) {
			sb.append(players[i].num).append(" ");
		}

		System.out.println(sb.toString());
	}
}