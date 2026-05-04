package view;

import model.Types;
import javax.swing.*;
import java.awt.*;

public class InterfaceGraphique implements Runnable {

    JFrame frame;
    boolean maximized = false;

    @Override
    public void run() {

        frame = new JFrame("LACUNA");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DragLayer dragLayer = new DragLayer();
        frame.setGlassPane(dragLayer);
        dragLayer.setVisible(true);

        // ================= ROOT FLEX (VERTICAL) =================
        FlexPanel root = new FlexPanel();
        root.setDirection(FlexPanel.Direction.COLUMN);
        root.setJustify(FlexPanel.Justify.START);
        root.setAlign(FlexPanel.Align.STRETCH);
        root.setBackground(Color.BLACK);

        // ================= ZONE SCORE (TOP - CENTRÉE) =================
        FlexPanel scoreHeader = new FlexPanel();
        scoreHeader.setDirection(FlexPanel.Direction.ROW);
        scoreHeader.setJustify(FlexPanel.Justify.CENTER);
        scoreHeader.setAlign(FlexPanel.Align.CENTER);
        scoreHeader.setPreferredSize(new Dimension(0, 350));
        scoreHeader.setGap(100);

        Score scoreArgent = new Score(Types.TypePion.ARGENT);
        scoreArgent.setPreferredSize(new Dimension(250, 320));

        Score scoreOr = new Score(Types.TypePion.OR);
        scoreOr.setPreferredSize(new Dimension(250, 320));

        JLabel scoreLabel = new JLabel("0 - 0", SwingConstants.CENTER);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 40));

        scoreHeader.add(scoreArgent);
        scoreHeader.add(scoreLabel);
        scoreHeader.add(scoreOr);

        // ================= ZONE JEU (ROW) =================
        FlexPanel gameRow = new FlexPanel();
        gameRow.setDirection(FlexPanel.Direction.ROW);
        gameRow.setJustify(FlexPanel.Justify.CENTER);
        gameRow.setAlign(FlexPanel.Align.STRETCH);
        gameRow.setBackground(Color.BLACK);

        JeuGraphique aire = new JeuGraphique(frame, scoreArgent, scoreOr, scoreLabel);
        aire.setBackground(Color.BLACK);
        aire.setOpaque(true);

        PionArgent leftPile = new PionArgent(frame);
        leftPile.setPreferredSize(new Dimension(100, 600));
        leftPile.setBackground(Color.BLACK);

        PionOr rightPile = new PionOr();
        rightPile.setPreferredSize(new Dimension(100, 600));
        rightPile.setBackground(Color.BLACK);

        JPanel s1 = new JPanel();
        s1.setBackground(Color.BLACK);
        JPanel s2 = new JPanel();
        s2.setBackground(Color.BLACK);

        gameRow.add(s1);
        gameRow.setFlexGrow(s1, 1);
        gameRow.add(leftPile);
        gameRow.setFlexGrow(leftPile, 1);
        gameRow.add(aire);
        gameRow.setFlexGrow(aire, 4);
        gameRow.add(rightPile);
        gameRow.setFlexGrow(rightPile, 1);
        gameRow.add(s2);
        gameRow.setFlexGrow(s2, 1);

        // ================= ASSEMBLAGE FINAL =================
        root.add(scoreHeader);
        root.setFlexGrow(scoreHeader, 0);
        root.add(gameRow);
        root.setFlexGrow(gameRow, 1);

        frame.add(root);

        // ================= FRAME =================
        frame.setSize(1200, 950);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void toggleFullscreen() {
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = env.getDefaultScreenDevice();

        if (maximized) {
            device.setFullScreenWindow(null);
            maximized = false;
        } else {
            device.setFullScreenWindow(frame);
            maximized = true;
        }
    }
}
