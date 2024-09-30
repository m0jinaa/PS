import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String h = br.readLine();

		int answer = 1;

		if ("1".equals(h)) {
			answer = 2;
		}

		System.out.println(answer);
	}
}