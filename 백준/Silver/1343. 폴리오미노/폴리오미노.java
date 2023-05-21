import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input,".");
		StringTokenizer stt = new StringTokenizer(input,"X");
		StringBuilder sb = new StringBuilder();
		int x,t;
		if(input.charAt(0)=='.') {
			sb.append(stt.nextToken());
		}
		while(st.hasMoreTokens()) {
			x = st.nextToken().length();
			if(x%2!=0) {
				sb.setLength(0);
				sb.append(-1);
				break;
			}
			else {
				t = x/4;
				while(t-->0) {
					sb.append("AAAA");
				}
				if(x%4!=0) {
					sb.append("BB");
				}
			}
			if(stt.hasMoreTokens())
				sb.append(stt.nextToken());
		}
        
		System.out.println(sb.toString());
	}
}