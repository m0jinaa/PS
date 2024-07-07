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
		int m = Integer.parseInt(st.nextToken());

		int[] arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		int a, b;
		int t;

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			t = arr[a];
			arr[a] = arr[b];
			arr[b] = t;

		}

		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}