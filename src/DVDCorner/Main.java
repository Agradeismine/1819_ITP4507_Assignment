/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author YipYi
 */
public class Main {

    public static void main(String[] args) {
        Vector _DVD = new Vector();         //store the DVD
        //Stack operHist = new Stack();       //store the operation command
        Caretaker ct = new Caretaker();     // Prepare a Caretaker for  the undo/redo operation

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String command;
        String[] factoryCmd = {"DVDCorner.CreateDVDFactory", "DVDCorner.ShowDVDFactory", "DVDCorner.AcceptDvdDonateFactory", "DVDCorner.LendDVDFactory", "DVDCorner.ReturnDVDFactory", "DVDCorner.UndoFactory", "DVDCorner.RedoFactory", "DVDCorner.showUnRedoListFac", "DVDCorner.ExitFactory"};
        String[] inputCmd = {"c", "s", "a", "l", "g", "u", "r", "d", "x"};
        Set<String> accept = new HashSet<String>(Arrays.asList(inputCmd));
        String[] DVDtype = {"mo", "mv"};
        String[] DVDCreateFactory = {"DVDCorner.CreateMovieFactory", "DVDCorner.CreateMvFactory"};
        DRSCommand drsCmd;

        while (true) {
            try {
                while (true) {
                    System.out.println("DVD Record System");
                    System.out.println("Please enter command: [c | s | a | l | g | u | r | d | x]");
                    System.out.println("c = create DVD, s = show DVD, a = accept donation of DVD, l = lend out a DVD, g = get back a returned DVD, u = undo, r = redo, d = display undo/redo list, x = exit system\n");
                    command = br.readLine();
                    if (accept.contains(command)) {             //check correct command
                        for (int i = 0; i < factoryCmd.length; i++) {
                            if (command.equals(inputCmd[i])) {    //check which command should be executed
                                Constructor c = Class.forName(factoryCmd[i]).getConstructor(Caretaker.class, Vector.class);
                                DRSFactory df = (DRSFactory) c.newInstance(ct, _DVD);
                                drsCmd = df.FactoryMethod();
                                drsCmd.execute();
                            }
                        }
                    } else {
                        System.out.println("No this command!");
                        break;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Please input a correct command!");
            }
        }
    }

}
