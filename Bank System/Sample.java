// *****************CODE BY RUCHIR JAIN******************

//****************TESTING PAGE*********************
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sample {
    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = currentDate.format(formatter);
        System.out.println(formattedDate);
    }
}
