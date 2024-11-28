package version5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		final String regex = "[^*]+";
		final String string = " Time 23:54  Date:20.11.19\n"
			 + "*****************************\n"
			 + " Item  (qty X rate) = price\n"
			 + "-----------------------------\n"
			 + " Tea          1X10  =  10\n"
			 + " Coffee       1X25  =  25\n"
			 + " Set Menu     2X145 =  290\n"
			 + "------------------------------\n"
			 + " Total payable amount:325";

		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(string);
		String res = "";
		while (matcher.find()) {res+=(matcher.group(0).toString());}
		System.out.println(res);

	}

}
