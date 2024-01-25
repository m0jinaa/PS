import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		BigDecimal a = new BigDecimal(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		BigDecimal answer = a.pow(b);

		System.out.println(answer.toPlainString());
	}
}