import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		
		while(n-->0) {
			set.add(br.readLine());
		}
		
		while(m-->0) {
			st = new StringTokenizer(br.readLine(),",");
			while(st.hasMoreTokens()) {
				set.remove(st.nextToken());
			}
			sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}