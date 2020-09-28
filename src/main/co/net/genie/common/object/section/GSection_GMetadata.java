package co.net.genie.common.object.section;


import co.net.genie.common.datatype.GType_String;
import co.net.genie.common.object.field.GMetadata;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.section.NoSuchGFieldException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GCodes_GObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("rawtypes")
public class GSection_GMetadata
        <

                INTERFACE_OBJECT extends GObject_Interface
        >
extends GSection_GField_Variable
        <
                INTERFACE_OBJECT,
                GMetadata<INTERFACE_OBJECT, ?>
        >
{


    private final static GCode CODE_DEFAULT = new GCode("METADATA", "SET of GObject METADATA");


    public final GMetadata<INTERFACE_OBJECT, String> meta_Creator = new GMetadata<>(GCodes_GObject.Creator, new GType_String(100), "unknown");



    public GSection_GMetadata() {
        super(CODE_DEFAULT);
    }

    public GSection_GMetadata(GCode code) {
        super(code);
    }


    @Override
    public LinkedHashSet<GMetadata<INTERFACE_OBJECT, ?>> getGFields() {
        return super.getGFields();
    }

    @Override
    public GMetadata<INTERFACE_OBJECT, ?> get(GCode code) throws NoSuchGFieldException {
        return super.get(code);
    }

    @Override
    public GMetadata<INTERFACE_OBJECT, ?> get(String code_string) throws NoSuchGFieldException {
        return super.get(code_string);
    }

    @Override
    public boolean contains(GMetadata<INTERFACE_OBJECT, ?> field) {
        return super.contains(field);
    }

    @Override
    public boolean containsAll(Collection<GMetadata<INTERFACE_OBJECT, ?>> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<GMetadata<INTERFACE_OBJECT, ?>> iterator() {
        return getGFields().iterator();
    }



}
