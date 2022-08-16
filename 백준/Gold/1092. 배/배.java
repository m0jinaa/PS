import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		List<Integer> crane = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<n;i++) {
			crane.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		
		List<Integer> box = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i = 0;i<m;i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		crane.sort(Collections.reverseOrder());
		box.sort(Collections.reverseOrder());
		int now,size;
		int answer = 0;
		if(crane.get(0)<box.get(0))//크레인으로 못옮기는 상자 존재
			answer = -1;
		else {
			size = box.size();
			while(!box.isEmpty()) {
				answer++;
				now = 0;
				for(int i = 0;i<n;) {
					if(now==size)
						break;
					if(crane.get(i)>=box.get(now)) {
						box.remove(now);
						size--;
						i++;
					}
					else
						now++;
				}
			}
		}
		System.out.println(answer);
	}
}
