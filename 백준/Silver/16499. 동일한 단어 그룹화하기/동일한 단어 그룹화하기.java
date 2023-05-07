import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Map<String,Integer> map = new HashMap<>();
		
		int n = Integer.parseInt(br.readLine());
		
		char[] word;
		String sortedWord;
		while(n-->0) {
			word = br.readLine().toCharArray();
			Arrays.sort(word);
			sb.append(word);
			sortedWord = sb.toString();
			sb.setLength(0);
			map.put(sortedWord, map.getOrDefault(sortedWord, 0)+1);
		}
		
		System.out.println(map.keySet().size());	
	}
}