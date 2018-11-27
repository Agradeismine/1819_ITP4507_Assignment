import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class LendDVD implements DRSCommand {

    Caretaker ct;
    Vector _DVD;
    Stack operHist;
    int id;
    DVD dvd;

    public LendDVD(Caretaker ct, Vector _DVD, int id) {
        this.ct = ct;
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
                    ct.save(_DVD, ("Lend " + id + " " + dvd.getTitle()));
                    dvd.setNumAvailable(dvd.getNumAvailable() - 1);
                    System.out.println("Lent out: " + dvd.getTitle());
                    System.out.println("Number of available copies: " + dvd.getNumAvailable() + "\n");
                } else {      //Lending a DVD with zero available copy will display a warning message
                    System.out.println("Invalid request (" + dvd.getTitle() + " has no available copy).\n");

                }
            }
        }
    }

}
