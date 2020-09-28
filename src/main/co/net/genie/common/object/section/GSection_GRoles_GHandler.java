package co.net.genie.common.object.section;

import co.net.genie.common.field.GField;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GRole;
import co.net.genie.common.object.field.GRole_GHandler;
import co.net.genie.common.object.section.GObject_GSection_GHandler_Abstract;
import co.net.genie.common.object.section.GSection_GRoles;

import java.util.concurrent.ExecutorService;

public class GSection_GRoles_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GObject_GSection_GHandler_Abstract
        <

                INTERFACE_OBJECT,
                GSection_GRoles<INTERFACE_OBJECT>,
                GRole<INTERFACE_OBJECT>

    >



{
    public GSection_GRoles_GHandler(ExecutorService executor) {
        super(executor);
    }

    @Override
    protected GHandler_Abstract init_new_GField_GHandler(GField field) {
        return new GRole_GHandler(executor);
    }
}
