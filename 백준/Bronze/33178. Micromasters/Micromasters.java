import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 한명당 10%이므로 무료로 들으려면 10명 채워야함.
		// 따라서 무료로 들을 수 있는 강의 수는 n을 10으로 나눈 몫
		int answer = n / 10;

		System.out.println(answer);
	}
}