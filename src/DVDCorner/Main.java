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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector _DVD = new Vector();     //store the DVD
        Stack stack = new Stack();    //store the operation command

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String command;
        String[] factoryCmd = {"DVDCorner.CreateDVDFactory", "DVDCorner.ShowDVDFactory", "DVDCorner.DonateDVDFactory", "DVDCorner.LendDVDFactory", "DVDCorner.ReturnDVDFactory"};
        String[] inputCmd = {"c", "s", "a", "l", "g", "u", "r", "d", "x"};
        Set<String> accept = new HashSet<String>(Arrays.asList(inputCmd));
        String type = null;
        String[] DVDtype = {"mo", "mv"};
        String[] DVDCreateFactory = {"DVDCorner.CreateMovieFactory", "DVDCorner.CreateMvFactory"};
        DRSCommand drsCmd;

        boolean cont = true;
        while (cont) {
            try {
                while (cont) {
                    System.out.println("DVD Record System");
                    System.out.println("Please enter command: [c | s | a | l | g | u | r | d | x]");
                    System.out.println("c = create DVD, s = show DVD, a = accept donation of DVD, l = lend out a DVD, g = get back a returned DVD, u = undo, r = redo, d = display undo/redo list, x = exit system\n");
                    command = br.readLine();
                    if (accept.contains(command)) {             //check correct command
                        if (command.equals("x")) {
                            cont = false;
                        } else {
                            for (int i = 0; i < factoryCmd.length; i++) {   //not include undo, redo, delete
                                if (command.equals(inputCmd[i])) {    //check which command should be executed
                                    Constructor c = Class.forName(factoryCmd[i]).getConstructor(Vector.class);
                                    DRSFactory df = (DRSFactory) c.newInstance(_DVD);
                                    //DRSFactory df = (DRSFactory) Class.forName(factoryCmd[i]).newInstance();
                                    drsCmd = df.FactoryMethod();
                                    drsCmd.execute();
                                    if (!(drsCmd instanceof ShowDVD)) {
                                        stack.add(drsCmd);
                                    }
                                }
                            }
                        }

                    } else {
                        System.out.println("Please input a correct command!");
                        break;
                    }

                }
            } catch (NumberFormatException ex) {
                System.out.println("Please input a correct command!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
