package co.net.genie.common.object.field;

import co.net.genie.common.object.field.GElement;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GSearch_GHandler_Abstract;
import co.net.genie.common.object.field.ValueGetProhibition;
import co.net.genie.common.translator.GCode;

import java.util.concurrent.ExecutorService;

public class GSearch_GHandler_Regexp
        <
                INTERFACE_OBJECT extends GObject_Interface,
                SEARCH extends GSearch<INTERFACE_OBJECT>

        >

extends GSearch_GHandler_Abstract
        <
                INTERFACE_OBJECT,
                SEARCH
        >
{
    public GSearch_GHandler_Regexp(ExecutorService executor, GCode... searched_elements_codes) {
        super(executor, searched_elements_codes);
    }

    @Override
    protected boolean do_verify_hasMatch(String search_string_validated) {

        if(search_string_validated == null) {
            return false;
        }


        for (GElement<INTERFACE_OBJECT, ?> element : getSearchedElements()) {

            String element_value;


            try {
                element_value = element.getValue_StringLocaleCompatible();
            }
            catch (ValueGetProhibition prhb) {
                return false;
            }

            if(search_string_validated.equals("") && (element_value.equals("") | element_value == null)) {
                return true;
            }
            else if(search_string_validated.toUpperCase().equals(element_value.toUpperCase())) {
                return true;
            }
            else {
                continue; //next element
            }

        }

        return false;

    }
}
