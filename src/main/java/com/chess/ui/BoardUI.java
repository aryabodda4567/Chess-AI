package com.chess.ui;

import com.chess.ai.utils.Parser;
import com.chess.models.Location;
import com.chess.models.Square;
import com.chess.piece.Empty;
import com.chess.util.BoardUtil;
import com.chess.util.Message;
import com.chess.util.MoveUtil;
import com.chess.util.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class BoardUI extends States {
    private final JButton[][] buttons = new JButton[8][8]; // Store buttons
    private final JPanel boardPanel = new JPanel(new GridLayout(8, 8));
    private final JFrame frame = new JFrame("Chess Board");
    private Square[][] board;


    public BoardUI(Square[][] board) {
        this.board = board;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 1200);
        frame.add(boardPanel);
        addEnterKeyBinding();
    }

    public void addToUI() {
        boardPanel.removeAll(); // Clear previous components if any

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JButton button = new JButton();
                button.setBackground((i + j) % 2 == 0 ? Color.WHITE : Color.GRAY);
                customizeButton(button, i, j);
                buttons[i][j] = button; // Store button reference
                board[i][j].setSquareButton(button);
                boardPanel.add(button);
            }
        }
    }


    public void displayBoard() {
        frame.setVisible(true);
    }


    private void customizeButton(JButton button, int row, int col) {

//        If piece is not a empty
        if (!(board[row][col].getPiece() instanceof Empty)) {
//            Create URL
            String url = "/" + board[row][col].getPiece().getColor().toString() + "_" + board[row][col].getPiece().getName().toUpperCase() + ".png";
            URL resource = Utils.class.getResource(url);
            if (resource == null) {
                System.out.println("Resource not found");
                System.exit(1);
            } else {
                ImageIcon originalIcon = new ImageIcon(resource);
                // Resize the image to match the button size
                Image img = originalIcon.getImage();
                Image resizedImg = img.getScaledInstance(button.getWidth() + 60,
                        button.getHeight() + 60, Image.SCALE_SMOOTH);
                ImageIcon resizedIcon = new ImageIcon(resizedImg);
                board[row][col].setIcon(resizedIcon);
                button.setIcon(resizedIcon);
            }
//            Set icon to button from the board
            button.setIcon(board[row][col].getIcon());

        }
        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                previousCol = currentCol;
                previousRow = currentRow;
                currentCol = col;
                currentRow = row;
                move.delete(0, move.length());
                move.append(Parser.getPosition(previousRow, previousCol)).append(" ")
                        .append(Parser.getPosition(currentRow, currentCol));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });


    }


    /// On clicking ENTER key this method invokes
    private void addEnterKeyBinding() {
        boardPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "enableMove");
        boardPanel.getActionMap().put("enableMove", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                                game();

            }
        });
    }

    public void game(){
        //              Validate and move the piece
        Message message = Utils.validateMove(move.toString(), board, board[0][0].currentColor);
        if (message.isError()) {
//                   Invalid move
            UiUtil.showMessage(message.getMessage());
        } else {
//                  On correct move set updated button to button array
            Location[] locations = MoveUtil.parseMove(move.toString());
            assert locations != null;
//                    Set button  in board to button array
            buttons[locations[1].getX()][locations[1].getY()] = board[locations[1].getX()]
                    [locations[1].getY()].getSquareButton();
            buttons[locations[0].getX()][locations[0].getY()] = board[locations[0].getX()]
                    [locations[0].getY()].getSquareButton();


            //            Check black and white kings are exist
            if(board[0][0].currentColor.equals(com.chess.models.Color.BLACK)){
                if(!BoardUtil.isWhiteKingExist(board)){
                    JOptionPane.showConfirmDialog(null,"Black won the match");
                    System.exit(0);
                }
            }else{
                if(!BoardUtil.isBlackKingExist(board)){
                    JOptionPane.showConfirmDialog(null,"White won the match");
                    System.exit(0);
                }
            }

//                    Update color
            board[0][0].currentColor = board[0][0].currentColor.equals(com.chess.models.Color.WHITE) ?
                    com.chess.models.Color.BLACK : com.chess.models.Color.WHITE;




        }
    }

}

