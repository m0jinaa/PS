import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int k,now,bef;
		String answer = "Yes";
		end:while(m-->0) {
			bef = n+1;
			k = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine()," ");
			
			while(k-->0) {
				now = Integer.parseInt(st.nextToken());
				if(bef>now) {
					bef = now;
				}
				else {
					answer = "No";
					break end;
				}
			}
		}
		
		System.out.println(answer);	
	}
}