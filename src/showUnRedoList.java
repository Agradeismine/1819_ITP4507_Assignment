
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class showUnRedoList implements DRSCommand {

    Caretaker ct;
    Vector _DVD;

    public showUnRedoList(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    public void execute() {
        ct.showUndoRedoList();
    }

}
