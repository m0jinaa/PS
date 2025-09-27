import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Map<String, String> seminar = new HashMap<>();

		seminar.put("Algorithm", "204\n");
		seminar.put("DataAnalysis", "207\n");
		seminar.put("ArtificialIntelligence", "302\n");
		seminar.put("CyberSecurity", "B101\n");
		seminar.put("Network", "303\n");
		seminar.put("Startup", "501\n");
		seminar.put("TestStrategy", "105\n");

		int n = Integer.parseInt(br.readLine());

		String name;

		while (n-- > 0) {
			name = br.readLine();

			sb.append(seminar.get(name));
		}

		System.out.println(sb.toString());
	}
}