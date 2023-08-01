import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] gives;
	static boolean[] v;
	static boolean[] caught;
	static LinkedList<Integer> q;

	static int bfs() {
		int x;
		int answer = 0;

		while (!q.isEmpty()) {
			x = q.poll();
			for (int y : gives[x]) {
				if (caught[y])
					continue;
				v[y] = true;
				answer++;
				q.add(y);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean[] output = new boolean[n];
		boolean[] input = new boolean[n];
		caught = new boolean[n];
		v = new boolean[n];

		gives = new ArrayList[n];

		for (int i = 0; i < n; i++) {
			gives[i] = new ArrayList<>();
		}
		int x, y;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			x = st.nextToken().charAt(0) - 'A';
			y = st.nextToken().charAt(0) - 'A';

			gives[x].add(y);
			output[x] = true;
			input[y] = true;
		}

		st = new StringTokenizer(br.readLine(), " ");

		int k = Integer.parseInt(st.nextToken());
		while (k-- > 0) {
			x = st.nextToken().charAt(0) - 'A';
			caught[x] = true;
		}
		q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			if (!caught[i] && output[i] && !input[i]) {
				q.add(i);
				v[i] = true;
			}
		}

		System.out.println(bfs());
	}
}