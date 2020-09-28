package co.net.genie.common.object.field;

import co.net.genie.common.ValidateArgument;
import co.net.genie.common.annotations.NotNull;
import co.net.genie.common.field.GField;
import co.net.genie.common.field.GFieldError;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.validators.Validator_NotNull;

public class GObject_GField
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GField


{

    //******************** synchronized by this ********************
    INTERFACE_OBJECT interface_object = null;

    public GObject_GField(GCode code) {
        super(code);
    }


    /**Do not use this method!!!
     * GField get GObject from Section, but Section gets it from GObject.
     * GFields have to setup reference to GObject after init.
     * On GField init, GObject instance may not be available.
     *
     * @param interface_object
     */
    synchronized public void setup_GObject(INTERFACE_OBJECT interface_object) {
        new ValidateArgument(GObject_Interface.class, interface_object, new Validator_NotNull());
        this.interface_object = interface_object;
    }


    @NotNull
    synchronized public INTERFACE_OBJECT getGObject() {
        if(interface_object == null) {
            throw new GFieldError(this + ": GObject not setup!");
        }
        return interface_object;
    }

    @Override
    public String toString() {

        String args = this.getGArgs().size() > 0 ? "[" + this.getGArgs() + "]" : "";

        if (getGObject() != this) {
            return getGObject().toString() + "#" + getGCode() + args;
        }
        else {
            return this.getClass().getSimpleName() + "#" + getGCode() + args;
        }



    }
}
