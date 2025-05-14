import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int z = Integer.parseInt(st.nextToken());

		int answer, min;

		if (x <= 3 && y <= 3 && z <= 3) {
			// 자르지 않아도 건포도의 위치를 알 수 있는 경우
			answer = 0;
		} else {
			// 제일 짧은 길이를 기준으로 1과 2로만 구성될 수 있게 나눠야 함.
			min = Math.min(x, Math.min(y, z));

			answer = Math.max((min - 1) / 2, 0);
		}

		System.out.println(answer);
	}
}