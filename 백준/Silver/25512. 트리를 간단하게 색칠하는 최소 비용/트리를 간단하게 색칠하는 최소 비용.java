import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static long[] total;
	static int[][] price;

	static void dfs(int x, int t) {
		for (int i = 0; i < 2; i++) {
			total[(i + t) % 2] += price[x][i];
		}
		for (int y : canGo[x]) {
			dfs(y, 1 - t);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int p, c;

		canGo = new ArrayList[n];
		total = new long[2];
		price = new int[n][2];

		for (int i = 0; i < n; i++) {
			canGo[i] = new ArrayList<>();
		}

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			canGo[p].add(c);
		}

		int w, b;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			price[i][0] = w;
			price[i][1] = b;
		}

		dfs(0, 0);

		System.out.println(Math.min(total[0], total[1]));

	}
}