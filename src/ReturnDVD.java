
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class ReturnDVD implements DRSCommand {
    Caretaker ct;
    Vector _DVD;
    int id;
    DVD dvd;

    public ReturnDVD(Caretaker ct, Vector _DVD, int id) {
        this.ct = ct;
        this._DVD = _DVD;
        this.id = id;
    }

    @Override
    public void execute() {
        for (int i = 0; i < _DVD.size(); i++) {
            if (((DVD) _DVD.elementAt(i)).getDvdID() == id) {
                dvd = ((DVD) _DVD.elementAt(i));
                                ct.save(_DVD, ("Get back "+id+" "+dvd.getTitle()));
                    dvd.setNumAvailable(dvd.getNumAvailable() + 1);
                    System.out.println("Returned: " + dvd.getTitle());
                    System.out.println("Number of available copies: " + dvd.getNumAvailable() + "\n");
            }
        }
    }
//
//    @Override
//    public void undo() {
//        if(dvd!=null){
//            dvd.setNumAvailable(dvd.getNumAvailable() - 1);
//        }
//    }

    @Override
    public String toString() {
        return "";
    }


}
