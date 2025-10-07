import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		char[] row = st.nextToken().toCharArray();

		int n = row.length;

		int b = Integer.parseInt(st.nextToken());

		int d = 1;

		int g;

		int answer = 0;

		for (int i = n - 1; i >= 0; i--, d *= b) {
			if (row[i] <= '9') {
				g = row[i] - '0';
			} else {
				g = row[i] - 'A' + 10;
			}

			answer += (g * d);
		}

		System.out.println(answer);
	}
}