import javax.swing.*;
import java.awt.*;

/*10:30 Создание игры «Сапёр» на Java*/
public class JavaSweeper extends JFrame {
    private JPanel panel;          //19:15 для додавання панелі

    public static void main(String[] args) {
        new JavaSweeper();          //16:15 .setVisible(true) -->
    }

    //14:00
    private JavaSweeper() {
        initPanel();    //20:20 проініціалізуємо панель
        initFrame();        //16:15
    }

    private void initPanel() {//19:25 метод,який буде панель ініціалізувати
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(500, 500));
        add(panel);
    }

    private void initFrame() {//14:35
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");       //встановлюємо заголовок
        setLocationRelativeTo(null);    //встановлюємо його по центру
        setResizable(false);            //ми не будемо змінювати розміри вікна
        setVisible(true);               //щоб форму було видимо
    }
}
