/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DVDCorner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author YipYi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        int command;
        String[] factoryCmd = {"DVDCorner.CreateDVDFactory", "DVDCorner.ShowDVDFactory", "DVDCorner.DonateDVDFactory", "DVDCorner.LendDVDFactory", "DVDCorner.ReturnDVDFactory"};

        boolean cont = true;
        while (cont) {
            try {
                while (cont) {
                    System.out.println("DVD Record System");
                    System.out.println("Please enter command: [c | s | a | l | g | u | r | d | x]");
                    System.out.println("c = create DVD, s = show DVD, a = accept donation of DVD, l = lend out a DVD, g = get back a returned DVD, u = undo, r = redo, d = display undo/redo list, x = exit system\n");
                    command = Integer.parseInt(br.readLine());
                    
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
