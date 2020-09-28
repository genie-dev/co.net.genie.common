package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GObject_GField_GHandler_Variable;
import co.net.genie.common.object.field.GProperty;

import java.util.concurrent.ExecutorService;

public class GProperty_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface,
                PROPERTY extends GProperty<INTERFACE_OBJECT, PRIM>,
                PRIM
        >
        extends GObject_GField_GHandler_Variable
        <
                INTERFACE_OBJECT,
                PROPERTY,
                PRIM
        >


{
    public GProperty_GHandler(ExecutorService executor) {
        super(executor);
    }
}
