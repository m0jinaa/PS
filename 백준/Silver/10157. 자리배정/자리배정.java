import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine());

		if (k > r * c) {
			sb.append(0);
		} else {
			int round = r * 2 + c * 2 - 4;

			int up = r;
			int down = 1;
			int left = 1;
			int right = c;

			while (round < k) {
				k -= round;
				round -= 8;
				up--;
				down++;
				left++;
				right--;
				c -= 2;
				r -= 2;
			}

			int x = -1;
			int y = -1;

			if (k <= r) {
				y = left;
				x = down + k - 1;
			} else if (k <= r + c - 1) {
				x = up;
				y = left + k - r;
			} else if (k <= 2 * r + c - 2) {
				y = right;
				x = down + round - k - c + 2;
			} else {
				x = down;
				y = left + round - k + 1;
			}

			sb.append(y).append(" ").append(x);

		}

        System.out.println(sb.toString());
	}
}