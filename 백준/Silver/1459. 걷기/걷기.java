import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		long m;
		long answer = 0;
		
		long total = x + y;
		
		long d = Math.abs(x - y);
		long l = Math.min(s, w);
		
		m = Math.min(x, y);
		
		if (2 * w > s) {
			answer = s * m + l * (d / 2) * 2;
			if (total % 2 != 0)
				answer += w;
		} else {
			answer = total * w;
		}

		System.out.println(answer);
	}
}