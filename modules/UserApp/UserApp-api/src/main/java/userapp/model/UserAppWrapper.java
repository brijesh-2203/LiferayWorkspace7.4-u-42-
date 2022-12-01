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

package userapp.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserApp}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserApp
 * @generated
 */
public class UserAppWrapper
	extends BaseModelWrapper<UserApp>
	implements ModelWrapper<UserApp>, UserApp {

	public UserAppWrapper(UserApp userApp) {
		super(userApp);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("appId", getAppId());
		attributes.put("description", getDescription());
		attributes.put("link", getLink());
		attributes.put("logoUrl", getLogoUrl());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String appId = (String)attributes.get("appId");

		if (appId != null) {
			setAppId(appId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		String logoUrl = (String)attributes.get("logoUrl");

		if (logoUrl != null) {
			setLogoUrl(logoUrl);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public UserApp cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the app ID of this user app.
	 *
	 * @return the app ID of this user app
	 */
	@Override
	public String getAppId() {
		return model.getAppId();
	}

	/**
	 * Returns the description of this user app.
	 *
	 * @return the description of this user app
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the link of this user app.
	 *
	 * @return the link of this user app
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the logo url of this user app.
	 *
	 * @return the logo url of this user app
	 */
	@Override
	public String getLogoUrl() {
		return model.getLogoUrl();
	}

	/**
	 * Returns the name of this user app.
	 *
	 * @return the name of this user app
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this user app.
	 *
	 * @return the primary key of this user app
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this user app.
	 *
	 * @return the uuid of this user app
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the app ID of this user app.
	 *
	 * @param appId the app ID of this user app
	 */
	@Override
	public void setAppId(String appId) {
		model.setAppId(appId);
	}

	/**
	 * Sets the description of this user app.
	 *
	 * @param description the description of this user app
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the link of this user app.
	 *
	 * @param link the link of this user app
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the logo url of this user app.
	 *
	 * @param logoUrl the logo url of this user app
	 */
	@Override
	public void setLogoUrl(String logoUrl) {
		model.setLogoUrl(logoUrl);
	}

	/**
	 * Sets the name of this user app.
	 *
	 * @param name the name of this user app
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this user app.
	 *
	 * @param primaryKey the primary key of this user app
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this user app.
	 *
	 * @param uuid the uuid of this user app
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	protected UserAppWrapper wrap(UserApp userApp) {
		return new UserAppWrapper(userApp);
	}

}