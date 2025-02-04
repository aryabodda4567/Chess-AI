package com.chess.ui;

import com.chess.ai.utils.Parser;
import com.chess.models.Location;
import com.chess.models.Square;
import com.chess.piece.Empty;
import com.chess.util.Message;
import com.chess.util.MoveUtil;
import com.chess.util.Utils;
import jdk.jshell.execution.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static com.chess.ui.UiUtil.showMessage;

public class BoardUI  extends States{
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

    private void movePiece(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow == toRow && fromCol == toCol) return; // No movement

        JButton sourceButton = buttons[fromRow][fromCol];
        JButton targetButton = buttons[toRow][toCol];

        // Swap the text/icons (For now, using text. Can be extended to chess piece icons)
        targetButton.setText(sourceButton.getText());
        sourceButton.setText("");

        System.out.println("Moved from (" + fromRow + ", " + fromCol + ") to (" + toRow + ", " + toCol + ")");
    }

    public void setSquareButton(int row, int col, JButton button) {
        if (row >= 0 && row < 8 && col >= 0 && col < 8) {
            boardPanel.remove(buttons[row][col]); // Remove old button
            buttons[row][col] = button; // Update button
            boardPanel.add(button, row * 8 + col); // Re-add at correct position
            boardPanel.revalidate();
            boardPanel.repaint();
        }
    }

    public void displayBoard() {
        frame.setVisible(true);
    }


    private  JButton customizeButton(JButton button, int row, int col) {

        if(!(board[row][col].getPiece() instanceof Empty)) {
            button.setText(board[row][col].getPiece().getName());
            System.out.println(board[row][col].getPiece().getColor());
        }



        button.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {


//               Remove buttons previous color and add board color





                previousCol = currentCol;
                previousRow = currentRow;
                currentCol = col;
                currentRow = row;
                System.out.println("Prev"+previousRow + " " + previousCol);
                System.out.println("Cur"+currentRow+ " " + currentCol);




                move.delete(0,move.length());
                move.append( Parser.getPosition(previousRow,previousCol)).append(" ")
                        .append(Parser.getPosition(currentRow,currentCol));
                System.out.println(move.toString());




//


                System.out.println("mousePressed");
            }

            @Override
            public void mousePressed(MouseEvent e) {


            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBorder(BorderFactory.createEmptyBorder());
                System.out.println("mouseReleased");

            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                System.out.println("mouseEntered");

            }

            @Override
            public void mouseExited(MouseEvent e) {
//                System.out.println("mouseExited");
            }
        });



        return button;
    }


    private void addEnterKeyBinding() {
        boardPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "enableMove");
        boardPanel.getActionMap().put("enableMove", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
//              Validate and move the piece
                 Message message = Utils.validateMove(move.toString(),board,board[0][0].currentColor);

                if(message.isError()){
//                    Invalid move
                    //System.out.println(message.getMessage());
                    UiUtil.showMessage(message.getMessage());
                }else {
//                  On correct move set updated button to button array
                    Location[]  locations = MoveUtil.parseMove(move.toString());
                    assert locations != null;

//                    Set
                    buttons[locations[1].getX()][locations[1].getY()] = board[locations[1].getX()]
                            [locations[1].getY()].getSquareButton();
                    buttons[locations[0].getX()][locations[0].getY()] = board[locations[0].getX()]
                            [locations[0].getY()].getSquareButton();

//                    Update color
                    board[0][0].currentColor = board[0][0].currentColor.equals(com.chess.models.Color.WHITE) ?
                            com.chess.models.Color.BLACK : com.chess.models.Color.WHITE;
                }
            }
        });
    }







}

