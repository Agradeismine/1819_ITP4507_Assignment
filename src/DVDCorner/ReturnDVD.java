/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class ReturnDVD implements DRSCommand {

    Vector _DVD;
    int id;
    DVD dvd;

    public ReturnDVD(Vector _DVD, int id) {
        this._DVD = _DVD;
        this.id = id;
    }

    @Override
    public void execute() {
        for (int i = 0; i < _DVD.size(); i++) {
            if (((DVD) _DVD.elementAt(i)).getDvdID() == id) {
                dvd = ((DVD) _DVD.elementAt(i));
                    dvd.setNumAvailable(dvd.getNumAvailable() + 1);
                    System.out.println("Returned: " + dvd.getTitle());
                    System.out.println("Number of available copies: " + dvd.getNumAvailable() + "\n");
            }
        }
    }

    @Override
    public void undo() {
        if(dvd!=null){
            dvd.setNumAvailable(dvd.getNumAvailable() - 1);
        }
    }

    @Override
    public String toString() {
        return "";
    }


}
