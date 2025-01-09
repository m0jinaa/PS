import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] price = new int[n];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(price);

		int first = 0;

		int cnt = 0;

		for (int p : price) {
			if (first <= p) {
				cnt++;
				first = p * 2;
			}
		}

		System.out.println(cnt);
	}
}