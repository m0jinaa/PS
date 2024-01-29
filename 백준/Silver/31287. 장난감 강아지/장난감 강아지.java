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

		k = Math.min(k, n);
		char[] ord = br.readLine().toCharArray();

		int h = 0;
		int w = 0;

		boolean visit = false;

		while (!visit && k-- > 0) {
			for (char c : ord) {
				switch (c) {
				case 'U':
					h++;
					break;
				case 'D':
					h--;
					break;
				case 'R':
					w++;
					break;
				case 'L':
					w--;
					break;
				}
				if (h == 0 && w == 0) {
					visit = true;
					break;
				}
			}

		}

		System.out.println(visit ? "YES" : "NO");
	}
}