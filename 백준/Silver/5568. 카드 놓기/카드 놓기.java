import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    static int n,k;
    static HashSet<String> set;

    static String[] nums;
    static boolean[] selected;

    static void combi(int cnt, String now) {
        if(cnt==k) {
            set.add(now);
            return;
        }

        for(int i = 0;i<n;i++) {
            if(selected[i])
                continue;
            selected[i] = true;
            combi(cnt+1,now+nums[i]);
            selected[i] = false;
        }
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        selected = new boolean[n];

        nums = new String[n];

        for(int i = 0;i<n;i++) {
            nums[i] = br.readLine();
        }

        combi(0,"");

        System.out.println(set.size());

    }
}
