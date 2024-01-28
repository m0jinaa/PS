public class Main {
	public static void main(String[] args) throws Exception {
		StringBuilder sb = new StringBuilder();

		int n = 100;

		sb.append(n).append("\n");

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					sb.append(0);
				else if (i == n - 1 || j == n - 1)
					sb.append(1);
				else
					sb.append(1000);

				sb.append(j == n - 1 ? "\n" : " ");
			}
		}

		System.out.println(sb.toString());
	}
}
