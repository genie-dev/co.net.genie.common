package co.net.genie.common.object.field;

import co.net.genie.common.object.GObject_Interface;

import java.util.concurrent.ExecutorService;

public class GMetadata_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface,
                METADATA extends GMetadata<INTERFACE_OBJECT, PRIM>,
                PRIM
        >
    extends GObject_GField_GHandler_Variable
        <
                    INTERFACE_OBJECT,
                    METADATA,
                    PRIM
            >


{
    public GMetadata_GHandler(ExecutorService executor) {
        super(executor);
    }
}
