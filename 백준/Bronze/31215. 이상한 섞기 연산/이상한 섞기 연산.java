import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		int n;
		while (t-- > 0) {
			n = Integer.parseInt(br.readLine());
			if (n >2) {
				System.out.println(3);
			} else {
				System.out.println(1);
			}
		}

	}
}
