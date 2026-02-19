import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] pot = new int[n];

		Arrays.fill(pot, k);

		int now = 0;

		int day = 0;

		do {
			day++;
			for (int i = 0; i < a; i++) {
				pot[(i + now) % n] += b;
			}
			now = (now + a) % n;
		} while (pot[now] > day);

		System.out.println(day);
	}
}