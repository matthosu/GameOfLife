/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author Mateusz
 */
class MouseClicker implements MouseListener {
    private int row;
    private int cell;
    private StructureGoL playground;
    public MouseClicker(int atRow, int atCell, StructureGoL space) {
        row = atRow;
        cell = atCell;
        playground = space;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
        if(playground.getAt(row, cell))
        {
            source.setBackground(Color.BLACK);
            playground.setDead(row, cell);
        }else
        {
            source.setBackground(Color.WHITE);
            playground.setAlive(row,cell);
        }
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
    
}
