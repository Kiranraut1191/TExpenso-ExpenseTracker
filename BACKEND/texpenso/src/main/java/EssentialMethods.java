import java.sql.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.time.LocalDate;

public class EssentialMethods {

	// Format and parse java.sql.Date
	public static Date dateFormat(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
		String formattedDate = formatter.format(date); // Convert to formatted string

		try {
			// Parse the string back into java.util.Date
			java.util.Date parsedDate = formatter.parse(formattedDate);

			// Convert java.util.Date to java.sql.Date
			return new Date(parsedDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace(); // Handle parsing exception
			return null; // Return null if parsing fails
		}
	}

	// Correctly create current java.sql.Date from LocalDate
	public static Date currentDate() {
		LocalDate localDate = LocalDate.now();
		// Convert LocalDate to java.sql.Date
		Date sqlDate = Date.valueOf(localDate); // Utilize Date.valueOf()
		return dateFormat(sqlDate); // Format the SQL date
	}

}