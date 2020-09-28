package co.net.genie.common.object;

import co.net.genie.common.handler.GHandlerException;
import co.net.genie.common.handler.GHandlerProhibition;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.object.section.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutorService;

public abstract class GObject_GHandler_Abstract
        <

                OBJECT extends GObject_Abstract,
                ARGS,
                RESULT

        >
extends GHandler_Abstract
        <

                OBJECT,
                ARGS,
                RESULT
        >
{

    static final protected Logger LOGGER = LogManager.getLogger(GObject_GHandler_Abstract.class);



    public GObject_GHandler_Abstract(ExecutorService executor) {
        super(executor);
    }


    @Override
    protected void setup_GField_Related_Items(OBJECT object) {

        object.METADATA.setup_GHandler(init_new_GSection_GMetadata_GHandler(object.METADATA));
        object.ROLES.setup_GHandler(init_new_GSection_GRoles_GHandler(object.ROLES));
        object.PERMISSIONS.setup_GHandler(init_new_GSection_GPermissions_GHandler(object.PERMISSIONS));
        object.PROPERTIES.setup_GHandler(init_new_GSection_GProperties_GHandler(object.PROPERTIES));
        object.STATUSES.setup_GHandler(init_new_GSection_GStatuses_GHandler(object.STATUSES));
        object.ELEMENTS.setup_GHandler(init_new_GSection_GElements_GHandler(object.ELEMENTS));
        object.METHODS.setup_GHandler(init_new_GSection_GMethods_GHandler(object.METHODS));
        object.SEARCHES.setup_GHandler(init_new_GSection_GSearches_GHandler(object.SEARCHES));

    }

    @Override
    protected ARGS do_GFieldAction_ValidateArgs(ARGS s) throws GHandlerProhibition, GHandlerException {
        return s;
    }

    @Override
    protected RESULT do_GFieldAction_OnBefore(ARGS args_validated, RESULT result_on_call) throws GHandlerProhibition, GHandlerException {
        return result_on_call;
    }

    @Override
    protected RESULT do_GFieldAction_OnAction(ARGS args_validated, RESULT result_on_after_before) throws GHandlerProhibition, GHandlerException {
        return result_on_after_before;
    }

    @Override
    protected RESULT do_GFieldAction_ValidateResult(ARGS args_validated, RESULT result_on_after_action) {
        return result_on_after_action;
    }

    @Override
    protected void do_GFieldAction_OnAfter(ARGS args_validated, RESULT result_validated) {

    }

    protected abstract GSection_GMetadata_GHandler init_new_GSection_GMetadata_GHandler(GSection_GMetadata<OBJECT> section_metadata);

    protected abstract GSection_GRoles_GHandler init_new_GSection_GRoles_GHandler(GSection_GRoles<OBJECT> section_roles);

    protected abstract GSection_GPermissions_GHandler init_new_GSection_GPermissions_GHandler(GSection_GPermissions<OBJECT> section_permissions);

    protected abstract GSection_GProperties_GHandler init_new_GSection_GProperties_GHandler(GSection_GProperties<OBJECT> section_properties);

    protected abstract GSection_GStatuses_GHandler init_new_GSection_GStatuses_GHandler(GSection_GStatuses<OBJECT> section_statuses);

    protected abstract GSection_GElements_GHandler init_new_GSection_GElements_GHandler(GSection_GElements<OBJECT> section_elements);

    protected abstract GSection_GMethods_GHandler init_new_GSection_GMethods_GHandler(GSection_GMethods<OBJECT> section_methods);

    protected abstract GSection_GSearches_GHandler init_new_GSection_GSearches_GHandler(GSection_GSearches<OBJECT> section_seaches);




}
