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

package userapp.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import userapp.model.UserApp;

/**
 * The persistence utility for the user app service. This utility wraps <code>userapp.service.persistence.impl.UserAppPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAppPersistence
 * @generated
 */
public class UserAppUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(UserApp userApp) {
		getPersistence().clearCache(userApp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, UserApp> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<UserApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<UserApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<UserApp> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<UserApp> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static UserApp update(UserApp userApp) {
		return getPersistence().update(userApp);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static UserApp update(
		UserApp userApp, ServiceContext serviceContext) {

		return getPersistence().update(userApp, serviceContext);
	}

	/**
	 * Returns all the user apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user apps
	 */
	public static List<UserApp> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the user apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user apps
	 * @param end the upper bound of the range of user apps (not inclusive)
	 * @return the range of matching user apps
	 */
	public static List<UserApp> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the user apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user apps
	 * @param end the upper bound of the range of user apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user apps
	 */
	public static List<UserApp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserApp> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user apps where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user apps
	 * @param end the upper bound of the range of user apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user apps
	 */
	public static List<UserApp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserApp> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user app
	 * @throws NoSuchUserAppException if a matching user app could not be found
	 */
	public static UserApp findByUuid_First(
			String uuid, OrderByComparator<UserApp> orderByComparator)
		throws userapp.exception.NoSuchUserAppException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user app, or <code>null</code> if a matching user app could not be found
	 */
	public static UserApp fetchByUuid_First(
		String uuid, OrderByComparator<UserApp> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user app
	 * @throws NoSuchUserAppException if a matching user app could not be found
	 */
	public static UserApp findByUuid_Last(
			String uuid, OrderByComparator<UserApp> orderByComparator)
		throws userapp.exception.NoSuchUserAppException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user app, or <code>null</code> if a matching user app could not be found
	 */
	public static UserApp fetchByUuid_Last(
		String uuid, OrderByComparator<UserApp> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the user apps before and after the current user app in the ordered set where uuid = &#63;.
	 *
	 * @param appId the primary key of the current user app
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user app
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	public static UserApp[] findByUuid_PrevAndNext(
			String appId, String uuid,
			OrderByComparator<UserApp> orderByComparator)
		throws userapp.exception.NoSuchUserAppException {

		return getPersistence().findByUuid_PrevAndNext(
			appId, uuid, orderByComparator);
	}

	/**
	 * Removes all the user apps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of user apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user apps
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the user app in the entity cache if it is enabled.
	 *
	 * @param userApp the user app
	 */
	public static void cacheResult(UserApp userApp) {
		getPersistence().cacheResult(userApp);
	}

	/**
	 * Caches the user apps in the entity cache if it is enabled.
	 *
	 * @param userApps the user apps
	 */
	public static void cacheResult(List<UserApp> userApps) {
		getPersistence().cacheResult(userApps);
	}

	/**
	 * Creates a new user app with the primary key. Does not add the user app to the database.
	 *
	 * @param appId the primary key for the new user app
	 * @return the new user app
	 */
	public static UserApp create(String appId) {
		return getPersistence().create(appId);
	}

	/**
	 * Removes the user app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app that was removed
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	public static UserApp remove(String appId)
		throws userapp.exception.NoSuchUserAppException {

		return getPersistence().remove(appId);
	}

	public static UserApp updateImpl(UserApp userApp) {
		return getPersistence().updateImpl(userApp);
	}

	/**
	 * Returns the user app with the primary key or throws a <code>NoSuchUserAppException</code> if it could not be found.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	public static UserApp findByPrimaryKey(String appId)
		throws userapp.exception.NoSuchUserAppException {

		return getPersistence().findByPrimaryKey(appId);
	}

	/**
	 * Returns the user app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app, or <code>null</code> if a user app with the primary key could not be found
	 */
	public static UserApp fetchByPrimaryKey(String appId) {
		return getPersistence().fetchByPrimaryKey(appId);
	}

	/**
	 * Returns all the user apps.
	 *
	 * @return the user apps
	 */
	public static List<UserApp> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the user apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user apps
	 * @param end the upper bound of the range of user apps (not inclusive)
	 * @return the range of user apps
	 */
	public static List<UserApp> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the user apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user apps
	 * @param end the upper bound of the range of user apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user apps
	 */
	public static List<UserApp> findAll(
		int start, int end, OrderByComparator<UserApp> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user apps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserAppModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user apps
	 * @param end the upper bound of the range of user apps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user apps
	 */
	public static List<UserApp> findAll(
		int start, int end, OrderByComparator<UserApp> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the user apps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of user apps.
	 *
	 * @return the number of user apps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static UserAppPersistence getPersistence() {
		return _persistence;
	}

	private static volatile UserAppPersistence _persistence;

}