package co.net.genie.common.object.section;


import co.net.genie.common.object.GObject_Interface;
import co.net.genie.common.object.field.GSearch;
import co.net.genie.common.section.NoSuchGFieldException;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.translator.GCodes_GObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;

@SuppressWarnings("rawtypes")
public class GSection_GSearches
        <
                INTERFACE_OBJECT extends GObject_Interface
        >
extends GObject_GSection
        <
                INTERFACE_OBJECT,
                GSearch<INTERFACE_OBJECT>
        >
{

    private final static GCode CODE_DEFAULT = new GCode("SEARCHES", "SET of GObject SEARCHES");

    public final GSearch<INTERFACE_OBJECT> Code_Name = new GSearch<>(GCodes_GObject.Search_Code_Name);


    public GSection_GSearches() {
        super(CODE_DEFAULT);
    }

    public GSection_GSearches(GCode code) {
        super(code);
    }

    @Override
    public LinkedHashSet<GSearch<INTERFACE_OBJECT>> getGFields() {
        return super.getGFields();
    }

    @Override
    public GSearch<INTERFACE_OBJECT> get(GCode code) throws NoSuchGFieldException {
        return super.get(code);
    }

    @Override
    public GSearch<INTERFACE_OBJECT> get(String code_string) throws NoSuchGFieldException {
        return super.get(code_string);
    }

    @Override
    public boolean contains(GSearch<INTERFACE_OBJECT> field) {
        return super.contains(field);
    }

    @Override
    public boolean containsAll(Collection<GSearch<INTERFACE_OBJECT>> collection) {
        return getGFields().containsAll(collection);
    }

    @Override
    public Iterator<GSearch<INTERFACE_OBJECT>> iterator() {
        return getGFields().iterator();
    }








}
