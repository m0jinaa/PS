import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		char[] shape = br.readLine().replaceAll(" ", "").toCharArray();
		char[] rev = new char[n];

		int te;
		for (int i = n - 1; i >= 0; i--) {
			te = shape[i] + 2;

			rev[n - 1 - i] = (char) (te > '4' ? te - 4 : te);
		}

		String polygon = String.valueOf(shape);
		polygon += polygon;

		String reversePolygon = String.valueOf(rev);
		reversePolygon += reversePolygon;

		int tc = Integer.parseInt(br.readLine());

		String input, t;

		int cnt = 0;

		while (tc-- > 0) {
			input = br.readLine();
			t = input.replaceAll(" ", "");

			if (polygon.contains(t) || reversePolygon.contains(t)) {
				cnt++;
				sb2.append(input).append("\n");
			}
		}
		sb.append(cnt).append("\n");
		sb.append(sb2.toString());
		System.out.print(sb.toString());
	}
}