/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import static DVDCorner.Library.isInteger;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class ReturnDVDFactory extends DRSFactory {

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Caretaker ct;
    Vector _DVD;
    int id;
    boolean cont = true;
    String line;

    public ReturnDVDFactory(Caretaker ct, Vector _DVD) {
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        while (cont) {
            try {
                while (cont) {
                    System.out.println("Enter ID:");
                    line = br.readLine();
                    if (isInteger(line)) {
                        id = Integer.parseInt(br.readLine());
                        cont = false;
                    } else {
                                        System.out.println("Please input correct ID.");
                    }
                }
            } catch (Exception ex) {
                //ex.printStackTrace();
            }
        }

        return new ReturnDVD(ct, _DVD, id);
    }

}
