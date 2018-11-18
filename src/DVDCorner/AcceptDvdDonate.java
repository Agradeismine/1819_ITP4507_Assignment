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
public class AcceptDvdDonate implements DRSCommand {

    Vector _DVD;
    Stack operHist;
    int id, numDonated;
    DVD dvd;

    public AcceptDvdDonate(Vector _DVD, int id, int numDonated) {
        this._DVD = _DVD;
        this.id = id;
        this.numDonated = numDonated;
    }

    @Override
    public void execute() {
        for (int i = 0; i < _DVD.size(); i++) {
            if (((DVD) _DVD.elementAt(i)).getDvdID() == id) {
                dvd = ((DVD) _DVD.elementAt(i));
                dvd.setNumAvailable(dvd.getNumAvailable() + numDonated);
                System.out.println("Donation accepted: " + dvd.getTitle());
                System.out.println("Number of available copies: " + dvd.getNumAvailable() + "\n");
            }
        }
    }

    @Override
    public void undo() {
        if(dvd!=null){
            dvd.setNumAvailable(dvd.getNumAvailable() - numDonated);
        }
    }

}
