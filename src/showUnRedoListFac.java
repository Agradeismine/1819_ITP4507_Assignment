
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class showUnRedoListFac extends DRSFactory{
    Caretaker ct;
    Vector _DVD;

    public showUnRedoListFac(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }
    @Override
    DRSCommand FactoryMethod() {
        return new showUnRedoList(ct, _DVD);
    }
    
}
