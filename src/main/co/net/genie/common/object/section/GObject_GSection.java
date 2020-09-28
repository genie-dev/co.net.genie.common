package co.net.genie.common.object.section;

import co.net.genie.common.ValidateArgument;
import co.net.genie.common.annotations.NotNull;
import co.net.genie.common.field.GFieldError;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GObject_GField;
import co.net.genie.common.section.GSection_Abstract;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.validators.Validator_NotNull;

public class GObject_GSection
        <
                INTERFACE_OBJECT extends GObject_Interface,
                INTERFACE_FIELD extends GObject_GField<INTERFACE_OBJECT>
        >
extends GSection_Abstract
        <
                INTERFACE_FIELD
         >


{

    //******************** synchronized by this ********************
    INTERFACE_OBJECT interface_object = null;


    public GObject_GSection(GCode code) {
        super(code);
    }


    /**Sections may not reference parent object on section init, because object is not created yet.
     * First I will create Section, then I will create Object, then I will setup GObject for Section -> setup_GObject(...)
     *
     *
     */
    final synchronized public void setup_GObject(@NotNull INTERFACE_OBJECT interface_object) {
        new ValidateArgument(GObject_Interface.class, interface_object, new Validator_NotNull());
        this.interface_object = interface_object;

        for(INTERFACE_FIELD field : this) {
            field.setup_GObject(interface_object);
        }
    }

    @NotNull
    synchronized public INTERFACE_OBJECT getGObject() {
        if(interface_object == null) {
            throw new GFieldError(this + ": GObject not setup!");
        }
        return interface_object;
    }


}
