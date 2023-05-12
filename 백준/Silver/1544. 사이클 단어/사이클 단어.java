import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		ArrayList<String> list = new ArrayList<>();
		
		
		int n = Integer.parseInt(br.readLine());
		
		String word;

		boolean have;
		
		while(n-->0) {
			word = br.readLine();
			have = false;
			for(String w: list) {
				if(word.length()*2==w.length() && w.contains(word)) {
					have = true;
					break;
				}
					
			}
			if(!have) {
				list.add(word.concat(word));
			}
		}
		
		System.out.println(list.size());
	}
}