
import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author YipYi
 */
public class CreateDVDFactory extends DRSFactory {

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);

    String type = null;
    String[] DVDtype = {"mo", "mv"};
    String[] DVDCreateFactory = {"CreateMovieFactory", "CreateMvFactory"};
    Caretaker ct;
    Vector _DVD;
    DRSFactory df = null;

    public CreateDVDFactory() {
    }

    public CreateDVDFactory(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        try {
            System.out.println("Enter DVD type (mo=movie/mv=MV):");
            type = br.readLine();
            List<String> list = Arrays.asList(DVDtype);

            for (int i = 0; i < DVDtype.length; i++) {
                if (DVDtype[i].equals(type)) {
                    Constructor c = Class.forName(DVDCreateFactory[i]).getConstructor(Caretaker.class, Vector.class);
                    df = (DRSFactory) c.newInstance(ct, _DVD);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return df.FactoryMethod();
    }

}
