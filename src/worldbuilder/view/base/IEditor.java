package worldbuilder.view.base;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Text;

/**
 * Editor component interface.
 *
 * @author Stefan Brus
 *
 */

public interface IEditor {

    /**
     * The layout object used by the editors
     */

    Layout EDITOR_LAYOUT = new GridLayout(2, false);

    /**
     * Get the name field
     *
     * @return The name field
     */

    Text getNameField();

    /**
     * Get the save button
     *
     * @return The save button
     */

    Button getSaveButton();

    /**
     * Get the remove button
     *
     * @return The remove button
     */

    Button getRemoveButton();
}
