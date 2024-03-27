import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean isLunaYear(int y) {
		if (y % 400 == 0 || (y % 4 == 0 && y % 100 != 0))
			return true;
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ,:");
		String month = st.nextToken();
		int date = Integer.parseInt(st.nextToken());
		int year = Integer.parseInt(st.nextToken());
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());

		int oneYear = isLunaYear(year) ? 366 : 365;

		oneYear *= (24 * 60);

		int now = 0;

		switch (month) {
		case "December":
			now += 30;
		case "November":
			now += 31;
		case "October":
			now += 30;
		case "September":
			now += 31;
		case "August":
			now += 31;
		case "July":
			now += 30;
		case "June":
			now += 31;
		case "May":
			now += 30;
		case "April":
			now += 31;
		case "March":
			if (isLunaYear(year))
				now += 29;
			else
				now += 28;
		case "February":
			now += 31;
			break;
		}

		now += (date - 1);

		now *= 24;

		now += hour;

		now *= 60;

		now += minute;

		double answer = 1.0 * now / oneYear;

		System.out.println(answer * 100);
	}
}