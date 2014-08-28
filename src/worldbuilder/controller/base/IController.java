package worldbuilder.controller.base;

import java.util.List;

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
     * Get the object list
     *
     * @return The object list
     */

    List<ObjectType> getObjectList();

    /**
     * Save an object
     *
     * @param obj The object
     * @param add If true, add a new object, else save the current one
     */

    void saveObject(ObjectType obj, boolean add);

    /**
     * Refresh the view
     */

    void refreshView();
}
