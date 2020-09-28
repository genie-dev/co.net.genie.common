package co.net.genie.common.object;

import co.net.genie.common.*;
import co.net.genie.common.annotations.NotNull;
import co.net.genie.common.field.GField;
import co.net.genie.common.id.GID;
import co.net.genie.common.object.section.*;
import co.net.genie.common.translator.GCode;
import co.net.genie.common.validators.*;
import org.apache.logging.log4j.Logger;

public abstract class GObject_Abstract
		<

			OBJECT extends GObject_Abstract
				<
						OBJECT,

						INTERFACE_METADATA,
						INTERFACE_ROLES,
						INTERFACE_PERMISSIONS,
						INTERFACE_PROPERTIES,
						INTERFACE_STATUSES,
						INTERFACE_ELEMENTS,
						INTERFACE_METHODS,
						INTERFACE_SEARCHES,

						METADATA,
						ROLES,
						PERMISSIONS,
						PROPERTIES,
						STATUSES,
						ELEMENTS,
						METHODS,
						SEARCHES
				>,

			INTERFACE_METADATA extends GSection_GMetadata,
			INTERFACE_ROLES extends GSection_GRoles,
			INTERFACE_PERMISSIONS extends GSection_GPermissions,
			INTERFACE_PROPERTIES extends GSection_GProperties,
			INTERFACE_STATUSES extends GSection_GStatuses,
			INTERFACE_ELEMENTS extends GSection_GElements,
			INTERFACE_METHODS extends GSection_GMethods,
			INTERFACE_SEARCHES extends GSection_GSearches,

			METADATA extends INTERFACE_METADATA,
			ROLES extends INTERFACE_ROLES,
			PERMISSIONS extends INTERFACE_PERMISSIONS,
			PROPERTIES extends INTERFACE_PROPERTIES,
			STATUSES extends INTERFACE_STATUSES,
			ELEMENTS extends INTERFACE_ELEMENTS,
			METHODS extends INTERFACE_METHODS,
			SEARCHES extends INTERFACE_SEARCHES



		>
	extends GField


	implements GObject_Interface
		<
				INTERFACE_METADATA,
				INTERFACE_ROLES,
				INTERFACE_PERMISSIONS,
				INTERFACE_PROPERTIES,
				INTERFACE_STATUSES,
				INTERFACE_ELEMENTS,
				INTERFACE_METHODS,
				INTERFACE_SEARCHES

		>
{

	static final public Logger LOGGER = GObject_Interface.LOGGER;


	private final GID gid;

	public final METADATA METADATA;
	public final ROLES ROLES;
	public final PERMISSIONS PERMISSIONS;
	public final PROPERTIES PROPERTIES;
	public final STATUSES STATUSES;
	public final ELEMENTS ELEMENTS;
	public final METHODS METHODS;
	public final SEARCHES SEARCHES;




	/**Only protected constructors.
	 * Normally GObject instance should have public constructor with no arguments
	 *
	 *
	 * @param code
	 * @param metadata
	 * @param roles
	 * @param permissions
	 * @param properties
	 * @param statuses
	 * @param elements
	 * @param methods
	 * @param searches
	 */
	protected GObject_Abstract(
			@NotNull GID gid,
			@NotNull GCode code,
			@NotNull METADATA metadata,
			@NotNull ROLES roles,
			@NotNull PERMISSIONS permissions,
			@NotNull PROPERTIES properties,
			@NotNull STATUSES statuses,
			@NotNull ELEMENTS elements,
			@NotNull METHODS methods,
			@NotNull SEARCHES searches
	) {


		super(code);


		new ValidateArgument(GSection_GMetadata.class, metadata, new Validator_NotNull());
		new ValidateArgument(GSection_GRoles.class, roles, new Validator_NotNull());
		new ValidateArgument(GSection_GPermissions.class, permissions, new Validator_NotNull());
		new ValidateArgument(GSection_GProperties.class, properties, new Validator_NotNull());
		new ValidateArgument(GSection_GStatuses.class, statuses, new Validator_NotNull());
		new ValidateArgument(GSection_GElements.class, elements, new Validator_NotNull());
		new ValidateArgument(GSection_GMethods.class, methods, new Validator_NotNull());
		new ValidateArgument(GSection_GSearches.class, searches, new Validator_NotNull());

		this.gid = gid;

		this.METADATA = metadata;
		this.ROLES = roles;
		this.PERMISSIONS = permissions;
		this.PROPERTIES = properties;
		this.STATUSES = statuses;
		this.ELEMENTS = elements;
		this.METHODS = methods;
		this.SEARCHES = searches;

		this.METADATA.setup_GObject((OBJECT) this);
		this.ROLES.setup_GObject((OBJECT) this);
		this.PERMISSIONS.setup_GObject((OBJECT) this);
		this.PROPERTIES.setup_GObject((OBJECT) this);
		this.STATUSES.setup_GObject((OBJECT) this);
		this.ELEMENTS.setup_GObject((OBJECT) this);
		this.METHODS.setup_GObject((OBJECT) this);
		this.SEARCHES.setup_GObject((OBJECT) this);

		try {
			this.ELEMENTS.ID.setup_Value(this.gid);
		}
		catch (Throwable err) { // ValidatorProhibition
			throw new GObjectError(err);
		}



	}



	@Override
	public GID getGID() {
		return gid;
	}

	@Override
	public INTERFACE_METADATA getGMetadataInterface() {
		return getGMetadata();
	}
	@Override
	public final METADATA getGMetadata() {
		return this.METADATA;
	}

	@Override
	public INTERFACE_ROLES getGRolesInterface() {
		return getGRoles();
	}
	@Override
	public final ROLES getGRoles() {
		return this.ROLES;
	}

	@Override
	public INTERFACE_PERMISSIONS getGPermissionsInterface() {
		return getGPermissions();
	}
	@Override
	public final PERMISSIONS getGPermissions() {
		return this.PERMISSIONS;
	}

	@Override
	public INTERFACE_PROPERTIES getGPropertiesInterface(){
		return getGProperties();
	}
	@Override
	public final PROPERTIES getGProperties() {
		return this.PROPERTIES;
	}

	@Override
	public INTERFACE_STATUSES getGStatusesInterface() {
		return getGStatuses();
	}
	@Override
	public final STATUSES getGStatuses() {
		return this.STATUSES;
	}

	@Override
	public INTERFACE_ELEMENTS getGElementsInterface() {
		return getGElements();
	}
	@Override
	public final ELEMENTS getGElements() {
		return this.ELEMENTS;
	}

	@Override
	public INTERFACE_METHODS getGMethodsInterface() {
		return getGMethods();
	}
	@Override
	public final METHODS getGMethods() {
		return this.METHODS;
	}

	@Override
	public INTERFACE_SEARCHES getGSearchesInterface() {
		return getGSearches();
	}
	@Override
	public final SEARCHES getGSearches() {
		return this.SEARCHES;
	}


	@Override
	public int hashCode() {
		return gid.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if(obj == null) {
			return false;
		}
		else if(
				obj instanceof GObject_Abstract &&
				obj.getClass().equals(this.getClass()) &&
				((GObject_Abstract) obj).hashCode() == hashCode()
		) {
			return true;
		}
		else {
			return false;
		}

	}


}
