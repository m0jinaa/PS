import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] arr;
	static int ind;

	static void getLoc(int x) {
		if (arr[ind] < x) {
			arr[++ind] = x;
		} else {
			int s = 0;
			int e = ind;
			int m;

			int loc = ind + 1;

			while (s <= e) {
				m = (s + e) / 2;

				if (arr[m] >= x) {
					loc = m;
					e = m - 1;
				} else {
					s = m + 1;
				}
			}

			arr[loc] = x;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];

		int x;

		for (int i = 0; i < n; i++) {
			x = Integer.parseInt(br.readLine());

			getLoc(x);
		}

		System.out.println(ind);
	}
}