import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] house;
	static int end;

	static void getMax(int x) {
		
		int m;

		int s = 0;
		int e = end;
		int ans = e + 1;
		boolean added = true;

		while (s <= e) {
			m = (s + e) / 2;

			if (house[m] >= x) {
				added = false;
				ans = m;
				e = m - 1;
			} else {
				s = m + 1;
			}
		}

		house[ans] = x;
		if (added)
			end++;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		int n, x;

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			house = new int[n];
			end = -1;

			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < n; i++) {
				x = Integer.parseInt(st.nextToken());

				getMax(x);
			}

			sb.append("Case #").append(t).append(": ").append(n - end - 1).append("\n");
		}

		System.out.print(sb.toString());
	}
}