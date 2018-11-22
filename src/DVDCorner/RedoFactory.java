/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

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
