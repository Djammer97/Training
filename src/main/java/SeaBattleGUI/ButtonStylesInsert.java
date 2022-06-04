package SeaBattleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ButtonStylesInsert extends JFrame {

    private JButton[][] buttons = new JButton[10][10];
    private JButton[][] numbers = new JButton[10][2];
    private Container container;
    private Action action = new SimpleAction();
    private final String SHIP = "C:" + File.separator + "JavaMarathon2021" + File.separator +
            "src" + File.separator + "images" + File.separator + "ship-icon.png";
    private final String SEA = "C:" + File.separator + "JavaMarathon2021" + File.separator +
            "src" + File.separator + "images" + File.separator + "sea.png";
    private final String DOT = "C:" + File.separator + "JavaMarathon2021" + File.separator +
            "src" + File.separator + "images" + File.separator + "dot.png";
    private Player player;

    public ButtonStylesInsert(Player player) {
        super("Поле боя");
        this.player = player;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(290, 365);
        setLayout(null);
        JLabel label = new JLabel("Поле игрока " + player.getName());
        label.setBounds(100, 0, 290, 50);
        container = getContentPane();
        container.add(label);
        for (int i = 0; i < 10; i++) {
            numbers[i][0] = new JButton(i + "");
            numbers[i][1] = new JButton(i + "");
            numbers[i][0].setBounds((i + 1) * 25, 50, 25, 25);
            numbers[i][0].setMargin(new Insets(0, 0, 0, 0));
            numbers[i][0].setEnabled(false);
            numbers[i][1].setMargin(new Insets(0, 0, 0, 0));
            numbers[i][1].setBounds(0, (i + 1) * 25 + 50, 25, 25);
            numbers[i][1].setEnabled(false);
            container.add(numbers[i][0]);
            container.add((numbers[i][1]));
            for (int j = 0; j < 10; j++) {
                buttons[i][j] = new JButton(action);
                buttons[i][j].setName(i + "," + j);
                buttons[i][j].setMargin(new Insets(0, 0, 0, 0));
                buttons[i][j].setBounds((j + 1) * 25, (i + 1) * 25 + 50, 25, 25);
                container.add(buttons[i][j]);
            }
        }
        setVisible(true);
        setResizable(false);
    }

    class SimpleAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            System.out.println("Нажатие на кнопку <" + btn.getName() + ">");
            btn.setEnabled(false);
            Battlefield.insertShip.append(btn.getName()).append(";");
        }
    }

    public void reBuild() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buttons[i][j].setEnabled(true);
                if (player.getBattlefield().getCell(i, j).getCondition() == Cell.SHIP) {
                    buttons[i][j].setIcon(new ImageIcon(SHIP));
                } else {
                    if (player.getBattlefield().getCell(i, j).getCondition() == Cell.OREOL) {
                        buttons[i][j].setIcon(new ImageIcon(DOT));
                    }
                }
            }
        }
    }
}
