package worldbuilder.controller.base;

import worldbuilder.model.base.BaseObject;
import worldbuilder.view.base.BaseView;

/**
 * Controller interface.
 *
 * @author Stefan Brus
 *
 * @param <ObjectType> The model object type
 * @param <ViewType> The view type
 */

public interface IController<ObjectType extends BaseObject, ViewType extends BaseView<?>> {

    /**
     * Get the view
     *
     * @return The view
     */

    ViewType getView();

    /**
     * Save an object
     *
     * @param obj The object
     */

    void saveObject(ObjectType obj);

    /**
     * Refresh the view
     *
     * @param Whether or not the model has been updated
     */

    void refreshView(boolean modelUpdated);
}
