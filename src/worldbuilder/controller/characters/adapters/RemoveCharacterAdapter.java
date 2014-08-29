package worldbuilder.controller.characters.adapters;

import worldbuilder.controller.base.adapters.BaseRemoveAdapter;
import worldbuilder.controller.characters.CharactersController;

/**
 * Selection adapter for removing characters
 *
 * @author Stefan Brus
 *
 */

public class RemoveCharacterAdapter extends BaseRemoveAdapter<CharactersController> {

    /**
     * Constructor
     *
     * @param controller Reference to the controller
     */

    public RemoveCharacterAdapter(CharactersController controller) {
        super(controller);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void clearEditor() {
        this.controller.getView().getEditor().getBirthYearField().setSelection(0);
        this.controller.getView().getEditor().getBirthPlaceField().setItems(new String[0]);
        this.controller.getView().getEditor().getBackgroundField().setText("");
    }
}
