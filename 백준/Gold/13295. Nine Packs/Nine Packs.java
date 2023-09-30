import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int h, b;
	static int[] hotdogs;
	static int[] buns;
	static int[] hs;
	static int[] bs;
	static final int INF = 1_000_000_007;
	static final int MAX = 100_001;

	static void check() {
		hotdogs = new int[MAX];
		buns = new int[MAX];

		Arrays.fill(hotdogs, INF);
		Arrays.fill(buns, INF);

		hotdogs[0] = 0;
		buns[0] = 0;

		for (int x : hs) {
			for (int j = MAX - 1; j >= x; j--) {
				hotdogs[j] = Math.min(hotdogs[j], hotdogs[j - x] + 1);
			}
		}

		for (int x : bs) {
			for (int j = MAX - 1; j >= x; j--) {
				buns[j] = Math.min(buns[j], buns[j - x] + 1);
			}
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		h = Integer.parseInt(st.nextToken());

		hs = new int[h];

		for (int i = 0; i < h; i++) {
			hs[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		b = Integer.parseInt(st.nextToken());

		bs = new int[b];

		for (int i = 0; i < b; i++) {
			bs[i] = Integer.parseInt(st.nextToken());
		}

		check();

		int MAX = 100_001;

		int answer = INF;

		for (int i = 1; i < MAX; i++) {
			if (hotdogs[i] != INF && buns[i] != INF) {
				answer = Math.min(answer, hotdogs[i] + buns[i]);
			}
		}

		System.out.println(answer == INF ? "impossible" : answer);
	}
}