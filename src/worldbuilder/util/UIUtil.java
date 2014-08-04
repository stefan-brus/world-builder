package worldbuilder.util;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;

/**
 * Class containing static utility methods for UI stuff
 *
 * @author Stefan Brus
 *
 */

public class UIUtil {

    /**
     * Helper function to display a save error message box
     */

    public static void displayMessage(Shell shell, String title, String msg) {
        MessageBox msgBox = new MessageBox(shell, SWT.OK);
        msgBox.setText(title);
        msgBox.setMessage(msg);
        msgBox.open();
    }
}
