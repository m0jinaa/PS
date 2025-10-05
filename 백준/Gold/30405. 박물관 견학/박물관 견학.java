import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());

		int k, p;
		int ind = 0;
		int[] list = new int[2 * n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			k = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= k; j++) {
				p = Integer.parseInt(st.nextToken());
				if (j == 1 || j == k) {
					list[ind++] = p;
				}
			}
		}

		Arrays.sort(list);

		int answer = list[n - 1];

		System.out.println(answer);
	}
}