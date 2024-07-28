import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Model {

    private String formattedTime;

    public void updateTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.formattedTime = currentTime.format(formatter);
    }

    public String getFormattedTime() {
        return formattedTime;
    }
}
