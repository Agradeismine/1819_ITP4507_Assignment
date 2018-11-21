package DVDCorner;

import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class Memento {

    Vector _origDVD;
    Vector _oldDVD;
    Vector _redoDVD;
    DVD undoDvd;
    int undoDvdNumAvailable;
    DVD redoDvd;
    int redoDvdNumAvailable;
    int[] undoDvdNumAva;       //fucking test
    int[] redoDvdNumAva;
    String info;

    Memento(Vector _DVD, String info) {
        this.info = info;
        this._origDVD = _DVD;      //冇斷relationship
        this._oldDVD = (Vector) _DVD.clone();
        if (_DVD.size() > 0) {
            //this.undoDvd = (DVD) _oldDVD.lastElement();
            //undoDvdNumAvailable = ((DVD) _oldDVD.lastElement()).getNumAvailable();

            undoDvdNumAva = new int[_DVD.size()];
            redoDvdNumAva = new int[_DVD.size()];
            for (int i = 0; i < _DVD.size(); i++) {
                undoDvdNumAva[i] = ((DVD) _DVD.get(i)).getNumAvailable();
            }
        }
    }

    public void undo() {

        _redoDVD = (Vector) _origDVD.clone();    //save for redo    may have problems
        //System.out.println("save for redo, _redoDVD: " + _redoDVD);    //test

        if (_origDVD.size() != _oldDVD.size()) {
            undoDvd = (DVD) _origDVD.lastElement();  //save for redo
            _origDVD.remove(undoDvd);    //// undo create
        } else {
            //redoDvd = (DVD) _origDVD.lastElement();           //save for redo, work but it is fucking
            //redoDvdNumAvailable = redoDvd.getNumAvailable();  //same

            for (int i = 0; i < undoDvdNumAva.length; i++) {
                redoDvdNumAva[i] = ((DVD) _origDVD.get(i)).getNumAvailable();
                ((DVD) _origDVD.get(i)).setNumAvailable(undoDvdNumAva[i]);
            }
            //System.out.println("_origDVD.lastElement(): " + _origDVD.lastElement());    //test
            //System.out.println("redoDvd = _origDVD.lastElement(): " + redoDvd);    //test
            //System.out.println("undoDvd: " + undoDvd);    //test

            //_origDVD.remove(_origDVD.lastElement());      //work but it is fucking
            //undoDvd.setNumAvailable(undoDvdNumAvailable); //same
            //_origDVD.add(undoDvd);                        //same
        }
        System.out.println("undo completed.\n");

        //_origDVD = _oldDVD;     
        //System.out.println("_origDVD: " + _origDVD);    //test
    }

    public void redo() {
        //System.out.println("_redoDVD: " + _redoDVD);    //test
        if (_origDVD.size() != _redoDVD.size()) {
            _origDVD.add(undoDvd);    //// undo create
        } else {
            //System.out.println("_origDVD.lastElement(): " + _origDVD.lastElement());    //test
            //System.out.println("redoDvdNumAvailable: " + redoDvdNumAvailable);    //test
            //System.out.println("redoDvd: " + redoDvd);    //test

//            _origDVD.remove(_origDVD.lastElement());          //work but it is fucking
//            redoDvd.setNumAvailable(redoDvdNumAvailable);
//            _origDVD.add(redoDvd);

            for (int i = 0; i < undoDvdNumAva.length; i++) {
                //redoDvdNumAva[i]= ((DVD)_origDVD.get(i)).getNumAvailable();
                ((DVD) _origDVD.get(i)).setNumAvailable(redoDvdNumAva[i]);
            }
        }
        System.out.println("redo completed.\n");
        //_origDVD = _redoDVD;

    }

    public String toString() {
        return info;
    }

}
