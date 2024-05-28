import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		n %= 100;

		int answer = -1;
		if (n == 0)
			answer = 0;
		else if (n <= 9)
			answer = 1;
		else if (n == 10)
			answer = 0;
		else if (n <= 15)
			answer = 1;
		else if (n <= 24)
			answer = 2;
		else if (n <= 29)
			answer = 1;
		else if (n == 30)
			answer = 0;
		else if (n <= 35)
			answer = 1;
		else if (n <= 40)
			answer = 2;
		else if (n <= 49)
			answer = 3;
		else if (n <= 54)
			answer = 2;
		else if (n <= 59)
			answer = 1;
		else if (n == 60)
			answer = 0;
		else if (n <= 65)
			answer = 1;
		else if (n <= 70)
			answer = 2;
		else if (n <= 75)
			answer = 3;
		else if (n <= 84)
			answer = 4;
		else if (n <= 89)
			answer = 3;
		else if (n <= 94)
			answer = 2;
		else
			answer = 1;

		System.out.println(answer);
	}
}