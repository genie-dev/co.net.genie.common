package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GObject_GField_GHandler_Variable;
import co.net.genie.common.object.field.GStatus;

import java.util.concurrent.ExecutorService;

public class GStatus_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface,
                STATUS extends GStatus<INTERFACE_OBJECT>

        >
    extends GObject_GField_GHandler_Variable
        <
                    INTERFACE_OBJECT,
                    STATUS,
                    Boolean
            >


{
    public GStatus_GHandler(ExecutorService executor) {
        super(executor);
    }
}
