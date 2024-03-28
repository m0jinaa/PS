import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] words;

		String end = "E-N-D";

		int max = 0;
		String answer = "";

		end: while (true) {
			words = br.readLine().split("[^a-zA-Z-]");

			for (String w : words) {
				if (end.equals(w))
					break end;
				if (w.length() > max) {
					max = w.length();
					answer = w.toLowerCase();
				}
			}
		}
        
		System.out.println(answer);
	}
}