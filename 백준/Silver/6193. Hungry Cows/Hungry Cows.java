import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] cow;
	static int ind;

	static void findLoc(int x) {
		if (cow[ind] < x) {
			cow[++ind] = x;
		} else {
			int s = 1;
			int e = ind;

			int m;

			int loc = ind + 1;

			while (s <= e) {
				m = (s + e) / 2;
				if (cow[m] >= x) {
					loc = m;
					e = m - 1;
				} else
					s = m + 1;
			}

			cow[loc] = x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		cow = new int[n + 1];
		ind = 0;

		int x;

		while (n > 0) {

			st = new StringTokenizer(br.readLine(), " ");

			while (st.hasMoreTokens() && n-- > 0) {
				x = Integer.parseInt(st.nextToken());

				findLoc(x);
			}
		}

		System.out.println(ind);
	}
}