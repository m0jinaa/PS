import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		int sum = 0;

		while (n-- > 0) {
			sum += Integer.parseInt(st.nextToken());
		}

		if (t <= sum) {
			System.out.println("Padaeng_i Happy");
		} else {
			System.out.println("Padaeng_i Cry");
		}
	}
}