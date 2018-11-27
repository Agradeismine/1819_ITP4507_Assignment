
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class CreateMvFactory extends DRSFactory {

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Caretaker ct;
    Vector _DVD;
    int dvdID = 0, length = 0, numAvailable = 0;
    String title = null, singer = null;
    String str;
    String[] strs;
    boolean cont = true;

    public CreateMvFactory(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        while (cont) {
            try {
                while (cont) {
                    System.out.println("Enter id, title, length, number of available copies, singer:");
                    str = br.readLine();
                    strs = str.split("[,]");           //separate the word to array

                    for (int i = 0; i < strs.length; i++) {
                        if ((strs[i].charAt(0) == ' ')) {       //remove the space which is the first letter
                            strs[i] = strs[i].substring(1);
                        }
                    }

                    if (strs.length == 5 && isInteger(strs[0]) && isInteger(strs[2]) && isInteger(strs[3])) {              //check the inputted data which have 5 values and correct type
                        dvdID = Integer.parseInt(strs[0]);
                        title = strs[1];
                        length = Integer.parseInt(strs[2]);
                        numAvailable = Integer.parseInt(strs[3]);
                        singer = strs[4];

                        cont = false;
                    } else {
                        System.out.println("Please input all valid information!");
                    }
                }

            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Please input all valid information!");
            } catch (Exception ex) {
            }

        }
        return new MvCreator(ct, _DVD, dvdID, title, length, numAvailable, singer);
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

}
