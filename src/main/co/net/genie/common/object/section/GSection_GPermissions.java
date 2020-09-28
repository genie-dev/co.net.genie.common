package co.net.genie.common.object.section;


import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GPermission;
import co.net.genie.common.section.NoSuchGFieldException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GCodes_GObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("rawtypes")
public class GSection_GPermissions
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GObject_GSection
        <
                INTERFACE_OBJECT,
                GPermission<INTERFACE_OBJECT>
        >
{

    private final static GCode CODE_DEFAULT = new GCode("PERMISSIONS", "SET of GObject PERMISSIONS");

    public final GPermission<INTERFACE_OBJECT> perm_do_Identify = new GPermission<>(GCodes_GObject.Permission_Identify, true);
    public final GPermission<INTERFACE_OBJECT> perm_do_Read = new GPermission<>(GCodes_GObject.Permission_Read, true);
    //TODO perm_grant_Identify
    //TODO perm_grant_Read
    //TODO perm_grant_Admin

    public GSection_GPermissions() {
        super(CODE_DEFAULT);
    }

    public GSection_GPermissions(GCode code) {
        super(code);
    }

    @Override
    public LinkedHashSet<GPermission<INTERFACE_OBJECT>> getGFields() {
        return super.getGFields();
    }

    @Override
    public GPermission<INTERFACE_OBJECT> get(GCode code) throws NoSuchGFieldException {
        return super.get(code);
    }

    @Override
    public GPermission<INTERFACE_OBJECT> get(String code_string) throws NoSuchGFieldException {
        return super.get(code_string);
    }

    @Override
    public boolean contains(GPermission<INTERFACE_OBJECT> field) {
        return super.contains(field);
    }

    @Override
    public boolean containsAll(Collection<GPermission<INTERFACE_OBJECT>> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<GPermission<INTERFACE_OBJECT>> iterator() {
        return getGFields().iterator();
    }



}
