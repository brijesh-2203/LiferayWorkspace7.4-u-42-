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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

import userapp.exception.NoSuchUserAppException;

import userapp.model.UserApp;

/**
 * The persistence interface for the user app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserAppUtil
 * @generated
 */
@ProviderType
public interface UserAppPersistence extends BasePersistence<UserApp> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link UserAppUtil} to access the user app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the user apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user apps
	 */
	public java.util.List<UserApp> findByUuid(String uuid);

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
	public java.util.List<UserApp> findByUuid(String uuid, int start, int end);

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
	public java.util.List<UserApp> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserApp>
			orderByComparator);

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
	public java.util.List<UserApp> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserApp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user app
	 * @throws NoSuchUserAppException if a matching user app could not be found
	 */
	public UserApp findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserApp>
				orderByComparator)
		throws NoSuchUserAppException;

	/**
	 * Returns the first user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user app, or <code>null</code> if a matching user app could not be found
	 */
	public UserApp fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserApp>
			orderByComparator);

	/**
	 * Returns the last user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user app
	 * @throws NoSuchUserAppException if a matching user app could not be found
	 */
	public UserApp findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserApp>
				orderByComparator)
		throws NoSuchUserAppException;

	/**
	 * Returns the last user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user app, or <code>null</code> if a matching user app could not be found
	 */
	public UserApp fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<UserApp>
			orderByComparator);

	/**
	 * Returns the user apps before and after the current user app in the ordered set where uuid = &#63;.
	 *
	 * @param appId the primary key of the current user app
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user app
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	public UserApp[] findByUuid_PrevAndNext(
			String appId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<UserApp>
				orderByComparator)
		throws NoSuchUserAppException;

	/**
	 * Removes all the user apps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of user apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user apps
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the user app in the entity cache if it is enabled.
	 *
	 * @param userApp the user app
	 */
	public void cacheResult(UserApp userApp);

	/**
	 * Caches the user apps in the entity cache if it is enabled.
	 *
	 * @param userApps the user apps
	 */
	public void cacheResult(java.util.List<UserApp> userApps);

	/**
	 * Creates a new user app with the primary key. Does not add the user app to the database.
	 *
	 * @param appId the primary key for the new user app
	 * @return the new user app
	 */
	public UserApp create(String appId);

	/**
	 * Removes the user app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app that was removed
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	public UserApp remove(String appId) throws NoSuchUserAppException;

	public UserApp updateImpl(UserApp userApp);

	/**
	 * Returns the user app with the primary key or throws a <code>NoSuchUserAppException</code> if it could not be found.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	public UserApp findByPrimaryKey(String appId) throws NoSuchUserAppException;

	/**
	 * Returns the user app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app, or <code>null</code> if a user app with the primary key could not be found
	 */
	public UserApp fetchByPrimaryKey(String appId);

	/**
	 * Returns all the user apps.
	 *
	 * @return the user apps
	 */
	public java.util.List<UserApp> findAll();

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
	public java.util.List<UserApp> findAll(int start, int end);

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
	public java.util.List<UserApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserApp>
			orderByComparator);

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
	public java.util.List<UserApp> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<UserApp>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the user apps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of user apps.
	 *
	 * @return the number of user apps
	 */
	public int countAll();

}