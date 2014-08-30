package worldbuilder.view.widgets;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Spinner;

/**
 * Custom widget for year spinners.
 *
 * Overrides checkSubClass to allow subclassing an SWT widget.
 *
 * @author Stefan Brus
 *
 */

public class YearSpinner extends Spinner {

    /**
     * Minimum bound for this spinner
     */

    private static final int MIN_BOUND = 0;

    /**
     * Maximum bound for this spinner
     */

    private static final int MAX_BOUND = 9999;

    /**
     * Constructor
     *
     * @param parent The parent component
     */

    public YearSpinner(Composite parent) {
        super(parent, SWT.BORDER);

        this.initSpinner();
    }

    @Override
    protected void checkSubclass() {

    }

    /**
     * Initialize the year spinner
     */

    private void initSpinner() {
        this.setMinimum(MIN_BOUND);
        this.setMaximum(MAX_BOUND);
    }
}
