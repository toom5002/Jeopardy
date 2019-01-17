package jeopardy;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Jeopardy {

    static int count = 0, score1 = 0, score2 = 0, turn = 0;
    static String cat[] = new String[5];
    static String price[][] = new String[6][5];
    static JButton b[][] = new JButton[6][5];
    static JFrame frame = new JFrame();
    static String QA[][] = new String[25][2];

    public static void main(String[] args) throws Exception {

        music("src\\audio\\jeop.wav");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Jeopardy. Team 1 = " + score1 + ". Team 2 = " + score2 + ".");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new GridLayout(6, 5));

        categories();
        buttoncreate();

        frame.setVisible(true);

    }

    public static void music(String file) throws FileNotFoundException, IOException, UnsupportedAudioFileException, LineUnavailableException {

        AudioInputStream song1 = AudioSystem.getAudioInputStream(new File(file));
        Clip clip = AudioSystem.getClip();
        clip.open(song1);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        //clip.stop();
    }

    public static void categories() {
        QA[0][0] = "What is the only mammal that can truly fly?";
        QA[0][1] = "bat";
        QA[1][0] = "What is the only animal born with horns?";
        QA[1][1] = "giraffe";
        QA[2][0] = "What kind of animal is a komono dragon?";
        QA[2][1] = "lizard";
        QA[3][0] = "True or false - The python is a poisonous snake?";
        QA[3][1] = "false";
        QA[4][0] = "Which bird has the largest wingspan of any living bird?";
        QA[4][1] = "albatross";
        QA[5][0] = "What is Japans natinonal sport?";
        QA[5][1] = "sumo";
        QA[6][0] = "What is the name of the popular traditional sword figter?";
        QA[6][1] = "samurai";
        QA[7][0] = "What is the name of their most widely practice religion?";
        QA[7][1] = "shinto";
        QA[8][0] = "The second atom bomb fell on what city?";
        QA[8][1] = "nagasaki";
        QA[9][0] = "What is the Japanese word that means “empty orchestra”?";
        QA[9][1] = "karaoke";
        QA[10][0] = "How many people have walked on the moon? \n(use numbers)";
        QA[10][1] = "12";
        QA[11][0] = "What year did the firt man walk on the moon? \n(use numbers)";
        QA[11][1] = "1969";
        QA[12][0] = "Which US president was the first to telephone the moon?";
        QA[12][1] = "richard nixon";
        QA[13][0] = "In the first moon mission which third astronaut had to stay in the shuttle?";
        QA[13][1] = "michael collins";
        QA[14][0] = "During this phase we cannot see any light from the moon?";
        QA[14][1] = "new moon";
        QA[15][0] = "What does R&B stand for?";
        QA[15][1] = "rhythm and blues";
        QA[16][0] = "Who is the lead singer for Guns N' Roses?";
        QA[16][1] = "axl rose";
        QA[17][0] = "What is the up and coming music style out of asia?";
        QA[17][1] = "kpop";
        QA[18][0] = "Which decade did Elvis Presley become famous in? \n(use numbers)";
        QA[18][1] = "1950";
        QA[19][0] = "What is the name of the album that has sold the most woldwide?";
        QA[19][1] = "thriller";
        QA[20][0] = "How many calories do you burn by drinking cold water? \n(use numbers)";
        QA[20][1] = "18";
        QA[21][0] = "How many standard time zones are there?\n(use numbers)";
        QA[21][1] = "24";
        QA[22][0] = "What part of the plant is a carrot?";
        QA[22][1] = "root";
        QA[23][0] = "How much money is in a game of Monopoly?\n(use numbers)";
        QA[23][1] = "15140";
        QA[24][0] = "What was the last movie personally overseen by Walt Disney?";
        QA[24][1] = "the jungle book";
      
        String[] cat = {"Animal", "Japan", "Moon", "Music", "Misc"};

        for (int a = 0; a < 6; a++) {
            for (int b = 0; b < 5; b++) {

                if (a == 0) {
                    price[a][b] = cat[b];
                }
                if (a == 1) {
                    price[a][b] = "$400";
                }
                if (a == 2) {
                    price[a][b] = "$800";
                }
                if (a == 3) {
                    price[a][b] = "$1200";
                }
                if (a == 4) {
                    price[a][b] = "$1600";
                }
                if (a == 5) {
                    price[a][b] = "$1800";
                }
            }
        }

    }

    public static void buttoncreate() {

        for (int x = 0; x < 6; x++) {
            for (int y = 0; y < 5; y++) {

                b[x][y] = new JButton(price[x][y] /*.toUpperCase()*/);
                b[x][y].setBackground(Color.BLUE);
                b[x][y].setForeground(Color.YELLOW);
                b[x][y].setFont(new Font("Verdana", Font.BOLD, 60));
                b[x][y].setBorder(BorderFactory.createLineBorder(Color.black, 2));
                if (x == 0) {
                    b[x][y].setBorder(BorderFactory.createLineBorder(Color.black, 5));
                }

                b[x][y].setName(Integer.toString((x) + (y * 5)));
                //b[x][y].setText(b[x][y].getName());
                b[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        turn++;
                        String player = "";
                        // ((JButton) (e.getSource())).setContentAreaFilled(false);
                        ((JButton) (e.getSource())).setText("");
                        ((JButton) (e.getSource())).setEnabled(false);
                        count++;

                        if (!((turn % 2) == 0)) {
                            player = "1";
                        } else {
                            player = "2";
                        }

                        QA(player, ((JButton) (e.getSource())).getName());

                        if (count >= 25) {
                            JOptionPane.showMessageDialog(null, "THE GAME HAS FINISHED!");
                            if (score1 > score2) {
                                JOptionPane.showMessageDialog(null, "Team 1 has WON!");
                            } else if (score1 < score2) {
                                JOptionPane.showMessageDialog(null, "Team 2 has WON!");
                            } else if (score1 == score2) {
                                JOptionPane.showMessageDialog(null, "Both teams have tied. Try harder next time.");
                            }
                            System.exit(0);
                        }
                        frame.setTitle("Jeopardy. Team 1 = " + score1 + ". Team 2 = " + score2 + ".");
                    }
                });

                if (x == 0) {
                    b[x][y].setEnabled(false);

                }

                frame.add(b[x][y]);
            }
        }
    }

    public static void QA(String player, String bNum) {
        String guess = "";
        int x = 0, iNum = 0;

        iNum = Integer.parseInt(bNum);

        x = iNum - 1;

        guess = JOptionPane.showInputDialog("Team " + player + ": " + QA[x][0]);
        if (guess.equalsIgnoreCase(QA[x][1])) {
            JOptionPane.showMessageDialog(null, "Correct answer");
            if (player.equals("1")) {
                score1 = score1 + 400;
            } else if (player.equals("2")) {
                score2 = score2 + 400;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect answer");
            if (player.equals(1)) {
                score1 = score1 - 400;
            } else {
                score2 = score2 - 400;
            }
        }

    }

}

// add up to 4 teams
// get the score working properly !!!!
