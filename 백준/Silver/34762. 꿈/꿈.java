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

		int m = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int bef = 0;

		int s = -1;

		boolean possible = true;

		for (int i = 0; i < m && possible; i++) {
			s = Integer.parseInt(st.nextToken());

			if (bef != 0 && s - bef != 1 && s - bef - 1 <= k) {
				possible = false;
			}
			bef = s;
		}

		if (n != s)
			possible &= ((n - s) > k);

		System.out.println(possible ? "YES" : "NO");
	}
}