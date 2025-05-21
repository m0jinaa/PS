import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] cnt;

	static boolean canWin(int x, int y, int z) {
		for (int i = 100; i > 0; i--) {
			if (cnt[i] != 1)
				continue;

			return (x == i || y == i || z == i);
		}

		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		cnt = new int[101];

		int x;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				x = Integer.parseInt(st.nextToken());
				cnt[x]++;
			}
		}

		int answer = 0;

		for (int i = 1; i <= 100; i++) {
			for (int j = i + 1; j <= 100; j++) {
				for (int k = j + 1; k <= 100; k++) {
					cnt[i]++;
					cnt[j]++;
					cnt[k]++;
					if (canWin(i, j, k))
						answer++;
					cnt[i]--;
					cnt[j]--;
					cnt[k]--;
				}
			}
		}

		System.out.println(answer);
	}
}