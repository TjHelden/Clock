import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MyFrame extends JFrame {

    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Digital Clock Program");
        this.setLayout(new FlowLayout());
        this.setSize(350,230);
        this.setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMM dd, yyyy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Helvetica", Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00FB090));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Helvetica", Font.PLAIN,40));
        dayLabel.setForeground(new Color(0x00FB090));

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Helvetica", Font.PLAIN,30));
        dateLabel.setForeground(new Color(0x00FB090));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
    }
    public void setTime() {
        while(true) {
            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
