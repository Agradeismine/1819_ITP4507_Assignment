package DVDCorner;

/**
 *
 * @author YipYi
 */
public class DVD {
    private int dvdID;
    private String title;
    private int length;
    private int numAvailable;

    public DVD(int dvdID, String title, int length, int numAvailable) {
        this.dvdID = dvdID;
        this.title = title;
        this.length = length;
        this.numAvailable = numAvailable;
    }

    public int getDvdID() {
        return dvdID;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public int getNumAvailable() {
        return numAvailable;
    }

    public void setNumAvailable(int numAvailable) {
        this.numAvailable = numAvailable;
    }
    
    public String toString(){
        return "";
    }
    
}
