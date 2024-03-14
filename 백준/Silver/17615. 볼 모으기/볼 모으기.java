import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] row = br.readLine().toCharArray();

		int r = 0;
		int b = 0;

		int rc = 0;
		int bc = 0;

		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (row[i] == 'R') {
				r = 1;
				rc += b;
			} else {
				b = 1;
				bc += r;
			}
		}

		answer = Math.min(rc, bc);

		r = 0;
		b = 0;
		rc = 0;
		bc = 0;

		for (int i = n - 1; i >= 0; i--) {
			if (row[i] == 'R') {
				r = 1;
				rc += b;
			} else {
				b = 1;
				bc += r;
			}
		}

		answer = Math.min(answer, Math.min(rc, bc));

		System.out.println(answer);
	}
}