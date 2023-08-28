import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int x, y;
		int[] cnt = new int[n + 1];

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			cnt[x]++;
			cnt[y]++;
		}

		int q = Integer.parseInt(br.readLine());

		int t, k;

		while (q-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			t = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			if(t==2) {
				sb.append("yes\n");
			}
			else if(cnt[k]>=2){
				sb.append("yes\n");
			}
			else {
				sb.append("no\n");
			}
		}
		
		System.out.print(sb.toString());
	}
}