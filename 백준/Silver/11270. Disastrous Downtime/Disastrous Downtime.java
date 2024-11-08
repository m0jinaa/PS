import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] time = new int[n];

		for (int i = 0; i < n; i++) {
			time[i] = Integer.parseInt(br.readLine());
		}

		int start = 0;
		int s, e, m, c, loc;
		int answer = 0;

		while (start < n) {
			s = start;
			e = n - 1;
			loc = s - 1;
			while (s <= e) {
				m = (s + e) / 2;

				if (time[m] < time[start] + 1000) {
					loc = m;
					s = m + 1;
				} else {
					e = m - 1;
				}
			}
            
            //1000ms 동안 존재하는 일이 처리되기위해 필요한 서버 수
			c = (int) Math.ceil(1.0 * (loc - start + 1) / k);
            
			answer = Math.max(answer, c);
			start = loc + 1;
		}

		System.out.println(answer);
	}
}