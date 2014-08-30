package worldbuilder.view.characters;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import worldbuilder.view.base.BaseEditor;
import worldbuilder.view.widgets.YearSpinner;

/**
 * The character editor component.
 *
 * @author Stefan Brus
 *
 */

public class CharacterEditor extends BaseEditor {

    /**
     * The year of birth spinner
     */

    private YearSpinner birthYearField;

    /**
     * The place of birth combo box
     */

    private Combo birthPlaceField;

    /**
     * The background text field
     */

    private Text backgroundField;

    /**
     * Constructor
     *
     * @param parent The parent component
     * @param style The style
     */

    public CharacterEditor(Composite parent, int style) {
        super(parent, style);
    }

    /**
     * Get the birth year field
     *
     * @return The birth year field
     */

    public Spinner getBirthYearField() {
        return this.birthYearField;
    }

    /**
     * Get the birth place field
     *
     * @return The birth place field
     */

    public Combo getBirthPlaceField() {
        return this.birthPlaceField;
    }

    /**
     * Get the background field
     *
     * @return The background field
     */

    public Text getBackgroundField() {
        return this.backgroundField;
    }

    @Override
    protected void initFields() {
        Label yearLbl = new Label(this, SWT.NONE);
        yearLbl.setText("Year of birth");

        this.birthYearField = new YearSpinner(this);

        Label placeLbl = new Label(this, SWT.NONE);
        placeLbl.setText("Place of birth");

        this.birthPlaceField = new Combo(this, SWT.NONE);

        Label backgroundLbl = new Label(this, SWT.NONE);
        backgroundLbl.setText("Background");

        this.backgroundField = new Text(this, SWT.MULTI | SWT.BORDER);
    }

}
