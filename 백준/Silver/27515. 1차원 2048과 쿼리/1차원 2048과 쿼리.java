import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int q = Integer.parseInt(br.readLine());

		long x;
		long sum = 0;
		long ans;

		while (q-- > 0) {
			x = Long.parseLong(br.readLine());

			sum += x;

			ans = sum == 0 ? 0 : (long) Math.pow(2, (int) (Math.log10(sum) / Math.log10(2)));

			sb.append(ans).append("\n");
		}
		System.out.print(sb.toString());
	}
}