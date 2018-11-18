/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

/**
 *
 * @author YipYi
 */
public class Movie extends DVD {

    private String director;

    public Movie(int dvdID, String title, int length, int numAvailable, String director) {
        super(dvdID, title, length, numAvailable);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return getDvdID() + "\t" + getTitle() + "\t\t" + getLength() + "\t\t" + getNumAvailable() + "\t" + getDirector();
    }

}
