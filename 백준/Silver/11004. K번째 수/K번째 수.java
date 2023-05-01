import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine(), " ");
		int x;
		while (n-- > 0) {
			x = Integer.parseInt(st.nextToken());
			list.add(x);
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(k-1));
	}
}