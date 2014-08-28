package worldbuilder.view.base;

import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.List;

/**
 * View interface
 *
 * @author Stefan Brus
 *
 * @param <EditorType> The editor's class
 */

public interface IView<EditorType extends BaseEditor> {

    /**
     * The layout object used by the views
     */

    Layout VIEW_LAYOUT = new GridLayout(2, false);

    /**
     * Get the list
     *
     * @return The list
     */

    List getList();

    /**
     * Get the editor
     *
     * @return The editor
     */

    EditorType getEditor();

    /**
     * Get the add button
     *
     * @return The add button
     */

    Button getAddButton();
}
