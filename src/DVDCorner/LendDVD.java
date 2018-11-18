/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class LendDVD implements DRSCommand {

    Vector _DVD;
    Stack operHist;
    int id;
    DVD dvd;

    public LendDVD(Vector _DVD, int id) {
        this._DVD = _DVD;
        this.id = id;
//        this.operHist = operHist;
    }

    @Override
    public void execute() {
        for (int i = 0; i < _DVD.size(); i++) {
            if (((DVD) _DVD.elementAt(i)).getDvdID() == id) {
                dvd = ((DVD) _DVD.elementAt(i));
                if (dvd.getNumAvailable() > 0) {    //Lending a DVD with 1 or more available
                    dvd.setNumAvailable(dvd.getNumAvailable() - 1);
                    System.out.println("Lent out: " + dvd.getTitle());
                    System.out.println("Number of available copies: " + dvd.getNumAvailable() + "\n");
                } else {      //Lending a DVD with zero available copy will display a warning message
                    System.out.println("Invalid request (" + dvd.getTitle() + " has no available copy).\n");

                }
            }
        }
    }

    @Override
    public void undo() {
        if (dvd != null) {
            dvd.setNumAvailable(dvd.getNumAvailable() + 1);
        }
    }


}
