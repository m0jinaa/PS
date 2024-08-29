import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int t;

		int x;

		int[] count = new int[100001];

		boolean zero = false;

		int l;

		for (int i = 0; i < n; i++) {
			if (i == 0)
				t = 0;
			else
				t = "*".equals(st.nextToken()) ? 0 : 1;

			x = Math.abs(Integer.parseInt(st.nextToken()));

			l = (int) Math.floor(Math.sqrt(x));

			if (x == 0) {
				zero = true;
				break;
			}

			else if (t == 0) {
				for (int j = 2; j <= l; j++) {
					while (x % j == 0) {
						count[j]++;
						x /= j;
					}
				}
				if (x != 1) {
					count[x]++;
				}

			} else {
				for (int j = 2; j <= l; j++) {
					while (x % j == 0) {
						count[j]--;
						x /= j;
					}
				}

				if (x != 1) {
					count[x]--;
				}
			}
		}

		boolean chocolate = true;

		for (int i = 0; i <= 100000; i++) {
			if (count[i] < 0) {
				chocolate = false;
				break;
			}

		}

		System.out.println((zero || chocolate) ? "mint chocolate" : "toothpaste");
	}
}