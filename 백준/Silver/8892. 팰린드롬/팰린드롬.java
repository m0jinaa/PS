import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		int n;
		String[] str;
		
		String answer = "0";
		while(tc-->0) {
			answer = "0";
			n = Integer.parseInt(br.readLine());
			str = new String[n];
			for(int i = 0;i<n;i++) {
				str[i] = br.readLine();
			}
			
			end:for(int i = 0;i<n;i++) {
				for(int j = 0;j<n;j++) {
					if(i==j)
						continue;
					if((str[i]+str[j]).equals((new StringBuilder(str[i]+str[j])).reverse().toString())) {
						answer = str[i]+str[j];
						break end;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}
}