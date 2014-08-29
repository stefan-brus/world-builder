package worldbuilder.controller.base.adapters;

import worldbuilder.controller.base.BaseController;
import worldbuilder.model.base.BaseObject;
import worldbuilder.view.base.BaseAddDialog;

/**
 * Base class for all open add dialog adapters.
 *
 * @author Stefan Brus
 *
 * @param <ObjectType> The type of the object
 * @param <DialogType> The type of the dialog
 * @param <ControllerType> The type of the controller
 */

public abstract class BaseAddDialogAdapter<ObjectType extends BaseObject, DialogType extends BaseAddDialog<ObjectType, ?>, ControllerType extends BaseController<ObjectType, ?>>
    extends BaseAdapter<ControllerType> {

    /**
     * The dialog to open
     */

    protected BaseAddDialog<ObjectType, ?> dialog;

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public BaseAddDialogAdapter(ControllerType controller) {
        super(controller);

        this.createDialog();
    }

    @Override
    protected void performAction() {
        ObjectType result = this.dialog.open();

        if (result != null) {
            this.controller.saveObject(result, true);
        }
    }

    /**
     * Override this, create the dialog
     */

    protected abstract void createDialog();
}
