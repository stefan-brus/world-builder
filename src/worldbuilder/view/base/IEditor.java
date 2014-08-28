package worldbuilder.view.base;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Layout;

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
