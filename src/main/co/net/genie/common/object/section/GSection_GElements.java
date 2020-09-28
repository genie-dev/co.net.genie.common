package co.net.genie.common.object.section;


import co.net.genie.common.datatype.GType_GID;
import co.net.genie.common.datatype.GType_Integer;
import co.net.genie.common.datatype.GType_String;
import co.net.genie.common.id.GID;
import co.net.genie.common.object.field.GElement;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.section.NoSuchGFieldException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GCodes_GObject;
import co.net.genie.common.validators.Validator_AlwaysValid;
import co.net.genie.common.validators.Validator_NotNullNotZeroLength;
import co.net.genie.common.validators.Validator_PositiveOrZero;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("rawtypes")
public class GSection_GElements
        <
                INTERFACE_OBJECT extends GObject_Interface

        >
    extends GSection_GField_Variable
        <
                        INTERFACE_OBJECT,
                        GElement<INTERFACE_OBJECT, ?>
                >
{

    private final static GCode CODE_DEFAULT = new GCode("ELEMENTS", "SET of GObject ELEMENTS");


    public final GElement<INTERFACE_OBJECT, GID> ID = new GElement<INTERFACE_OBJECT, GID>(GCodes_GObject.ID, new GType_GID(), null, new Validator_AlwaysValid()) {
        @Override
        public boolean property_Editable() {
            return false;
        }
    };
    public final GElement<INTERFACE_OBJECT, String> CODE = new GElement<>(GCodes_GObject.CODE, new GType_String(25), "unknown", new Validator_NotNullNotZeroLength());
    public final GElement<INTERFACE_OBJECT, String> NAME = new GElement<>(GCodes_GObject.NAME, new GType_String(100), "unknown", new Validator_NotNullNotZeroLength());


    public GSection_GElements() {
        super(CODE_DEFAULT);
    }

    public GSection_GElements(GCode code) {
        super(code);
    }



    @Override
    public LinkedHashSet<GElement<INTERFACE_OBJECT, ?>> getGFields() {
        return super.getGFields();
    }

    @Override
    public GElement<INTERFACE_OBJECT, ?> get(GCode code) throws NoSuchGFieldException {
        return super.get(code);
    }

    @Override
    public GElement<INTERFACE_OBJECT, ?> get(String code_string) throws NoSuchGFieldException {
        return super.get(code_string);
    }

    @Override
    public boolean contains(GElement<INTERFACE_OBJECT, ?> field) {
        return super.contains(field);
    }

    @Override
    public boolean containsAll(Collection<GElement<INTERFACE_OBJECT, ?>> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<GElement<INTERFACE_OBJECT, ?>> iterator() {
        return getGFields().iterator();
    }


}
