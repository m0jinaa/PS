import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," :");
		int start, end, stream;
		
		start = Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
		stream = Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());
		
		String input = "";
		int time;
		Set<String> set = new HashSet<String>();
		String name;
		int answer = 0;
		
		while((input = br.readLine())!=null && !input.isEmpty()) {
			st = new StringTokenizer(input," :");
			time = Integer.parseInt(st.nextToken())*60+Integer.parseInt(st.nextToken());

			name = st.nextToken();
			
			if(time<=start) {
				set.add(name);
			}
			else if(end<=time && time<=stream && set.contains(name)) {
				answer++;
				set.remove(name);
			}		
		}
		
		System.out.println(answer);
	}
}