import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static long fact(int x) {
		if (x == 0 || x == 1)
			return 1L;
		else
			return x * fact(x - 1);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long answer = fact(n);

		System.out.println(answer);
	}
}