/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class ShowDVD implements DRSCommand {

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Vector _DVD;
    String line;

    public ShowDVD(Vector _DVD) {
        this._DVD = _DVD;
    }

    @Override
    public void execute() {
        try {
            System.out.println("Enter ID (a to show all):");
            line = br.readLine();
            System.out.println("\nDVD information");
            if (line.equals("a")) {
                System.out.println("ID\tTitle\t\tLength (mins)\tNo. available\tOther Info");
                for (int i = 0; i < _DVD.size(); i++) {
                    System.out.println(((DVD) _DVD.elementAt(i)).toString());
                }
                System.out.println();
            } else if (Library.isInteger(line)) {
                for (int i = 0; i < _DVD.size(); i++) {
                    DVD dvd = (DVD) _DVD.elementAt(i);
                    if (dvd.getDvdID() == Integer.parseInt(line)) {
                        System.out.println("ID: " + dvd.getDvdID());
                        System.out.println("Title: " + dvd.getTitle());
                        System.out.println("Length: " + dvd.getLength() + " min(s)");
                        System.out.println("Number of available copies: " + dvd.getNumAvailable());
                        if (dvd instanceof Movie) {
                            System.out.println("Director: " + ((Movie) dvd).getDirector()+"\n");
                        } else if (dvd instanceof MV) {
                            System.out.println("Director: " + ((MV) dvd).getSinger()+"\n");
                        }
                    }
                }
            }else{
                System.out.println("Please input correct ID.");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
