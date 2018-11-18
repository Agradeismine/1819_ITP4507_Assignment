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
public class ShowDVDFactory extends DRSFactory{
    Vector _DVD;

    public ShowDVDFactory(Vector _DVD) {
        this._DVD = _DVD;
    }
    
    @Override
    DRSCommand FactoryMethod() {
        return new ShowDVD(_DVD);
    }
    
}
