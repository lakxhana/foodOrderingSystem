import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUpdater {
    private Timer timer;
    private JLabel timeLabel;

    public TimeUpdater(JLabel timeLabel) {
        this.timeLabel = timeLabel;
        updateTime(); // Initialize the label with the current time

        // Setup timer to update time every second
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateTime();
            }
        });
        timer.start();
    }

    private void updateTime() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(formatter);
        timeLabel.setText(formattedTime);
    }
}
