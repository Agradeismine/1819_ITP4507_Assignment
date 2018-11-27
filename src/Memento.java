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
    int[] undoDvdNumAva;
    int[] redoDvdNumAva;
    String info;

    Memento(Vector _DVD, String info) {
        this.info = info;
        this._origDVD = _DVD;
        this._oldDVD = (Vector) _DVD.clone();
        if (_DVD.size() > 0) {
            undoDvdNumAva = new int[_DVD.size()];
            redoDvdNumAva = new int[_DVD.size()];
            for (int i = 0; i < _DVD.size(); i++) {
                undoDvdNumAva[i] = ((DVD) _DVD.get(i)).getNumAvailable();
            }
        }
    }

    public void undo() {

        _redoDVD = (Vector) _origDVD.clone();    //save for redo    may have problems

        if (_origDVD.size() != _oldDVD.size()) {
            undoDvd = (DVD) _origDVD.lastElement();  //save for redo
            _origDVD.remove(undoDvd);    //// undo create
        } else {
            for (int i = 0; i < undoDvdNumAva.length; i++) {
                redoDvdNumAva[i] = ((DVD) _origDVD.get(i)).getNumAvailable();
                ((DVD) _origDVD.get(i)).setNumAvailable(undoDvdNumAva[i]);
            }
        }
        System.out.println("undo completed.\n");
    }

    public void redo() {
        if (_origDVD.size() != _redoDVD.size()) {
            _origDVD.add(undoDvd);    //// undo create
        } else {
            for (int i = 0; i < undoDvdNumAva.length; i++) {
                ((DVD) _origDVD.get(i)).setNumAvailable(redoDvdNumAva[i]);
            }
        }
        System.out.println("redo completed.\n");
    }

    public String toString() {
        return info;
    }

}
