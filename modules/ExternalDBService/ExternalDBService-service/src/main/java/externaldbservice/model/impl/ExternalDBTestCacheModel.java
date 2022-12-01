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

package externaldbservice.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import externaldbservice.model.ExternalDBTest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExternalDBTest in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ExternalDBTestCacheModel
	implements CacheModel<ExternalDBTest>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ExternalDBTestCacheModel)) {
			return false;
		}

		ExternalDBTestCacheModel externalDBTestCacheModel =
			(ExternalDBTestCacheModel)object;

		if (fooId == externalDBTestCacheModel.fooId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fooId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fooId=");
		sb.append(fooId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", eid=");
		sb.append(eid);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExternalDBTest toEntityModel() {
		ExternalDBTestImpl externalDBTestImpl = new ExternalDBTestImpl();

		if (uuid == null) {
			externalDBTestImpl.setUuid("");
		}
		else {
			externalDBTestImpl.setUuid(uuid);
		}

		externalDBTestImpl.setFooId(fooId);
		externalDBTestImpl.setGroupId(groupId);
		externalDBTestImpl.setCompanyId(companyId);
		externalDBTestImpl.setUserId(userId);

		if (userName == null) {
			externalDBTestImpl.setUserName("");
		}
		else {
			externalDBTestImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			externalDBTestImpl.setCreateDate(null);
		}
		else {
			externalDBTestImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			externalDBTestImpl.setModifiedDate(null);
		}
		else {
			externalDBTestImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			externalDBTestImpl.setName("");
		}
		else {
			externalDBTestImpl.setName(name);
		}

		externalDBTestImpl.setEid(eid);

		externalDBTestImpl.resetOriginalValues();

		return externalDBTestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		fooId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();

		eid = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(fooId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(eid);
	}

	public String uuid;
	public long fooId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public int eid;

}