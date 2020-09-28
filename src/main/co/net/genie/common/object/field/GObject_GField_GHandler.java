package co.net.genie.common.object.field;

import co.net.genie.common.annotations.Nullable;
import co.net.genie.common.field.GField;
import co.net.genie.common.handler.GHandlerException;
import co.net.genie.common.handler.GHandlerProhibition;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GObject_GField;

import java.util.concurrent.ExecutorService;

public class GObject_GField_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface,
                FIELD extends GObject_GField<INTERFACE_OBJECT>,
                ARGS,
                RESULT
        >
extends GHandler_Abstract
        <

                FIELD,
                ARGS,
                RESULT
        >
{






    public GObject_GField_GHandler(ExecutorService executor) {
        super(executor);

    }


    @Override
    protected void setup_GField_Related_Items(FIELD field) {
        //No need for this method for GField.
        //Actually this method is used only for GObject and for GSection
    }


    final public INTERFACE_OBJECT getGObject() {
        return (getGField() != null ? getGField().getGObject() : null);
    }


    @Override
    protected ARGS do_GFieldAction_ValidateArgs(ARGS args) throws GHandlerProhibition, GHandlerException {
        return args;
    }

    @Override
    @Nullable
    protected RESULT do_GFieldAction_OnBefore(ARGS args_validated, @Nullable RESULT result_on_call) throws GHandlerProhibition, GHandlerException {
        return result_on_call;
    }

    @Override
    protected RESULT do_GFieldAction_OnAction(ARGS args_validated, @Nullable RESULT result_on_after_before) throws GHandlerProhibition, GHandlerException {
        return result_on_after_before;
    }

    @Override
    protected RESULT do_GFieldAction_ValidateResult(ARGS args_validated, @Nullable RESULT result_on_after_action) {
        return result_on_after_action;
    }

    @Override
    protected void do_GFieldAction_OnAfter(ARGS args_validated, RESULT result_validated) {

    }


}
