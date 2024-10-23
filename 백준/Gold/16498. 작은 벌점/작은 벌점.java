import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] n;
	static int[][] nums;

	static int getMin(int a, int b, int c) {
		// a와 b 플레이어의 카드로 최대와 최소를 나타낼 수 있게하는 c 플레이어의 카드가 존재하는지 검사

        int min, max;
		int s, e, m;

		int ret = Integer.MAX_VALUE;

		boolean possible;

		for (int x : nums[a]) {
			for (int y : nums[b]) {
				s = 0;
				e = n[c] - 1;

				min = Math.min(x, y);
				max = Math.max(x, y);

				if (max - min >= ret)
					continue;

				possible = false;

				while (s <= e) {
					m = (s + e) / 2;

					if (min <= nums[c][m] && nums[c][m] <= max) {
						possible = true;
						break;
					} else if (min > nums[c][m]) {
						s = m + 1;
					} else {
						e = m - 1;
					}
				}
				if (possible) {
					ret = Math.min(ret, max - min);
				}
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = new int[3];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 3; i++) {
			n[i] = Integer.parseInt(st.nextToken());
		}

		nums = new int[3][];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");

			nums[i] = new int[n[i]];

			for (int j = 0; j < n[i]; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(nums[i]);
		}

		int answer = Integer.MAX_VALUE;

		answer = Math.min(answer, getMin(0, 1, 2));
		answer = Math.min(answer, getMin(0, 2, 1));
		answer = Math.min(answer, getMin(1, 2, 0));

		System.out.println(answer);
	}
}