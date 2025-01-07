import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] original = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			original[i] = Integer.parseInt(st.nextToken());
		}

		int q = Integer.parseInt(br.readLine());

		int l, r;
		int ind;
		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			ind = l;
			for (int i : original) {
				if (l <= i && i <= r) {
					sb.append(ind).append(" ");
					ind++;
				} else {
					sb.append(i).append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb.toString());
	}
}