import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] order = new int[k];

		st = new StringTokenizer(br.readLine(), " ");


		for (int i = 0; i < k; i++) {
			order[i] = Integer.parseInt(st.nextToken());
		}

		HashSet<Integer> using = new HashSet<>();

		int x;
		int v=0,last = 0;
		int answer = 0;
		int t;
		for (int i = 0; i < k; i++) {
			x = order[i];

			if (using.contains(x)) {
				continue;
			}
			else if (using.size() <n) {
				using.add(x);
				continue;
			}
			last = -1;
			v = -1;
			for(int y : using) {
				t = k+1;
				
				for(int j = i+1;j<k;j++) {
					if(order[j]==y) {
						t = j+1;
						break;
					}
				}
				
				if(t>last) {
					last = t;
					v = y;
				}
			}

			using.remove(v);
			using.add(x);
			answer++;
		}

		System.out.println(answer);
	}
}