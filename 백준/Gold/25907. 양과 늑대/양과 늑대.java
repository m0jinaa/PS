import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int s = 1;
		int e = n;
		int m;
		int ret;
		int answer = 0;

		while (s <= e) {
			m = (s + e) / 2;

			System.out.println("? " + m);
			ret = Integer.parseInt(br.readLine());

			if (m - ret == ret) {
				answer = m;
				break;
			} else if (m - ret < ret) {
				s = m + 1;
			} else {
				e = m - 1;
			}
		}

		System.out.println("! " + answer);
	}
}