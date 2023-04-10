import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static String[] words;
	
	static int upperBound(String x) {
		int s = 0;
		int e = words.length-1;
		int mid;
		int answer = -1;
		while(s<=e) {
			mid = (s+e)/2;
			if(words[mid].startsWith(x)) {
				answer = mid;
				s = mid+1;
			}
			else if(words[mid].compareTo(x)<0) {
				s = mid+1;
			}
			else {
				e = mid-1;
			}
		}
		return answer;
	}
	
	static int lowerBound(String x) {
		int s = 0;
		int e = words.length-1;
		int mid;
		int answer = words.length;
		while(s<=e) {
			mid = (s+e)/2;
			if(words[mid].startsWith(x)) {
				answer = mid;
				e = mid-1;
			}
			else if(words[mid].compareTo(x)<0) {
				s = mid+1;
			}
			else {
				e = mid-1;
			}
		}
		return answer;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		words = new String[n];
		
		for(int i = 0;i<n;i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words);
		
		int answer = 0;
		String w;
		while(m-->0) {
			w = br.readLine();
			int e = upperBound(w);
			int s = lowerBound(w);
			if(e-s+1>0) {
				answer++;
			}
		}
			
		System.out.println(answer);
	}
}