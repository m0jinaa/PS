import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		LinkedList<String>[] sentences = new LinkedList[n];
		
		for(int i = 0;i<n;i++) {
			sentences[i] = new LinkedList<>(Arrays.asList(br.readLine().split(" ")));
		}
		
		String[] L = br.readLine().split(" ");
		boolean find;
		
		String answer = "Possible";
		for(String word : L) {
			find = false;
			for(int i= 0;i<n;i++) {
				if(word.equals(sentences[i].peek())) {
					sentences[i].pollFirst();
					find = true;
					break;
				}
			}
			if(!find) {
				answer = "Impossible";
				break;
			}
		}
		
		for(int i = 0;i<n;i++) {
			if(!sentences[i].isEmpty()) {
				answer = "Impossible";
				break;
			}
		}
		
		System.out.println(answer);				
	}
}