import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		int answer = 1;

		if (k == 1) {
			answer = 0;
		} else {
			// 0이 연속으로 k개 있는 가장 짧은 (-2)진수 => (-2)^k 구하기
			while (k-- > 0) {
				answer *= (-2);
			}
		}

		System.out.println(answer);
	}
}