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
public class ExitCreator implements DRSCommand {

    public ExitCreator() {
    }

    @Override
    public void execute() {
        System.exit(0);
    }
    
}
