/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.user.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the Address service. Represents a row in the &quot;UserDetails_Address&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.liferay.user.model.impl.AddressModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.liferay.user.model.impl.AddressImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
@ProviderType
public interface AddressModel extends BaseModel<Address> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a address model instance should use the {@link Address} interface instead.
	 */

	/**
	 * Returns the primary key of this address.
	 *
	 * @return the primary key of this address
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this address.
	 *
	 * @param primaryKey the primary key of this address
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this address.
	 *
	 * @return the uuid of this address
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this address.
	 *
	 * @param uuid the uuid of this address
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the address ID of this address.
	 *
	 * @return the address ID of this address
	 */
	public long getAddressId();

	/**
	 * Sets the address ID of this address.
	 *
	 * @param addressId the address ID of this address
	 */
	public void setAddressId(long addressId);

	/**
	 * Returns the city of this address.
	 *
	 * @return the city of this address
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this address.
	 *
	 * @param city the city of this address
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this address.
	 *
	 * @return the state of this address
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this address.
	 *
	 * @param state the state of this address
	 */
	public void setState(String state);

	@Override
	public Address cloneWithOriginalValues();

}