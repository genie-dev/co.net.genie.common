package co.net.genie.common.object.section;

import co.net.genie.common.field.GField;
import co.net.genie.common.handler.GHandler_Abstract;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GMetadata;
import co.net.genie.common.object.field.GMetadata_GHandler;
import co.net.genie.common.object.section.GObject_GSection_GHandler_Abstract;
import co.net.genie.common.object.section.GSection_GMetadata;

import java.util.concurrent.ExecutorService;

public class GSection_GMetadata_GHandler
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GObject_GSection_GHandler_Abstract
        <

                INTERFACE_OBJECT,
                GSection_GMetadata<INTERFACE_OBJECT>,
                GMetadata<INTERFACE_OBJECT, ?>


    >



{
    public GSection_GMetadata_GHandler(ExecutorService executor) {
        super(executor);
    }

    @Override
    protected GHandler_Abstract init_new_GField_GHandler(GField field) {
        return new GMetadata_GHandler(executor);
    }
}
