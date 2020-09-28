package co.net.genie.common.object.field;


import co.net.genie.common.datatype.GType_Boolean;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCode;

import java.util.HashSet;


public class GRole
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
        extends GObject_GField_Variable
        <
                INTERFACE_OBJECT,
                Boolean
        >

 {

    private final GPermission[] permissions;



    public GRole(GCode code, GPermission ... permissions) {
        super(code, new GType_Boolean(),false);

        this.permissions = permissions != null ? permissions : new GPermission[]{};

    }



    final public HashSet<GPermission> getPermissions() {

        HashSet<GPermission> permissions_copy = new HashSet<GPermission>();

        for (GPermission p : this.permissions) {

            if (p != null) {
                permissions_copy.add(p);
            }
        }

        return permissions_copy;

    }



}
