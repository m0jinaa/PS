import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean[] dp;
	static Block[] blocks;
	static final int MAX = 40000;

	static class Block implements Comparable<Block> {
		int h, a, c;

		public Block(int h, int a, int c) {
			super();
			this.h = h;
			this.a = a;
			this.c = c;
		}

		@Override
		public int compareTo(Block b) {
			return this.a - b.a;
		}
	}

	static int getMax() {
		int nx;

		dp[0] = true;

		for (Block b : blocks) {
			for (int i = MAX; i >= 0; i--) {
				if (!dp[i])
					continue;
				nx = i;
				for (int j = 0; j < b.c; j++) {
					nx += b.h;

					if (nx > MAX || nx > b.a)
						break;
					dp[nx] = true;
				}
			}
		}

		int answer = 0;

		for (int i = MAX; i >= 0; i--) {
			if (!dp[i])
				continue;

			answer = i;
			break;
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		blocks = new Block[k];

		int h, a, c;

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			h = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			blocks[i] = new Block(h, a, c);
		}

		Arrays.sort(blocks);

		dp = new boolean[MAX + 1];

		int answer = getMax();

		System.out.println(answer);
	}
}