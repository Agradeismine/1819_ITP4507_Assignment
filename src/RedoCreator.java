
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class RedoCreator implements DRSCommand {

    Caretaker ct;
    Vector _DVD;

    public RedoCreator(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    public void execute() {
        ct.redo();
    }

}
