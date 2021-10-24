package assignment_02;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class TestGoldpreis {
public static void main(String[] args) throws ParseException {
	String s1 = "22.580,00";
	NumberFormat format = NumberFormat.getInstance(Locale.GERMAN);
	Number number = format.parse(s1);
	double d1 = number.doubleValue();
	System.out.println(d1);
}
}