import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int l = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int n = l * r;

		int[] bit = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i % r == 0) {
				bit[i] += 1;
			}
			if (i % l == 0) {
				bit[i] += 2;
			}
		}

		for (int i = 0; i <= n; i++) {
			if (bit[i] != 0) {
				sb.append(bit[i]);
			}
		}

		System.out.println(sb.toString());
	}
}
