import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class MovieCreator implements DRSCommand {
    Caretaker ct;
    Vector _DVD;
    int dvdID, length, numAvailable;
    String title, director;
    Movie movie;

    public MovieCreator(Caretaker ct, Vector _DVD, int dvdID, String title, int length, int numAvailable, String director) {      //add caretaker
        this.ct = ct;
        this._DVD = _DVD;
        this.dvdID = dvdID;
        this.length = length;
        this.numAvailable = numAvailable;
        this.title = title;
        this.director = director;
    }

    @Override
    public void execute() {
//        ct.saveCreateMovie(this);
        ct.save(_DVD, ("Create "+dvdID+" "+title));
        movie = new Movie(dvdID, title, length, numAvailable, director);
        _DVD.add(movie);
        System.out.println("DVD record created.\n");
    }

//    @Override
//    public void undo() {
//        if(_DVD!= null){
//            _DVD.remove(movie);
//        }
//    }

}
