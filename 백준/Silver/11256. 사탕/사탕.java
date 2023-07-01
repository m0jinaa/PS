import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());
		int[] box;
		int candy, n, r, c, cnt;
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			candy = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			box = new int[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				box[i] = r * c;
			}

			Arrays.sort(box);

			cnt = 0;

			for (int i = n - 1; i >= 0; i--) {
				cnt++;
				candy -= box[i];
				if (candy <= 0)
					break;
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}