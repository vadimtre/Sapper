import sweeper.Box;

import javax.swing.*;
import java.awt.*;

/*10:30 Создание игры «Сапёр» на Java до 40 хв.
        далі
    Java.Сапёр Пошаговое создание игры Minesweeper      https://www.youtube.com/watch?v=SaoxeveWy4o&list=PLt5E226f3KMEv6huOjYdpVKZIz1PSlvEA
        Евгений Витольдович
        починаємо з 12 видео из 17 (Java.Сапёр — Перечисление кубиков)
*/
public class JavaSweeper extends JFrame {
    private JPanel panel;               //19:15 для додавання панелі
    private final int COLS = 15;        //23:00 додамо деякі константи, які будуть визначати розмір нашого поля і розмір нашого екрана гри
    private final int ROWS = 1;
    private final int IMAGE_SIZE = 50;  //23:30 додамо константу - розмір 1-го малюнка

    public static void main(String[] args) {
        new JavaSweeper();          //16:15 .setVisible(true) -->
    }

    //14:00
    private JavaSweeper() {
        setImages();    //added in 14v
        initPanel();    //20:20 проініціалізуємо панель
        initFrame();        //16:15
    }

    private void initPanel() {  //19:25 метод,який буде панель ініціалізувати
        //panel = new JPanel();
        //36:00 для малювання малюнку на нашій формі
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) { //36:40 ця ф-ція буде автоматично викликатись кожен раз коли потрібно намалювати форму
                super.paintComponent(g);
                //--> 13.Первый цикл
                for (Box box : Box.values()) //метод values() перебирає всі перечислення
                    g.drawImage((Image) box.image,  //added in 14v  3:00 --> (Image)        //changed in 14v   getImage(box.name().toLowerCase()) --> box.image
                            box.ordinal() * IMAGE_SIZE,     //ordinal() повертає текущий номер в списку елементів
                            0,
                            this);
                //
                /* comment in 13 video
                g.drawImage(getImage("bomb"), 0, 0, this);
                g.drawImage(getImage("num1"), IMAGE_SIZE, 0, this);
                */
            }
        };
        //panel.setPreferredSize(new Dimension(500, 500));
        //24:00  50 --
        panel.setPreferredSize(new Dimension(COLS * IMAGE_SIZE, ROWS * IMAGE_SIZE));
        add(panel);
    }

    private void initFrame() {  //14:35
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Sweeper");       //встановлюємо заголовок
        setLocationRelativeTo(null);    //встановлюємо його по центру
        setResizable(false);            //ми не будемо змінювати розміри вікна
        setVisible(true);               //щоб форму було видимо
    }

    //added in 14v встановить потрібні малюнки до кожного екземпляра перечислення Box
    private void setImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    private Image getImage(String name) {   //33:00 напишемо ф-цію, яка буде займатись отриманням малюнків
        String filename = "img/" + name.toLowerCase() + ".png";   //по-перше треба визначити імя файла, що містить ці малюнки
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));   //!!!!з-робити папку image ресурсною (right button --> make .. --> ...)
        return icon.getImage();
    }

}
