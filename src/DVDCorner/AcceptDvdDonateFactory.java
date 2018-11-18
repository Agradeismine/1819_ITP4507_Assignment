/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

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
    Vector _DVD;
    boolean cont = true;
    int id, numDonated;

    public AcceptDvdDonateFactory(Vector _DVD) {
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
                ex.printStackTrace();
            }
        }
        return new AcceptDvdDonate(_DVD, id, numDonated);
    }

}
