import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int[] numbers = new int[n];
		int x;
		for(int i = 0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0;j<n;j++) {
				x = Integer.parseInt(st.nextToken());
				numbers[i]|=x;
				numbers[j]|=x;
			}
		}
		
		for(int num : numbers) {
			sb.append(num).append(" ");
		}
		System.out.println(sb.toString());
	}

}