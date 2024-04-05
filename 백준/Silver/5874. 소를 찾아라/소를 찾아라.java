import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] row = br.readLine().toCharArray();

		int n = row.length;

		int back = 0;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			if (i > 0 && row[i] == '(' && row[i - 1] == '(') {// 베시 뒷다리
				back++;
			} else if (i > 0 && row[i] == ')' && row[i - 1] == ')') {// 베시 앞다리
				answer += back;
			}
		}

		System.out.println(answer);
	}
}