import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
    static int[][] numbers;
    static HashMap<Long, Integer> result;
    static HashSet<Long> used;
    static int[] chosen;
    static boolean dfs(int ind) {
        long res;
        for(int i = 1;i<=3;i++) {

            switch(i) {
            case 1:
                res = numbers[ind][0]+numbers[ind][1];
                break;
            case 2:
                res = numbers[ind][0]-numbers[ind][1];
                break;
            default:
                res = numbers[ind][0]*1L*numbers[ind][1];
                break;
            }
            
            if(used.contains(res))
            	continue;
            used.add(res);

            if(!result.containsKey(res) || dfs(result.get(res))) {
                result.put(res, ind);
                chosen[ind] = i;
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        chosen = new int[n+1];
        numbers = new int[n+1][2];
        used = new HashSet<>();

        result = new HashMap<Long,Integer>();

        int a,b;

        for(int i = 1;i<=n;i++) {
            st = new StringTokenizer(br.readLine()," ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            numbers[i][0] = a;
            numbers[i][1] = b;
        }

        int cnt = 0;

        for(int i = 1;i<=n;i++) {
            used.clear();
            if(dfs(i)) {
                cnt++;
            }
        }

        if(cnt==n) {
            for(int i = 1; i<=n;i++) {
                switch(chosen[i]) {
                case 1:
                    sb.append(numbers[i][0])
                    .append(" + ")
                    .append(numbers[i][1])
                    .append(" = ")
                    .append(numbers[i][0]+numbers[i][1]).append("\n");
                    break;
                case 2:
                    sb.append(numbers[i][0])
                    .append(" - ")
                    .append(numbers[i][1])
                    .append(" = ")
                    .append(numbers[i][0]-numbers[i][1]).append("\n");
                    break;
                case 3:
                    sb.append(numbers[i][0])
                    .append(" * ")
                    .append(numbers[i][1])
                    .append(" = ")
                    .append(numbers[i][0]*1L*numbers[i][1]).append("\n");
                    break;

                }
            }
        }
        else {
            sb.append("impossible\n");
        }

        System.out.print(sb.toString());

    }
}