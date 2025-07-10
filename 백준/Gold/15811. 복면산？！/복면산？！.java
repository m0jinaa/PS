import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n = 18, a, b, c;
	static int ind = 0;
	static int[] indA, indB, indC, v;
	static boolean[] occupied;
	static Map<Character, Integer> indexMaker;

	static int getInd(char x) {
		if (!indexMaker.containsKey(x)) {
			indexMaker.put(x, ind++);
		}

		return indexMaker.get(x);
	}

	static boolean check() {
		int up = 0;

		for (int i = 0; i < n; i++) {
			if ((v[indA[i]] + v[indB[i]] + up) % 10 != v[indC[i]])
				return false;
			up = (v[indA[i]] + v[indB[i]] + up) / 10;
		}

		return true;
	}

	static boolean setValue(int x) {
		if (x == ind) {
			return check();
		}

		for (int i = 0; i < 10; i++) {
			if (occupied[i])
				continue;
			occupied[i] = true;
			v[x] = i;

			if (setValue(x + 1))
				return true;

			occupied[i] = false;
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		indexMaker = new HashMap<>();
		occupied = new boolean[10];

		indA = new int[n];
		indB = new int[n];
		indC = new int[n];

		Arrays.fill(indA, n);
		Arrays.fill(indB, n);
		Arrays.fill(indC, n);

		v = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		char[] word;

		word = st.nextToken().toCharArray();

		a = word.length;

		for (int i = 0; i < a; i++) {
			indA[a - 1 - i] = getInd(word[i]);
		}

		word = st.nextToken().toCharArray();

		b = word.length;

		for (int i = 0; i < b; i++) {
			indB[b - 1 - i] = getInd(word[i]);
		}

		word = st.nextToken().toCharArray();

		c = word.length;

		for (int i = 0; i < c; i++) {
			indC[c - 1 - i] = getInd(word[i]);
		}

		if (setValue(0))
			sb.append("YES");
		else {
			sb.append("NO");
		}

		System.out.println(sb.toString());
	}
}