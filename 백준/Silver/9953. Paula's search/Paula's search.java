import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n;
		int s, e, m, cnt;

		while ((n = Integer.parseInt(br.readLine())) != 0) {
			cnt = 0;

			s = 2;
			e = 100;

			while (s <= e) {
				m = (s + e) / 2;

				if (s % 2 != m % 2)
					m--;
				cnt++;

				if (m == n) { //원하는 가게 도착
					break;
				} else if (m % 2 != n % 2) { // 길 건너야함
					s--;
					e--;
				} else if (m < n) { // 오른쪽 살펴봐야 함
					s = m + 2;
				} else { // 왼쪽 살펴봐야 함
					e = m - 2;
				}
			}

			sb.append(cnt).append("\n");
		}

		System.out.println(sb.toString());
	}
}