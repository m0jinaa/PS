import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static char[] s;
	static char[] p;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		s = br.readLine().toCharArray();

		p = br.readLine().toCharArray();

		int sl = s.length;
		int pl = p.length;

		int answer = 0;
		int t, max;

		for (int i = 0; i < pl;) {
			max = 0;

			for (int j = 0; j < sl; j++) {
				t = 0;

				while (i + t < pl && j + t < sl && p[i + t] == s[j + t])
					t++;

				max = Math.max(max, t);
			}
			i += max;
			answer++;
		}

		System.out.println(answer);
	}
}