import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
    
        // 중앙값부터 시작해서 양방향값 번갈아 출력
        
		int n = Integer.parseInt(br.readLine());

		int ind = 0;

		int e = (n + 2) / 2;
		int s = e - 1;

		while (ind++ < n) {
			if (ind % 2 == 0) {
				sb.append(s--).append(" ");
			} else {
				sb.append(e++).append(" ");
			}
		}

		System.out.println(sb.toString());
	}
}