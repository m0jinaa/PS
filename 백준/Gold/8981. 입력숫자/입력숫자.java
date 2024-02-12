import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int x, t = 0;

		int n = Integer.parseInt(br.readLine());

		int[] nums = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] input = new int[n];

		t = 0;
		x = 0;
		int i = 0;
		while (i < n) {
			x = (x + t) % n;

			while (input[x] != 0) {
				x = (x + 1) % n;
			}

			input[x] = nums[i];
			t = nums[i];
			i++;
		}

		sb.append(n).append("\n");

		for (int y : input) {
			sb.append(y).append(" ");
		}

		System.out.println(sb.toString());
	}
}