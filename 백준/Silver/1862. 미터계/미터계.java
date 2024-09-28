import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int answer = 0;
        
        char[] row = br.readLine().toCharArray();
    
        int n = row.length;
        int t;
        for(int i = n-1;i>=0;i--){
            t = row[i]-'0';
            
            if(t>=5)
                t--;
                
            answer+=(int)Math.pow(9,n-1-i) * t;
        }
        
        
        System.out.println(answer);
    }
}