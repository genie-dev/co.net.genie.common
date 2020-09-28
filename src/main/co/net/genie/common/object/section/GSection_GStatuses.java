package co.net.genie.common.object.section;


import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GStatus;
import co.net.genie.common.section.NoSuchGFieldException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GCodes_GObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("rawtypes")
public class GSection_GStatuses
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GObject_GSection
        <
                INTERFACE_OBJECT,
                GStatus<INTERFACE_OBJECT>
        >

{


    private final static GCode CODE_DEFAULT = new GCode("STATUSES", "SET of GObject STATUSES");

    public final GStatus<INTERFACE_OBJECT> status_Derivative = new GStatus<>(GCodes_GObject.Status_Posted, false);

    public GSection_GStatuses() {
        super(CODE_DEFAULT);
    }

    public GSection_GStatuses(GCode code) {
        super(code);
    }

    @Override
    public LinkedHashSet<GStatus<INTERFACE_OBJECT>> getGFields() {
        return super.getGFields();
    }

    @Override
    public GStatus<INTERFACE_OBJECT> get(GCode code) throws NoSuchGFieldException {
        return super.get(code);
    }

    @Override
    public GStatus<INTERFACE_OBJECT> get(String code_string) throws NoSuchGFieldException {
        return super.get(code_string);
    }

    @Override
    public boolean contains(GStatus<INTERFACE_OBJECT> field) {
        return super.contains(field);
    }

    @Override
    public boolean containsAll(Collection<GStatus<INTERFACE_OBJECT>> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<GStatus<INTERFACE_OBJECT>> iterator() {
        return getGFields().iterator();
    }


}
