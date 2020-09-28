package co.net.genie.common.object.section;

import co.net.genie.common.handler.GHandlerException;
import co.net.genie.common.handler.GHandlerProhibition;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GObject_GField;
import co.net.genie.common.object.section.GObject_GSection;
import co.net.genie.common.section.GSection_GHandler_Abstract;
import co.net.genie.common.translator.GCode;

import java.util.concurrent.ExecutorService;

public abstract class GObject_GSection_GHandler_Abstract
            <
                    INTERFACE_OBJECT extends GObject_Interface,
                    SECTION extends GObject_GSection<INTERFACE_OBJECT, INTERFACE_FIELD>,
                    INTERFACE_FIELD extends GObject_GField<INTERFACE_OBJECT>


            >
extends GSection_GHandler_Abstract
        <
                    SECTION,
                    INTERFACE_FIELD

            >
{




    public GObject_GSection_GHandler_Abstract(ExecutorService executor) {
        super(executor);
    }




    @Override
    protected GCode do_GFieldAction_ValidateArgs(GCode code) throws GHandlerProhibition, GHandlerException {
        return code;
    }

    @Override
    protected String do_GFieldAction_OnBefore(GCode args_validated, String result_on_call) throws GHandlerProhibition, GHandlerException {
        return result_on_call;
    }

    @Override
    protected String do_GFieldAction_OnAction(GCode args_validated, String result_on_after_before) throws GHandlerProhibition, GHandlerException {
        return result_on_after_before;
    }

    @Override
    protected String do_GFieldAction_ValidateResult(GCode args_validated, String result_on_after_action) {
        return result_on_after_action;
    }

    @Override
    protected void do_GFieldAction_OnAfter(GCode args_validated, String result_validated) {

    }



}
