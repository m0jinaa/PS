import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int x;

		int a, b;

		int[] nums = new int[1 << 20];

		while (st.hasMoreTokens()) {
			x = Integer.parseInt(st.nextToken());
			a = x / 32;
			b = x % 32;

			if ((nums[a] & (1 << b)) != 0)
				continue;

			nums[a] |= (1 << b);
			sb.append(x).append(" ");
		}

		System.out.println(sb.toString());
	}
}