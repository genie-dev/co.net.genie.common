package co.net.genie.common.object.section;


import co.net.genie.common.object.field.*;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.section.NoSuchGFieldException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GCodes_GObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("rawtypes")
public class GSection_GMethods
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GObject_GSection
        <
                INTERFACE_OBJECT,
                GMethod<INTERFACE_OBJECT, ?, ?>
        >
{

    public final static GCode CODE_DEFAULT = new GCode("METHODS", "SET of GObject METHODS");

    final public GMethod_Create Create = new GMethod_Create();
    final public GMethod_Identify<INTERFACE_OBJECT> Identify = new GMethod_Identify<>();
    final public GMethod_Read<INTERFACE_OBJECT> Read = new GMethod_Read<>();
    public final GMethod_Update Update = new GMethod_Update();

    public final GMethod<INTERFACE_OBJECT, String, String> Delete = new GMethod(GCodes_GObject.do_Delete);




    public GSection_GMethods() {
        super(CODE_DEFAULT);
    }

    public GSection_GMethods(GCode code) {
        super(code);
    }

    @Override
    public LinkedHashSet<GMethod<INTERFACE_OBJECT, ?, ?>> getGFields() {
        return super.getGFields();
    }

    @Override
    public GMethod<INTERFACE_OBJECT, ?, ?> get(GCode code) throws NoSuchGFieldException {
        return super.get(code);
    }

    @Override
    public GMethod<INTERFACE_OBJECT, ?, ?> get(String code_string) throws NoSuchGFieldException {
        return super.get(code_string);
    }

    @Override
    public boolean contains(GMethod<INTERFACE_OBJECT, ?, ?> field) {
        return super.contains(field);
    }

    @Override
    public boolean containsAll(Collection<GMethod<INTERFACE_OBJECT, ?, ?>> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<GMethod<INTERFACE_OBJECT, ?, ?>> iterator() {
        return getGFields().iterator();
    }

}
