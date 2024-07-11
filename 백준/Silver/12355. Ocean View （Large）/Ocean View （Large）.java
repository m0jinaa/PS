import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	static int ind;

	static int getInd(int x) {
		int ret = ind;
		int s = 0;
		int e = ind - 1;
		int m;

		while (s <= e) {
			m = (s + e) / 2;

			if (arr[m] >= x) {
				ret = m;
				e = m - 1;
			} else
				s = m + 1;
		}

		if (ret == ind)
			ind++;

		return ret;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int n, x;
		int loc;

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];
			ind = 0;

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				x = Integer.parseInt(st.nextToken());
				loc = getInd(x);
				arr[loc] = x;
			}

			sb.append("Case #").append(t).append(": ").append(n - ind).append("\n");
		}

		System.out.print(sb.toString());
	}
}