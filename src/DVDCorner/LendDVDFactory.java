/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class LendDVDFactory extends DRSFactory {

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Vector _DVD;
    Stack operHist;
    int id;
    boolean cont = true;

    public LendDVDFactory(Vector _DVD) {
        this._DVD = _DVD;
//        this.operHist = operHist;
    }

    @Override
    DRSCommand FactoryMethod() {
        while (cont) {
            try {
                while (cont) {
                    System.out.println("Enter ID:");
                    id = Integer.parseInt(br.readLine());
                    cont = false;

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return new LendDVD(_DVD, id);
    }

}
