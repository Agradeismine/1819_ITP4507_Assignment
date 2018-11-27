

import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class AcceptDvdDonate implements DRSCommand {
    Caretaker ct;
    Vector _DVD;
    Stack operHist;
    int id, numDonated;
    DVD dvd;

    public AcceptDvdDonate(Caretaker ct, Vector _DVD, int id, int numDonated) {
        this.ct=ct;
        this._DVD = _DVD;
        this.id = id;
        this.numDonated = numDonated;
    }

    @Override
    public void execute() {
        for (int i = 0; i < _DVD.size(); i++) {
            if (((DVD) _DVD.elementAt(i)).getDvdID() == id) {
                dvd = ((DVD) _DVD.elementAt(i));
                ct.save(_DVD, ("Accept "+id+" "+ dvd.getTitle()+ " ("+numDonated+" copies)"));
                dvd.setNumAvailable(dvd.getNumAvailable() + numDonated);
                System.out.println("Donation accepted: " + dvd.getTitle());
                System.out.println("Number of available copies: " + dvd.getNumAvailable() + "\n");
            }
        }
    }
}
