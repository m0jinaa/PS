import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		char[] S = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine(), " ");

		int d = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int c = 0;

		int h = 0;
		int y = 0;
		int u = 0;

		int energy = 0;

		for (int i = 0; i < n; i++) {
			if (S[i] == 'H' || S[i] == 'Y' || S[i] == 'U') {
				switch (S[i]) {
				case 'H':
					h++;
					break;
				case 'Y':
					y++;
					break;
				case 'U':
					u++;
					break;
				}

				// 드래그해서 삭제하는 것과 하나씩 삭제하는 것 중 비용이 적게드는 쪽으로 선택.
				energy += Math.min(d * c, m + d);

				c = 0;

			} else {
				c++;
			}
		}

		// 마지막부분에 남은 HYU가 아닌 문자 체크
		energy += Math.min(d * c, m + d);

		int hyu = Math.min(h, Math.min(y, u));

		sb.append(energy == 0 ? "Nalmeok" : energy).append("\n");
		sb.append(hyu == 0 ? "I love HanYang University" : hyu).append("\n");

		System.out.println(sb.toString());
	}
}