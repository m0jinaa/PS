import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		HashSet<String> set = new HashSet<>();

		int tc = Integer.parseInt(br.readLine());

		int n;
		String city;

		while (tc-- > 0) {
			n = Integer.parseInt(br.readLine());

			while (n-- > 0) {
				city = br.readLine();
				set.add(city);
			}

			sb.append(set.size()).append("\n");
			set.clear();
		}

		System.out.print(sb.toString());
	}
}