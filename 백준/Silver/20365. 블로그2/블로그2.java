import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] row = br.readLine().toCharArray();

		int r = 0;
		int b = 0;

		for (int i = 0; i < n; i++) {
			if (i == 0 || row[i] != row[i - 1]) {
				if (row[i] == 'R') {
					r++;
				} else {
					b++;
				}
			}
		}

		int answer = Math.min(r, b) + 1;

		System.out.println(answer);

	}
}