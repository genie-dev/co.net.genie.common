package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GObject_GField_GHandler_Variable;
import co.net.genie.common.object.field.GPermission;

import java.util.concurrent.ExecutorService;

public class GPermission_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface,
                PERMISSION extends GPermission<INTERFACE_OBJECT>
        >
    extends GObject_GField_GHandler_Variable
        <
                    INTERFACE_OBJECT,
                    PERMISSION,
                    Boolean
            >


{
    public GPermission_GHandler(ExecutorService executor) {
        super(executor);
    }
}
