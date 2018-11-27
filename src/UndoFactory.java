
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class UndoFactory extends DRSFactory {

    Caretaker ct;
    Vector _DVD;

    public UndoFactory(Caretaker ct, Vector _DVD) {    //add caretaker
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        return new UndoCreator(ct, _DVD);
    }

}
