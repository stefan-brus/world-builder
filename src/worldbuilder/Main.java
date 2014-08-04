package worldbuilder;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import worldbuilder.controller.Controllers;
import worldbuilder.view.MainWindow;

/**
 * Main class.
 *
 * Creates the SWT display and shell, and the World Builder main window.
 *
 * @author Stefan Brus
 *
 */

public class Main {

    /**
     * Main function.
     *
     * @param args unused
     */

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);

        shell.setLayout(new FillLayout());

        MainWindow mainWindow = new MainWindow(shell, SWT.NONE);
        Controllers controllers = new Controllers(mainWindow);

        shell.pack();
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }
}
