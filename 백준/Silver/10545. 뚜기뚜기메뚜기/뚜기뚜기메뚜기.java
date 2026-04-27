import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int[] button = new int[10];

		int x;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= 9; i++) {
			x = Integer.parseInt(st.nextToken());
			button[x] = i;
		}

		char[] message = br.readLine().toCharArray();

		int[] press = new int[] { 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 9 };
		int[] cnt = new int[] { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1, 2, 3, 1, 2, 3, 4 };

		int p, c;

		int prev = 0;

		for (char m : message) {
			p = button[press[m - 'a']];
			c = cnt[m - 'a'];

			if (p == prev) {
				sb.append("#");
			}
			while (c-- > 0) {
				sb.append(p);
			}
			prev = p;
		}

		System.out.println(sb.toString());
	}
}