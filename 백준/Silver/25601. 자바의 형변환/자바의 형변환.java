import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int[] parent;
	static int ind = 0;
	static HashMap<String, Integer> map;

	static int getInd(String s) {
		map.putIfAbsent(s, ind);

		int ret = map.get(s);

		if (ret == ind) {
			ind++;
		}

		return ret;
	}

	static boolean castable(int x, int y) {
		while (x != y && x != -1) {
			x = parent[x];
		}

		return x == y;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		map = new HashMap<>();

		int a, b;
		parent = new int[n];

		Arrays.fill(parent, -1);
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			a = getInd(st.nextToken());
			b = getInd(st.nextToken());

			parent[a] = b;
		}

		st = new StringTokenizer(br.readLine(), " ");

		a = getInd(st.nextToken());
		b = getInd(st.nextToken());

		boolean answer = castable(a, b) || castable(b, a);

		System.out.println(answer ? 1 : 0);
	}
}