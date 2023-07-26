import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static ArrayList<Integer>[] canGo;
	static boolean[] v;
	static boolean[] canMeet;

	static boolean dfs(int x) {
		if (canMeet[x])
			return true;
		v[x] = true;
		boolean answer = true;

		int c = 0;

		for (int y : canGo[x]) {
			if (v[y])
				continue;
			answer &= dfs(y);
			c++;
		}

		return c == 0 ? false : answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		v = new boolean[n + 1];
		canMeet = new boolean[n + 1];

		canGo = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			canGo[i] = new ArrayList<>();
		}

		int u, v;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());

			canGo[u].add(v);
		}

		int s = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		while (s-- > 0) {
			x = Integer.parseInt(st.nextToken());
			canMeet[x] = true;
		}
		System.out.println(dfs(1) ? "Yes" : "yes");
	}
}