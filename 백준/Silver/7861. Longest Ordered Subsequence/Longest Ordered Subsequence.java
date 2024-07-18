import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int ind;

	static int getMin(int x) {
		int s = 0;
		int e = ind - 1;

		int ret = ind;

		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (arr[m] >= x) {
				ret = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];

		ind = 1;

		int x, loc;

		arr[0] = -1;
		
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= n; i++) {
			x = Integer.parseInt(st.nextToken());

			loc = getMin(x);

			arr[loc] = x;

			if (loc == ind)
				ind++;
		}

		System.out.println(ind - 1);
	}
}