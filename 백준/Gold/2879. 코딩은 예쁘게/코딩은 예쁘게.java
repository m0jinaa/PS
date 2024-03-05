import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] indent = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			indent[i] = -Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < n; i++) {
			indent[i] += Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		int d = 0;
		boolean yet = true;

		while (yet) {
			yet = false;
			for (int i = 0; i < n; i++) {
				if (indent[i] == 0)
					continue;

				d = indent[i];

				yet = true;

				for (int j = i + 1; j <= n; j++) {
					if (indent[i] * indent[j] > 0) {
						if (Math.abs(indent[j]) < Math.abs(d))
							d = indent[j];
					} else {
						answer += Math.abs(d);

						for (int k = i; k < j; k++)
							indent[k] -= d;
						i = j - 1;
						break;
					}
				}
			}
		}

		System.out.println(answer);
	}
}