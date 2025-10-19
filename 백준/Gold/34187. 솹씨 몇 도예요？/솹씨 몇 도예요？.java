import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int s = 0;
		int e = 2025;
		int m;

		String ret;
		final String COLD = "Cold";
		final String HOT = "Hot";

		while (s <= e) {
			m = (s + e) / 2;

			System.out.println("? " + m);
			ret = br.readLine();

			if (COLD.equals(ret)) {
				s = m;
				e = (e + m) / 2;
			} else if (HOT.equals(ret)) {
				s = (s + m) / 2;
				e = m - 1;
			} else {
				System.out.println("! " + m);
				break;
			}
		}
	}
}