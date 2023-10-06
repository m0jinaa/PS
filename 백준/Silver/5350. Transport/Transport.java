import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] dp;
	static Item[] items;
	static int weight;

	static class Item {
		int w, v;

		public Item(int w, int v) {
			super();
			this.w = w;
			this.v = v;
		}
	}

	static long getMax() {
		for (Item item : items) {
			for (int i = weight; i >= item.w; i--) {
				dp[i] = Math.max(dp[i], dp[i - item.w] + item.v);
			}
		}

		return dp[weight];
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
        
		int n, w, v;
        
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
            
			n = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());

			dp = new long[weight + 1];

			items = new Item[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
                
				w = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());

				items[i] = new Item(w, v);
			}

			sb.append(getMax()).append("\n");
		}

		System.out.print(sb.toString());
	}
}