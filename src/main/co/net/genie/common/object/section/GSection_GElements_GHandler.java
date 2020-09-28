package co.net.genie.common.object.section;

import co.net.genie.common.field.GField;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GElement;
import co.net.genie.common.object.field.GElement_GHandler;

import java.util.concurrent.ExecutorService;

public class GSection_GElements_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface

        >
extends GObject_GSection_GHandler_Abstract
        <

                INTERFACE_OBJECT,
                GSection_GElements<INTERFACE_OBJECT>,
                GElement<INTERFACE_OBJECT, ?>
    >



{
    public GSection_GElements_GHandler(ExecutorService executor) {
        super(executor);
    }

    @Override
    protected GHandler_Abstract init_new_GField_GHandler(GField field) {
        return new GElement_GHandler(executor);
    }
}
