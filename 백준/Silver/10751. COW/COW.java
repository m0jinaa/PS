import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		char[] row = br.readLine().toCharArray();

		long C = 0;
		long O = 0;
		long W = 0;

		for (char c : row) {
			switch (c) {
			case 'C':
				C++;
				break;
			case 'O':
				O += C;
				break;
			case 'W':
				W += O;
				break;
			}
		}

		System.out.println(W);
	}
}