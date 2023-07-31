import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] hates;
	static boolean[] v;
	static LinkedList<Integer> q;
	static boolean[] team1;

	static int makeTeam(int x) {
		v[x] = true;
		q.clear();
		q.add(x);

		int qsize;
		int time = 0;
		int now;
		int t1 = 0;
		while (!q.isEmpty()) {
			qsize = q.size();

			while (qsize-- > 0) {
				now = q.poll();
				if (time % 2 == 0) {
					team1[now] = true;
					t1++;
				}

				for (int y : hates[now]) {
					if (v[y])
						continue;
					v[y] = true;
					q.add(y);
				}
			}
			time++;
		}

		return t1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		hates = new ArrayList[n + 1];
		v = new boolean[n + 1];
		team1 = new boolean[n + 1];

		q = new LinkedList<>();

		int t1size = 0;
		int s, x;
		for (int i = 1; i <= n; i++) {
			hates[i] = new ArrayList<>();
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			s = Integer.parseInt(st.nextToken());
			while (s-- > 0) {
				x = Integer.parseInt(st.nextToken());
				hates[i].add(x);
				hates[x].add(i);
			}
		}

		for (int i = 1; i <= n; i++) {
			if (v[i])
				continue;
			t1size += makeTeam(i);
		}

		sb.append(t1size).append("\n");

		for (int i = 1; i <= n; i++) {
			if (team1[i])
				sb.append(i).append(" ");
		}
		sb.append("\n");

		sb.append(n - t1size).append("\n");

		for (int i = 1; i <= n; i++) {
			if (!team1[i])
				sb.append(i).append(" ");
		}

		System.out.println(sb.toString());
	}
}