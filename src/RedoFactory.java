
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class RedoFactory extends DRSFactory {

    Caretaker ct;
    Vector _DVD;

    public RedoFactory(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        return new RedoCreator(ct, _DVD);
    }

}
