import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0;i<n;i++) {
			String s = br.readLine();
			int g = 0;
			int b = 0;
			for(int j = 0;j<s.length();j++) {
				char c = s.charAt(j);
				switch(c) {
				case 'G':
				case 'g':
					g++;
					break;
				case 'B':
				case 'b':
					b++;
					break;
				default:
					break;
				}
			}
			if(g==b)
				System.out.println(s+" is NEUTRAL");
			else if(g<b)
				System.out.println(s+" is A BADDY");
			else
				System.out.println(s+" is GOOD");
		}
	}
}
