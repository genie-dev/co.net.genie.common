package co.net.genie.common.object.field;

import co.net.genie.common.ValidateArgument;
import co.net.genie.common.annotations.Nullable;
import co.net.genie.common.collection.GCollectionError;
import co.net.genie.common.handler.GHandlerException;
import co.net.genie.common.handler.GHandlerProhibition;
import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GElement;
import co.net.genie.common.object.field.GObject_GField_GHandler;
import co.net.genie.common.object.field.GSearch;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.validators.Validator_RangeNotEmptyNoNulls;

import java.util.LinkedHashSet;
import java.util.concurrent.ExecutorService;

public abstract class GSearch_GHandler_Abstract
        <
                INTERFACE_OBJECT extends GObject_Interface,
                SEARCH extends GSearch<INTERFACE_OBJECT>
        >
    extends GObject_GField_GHandler
        <
                    INTERFACE_OBJECT,
                    SEARCH,
                    String,
                    Boolean
            >


{

    //********************** immutable ********************
    private final GCode[] searched_elements_codes;

    //************** synchronized on this ********************
    private LinkedHashSet<GElement<INTERFACE_OBJECT, ?>> searched_elements = new LinkedHashSet<>();



    public GSearch_GHandler_Abstract(ExecutorService executor, GCode...searched_elements_codes) {
        super(executor);
        new ValidateArgument(GCode.class, searched_elements_codes,  new Validator_RangeNotEmptyNoNulls());

        this.searched_elements_codes = searched_elements_codes;

    }

    @Override
    synchronized protected void setup_GField_Related_Items(@Nullable SEARCH field) {
        searched_elements.clear();

        if(getGField() != null) {

            for(GCode code : searched_elements_codes) {

                try {
                    GElement<INTERFACE_OBJECT, ?> searched_element = getGObject().getGElements().get(code);
                    searched_elements.add(searched_element);

                }
                catch (Throwable err) {
                    LOGGER.error(this + ": not valid searched element code: '" + code + "' !");
                }


            }
        }
    }


    abstract protected boolean do_verify_hasMatch(String search_string_validated);

    final synchronized public LinkedHashSet<GElement<INTERFACE_OBJECT, ?>> getSearchedElements() {

        if(this.searched_elements.isEmpty()) {
            throw new GCollectionError(this + " searched elements not setup yet!");
        }

        LinkedHashSet<GElement<INTERFACE_OBJECT, ?>> searched_elements_copy = new LinkedHashSet<>();
        searched_elements_copy.addAll(this.searched_elements);

        return searched_elements_copy;
    }

    @Override
    protected String do_GFieldAction_ValidateArgs(String search_string) throws GHandlerProhibition, GHandlerException {
        return search_string;
    }

    @Override
    protected Boolean do_GFieldAction_OnBefore(String search_string_validated, Boolean result_on_call) throws GHandlerProhibition, GHandlerException {
        return result_on_call;
    }

    @Override
    protected Boolean do_GFieldAction_OnAction(String search_string_validated, Boolean result_on_after_before) throws GHandlerProhibition, GHandlerException {
        return do_verify_hasMatch(search_string_validated);
    }

    @Override
    protected Boolean do_GFieldAction_ValidateResult(String search_string_validated, Boolean result_on_after_action) {
        return result_on_after_action;
    }

    @Override
    protected void do_GFieldAction_OnAfter(String args_validated, Boolean result_validated) {

    }
}
