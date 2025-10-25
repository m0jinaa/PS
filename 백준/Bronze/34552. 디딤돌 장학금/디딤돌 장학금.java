import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int[] B = new int[11];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < 11; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		int n = Integer.parseInt(br.readLine());

		int total = 0;

		int b, s, l;

		while (n-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");

			b = Integer.parseInt(st.nextToken());
			l = (int) (Double.parseDouble(st.nextToken()) * 100);
			s = Integer.parseInt(st.nextToken());

			if (s < 17 || l < 200)
				continue;

			total += B[b];
		}

		System.out.println(total);
	}
}