import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		int size = (int) Math.pow(2, (int) Math.ceil(Math.log10(k) / Math.log10(2)));

		int cnt = 0;
		if (size != k) {

			while (k > 0) {
				if (k % 2 != 0) {
					cnt++;
				} else if (cnt != 0) {
					cnt++;
				}
				k >>= 1;
			}
		}
        
		System.out.println(size + " " + cnt);
	}
}