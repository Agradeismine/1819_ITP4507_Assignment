import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class ExitFactory extends DRSFactory {

    Caretaker ct;
    Vector _DVD;

    public ExitFactory(Caretaker ct, Vector _DVD) {    //add caretaker
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        return new ExitCreator();
    }

}
