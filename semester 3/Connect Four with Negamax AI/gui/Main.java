package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import processing.CurrentTable;
import processing.Playing;

public class Main extends JFrame {

	private JPanel contentPane;
	static JLabel lblPlayer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		Playing.init(6, 7);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int x = 1000, y = 600;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((int) dim.getWidth() / 2 - x / 2, (int) dim.getHeight() / 2 - y / 2, 1000, 600); // vasate safhe
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel board = new JPanel();
		board.setBounds(10, 10, 543 * 6 / 5, 543);
		contentPane.add(board);
		board.setLayout(new GridLayout(6, 7, 8, 8));

		JButton[][] buttons = new JButton[Playing.imax][Playing.jmax];
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[0].length; j++) {
				JButton jb = new JButton();
				jb.setMinimumSize(new Dimension(0, 0));
				jb.setBackground(Color.gray);
				jb.setBorderPainted(false);
				jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						for (int k = 0; k < buttons.length; k++) {
							for (int l = 0; l < buttons[0].length; l++) {
								if (e.getSource().equals(buttons[k][l])) {
//									System.out.println(k + " " + l);
									if (CurrentTable.move(k, l)) {
										if (CurrentTable.checkWin(k, l)) {
											lblPlayer.setText(Playing.getPlayerName() + " Wins!");
										} else {
											Playing.changeTurn();
											lblPlayer.setText(Playing.getPlayerName() + "'s Turn");
										}

									}
								}
							}
						}
						checkEndGame(buttons);
//						node t = NegamaxTree.negamax(CurrentTable.getbinary(), Integer.MIN_VALUE, Integer.MAX_VALUE,
//								Playing.turn == 1 ? 1 : -1);
//						System.out.println(t.lastMove);

					}
				});

				buttons[i][j] = jb;
				board.add(buttons[i][j]);
			}
		}
		CurrentTable.init(buttons);
		lblPlayer = new JLabel(Playing.getPlayerName() + "'s Turn");
		lblPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblPlayer.setBounds(671, 10, 305, 50);
		contentPane.add(lblPlayer);

	}

	public static void checkEndGame(JButton[][] buttons) {
		// check harekati mojud ast
		boolean endGame = true;
		for (int k = 0; k < buttons.length; k++) {
			if (CurrentTable.isMoveAvailable(k, 0)) {
				endGame = false;
				break;
			}
		}

		// end game
		if (endGame || Playing.win) {
			for (int k = 0; k < buttons.length; k++) {
				for (int l = 0; l < buttons[0].length; l++) {
					buttons[k][l].setEnabled(false);
				}
			}
			if (endGame && !Playing.win) {
				lblPlayer.setText("mosavi shod");
			}
		}
	}
}
