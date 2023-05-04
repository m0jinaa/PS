import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canUse;
	static boolean[] used;
	static int[] connected;

	static boolean dfs(int x) {

		for (int y : canUse[x]) {
			if (used[y])
				continue;
			used[y] = true;
			if (connected[y] == 0 || dfs(connected[y])) {
				connected[y] = x;
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] shirt = new int[n + 1];

		canUse = new ArrayList[n + 1];

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			canUse[i] = new ArrayList<>();
			shirt[i] = Integer.parseInt(br.readLine());
		}

		int[] collar = new int[m + 1];

		for (int i = 1; i <= m; i++) {
			collar[i] = Integer.parseInt(br.readLine());
		}

		int l1, r1, l2, r2;
		
		for (int i = 1; i <= n; i++) {
			l1 = (int) Math.ceil(1.0 * shirt[i] / 2);
			r1 = (shirt[i] * 3) / 4;
			l2 = shirt[i];
			r2 = (shirt[i] * 5) / 4;

			for (int j = 1; j <= m; j++) {
				if ((l1 <= collar[j] && collar[j] <= r1) || (l2 <= collar[j] && collar[j] <= r2))
					canUse[i].add(j);
			}
		}

		int answer = 0;

		used = new boolean[m + 1];

		connected = new int[m + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(used, false);
			if (dfs(i)) {
				answer++;
			}
		}

		System.out.println(answer);
	}
}