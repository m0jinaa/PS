import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static char[] map;
	static int[] v;

	static int move(int x, int c) {
		while (true) {
			if (v[x] == 0)
				v[x] = c;
			else if (v[x] != c) {
				return 0;
			} else {
				return 1;
			}
			if (map[x] == 'E') {
				x++;
			} else {
				x--;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		map = br.readLine().toCharArray();
		v = new int[n];

		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (v[i] != 0)
				continue;
			answer += move(i, i + 1);
		}

		System.out.println(answer);
	}
}