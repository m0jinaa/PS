import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());

		int p1, p2, p3, x1, x2, x3;

		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		p3 = Integer.parseInt(st.nextToken());
		x1 = Integer.parseInt(st.nextToken());
		x2 = Integer.parseInt(st.nextToken());
		x3 = Integer.parseInt(st.nextToken());

		int max = p1 * p2 * p3;

		int answer = -1;

		for (int i = 1; i <= max; i++) {
			if (i % p1 != x1 || i % p2 != x2 || i % p3 != x3)
				continue;

			answer = i;
			break;
		}
        
		System.out.println(answer);
	}
}