/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.io.*;
import java.lang.reflect.Constructor;
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
    String[] DVDCreateFactory = {"DVDCorner.CreateMovieFactory", "DVDCorner.CreateMvFactory"};
    Vector _DVD;
    DRSFactory df;

    public CreateDVDFactory() {
    }

    public CreateDVDFactory(Vector _DVD) {
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        try {
            System.out.println("Enter DVD type (mo=movie/mv=MV):");
            type = br.readLine();
            for (int i = 0; i < DVDtype.length; i++) {
                if (DVDtype[i].equals(type)) {
                    Constructor c = Class.forName(DVDCreateFactory[i]).getConstructor(Vector.class);
                    df = (DRSFactory) c.newInstance(_DVD);
                }
            }

        }catch(NullPointerException ex){
            ex.printStackTrace();
            System.out.println("No this type");
        } 
        catch (IOException ex) {
            ex.printStackTrace();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return df.FactoryMethod();
    }

}
