
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class MvCreator implements DRSCommand {
    Caretaker ct;
    Vector _DVD;
    int dvdID, length, numAvailable;
    String title, singer;
    MV mv;

    public MvCreator(Caretaker ct, Vector _DVD, int dvdID, String title, int length, int numAvailable, String singer) {
        this.ct = ct;
        this._DVD = _DVD;
        this.dvdID = dvdID;
        this.length = length;
        this.numAvailable = numAvailable;
        this.title = title;
        this.singer = singer;
    }

    @Override
    public void execute() {
        ct.save(_DVD, ("Create "+dvdID+" "+title));

        mv = new MV(dvdID, title, length, numAvailable, singer);
        _DVD.add(mv);
        System.out.println("DVD record created.\n");
    }
//
//    @Override
//    public void undo() {
//        if (_DVD != null) {
//            _DVD.remove(mv);
//        }
//    }

}
