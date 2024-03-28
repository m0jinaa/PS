import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] line;

	static int check(int ind, int bef) {
		if (ind == n) {
			return bef;
		} else if (line[ind] == 0)
			return -1;

		int next = bef + 1;

		int now = line[ind++];
		while (now < next && ind < n) {
			now = now * 10 + line[ind++];
		}

		if (now == next) {
			return check(ind, next);
		} else {
			return -1;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] row = br.readLine().toCharArray();

		n = row.length;

		line = new int[n];

		for (int i = 0; i < n; i++) {
			line[i] = row[i] - '0';
		}

		int start = 0;

		int ret;

		for (int i = 0; i < 3; i++) {
			start = start * 10 + line[i];

			ret = check(i + 1, start);

			if (ret != -1) {
				sb.append(start).append(" ").append(ret);
				break;
			}
		}

		System.out.println(sb.toString());
	}
}