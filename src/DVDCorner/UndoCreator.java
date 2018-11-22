package DVDCorner;

import java.util.Vector;

public class UndoCreator implements DRSCommand {

    Caretaker ct;
    Vector _DVD;

    UndoCreator(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    public void execute() {
        ct.undo();
    }

}
