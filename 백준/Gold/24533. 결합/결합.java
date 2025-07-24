import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		long x = 0, y = 0;
		long a, b;

		long energy = 0;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			a = Long.parseLong(st.nextToken());
			b = Long.parseLong(st.nextToken());

			energy += (a * y + b * x);

			x += a;
			y += b;
		}

		System.out.println(energy);
	}
}