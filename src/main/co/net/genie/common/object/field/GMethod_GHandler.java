package co.net.genie.common.object.field;

import co.net.genie.common.handler.GHandlerException;
import co.net.genie.common.handler.GHandlerProhibition;
import co.net.genie.common.object.GObject_Interface;

import java.util.concurrent.ExecutorService;

public class GMethod_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface,
                METHOD extends GMethod<INTERFACE_OBJECT, METH_ARGS, METH_RESULT>,
                METH_ARGS,
                METH_RESULT
        >
extends GObject_GField_GHandler
        <
                INTERFACE_OBJECT,
                METHOD,
                METH_ARGS,
                METH_RESULT
        >
{


    public GMethod_GHandler(ExecutorService executor) {
        super(executor);
    }

    @Override
    protected METH_ARGS do_GFieldAction_ValidateArgs(METH_ARGS meth_args) throws GHandlerProhibition, GHandlerException {
        return meth_args;
    }

    @Override
    protected METH_RESULT do_GFieldAction_OnBefore(METH_ARGS args_validated, METH_RESULT result_on_call) throws GHandlerProhibition, GHandlerException {
        return result_on_call;
    }

    @Override
    protected METH_RESULT do_GFieldAction_OnAction(METH_ARGS args_validated, METH_RESULT result_on_after_before) throws GHandlerProhibition, GHandlerException {
        return result_on_after_before;
    }

    @Override
    protected METH_RESULT do_GFieldAction_ValidateResult(METH_ARGS args_validated, METH_RESULT result_on_after_action) {
        return result_on_after_action;
    }

    @Override
    protected void do_GFieldAction_OnAfter(METH_ARGS args_validated, METH_RESULT result_validated) {

    }


}
