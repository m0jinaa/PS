import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] nums;
	static char[] mine;
	static int[] dx = new int[] { -1, 0, 1 };

	static boolean inRange(int x) {
		if (x < 0 || x >= n)
			return false;
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		char[] row;
		int cnt;
		int nx;
		boolean pos;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			row = br.readLine().toCharArray();
			mine = br.readLine().toCharArray();
			cnt = 0;
			nums = new int[n];

			for (int i = 0; i < n; i++) {
				nums[i] = row[i] - '0';
			}

			for (int i = 0; i < n; i++) {
				if (mine[i] != '*')
					continue;
				cnt++;

				for (int j = 0; j < 3; j++) {
					nx = i + dx[j];
					if (!inRange(nx))
						continue;
					nums[nx]--;
				}
			}

			for (int i = 0; i < n; i++) {
				if (mine[i] != '#')
					continue;
				pos = true;
				for (int j = 0; j < 3; j++) {
					nx = i + dx[j];
					if (!inRange(nx))
						continue;
					if (nums[nx] < 1) {
						pos = false;
						break;
					}
				}

				if (pos) {
					for (int j = 0; j < 3; j++) {
						nx = i + dx[j];
						if (!inRange(nx))
							continue;

						nums[nx]--;
					}
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.print(sb.toString());

	}
}