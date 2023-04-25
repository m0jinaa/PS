import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st,stt;

        int t = Integer.parseInt(br.readLine());
        int n;
        Map<String,Integer> map = new HashMap<>();
        String[] answer;
        String key,value;
        while(t-->0) {

            n = Integer.parseInt(br.readLine());

            answer = new String[n];

            st = new StringTokenizer(br.readLine()," ");

            for(int i = 0;i<n;i++) {
                map.put(st.nextToken(), i);
            }

            st = new StringTokenizer(br.readLine()," ");
            stt = new StringTokenizer(br.readLine()," ");

            for(int i = 0;i<n;i++) {
                key = st.nextToken();
                value = stt.nextToken();
                answer[map.get(key)] = value;
            }

            for(String s : answer) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}