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

package userapp.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import userapp.model.UserApp;

/**
 * The cache model class for representing UserApp in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class UserAppCacheModel implements CacheModel<UserApp>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof UserAppCacheModel)) {
			return false;
		}

		UserAppCacheModel userAppCacheModel = (UserAppCacheModel)object;

		if (appId.equals(userAppCacheModel.appId)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, appId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", appId=");
		sb.append(appId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", link=");
		sb.append(link);
		sb.append(", logoUrl=");
		sb.append(logoUrl);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserApp toEntityModel() {
		UserAppImpl userAppImpl = new UserAppImpl();

		if (uuid == null) {
			userAppImpl.setUuid("");
		}
		else {
			userAppImpl.setUuid(uuid);
		}

		if (appId == null) {
			userAppImpl.setAppId("");
		}
		else {
			userAppImpl.setAppId(appId);
		}

		if (description == null) {
			userAppImpl.setDescription("");
		}
		else {
			userAppImpl.setDescription(description);
		}

		if (link == null) {
			userAppImpl.setLink("");
		}
		else {
			userAppImpl.setLink(link);
		}

		if (logoUrl == null) {
			userAppImpl.setLogoUrl("");
		}
		else {
			userAppImpl.setLogoUrl(logoUrl);
		}

		if (name == null) {
			userAppImpl.setName("");
		}
		else {
			userAppImpl.setName(name);
		}

		userAppImpl.resetOriginalValues();

		return userAppImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		appId = objectInput.readUTF();
		description = objectInput.readUTF();
		link = objectInput.readUTF();
		logoUrl = objectInput.readUTF();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		if (appId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(appId);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (logoUrl == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(logoUrl);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public String appId;
	public String description;
	public String link;
	public String logoUrl;
	public String name;

}