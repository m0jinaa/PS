import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		char[] A, B;
		int a, b;
		boolean pos;
		String input;
		while ((input = br.readLine()) != null && !input.isEmpty()) {

			st = new StringTokenizer(input, " ");

			A = st.nextToken().toCharArray();
			B = st.nextToken().toCharArray();

			a = A.length;
			b = B.length;

			pos = true;

			if (a > b) {
				pos = false;
			} else {
				int i = 0;

				for (int j = 0; i < a && j < b; j++) {
					if (A[i] == B[j]) {
						i++;
					}
				}

				if (i != a) {
					pos = false;
				}
			}

			sb.append(pos ? "Yes" : "No").append("\n");
		}
		System.out.print(sb.toString());
	}
}