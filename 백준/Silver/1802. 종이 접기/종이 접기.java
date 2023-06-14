import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		char[] paper;
		int m, l, r;
		boolean same = true;
		while (t-- > 0) {
			paper = br.readLine().toCharArray();

			m = paper.length / 2;
			while (m != 0) {
				same = true;
				l = m - 1;
				r = m + 1;
				while (l >= 0) {
					if (paper[l] == paper[r]) {
						same = false;
						break;
					}
					l--;
					r++;
				}
				if (!same) {
					break;
				}
				m >>= 1;
			}

			sb.append(same ? "YES\n" : "NO\n");
		}

		System.out.print(sb.toString());
	}
}