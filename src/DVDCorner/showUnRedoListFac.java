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
