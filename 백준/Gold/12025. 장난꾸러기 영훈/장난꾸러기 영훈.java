import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] arr = br.readLine().toCharArray();
		long k = Long.parseLong(br.readLine()) - 1;
		int cnt = 0;

		int n = arr.length;

		int[] numbers = new int[n];
		for (int i = 0; i < n; i++) {
			numbers[i] = arr[i] - '0';
			if (numbers[i] == 1 || numbers[i] == 2 || numbers[i] == 6 || numbers[i] == 7) {
				cnt++;
				numbers[i] %= 5;
			}
		}

		if ((1L << cnt) <= k) {
			sb.append(-1);
		} else {
			int p = cnt - 1;
			for (int i = 0; i < n; i++) {
				if (numbers[i] == 1 || numbers[i] == 2 || numbers[i] == 6 || numbers[i] == 7) {
					if (((1 << p) & k) != 0) {
						sb.append(numbers[i] + 5);
					} else {
						sb.append(numbers[i]);
					}
					p--;
				} else {
					sb.append(numbers[i]);
				}
			}
		}

		System.out.println(sb.toString());
	}
}