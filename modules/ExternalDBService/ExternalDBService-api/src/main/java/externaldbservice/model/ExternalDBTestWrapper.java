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

package externaldbservice.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ExternalDBTest}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExternalDBTest
 * @generated
 */
public class ExternalDBTestWrapper
	extends BaseModelWrapper<ExternalDBTest>
	implements ExternalDBTest, ModelWrapper<ExternalDBTest> {

	public ExternalDBTestWrapper(ExternalDBTest externalDBTest) {
		super(externalDBTest);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fooId", getFooId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("eid", getEid());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fooId = (Long)attributes.get("fooId");

		if (fooId != null) {
			setFooId(fooId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer eid = (Integer)attributes.get("eid");

		if (eid != null) {
			setEid(eid);
		}
	}

	@Override
	public ExternalDBTest cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this external db test.
	 *
	 * @return the company ID of this external db test
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this external db test.
	 *
	 * @return the create date of this external db test
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the eid of this external db test.
	 *
	 * @return the eid of this external db test
	 */
	@Override
	public int getEid() {
		return model.getEid();
	}

	/**
	 * Returns the foo ID of this external db test.
	 *
	 * @return the foo ID of this external db test
	 */
	@Override
	public long getFooId() {
		return model.getFooId();
	}

	/**
	 * Returns the group ID of this external db test.
	 *
	 * @return the group ID of this external db test
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this external db test.
	 *
	 * @return the modified date of this external db test
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this external db test.
	 *
	 * @return the name of this external db test
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this external db test.
	 *
	 * @return the primary key of this external db test
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this external db test.
	 *
	 * @return the user ID of this external db test
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this external db test.
	 *
	 * @return the user name of this external db test
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this external db test.
	 *
	 * @return the user uuid of this external db test
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this external db test.
	 *
	 * @return the uuid of this external db test
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
	 * Sets the company ID of this external db test.
	 *
	 * @param companyId the company ID of this external db test
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this external db test.
	 *
	 * @param createDate the create date of this external db test
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the eid of this external db test.
	 *
	 * @param eid the eid of this external db test
	 */
	@Override
	public void setEid(int eid) {
		model.setEid(eid);
	}

	/**
	 * Sets the foo ID of this external db test.
	 *
	 * @param fooId the foo ID of this external db test
	 */
	@Override
	public void setFooId(long fooId) {
		model.setFooId(fooId);
	}

	/**
	 * Sets the group ID of this external db test.
	 *
	 * @param groupId the group ID of this external db test
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this external db test.
	 *
	 * @param modifiedDate the modified date of this external db test
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this external db test.
	 *
	 * @param name the name of this external db test
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this external db test.
	 *
	 * @param primaryKey the primary key of this external db test
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this external db test.
	 *
	 * @param userId the user ID of this external db test
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this external db test.
	 *
	 * @param userName the user name of this external db test
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this external db test.
	 *
	 * @param userUuid the user uuid of this external db test
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this external db test.
	 *
	 * @param uuid the uuid of this external db test
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ExternalDBTestWrapper wrap(ExternalDBTest externalDBTest) {
		return new ExternalDBTestWrapper(externalDBTest);
	}

}