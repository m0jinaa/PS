import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayList<BigInteger> list = new ArrayList<>();
        String input;

        while (n-- > 0) {
            input = br.readLine().replaceAll("[a-z]", " ");
            st = new StringTokenizer(input, " ");
            while (st.hasMoreTokens()) {
                list.add(new BigInteger(st.nextToken()));
            }
        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder();

        for (BigInteger num : list) {
            sb.append(num).append("\n");
        }

        System.out.print(sb.toString());
    }
}