import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int n;

	static void update(int x) {
		while (x <= n) {
			tree[x]++;
			x += (x & (-x));
		}
	}

	static int get(int x) {
		int ret = 0;
		while (x > 0) {
			ret += tree[x];
			x -= (x & (-x));
		}
		return ret;
	}

	static class Card implements Comparable<Card> {
		int r, b;

		public Card(int r, int b) {
			super();
			this.r = r;
			this.b = b;
		}

		@Override
		public int compareTo(Card c) {
			if (this.r != c.r) {
				return this.r - c.r;
			} else {
				return this.b - c.b;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> red = new HashMap<>();
		HashMap<Integer, Integer> blue = new HashMap<>();

		int[] bs = new int[n];

		tree = new int[n + 1];

		Card[] cards = new Card[n];

		int r, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			r = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			bs[i] = b;

			cards[i] = new Card(r, b);
		}

		Arrays.sort(bs);

		int ind = 1;

		for (int y : bs) {
			if (blue.containsKey(y))
				continue;
			blue.put(y, ind++);
		}

		long answer = 0;
		
		Arrays.sort(cards);
		
		int x;
		for (int i = 0; i < n; i++) {
			x = blue.get(cards[i].b);
			answer += i - get(x);
			update(x);
		}

		System.out.println(answer);
	}
}