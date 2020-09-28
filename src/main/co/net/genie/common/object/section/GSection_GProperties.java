package co.net.genie.common.object.section;


import co.net.genie.common.datatype.GType_Boolean;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GProperty;
import co.net.genie.common.section.NoSuchGFieldException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GCodes_GObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("rawtypes")
public class GSection_GProperties
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GSection_GField_Variable
        <
                INTERFACE_OBJECT,
                GProperty<INTERFACE_OBJECT, ?>
        >
{

    private final static GCode CODE_DEFAULT = new GCode("PROPERTIES", "SET of GObject PROPERTIES");

    public final GProperty<INTERFACE_OBJECT, Boolean> Support_Identify = new GProperty<>(GCodes_GObject.Support_Identify, new GType_Boolean(), true);
    public final GProperty<INTERFACE_OBJECT, Boolean> Support_Read = new GProperty<>(GCodes_GObject.Support_Read, new GType_Boolean(), true);

    public GSection_GProperties() {
        super(CODE_DEFAULT);
    }

    public GSection_GProperties(GCode code) {
        super(code);
    }

    @Override
    public LinkedHashSet<GProperty<INTERFACE_OBJECT, ?>> getGFields() {
        return super.getGFields();
    }

    @Override
    public GProperty<INTERFACE_OBJECT, ?> get(GCode code) throws NoSuchGFieldException {
        return super.get(code);
    }

    @Override
    public GProperty<INTERFACE_OBJECT, ?> get(String code_string) throws NoSuchGFieldException {
        return super.get(code_string);
    }

    @Override
    public boolean contains(GProperty<INTERFACE_OBJECT, ?> field) {
        return super.contains(field);
    }

    @Override
    public boolean containsAll(Collection<GProperty<INTERFACE_OBJECT, ?>> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<GProperty<INTERFACE_OBJECT, ?>> iterator() {
        return getGFields().iterator();
    }


}
