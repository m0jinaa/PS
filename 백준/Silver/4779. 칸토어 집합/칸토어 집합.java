import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[] answer;
	
	static void getAnswer(int s, int e) {
		if(s==e) {
			answer[s] = '-';
		}
		else {
			int size = (e-s+1)/3;
			getAnswer(s,s+size-1);
			getAnswer(e-size+1,e);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String input = "";
		
		int n;
		int size;
		while((input = br.readLine())!=null && !input.isEmpty()) {
			n = Integer.parseInt(input);
			size = (int)Math.pow(3, n);
			answer = new char[size];
			Arrays.fill(answer, ' ');
			if(size!=1) {
				getAnswer(0,size/3-1);
				getAnswer(2*size/3,size-1);				
			}
			else {
				answer[0] = '-';
			}
			
			for(char c:answer) {
				sb.append(c);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}

}
