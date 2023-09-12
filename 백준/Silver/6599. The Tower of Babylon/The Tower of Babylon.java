import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canStack;
	static long[] dp;
	static Block[] blocks;

	static class Block {
		int ind, w, l, h;

		public Block(int ind, int w, int l, int h) {
			super();
			this.ind = ind;
			if (w > l) {
				this.w = l;
				this.l = w;
			} else {
				this.w = w;
				this.l = l;
			}
			this.h = h;
		}

		public void check(Block b) {
			if (b.w < this.w && b.l < this.l)
				canStack[this.ind].add(b.ind);
			else if (this.w < b.w && this.l < b.l)
				canStack[b.ind].add(this.ind);
		}

	}

	static long getMax(int x) {
		if (dp[x] != -1)
			return dp[x];
		long h = 0;

		for (int y : canStack[x]) {
			h = Math.max(h, getMax(y));
		}

		return dp[x] = h + blocks[x].h;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n;
		int x, y, z;
		int t = 0;
		while (true) {
			n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;
			t++;
			blocks = new Block[n * 3];
			dp = new long[n * 3];
			canStack = new ArrayList[n * 3];

			Arrays.fill(dp, -1);
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				z = Integer.parseInt(st.nextToken());

				canStack[i * 3] = new ArrayList<>();
				canStack[i * 3 + 1] = new ArrayList<>();
				canStack[i * 3 + 2] = new ArrayList<>();

				blocks[i * 3] = new Block(i * 3, x, y, z);
				blocks[i * 3 + 1] = new Block(i * 3 + 1, y, z, x);
				blocks[i * 3 + 2] = new Block(i * 3 + 2, z, x, y);
			}

			for (int i = 0; i < 3 * n; i++) {
				for (int j = 1; j < 3 * n; j++) {
					blocks[i].check(blocks[j]);
				}
			}

			long answer = 0;

			for (int i = 0; i < 3 * n; i++) {
				answer = Math.max(answer, getMax(i));
			}

			sb.append("Case ").append(t).append(": maximum height = ").append(answer).append("\n");
		}

		System.out.print(sb.toString());
	}
}