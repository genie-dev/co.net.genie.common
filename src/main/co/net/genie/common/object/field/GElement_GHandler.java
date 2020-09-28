package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;

import java.util.concurrent.ExecutorService;

public class GElement_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface,
                ELEMENT extends GElement<INTERFACE_OBJECT, PRIM>,
                PRIM
        >
    extends GObject_GField_GHandler_Variable
        <
                    INTERFACE_OBJECT,
                    ELEMENT,
                    PRIM
            >


{
    public GElement_GHandler(ExecutorService executor) {
        super(executor);
    }
}
