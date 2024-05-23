import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		int[] line = new int[8];
		for (int i = 0; i < 120; i++) {
			line[i % 8] = (i % 20 + 1);
			if ((i + 1) % 8 == 0) {
				Arrays.sort(line);
				for (int x : line) {
					sb.append(x).append(" ");
				}
				sb.append("\n");
			}
		}

		System.out.println(sb.toString());
	}
}