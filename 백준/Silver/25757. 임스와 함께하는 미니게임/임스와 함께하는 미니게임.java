import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		HashSet<String> set = new HashSet<>();
		
		int n = Integer.parseInt(st.nextToken());
		String game = st.nextToken();
		
		while(n-->0) {
			set.add(br.readLine());
		}
		
		int answer = 0;
		
		switch(game) {
		case "Y":
			answer = set.size();
			break;
		case "F":
			answer = set.size()/2;
			break;
		case "O":
			answer = set.size()/3;
			break;
		}
		
		System.out.println(answer);
	}
}