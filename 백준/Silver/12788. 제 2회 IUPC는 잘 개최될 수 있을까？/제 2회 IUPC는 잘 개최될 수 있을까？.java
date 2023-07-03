import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		int[] pens = new int[n];

		for (int i = 0; i < n; i++) {
			pens[i] = Integer.parseInt(st.nextToken());
		}

		int need = m * k;

		Arrays.sort(pens);

		int cnt = 0;

		for (int i = n - 1; i >= 0; i--) {
			need -= pens[i];
			cnt++;
			if (need <= 0)
				break;
		}

		if (need > 0) {
			System.out.println("STRESS");
		} else {
			System.out.println(cnt);
		}
	}
}