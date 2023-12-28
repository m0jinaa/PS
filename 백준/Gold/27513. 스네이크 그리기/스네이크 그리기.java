import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int ans = n*m;
		
		if(ans%2==0) {
			sb.append(ans).append("\n");
			if(m%2==0) {
				for(int i = 1;i<=m;i++) {
					sb.append("1 "+i+"\n");
				}
				for(int i = m;i>=1;i--) {
					if(i%2==0) {
						for(int j = 2;j<=n;j++) {
							sb.append(j+" "+i+"\n");
						}
					}
					else {
						for(int j = n;j>=2;j--) {
							sb.append(j+" "+i+"\n");
						}					
					}
				}
			}
			else {
				for(int i = 1;i<=n;i++) {
					sb.append(i+" 1"+"\n");
				}
				for(int i = n;i>=1;i--) {
					if(i%2==0) {
						for(int j = 2;j<=m;j++) {
							sb.append(i+" "+j+"\n");
						}
					}
					else {
						for(int j = m;j>=2;j--) {
							sb.append(i+" "+j+"\n");
						}					
					}
				}
			}
		}
		else {
			sb.append(ans-1).append("\n");
			
			for(int i = 1;i<=m;i++) {
				sb.append("1 "+i+"\n");
			}
			
			for(int i = 2;i<=n-2;i++) {
				if(i%2!=0) {
					for(int j = 2;j<=m;j++) {
						sb.append(i+" "+j+"\n");
					}
				}
				else {
					for(int j = m;j>=2;j--) {
						sb.append(i+" "+j+"\n");
					}					
				}
			}
			
			for(int i = m;i>=1;i--) {
				if(i==1) {
					for(int j = n;j>1;j--) {
						sb.append(j+" "+i+"\n");
					}
				}
				else if(i==2) {
					sb.append(n+" "+i+"\n");
				}
				else if(i%2!=0) {
					for(int j = n-1;j<=n;j++) {
						sb.append(j+" "+i+"\n");
					}
				}
				else {
					for(int j = n;j>=n-1;j--) {
						sb.append(j+" "+i+"\n");
					}					
				}
			}			
		}
		System.out.println(sb.toString());
	}
}