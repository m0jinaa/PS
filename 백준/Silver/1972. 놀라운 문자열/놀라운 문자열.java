import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer, sb;
		answer = new StringBuilder();
		sb = new StringBuilder();
		
		String input;
		char[] word;
		int n;
		
		HashSet<String> set = new HashSet<>();
		boolean possible;
		while((input = br.readLine())!=null && !"*".equals(input)) {
			set.clear();
			
			word = input.toCharArray();
			n = word.length;
			possible = true;
			
			end : for(int i = 1;i<n;i++) {
				
				for(int j = 0;j<n-i;j++) {
					sb.append(word[j]).append(word[j+i]);
					if(!set.add(sb.toString())) {
						sb.setLength(0);
						possible = false;
						break end;
					}
					sb.setLength(0);
				}
				set.clear();
			}
			
			if(possible) {
				answer.append(input).append(" is surprising.\n");
			}
			else {
				answer.append(input).append(" is NOT surprising.\n");
			}			
		}
		
		System.out.println(answer.toString());
	}
}