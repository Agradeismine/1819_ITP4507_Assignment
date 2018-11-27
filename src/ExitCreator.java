/**
 *
 * @author YipYi
 */
public class ExitCreator implements DRSCommand {

    public ExitCreator() {
    }

    @Override
    public void execute() {
        System.exit(0);		//exit
    }
    
}
