/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class CreateMovieFactory extends DRSFactory {

    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    Caretaker ct;
    Vector _DVD;
    int dvdID = 0, length = 0, numAvailable = 0;
    String title = null, director = null;   //type = null,
    String str;
    String[] strs;
    boolean cont = true;

    public CreateMovieFactory(Caretaker ct, Vector _DVD) {    //add caretaker
        this.ct = ct;
        this._DVD = _DVD;
    }

    @Override
    DRSCommand FactoryMethod() {
        while (cont) {
            try {
                while (cont) {
                    System.out.println("Enter id, title, length, number of available copies, director:");
                    //dvdID = Integer.parseInt(br.readLine());
                    str = br.readLine();
                    //str = "1001, Forrest Gump, 182, 6, Robert Zemeckis";
                    strs = str.split("[,]");           //separate the word to array

                    for (int i = 0; i < strs.length; i++) {
                        if ((strs[i].charAt(0) == ' ')) {       //remove the space which is the first letter
                            strs[i] = strs[i].substring(1);
                        }
                        //System.out.println("strs[" + i + "]: " + strs[i]);      //test
                    }
                    
                    if (strs.length == 5 && isInteger(strs[0]) && isInteger(strs[2]) && isInteger(strs[3])) {              //check the inputted data
                        if (isInteger(strs[0]) && isInteger(strs[2]) && isInteger(strs[3])) {   //check some variable is correct type
                            dvdID = Integer.parseInt(strs[0]);
                            title = strs[1];
                            length = Integer.parseInt(strs[2]);
                            numAvailable = Integer.parseInt(strs[3]);
                            director = strs[4];
                        }
                        cont = false;
                    } else {
                        System.out.println("Please input all valid information!");

                    }
                }

            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("Please input all valid information!");
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }
        return new MovieCreator(ct, _DVD, dvdID, title, length, numAvailable, director);    //add caretaker
    }

    public boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

}
