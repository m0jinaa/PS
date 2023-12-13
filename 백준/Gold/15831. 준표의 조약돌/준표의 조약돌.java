import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int bCnt = 0;
		int wCnt = 0;

		char[] row = br.readLine().toCharArray();

		int s = 0;
		int e = 0;

		int answer = 0;

		while (e < n) {
			if (row[e] == 'B') {
				bCnt++;
			} else {
				wCnt++;
			}

			while (bCnt > b) {
				if (row[s++] == 'B') {
					bCnt--;
				} else {
					wCnt--;
				}
			}

			if (wCnt >= w) {
				answer = Math.max(answer, e - s + 1);
			}

			e++;
		}

		System.out.println(answer);
	}
}