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

package userapp.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserAppLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserAppLocalService
 * @generated
 */
public class UserAppLocalServiceWrapper
	implements ServiceWrapper<UserAppLocalService>, UserAppLocalService {

	public UserAppLocalServiceWrapper() {
		this(null);
	}

	public UserAppLocalServiceWrapper(UserAppLocalService userAppLocalService) {
		_userAppLocalService = userAppLocalService;
	}

	/**
	 * Adds the user app to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userApp the user app
	 * @return the user app that was added
	 */
	@Override
	public userapp.model.UserApp addUserApp(userapp.model.UserApp userApp) {
		return _userAppLocalService.addUserApp(userApp);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAppLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new user app with the primary key. Does not add the user app to the database.
	 *
	 * @param appId the primary key for the new user app
	 * @return the new user app
	 */
	@Override
	public userapp.model.UserApp createUserApp(String appId) {
		return _userAppLocalService.createUserApp(appId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAppLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param appId the primary key of the user app
	 * @return the user app that was removed
	 * @throws PortalException if a user app with the primary key could not be found
	 */
	@Override
	public userapp.model.UserApp deleteUserApp(String appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAppLocalService.deleteUserApp(appId);
	}

	/**
	 * Deletes the user app from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userApp the user app
	 * @return the user app that was removed
	 */
	@Override
	public userapp.model.UserApp deleteUserApp(userapp.model.UserApp userApp) {
		return _userAppLocalService.deleteUserApp(userApp);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _userAppLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _userAppLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userAppLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userAppLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>userapp.model.impl.UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userAppLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>userapp.model.impl.UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userAppLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _userAppLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _userAppLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public userapp.model.UserApp fetchUserApp(String appId) {
		return _userAppLocalService.fetchUserApp(appId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userAppLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAppLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user app with the primary key.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app
	 * @throws PortalException if a user app with the primary key could not be found
	 */
	@Override
	public userapp.model.UserApp getUserApp(String appId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userAppLocalService.getUserApp(appId);
	}

	/**
	 * Returns a range of all the user apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>userapp.model.impl.UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user apps
	 * @param end the upper bound of the range of user apps (not inclusive)
	 * @return the range of user apps
	 */
	@Override
	public java.util.List<userapp.model.UserApp> getUserApps(
		int start, int end) {

		return _userAppLocalService.getUserApps(start, end);
	}

	/**
	 * Returns the number of user apps.
	 *
	 * @return the number of user apps
	 */
	@Override
	public int getUserAppsCount() {
		return _userAppLocalService.getUserAppsCount();
	}

	/**
	 * Updates the user app in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserAppLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userApp the user app
	 * @return the user app that was updated
	 */
	@Override
	public userapp.model.UserApp updateUserApp(userapp.model.UserApp userApp) {
		return _userAppLocalService.updateUserApp(userApp);
	}

	@Override
	public UserAppLocalService getWrappedService() {
		return _userAppLocalService;
	}

	@Override
	public void setWrappedService(UserAppLocalService userAppLocalService) {
		_userAppLocalService = userAppLocalService;
	}

	private UserAppLocalService _userAppLocalService;

}