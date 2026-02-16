import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int size = 6;

		int n = Integer.parseInt(br.readLine());

		int[] shirts = new int[size];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < size; i++) {
			shirts[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		int t = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		int shirtBundle = 0;

		for (int i = 0; i < size; i++) {
			shirtBundle += (shirts[i] + t - 1) / t;
		}

		int penBundle = n / p;
		int single = n % p;

		sb.append(shirtBundle).append("\n");

		sb.append(penBundle).append(" ").append(single).append("\n");

		System.out.print(sb.toString());
	}
}