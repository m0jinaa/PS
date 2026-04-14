import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int h, w;

	static char[][] map;

	static long calculate(int s, int e, int r) {
		long left, right;

		long ret = -1;
		for (int i = s; i <= e; i++) {
			if (map[r][i] == '.')
				continue;

			if ('0' <= map[r][i] && map[r][i] <= '9') {
				ret = map[r][i] - '0';
				break;
			} else {
				left = calculate(s, i - 1, r + 1);
				right = calculate(i + 1, e, r + 1);

				if (map[r][i] == '+') {
					ret = left + right;
				} else if (map[r][i] == '-') {
					ret = left - right;
				} else {
					ret = left * right;
				}

				break;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());

		map = new char[h][];

		for (int i = 0; i < h; i++) {
			map[i] = br.readLine().toCharArray();
		}

		long answer = calculate(0, w - 1, 0);

		System.out.println(answer);
	}
}