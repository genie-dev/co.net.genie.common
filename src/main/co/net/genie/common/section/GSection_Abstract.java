package co.net.genie.common.section;


import co.net.genie.common.GError;
import co.net.genie.common.annotations.NotNull;
import co.net.genie.common.field.GField;
import co.net.genie.common.logging.LogMarker_Common;
import co.net.genie.common.object.section.GObject_GSection;
import co.net.genie.common.translator.GCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;


public class GSection_Abstract
        <
                INTERFACE_FIELD extends GField
        >
    extends GField

    implements Iterable<INTERFACE_FIELD> {

    static final protected Logger LOGGER = LogManager.getLogger(GSection_Abstract.class);

    //************* synchronized on this ******************
    //lazy setup only once on first get...
    private final LinkedHashSet<INTERFACE_FIELD> fields = new LinkedHashSet<>();

    //***************** immutables *************************



    public GSection_Abstract(@NotNull GCode code) {
        super(code);
    }




    public LinkedHashSet<INTERFACE_FIELD> getGFields() {

        /**Sometimes I have to override this method => so this is not final method.
         * For example some Section may want to perform some extra tasks on Fields, before returning.
         * One such a case is when Indexes verify if there is one and only one primary index.
         *
         */


        //This is actually a copy of fields. This set is returned by method.
        //Do not return actual fields set.
        LinkedHashSet<INTERFACE_FIELD> found_fields = new LinkedHashSet<INTERFACE_FIELD>();

        //*******************************************
        // being lazy, if fields already known...

        synchronized (this) {

            if (fields.size() > 0) {

                found_fields.addAll(fields);

                return found_fields;
            }
        }

        //********************************************************
        // first get of fields, start to looking for my fields ...

        Class<GSection_Abstract> clazz = (Class<GSection_Abstract>) this.getClass();

        Field[] clazz_fields = clazz.getFields();


        for (Field fld : clazz_fields) {

            if(fld.getName().length() > 5 && fld.getName().substring(0, 5).equals("this$")) {
                continue;
            }


            try {

                fld.setAccessible(true);

                //skip static fields...
                if(!Modifier.isStatic(fld.getModifiers())) {

                    //Only fields of INTERFACE_FIELD accepted
                    @SuppressWarnings("unchecked")
                    INTERFACE_FIELD field = (INTERFACE_FIELD) fld.get(this);

                    found_fields.add(field);
                }



            }
            catch (ClassCastException not_interface_field) {
                LOGGER.trace(this.toString() + " has field not of type INTERFACE_FIELD : '" + fld.getDeclaringClass().getSimpleName() + "#" + fld.getName() + "'. Ignoring");
                continue;
            }
            catch (Throwable err) {

                //Ultimate failure.

                GError.ARGS error_args = new GError.ARGS();
                error_args.put("class", this.getClass().getSimpleName());
                error_args.put("field", fld.getName());
                if(this instanceof GObject_GSection) {
                    error_args.put("object", ((GObject_GSection) this).getGObject().toString());
                }


                throw new GError(LOGGER, LogMarker_Common.OBJECT, err, error_args);
            }

        }


        if (found_fields.size() < 1) {

            String errorMessage = this.toString() + " has no valid fields.";

            GError.ARGS error_args = new GError.ARGS();
            error_args.put("class", this.getClass().getSimpleName());
            error_args.put("found_fields.size()", found_fields.size() + "");
            if(this instanceof GObject_GSection) {
                error_args.put("object", ((GObject_GSection) this).getGObject().toString());
            }

            throw new GError(LOGGER, LogMarker_Common.OBJECT, errorMessage, error_args);

        }

        synchronized (this) {
            this.fields.addAll(found_fields);
        }

        return found_fields;

    }


    public INTERFACE_FIELD get(GCode code) throws NoSuchGFieldException {

        if(code == null) {
            throw new NoSuchGFieldException("Field **NULL** not found");
        }

        for (INTERFACE_FIELD field : getGFields()) {
            if (field.getGCode() == code) {
                return field;
            }
        }

        throw new NoSuchGFieldException("Field '" + code + "' not found");
    }

    public INTERFACE_FIELD get(String code_string) throws NoSuchGFieldException {

        if(code_string == null || code_string.length() == 0) {
            throw new NoSuchGFieldException("Field **NULL** not found");
        }

        for (INTERFACE_FIELD field : getGFields()) {
            if (field.getGCode().toString() == code_string) {
                return field;
            }
        }

        throw new NoSuchGFieldException("Field '" + code_string + "' not found");
    }


    public boolean contains(String code_string) {

        for(GField field : this) {
            if(field.getGCode().toString().equals(code_string)) {
                return true;
            }
        }

        return false;
    }

    public boolean contains(GCode code) {

        for(GField field : this) {
            if(field.getGCode() == code) {
                return true;
            }
        }

        return false;
    }

    public boolean contains(INTERFACE_FIELD field) {
        return getGFields().contains(field);
    }

    public boolean containsAll(Collection<INTERFACE_FIELD> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<INTERFACE_FIELD> iterator() {

        return getGFields().iterator();

    }




    final public boolean isEmpty() {
        return getGFields().isEmpty();
    }

    final public int size() {
        return getGFields().size();
    }

    final public Object[] toArray() {
        return getGFields().toArray();
    }

    final public <T> T[] toArray(T[] a) {
        return getGFields().toArray(a);
    }





}
