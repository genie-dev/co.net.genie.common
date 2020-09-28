package co.net.genie.common.object.section;


import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GRole;
import co.net.genie.common.section.NoSuchGFieldException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GCodes_GObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("rawtypes")
public class GSection_GRoles
        <
                INTERFACE_OBJECT extends GObject_Interface
        >

extends GSection_GField_Variable
        <
                INTERFACE_OBJECT,
                GRole<INTERFACE_OBJECT>

        >
{

    private final static GCode CODE_DEFAULT = new GCode("ROLES", "SET of GObject ROLES");


    public final GRole<INTERFACE_OBJECT> Role_Owner = new GRole<>(GCodes_GObject.Role_Owner);
    public final GRole<INTERFACE_OBJECT> Role_Admin = new GRole<>(GCodes_GObject.Role_Admin);
    public final GRole<INTERFACE_OBJECT> Role_Identify = new GRole<>(GCodes_GObject.Role_Identify);
    public final GRole<INTERFACE_OBJECT> Role_Read = new GRole<>(GCodes_GObject.Role_Read);

    public GSection_GRoles() {
        super(CODE_DEFAULT);
    }

    public GSection_GRoles(GCode code) {
        super(code);
    }

    @Override
    public LinkedHashSet<GRole<INTERFACE_OBJECT>> getGFields() {
        return super.getGFields();
    }

    @Override
    public GRole<INTERFACE_OBJECT> get(GCode code) throws NoSuchGFieldException {
        return super.get(code);
    }

    @Override
    public GRole<INTERFACE_OBJECT> get(String code_string) throws NoSuchGFieldException {
        return super.get(code_string);
    }

    @Override
    public boolean contains(GRole<INTERFACE_OBJECT> field) {
        return super.contains(field);
    }

    @Override
    public boolean containsAll(Collection<GRole<INTERFACE_OBJECT>> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<GRole<INTERFACE_OBJECT>> iterator() {
        return getGFields().iterator();
    }



}
