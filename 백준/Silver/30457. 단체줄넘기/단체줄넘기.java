import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] d = new int[] { 1001, 1001 };

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int[] height = new int[n];

		for (int i = 0; i < n; i++) {
			height[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(height);
		int cnt = 0;
		int ind = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (d[ind] > height[i]) {
				d[ind] = height[i];
				cnt++;
				ind = 1 - ind;
			}
		}

		System.out.println(cnt);
	}
}