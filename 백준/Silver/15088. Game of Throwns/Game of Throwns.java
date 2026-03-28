import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String UNDO = "undo";
		String o;
		int p, m;

		Stack<Integer> history = new Stack<>();
		int eggHolder = 0;

		st = new StringTokenizer(br.readLine(), " ");

		while (k-- > 0) {
			o = st.nextToken();

			if (UNDO.equals(o)) {
				m = Integer.parseInt(st.nextToken());
				p = 0;
				while (m-- > 0) {
					p += history.pop();
				}

				p = (((-p) % n) + n) % n;
				eggHolder = (eggHolder + p) % n;

			} else {
				p = Integer.parseInt(o);
				p = ((p % n) + n) % n;

				eggHolder = (eggHolder + p) % n;
				history.add(p);
			}
		}
        
		System.out.println(eggHolder);
	}
}