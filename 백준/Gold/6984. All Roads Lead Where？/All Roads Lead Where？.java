import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int ind = 1;
	static char[] letter;
	static HashMap<String, Integer> map;
	static boolean[] v;
	static ArrayList<Integer>[] connectTo;
	static LinkedList<City> q;

	static class City {
		int ind;
		String way;

		public City(int ind) {
			super();
			this.ind = ind;
			this.way = "";
		}

		public City(int ind, String way) {
			super();
			this.ind = ind;
			this.way = way;
		}
	}

	static int getInd(String name) {
		map.putIfAbsent(name, ind++);
		int ret = map.get(name);

		letter[ret] = name.charAt(0);

		return ret;
	}

	static String bfs(int start, int end) {

		String answer = "";

		City now;

		q.clear();
		q.add(new City(start, "" + letter[start]));
		v[start] = true;

		while (!q.isEmpty()) {
			now = q.poll();

			if (now.ind == end) {
				answer = now.way;
				break;
			}

			for (int y : connectTo[now.ind]) {
				if (v[y])
					continue;
				v[y] = true;
				q.add(new City(y, now.way + letter[y]));
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int max = 2 * m;

		map = new HashMap<>();

		connectTo = new ArrayList[max + 1];
		v = new boolean[max + 1];
		letter = new char[max + 1];
		q = new LinkedList<>();

		for (int i = 1; i <= max; i++) {
			connectTo[i] = new ArrayList<>();
		}

		int a, b;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = getInd(st.nextToken());
			b = getInd(st.nextToken());

			connectTo[a].add(b);
			connectTo[b].add(a);
		}

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = getInd(st.nextToken());
			b = getInd(st.nextToken());

			Arrays.fill(v, false);

			sb.append(bfs(a, b)).append("\n");
		}

		System.out.println(sb.toString());
	}
}