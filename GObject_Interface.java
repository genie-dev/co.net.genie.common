package co.net.genie.common.object;

import co.net.genie.common.id.GID;
import co.net.genie.common.object.section.*;
import co.net.genie.common.translator.GTranslationInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public interface GObject_Interface
<

		INTERFACE_METADATA extends GSection_GMetadata,
		INTERFACE_ROLES extends GSection_GRoles,
		INTERFACE_PERMISSIONS extends GSection_GPermissions,
		INTERFACE_PROPERTIES extends GSection_GProperties,
		INTERFACE_STATUSES extends GSection_GStatuses,
		INTERFACE_ELEMENTS extends GSection_GElements,
		INTERFACE_METHODS extends GSection_GMethods,
		INTERFACE_SEARCHES extends GSection_GSearches


>
extends GTranslationInterface


{


	public static final Logger LOGGER = LogManager.getLogger(GObject_Interface.class);

	public GID getGID();

	public INTERFACE_METADATA getGMetadataInterface();

	public <METADATA extends INTERFACE_METADATA> METADATA getGMetadata();


	public INTERFACE_ROLES getGRolesInterface();

	public <ROLES extends INTERFACE_ROLES> ROLES getGRoles();


	public INTERFACE_PERMISSIONS getGPermissionsInterface();

	public <PERMISSIONS extends INTERFACE_PERMISSIONS> PERMISSIONS getGPermissions();


	public INTERFACE_PROPERTIES getGPropertiesInterface();

	public <PROPERTIES extends INTERFACE_PROPERTIES> PROPERTIES getGProperties();


	public INTERFACE_STATUSES getGStatusesInterface();

	public <STATUSES extends INTERFACE_STATUSES> STATUSES getGStatuses();


	public INTERFACE_ELEMENTS getGElementsInterface();

	public <ELEMENTS extends INTERFACE_ELEMENTS> ELEMENTS getGElements();


	public INTERFACE_METHODS getGMethodsInterface();

	public <METHODS extends INTERFACE_METHODS> METHODS getGMethods();


	public INTERFACE_SEARCHES getGSearchesInterface();

	public <SEARCHES extends INTERFACE_SEARCHES> SEARCHES getGSearches();




}
