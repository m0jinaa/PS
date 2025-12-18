import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		int s = 0;
		int e = 10_000_000;

		int sum = 0;

		int a;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			a = Integer.parseInt(st.nextToken());

			sum += a;
		}

		int answer = e + 1;

		int mid;

		while (s <= e) {
			mid = (s + e) / 2;

			if (sum + mid * 100 >= x * (mid + n)) {
				answer = mid;
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		System.out.println(answer);
	}
}