package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GObject_GField_GHandler_Variable;
import co.net.genie.common.object.field.GRole;

import java.util.concurrent.ExecutorService;

public class GRole_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface,
                ROLE extends GRole<INTERFACE_OBJECT>
        >
        extends GObject_GField_GHandler_Variable
        <
                        INTERFACE_OBJECT,
                        ROLE,
                        Boolean
                >


{
    public GRole_GHandler(ExecutorService executor) {
        super(executor);
    }
}
