package co.net.genie.common.object.section;

import co.net.genie.common.field.GField;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GStatus;
import co.net.genie.common.object.field.GStatus_GHandler;
import co.net.genie.common.object.section.GObject_GSection_GHandler_Abstract;
import co.net.genie.common.object.section.GSection_GStatuses;

import java.util.concurrent.ExecutorService;

public class GSection_GStatuses_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GObject_GSection_GHandler_Abstract
        <

                INTERFACE_OBJECT,
                GSection_GStatuses<INTERFACE_OBJECT>,
                GStatus<INTERFACE_OBJECT>


        >



{
    public GSection_GStatuses_GHandler(ExecutorService executor) {
        super(executor);
    }

    @Override
    protected GHandler_Abstract init_new_GField_GHandler(GField field) {
        return new GStatus_GHandler(executor);
    }
}
