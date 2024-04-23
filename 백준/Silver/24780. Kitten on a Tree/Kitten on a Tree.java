import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] canGo;
	static int[] bef;

	static void bfs(int s, int e) {
		LinkedList<Integer> q = new LinkedList<>();

		q.add(s);
		bef[s] = 0;

		int now;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now == e) {
				break;
			}

			for (int next : canGo[now]) {
				if (bef[next] != -1)
					continue;
				bef[next] = now;
				q.add(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int kitten = Integer.parseInt(br.readLine());

		boolean[] in = new boolean[101];
		boolean[] out = new boolean[101];
		bef = new int[101];
		canGo = new ArrayList[101];

		Arrays.fill(bef, -1);

		int e, s;

		for (int i = 1; i <= 100; i++) {
			canGo[i] = new ArrayList<>();
		}

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");

			e = Integer.parseInt(st.nextToken());

			if (e == -1)
				break;

			in[e] = true;

			while (st.hasMoreTokens()) {
				s = Integer.parseInt(st.nextToken());
				canGo[s].add(e);
				canGo[e].add(s);
				out[s] = true;
			}
		}

		int start = 0;

		for (int i = 1; i <= 100; i++) {
			if (in[i] && !out[i]) {
				start = i;
				break;
			}
		}

		bfs(start, kitten);

		while (kitten != 0) {
			sb.append(kitten);
			kitten = bef[kitten];
			sb.append(kitten == 0 ? "\n" : " ");
		}

		System.out.println(sb.toString());
	}
}