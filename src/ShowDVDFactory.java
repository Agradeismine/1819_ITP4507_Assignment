
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class ShowDVDFactory extends DRSFactory{
    Vector _DVD;
    Caretaker ct;

    public ShowDVDFactory(Caretaker ct, Vector _DVD) {    //add caretaker
        this.ct = ct;
        this._DVD = _DVD;
    }
    
    @Override
    DRSCommand FactoryMethod() {
        return new ShowDVD(_DVD);
    }
    
}
