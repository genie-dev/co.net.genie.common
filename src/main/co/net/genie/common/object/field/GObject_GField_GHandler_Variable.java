package co.net.genie.common.object.field;

import co.net.genie.common.object.field.GObject_GField_GHandler;
import co.net.genie.common.object.field.GObject_GField_Variable;
import co.net.genie.common.handler.GHandlerException;
import co.net.genie.common.handler.GHandlerProhibition;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.validators.ValidatorProhibition;

import java.util.concurrent.ExecutorService;

public class GObject_GField_GHandler_Variable
        <
                INTERFACE_OBJECT extends GObject_Interface,
                FIELD extends GObject_GField_Variable<INTERFACE_OBJECT, PRIM>,
                PRIM

        >

    extends GObject_GField_GHandler
        <
                    INTERFACE_OBJECT,
                    FIELD,
                    PRIM,
                    PRIM
            >

{


    public GObject_GField_GHandler_Variable(ExecutorService executor) {
        super(executor);
    }

    @Override
    protected PRIM do_GFieldAction_ValidateArgs(PRIM args) throws GHandlerProhibition, GHandlerException {
        try {
            return (getGField() != null ? getGField().validate_Value(args) : args);
        }
        catch (ValidatorProhibition prhb) {
            throw new GHandlerProhibition(prhb);
        }
    }

    @Override
    protected PRIM do_GFieldAction_OnBefore(PRIM args_validated, PRIM result_on_call) throws GHandlerProhibition, GHandlerException {
        return result_on_call;
    }

    @Override
    protected PRIM do_GFieldAction_OnAction(PRIM args_validated, PRIM result_on_after_before) throws GHandlerProhibition, GHandlerException {

        try {

            if(getGField() != null) {
                getGField().setup_Value(result_on_after_before);
            }

        }
        catch (ValidatorProhibition prhb) {
            throw new GHandlerProhibition(prhb);
        }
        return result_on_after_before;
    }

    @Override
    protected PRIM do_GFieldAction_ValidateResult(PRIM args_validated, PRIM result_on_after_action) {
        return result_on_after_action;
    }

    @Override
    protected void do_GFieldAction_OnAfter(PRIM args_validated, PRIM result_validated) {

    }






}
