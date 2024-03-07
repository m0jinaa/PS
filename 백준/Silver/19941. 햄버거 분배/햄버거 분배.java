import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		char[] row = br.readLine().toCharArray();
		int s, e;

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (row[i] != 'P')
				continue;

			s = Math.max(0, i - k);
			e = Math.min(n - 1, i + k);

			for (int j = s; j <= e; j++) {
				if (row[j] != 'H')
					continue;

				row[j] = 'O';
				cnt++;
				break;
			}
		}

		System.out.println(cnt);
	}
}