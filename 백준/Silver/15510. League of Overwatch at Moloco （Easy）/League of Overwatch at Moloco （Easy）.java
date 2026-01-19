import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] team = new int[n + 1];

		boolean possible = true;

		int f, s;

		ArrayList<Integer>[] againstTo = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			againstTo[i] = new ArrayList<>();
			team[i] = -1;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			f = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());

			againstTo[f].add(s);
			againstTo[s].add(f);
		}

		LinkedList<Integer> q = new LinkedList<>();

		int x;

		end: for (int i = 1; i <= n; i++) {
			if (team[i] != -1)
				continue;

			team[i] = 0;

			q.add(i);

			while (!q.isEmpty()) {
				x = q.poll();

				for (int y : againstTo[x]) {
					if (team[y] == team[x]) {
						possible = false;
						break end;
					} else if (team[y] != -1)
						continue;
					team[y] = 1 - team[x];
					q.add(y);
				}
			}
		}

		System.out.println(possible ? "POSSIBLE" : "IMPOSSIBLE");
	}
}