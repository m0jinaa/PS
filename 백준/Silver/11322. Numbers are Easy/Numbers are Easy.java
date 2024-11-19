import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());

		long n, x, nx;

		LinkedList<Long> q = new LinkedList<>();

		while (tc-- > 0) {
			n = Long.parseLong(br.readLine());

			q.clear();

			q.add(1L);

			while (!q.isEmpty()) {
				x = q.poll();

				if (x % n == 0) {
					sb.append(x).append("\n");
					break;
				}

				for (int i = 0; i < 2; i++) {
					nx = x * 10 + i;

					q.add(nx);
				}
			}
		}

		System.out.println(sb.toString());
	}
}