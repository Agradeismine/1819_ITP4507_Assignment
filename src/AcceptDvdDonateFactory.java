

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class AcceptDvdDonateFactory extends DRSFactory {

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Caretaker ct;
    Vector _DVD;
    boolean cont = true;
    int id, numDonated;

    public AcceptDvdDonateFactory(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        while (cont) {
            try {
                while (cont) {
                    System.out.println("Enter ID:");
                    id = Integer.parseInt(br.readLine());
                    System.out.println("Enter number of copies donated:");
                    numDonated = Integer.parseInt(br.readLine());
                    cont = false;
                }
            } catch (Exception ex) {
                System.out.println("Please input correct ID.");
            }
        }
        return new AcceptDvdDonate(ct, _DVD, id, numDonated);
    }

}
