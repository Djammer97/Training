package SeaBattleGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;

public class ButtonStylesPlay extends JFrame {

    private JButton[][] buttons1 = new JButton[10][10];
    private JButton[][] buttons2 = new JButton[10][10];
    private JButton[][] numbers1 = new JButton[10][2];
    private JButton[][] numbers2 = new JButton[10][2];
    private Container container;
    private Action action = new SimpleAction();
    private final String SHIP = "C:" + File.separator + "JavaMarathon2021" + File.separator +
            "src" + File.separator + "images" + File.separator + "ship-icon.png";
    private final String DOT = "C:" + File.separator + "JavaMarathon2021" + File.separator +
            "src" + File.separator + "images" + File.separator + "dot.png";
    private final String DESTROY = "C:" + File.separator + "JavaMarathon2021" + File.separator +
            "src" + File.separator + "images" + File.separator + "destroy.png";
    private Player player1;
    private Player player2;
    private JButton turn;
    private boolean turnPlayer1 = true;

    public ButtonStylesPlay(Player player1, Player player2) {
        super("Поле боя");
        this.player1 = player1;
        this.player2 = player2;
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(580, 415);
        if (turnPlayer1) {
            turn = new JButton("Ход игрока " + player1.getName());
        } else {
            turn = new JButton("Ход игрока " + player2.getName());
        }
        turn.setBounds(0, 325, 580, 50);
        turn.setEnabled(false);
        setLayout(null);
        JLabel label1 = new JLabel("Поле игрока " + player1.getName());
        label1.setBounds(100, 0, 290, 50);
        JLabel label2 = new JLabel("Поле игрока " + player2.getName());
        label2.setBounds(390, 0, 290, 50);
        container = getContentPane();
        container.add(turn);
        container.add(label1);
        container.add(label2);
        for (int i = 0; i < 10; i++) {
            numbers1[i][0] = new JButton(i + "");
            numbers1[i][1] = new JButton(i + "");
            numbers1[i][0].setBounds((i + 1) * 25, 50, 25, 25);
            numbers1[i][0].setMargin(new Insets(0, 0, 0, 0));
            numbers1[i][0].setEnabled(false);
            numbers1[i][1].setMargin(new Insets(0, 0, 0, 0));
            numbers1[i][1].setBounds(0, (i + 1) * 25 + 50, 25, 25);
            numbers1[i][1].setEnabled(false);
            container.add(numbers1[i][0]);
            container.add((numbers1[i][1]));
            numbers2[i][0] = new JButton(i + "");
            numbers2[i][1] = new JButton(i + "");
            numbers2[i][0].setBounds((i + 1) * 25 + 290, 50, 25, 25);
            numbers2[i][0].setMargin(new Insets(0, 0, 0, 0));
            numbers2[i][0].setEnabled(false);
            numbers2[i][1].setMargin(new Insets(0, 0, 0, 0));
            numbers2[i][1].setBounds(290, (i + 1) * 25 + 50, 25, 25);
            numbers2[i][1].setEnabled(false);
            container.add(numbers2[i][0]);
            container.add((numbers2[i][1]));
            for (int j = 0; j < 10; j++) {
                buttons1[i][j] = new JButton(action);
                buttons1[i][j].setName(i + "," + j);
                buttons1[i][j].setMargin(new Insets(0, 0, 0, 0));
                buttons1[i][j].setBounds((j + 1) * 25, (i + 1) * 25 + 50, 25, 25);
                container.add(buttons1[i][j]);
                buttons2[i][j] = new JButton(action);
                buttons2[i][j].setName(i + "," + j);
                buttons2[i][j].setMargin(new Insets(0, 0, 0, 0));
                buttons2[i][j].setBounds((j + 1) * 25 + 290, (i + 1) * 25 + 50, 25, 25);
                container.add(buttons2[i][j]);
            }
        }
        setVisible(true);
        setResizable(false);
    }

    class SimpleAction extends AbstractAction {

        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            Boolean right = false;
            if (turnPlayer1) {
                for (JButton[] buttons : buttons2) {
                    for (JButton button : buttons) {
                        if (btn.equals(button)) {
                            right = true;
                        }
                    }
                }
            } else {
                for (JButton[] buttons : buttons1) {
                    for (JButton button : buttons) {
                        if (btn.equals(button)) {
                            right = true;
                        }
                    }
                }
            }
            if (right) {
                System.out.println("Нажатие на кнопку <" + btn.getName() + ">");
                Battlefield.insertShip.append(btn.getName()).append(";");
            }
        }
    }

    public void reBuild() {
        if (turnPlayer1) {
            turn.setText("Ход игрока " + player1.getName());
        } else {
            turn.setText("Ход игрока " + player2.getName());
        }
        for (
                int i = 0;
                i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (player1.getBattlefield().getCell(i, j).getCondition() == Cell.SHIP &&
                        player1.getBattlefield().getCell(i, j).isVisible() &&
                        player1.getBattlefield().getCell(i, j).getShip().isAlive()) {
                    buttons1[i][j].setIcon(new ImageIcon(SHIP));
                } else {
                    if (player1.getBattlefield().getCell(i, j).getCondition() == Cell.SHIP &&
                            player1.getBattlefield().getCell(i, j).isVisible() &&
                            !player1.getBattlefield().getCell(i, j).getShip().isAlive()) {
                        buttons1[i][j].setIcon(new ImageIcon(DESTROY));
                    } else {
                        if (player1.getBattlefield().getCell(i, j).getCondition() == Cell.OREOL) {
                            buttons1[i][j].setIcon(new ImageIcon(DOT));
                        }
                    }
                }
                if (player2.getBattlefield().getCell(i, j).getCondition() == Cell.SHIP &&
                        player2.getBattlefield().getCell(i, j).isVisible() &&
                        player2.getBattlefield().getCell(i, j).getShip().isAlive()) {
                    buttons2[i][j].setIcon(new ImageIcon(SHIP));
                } else {
                    if (player2.getBattlefield().getCell(i, j).getCondition() == Cell.SHIP &&
                            player2.getBattlefield().getCell(i, j).isVisible() &&
                            !player2.getBattlefield().getCell(i, j).getShip().isAlive()) {
                        buttons2[i][j].setIcon(new ImageIcon(DESTROY));
                    } else {
                        if (player2.getBattlefield().getCell(i, j).getCondition() == Cell.OREOL) {
                            buttons2[i][j].setIcon(new ImageIcon(DOT));
                        }
                    }
                }
            }
        }

    }

    public void changeTurn() {
        turnPlayer1 = !turnPlayer1;
    }
}
