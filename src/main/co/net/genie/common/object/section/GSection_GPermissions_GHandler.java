package co.net.genie.common.object.section;

import co.net.genie.common.field.GField;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GPermission;
import co.net.genie.common.object.field.GPermission_GHandler;
import co.net.genie.common.object.section.GObject_GSection_GHandler_Abstract;
import co.net.genie.common.object.section.GSection_GPermissions;

import java.util.concurrent.ExecutorService;

public class GSection_GPermissions_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GObject_GSection_GHandler_Abstract
        <
                INTERFACE_OBJECT,
                GSection_GPermissions<INTERFACE_OBJECT>,
                GPermission<INTERFACE_OBJECT>
        >



{
    public GSection_GPermissions_GHandler(ExecutorService executor) {
        super(executor);
    }

    @Override
    protected GHandler_Abstract init_new_GField_GHandler(GField field) {
        return new GPermission_GHandler(executor);
    }
}
