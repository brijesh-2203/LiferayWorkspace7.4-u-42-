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

package userapp.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import userapp.exception.NoSuchUserAppException;

import userapp.model.UserApp;
import userapp.model.UserAppTable;
import userapp.model.impl.UserAppImpl;
import userapp.model.impl.UserAppModelImpl;

import userapp.service.persistence.UserAppPersistence;
import userapp.service.persistence.UserAppUtil;
import userapp.service.persistence.impl.constants.AppPersistenceConstants;

/**
 * The persistence implementation for the user app service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = {UserAppPersistence.class, BasePersistence.class})
public class UserAppPersistenceImpl
	extends BasePersistenceImpl<UserApp> implements UserAppPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserAppUtil</code> to access the user app persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserAppImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the user apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user apps
	 */
	@Override
	public List<UserApp> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserApp> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<UserApp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserApp> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<UserApp> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserApp> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<UserApp> list = null;

		if (useFinderCache) {
			list = (List<UserApp>)finderCache.getResult(finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (UserApp userApp : list) {
					if (!uuid.equals(userApp.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_USERAPP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(UserAppModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<UserApp>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user app
	 * @throws NoSuchUserAppException if a matching user app could not be found
	 */
	@Override
	public UserApp findByUuid_First(
			String uuid, OrderByComparator<UserApp> orderByComparator)
		throws NoSuchUserAppException {

		UserApp userApp = fetchByUuid_First(uuid, orderByComparator);

		if (userApp != null) {
			return userApp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserAppException(sb.toString());
	}

	/**
	 * Returns the first user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user app, or <code>null</code> if a matching user app could not be found
	 */
	@Override
	public UserApp fetchByUuid_First(
		String uuid, OrderByComparator<UserApp> orderByComparator) {

		List<UserApp> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user app
	 * @throws NoSuchUserAppException if a matching user app could not be found
	 */
	@Override
	public UserApp findByUuid_Last(
			String uuid, OrderByComparator<UserApp> orderByComparator)
		throws NoSuchUserAppException {

		UserApp userApp = fetchByUuid_Last(uuid, orderByComparator);

		if (userApp != null) {
			return userApp;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchUserAppException(sb.toString());
	}

	/**
	 * Returns the last user app in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user app, or <code>null</code> if a matching user app could not be found
	 */
	@Override
	public UserApp fetchByUuid_Last(
		String uuid, OrderByComparator<UserApp> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserApp> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public UserApp[] findByUuid_PrevAndNext(
			String appId, String uuid,
			OrderByComparator<UserApp> orderByComparator)
		throws NoSuchUserAppException {

		uuid = Objects.toString(uuid, "");

		UserApp userApp = findByPrimaryKey(appId);

		Session session = null;

		try {
			session = openSession();

			UserApp[] array = new UserAppImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userApp, uuid, orderByComparator, true);

			array[1] = userApp;

			array[2] = getByUuid_PrevAndNext(
				session, userApp, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserApp getByUuid_PrevAndNext(
		Session session, UserApp userApp, String uuid,
		OrderByComparator<UserApp> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_USERAPP_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(UserAppModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userApp)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<UserApp> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user apps where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserApp userApp :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userApp);
		}
	}

	/**
	 * Returns the number of user apps where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user apps
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_USERAPP_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "userApp.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userApp.uuid IS NULL OR userApp.uuid = '')";

	public UserAppPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(UserApp.class);

		setModelImplClass(UserAppImpl.class);
		setModelPKClass(String.class);

		setTable(UserAppTable.INSTANCE);
	}

	/**
	 * Caches the user app in the entity cache if it is enabled.
	 *
	 * @param userApp the user app
	 */
	@Override
	public void cacheResult(UserApp userApp) {
		entityCache.putResult(
			UserAppImpl.class, userApp.getPrimaryKey(), userApp);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the user apps in the entity cache if it is enabled.
	 *
	 * @param userApps the user apps
	 */
	@Override
	public void cacheResult(List<UserApp> userApps) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (userApps.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (UserApp userApp : userApps) {
			if (entityCache.getResult(
					UserAppImpl.class, userApp.getPrimaryKey()) == null) {

				cacheResult(userApp);
			}
		}
	}

	/**
	 * Clears the cache for all user apps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserAppImpl.class);

		finderCache.clearCache(UserAppImpl.class);
	}

	/**
	 * Clears the cache for the user app.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserApp userApp) {
		entityCache.removeResult(UserAppImpl.class, userApp);
	}

	@Override
	public void clearCache(List<UserApp> userApps) {
		for (UserApp userApp : userApps) {
			entityCache.removeResult(UserAppImpl.class, userApp);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(UserAppImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(UserAppImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user app with the primary key. Does not add the user app to the database.
	 *
	 * @param appId the primary key for the new user app
	 * @return the new user app
	 */
	@Override
	public UserApp create(String appId) {
		UserApp userApp = new UserAppImpl();

		userApp.setNew(true);
		userApp.setPrimaryKey(appId);

		String uuid = _portalUUID.generate();

		userApp.setUuid(uuid);

		return userApp;
	}

	/**
	 * Removes the user app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app that was removed
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	@Override
	public UserApp remove(String appId) throws NoSuchUserAppException {
		return remove((Serializable)appId);
	}

	/**
	 * Removes the user app with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user app
	 * @return the user app that was removed
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	@Override
	public UserApp remove(Serializable primaryKey)
		throws NoSuchUserAppException {

		Session session = null;

		try {
			session = openSession();

			UserApp userApp = (UserApp)session.get(
				UserAppImpl.class, primaryKey);

			if (userApp == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserAppException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userApp);
		}
		catch (NoSuchUserAppException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected UserApp removeImpl(UserApp userApp) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userApp)) {
				userApp = (UserApp)session.get(
					UserAppImpl.class, userApp.getPrimaryKeyObj());
			}

			if (userApp != null) {
				session.delete(userApp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userApp != null) {
			clearCache(userApp);
		}

		return userApp;
	}

	@Override
	public UserApp updateImpl(UserApp userApp) {
		boolean isNew = userApp.isNew();

		if (!(userApp instanceof UserAppModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userApp.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userApp);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userApp proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserApp implementation " +
					userApp.getClass());
		}

		UserAppModelImpl userAppModelImpl = (UserAppModelImpl)userApp;

		if (Validator.isNull(userApp.getUuid())) {
			String uuid = _portalUUID.generate();

			userApp.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(userApp);
			}
			else {
				userApp = (UserApp)session.merge(userApp);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(UserAppImpl.class, userAppModelImpl, false, true);

		if (isNew) {
			userApp.setNew(false);
		}

		userApp.resetOriginalValues();

		return userApp;
	}

	/**
	 * Returns the user app with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user app
	 * @return the user app
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	@Override
	public UserApp findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserAppException {

		UserApp userApp = fetchByPrimaryKey(primaryKey);

		if (userApp == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserAppException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userApp;
	}

	/**
	 * Returns the user app with the primary key or throws a <code>NoSuchUserAppException</code> if it could not be found.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app
	 * @throws NoSuchUserAppException if a user app with the primary key could not be found
	 */
	@Override
	public UserApp findByPrimaryKey(String appId)
		throws NoSuchUserAppException {

		return findByPrimaryKey((Serializable)appId);
	}

	/**
	 * Returns the user app with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param appId the primary key of the user app
	 * @return the user app, or <code>null</code> if a user app with the primary key could not be found
	 */
	@Override
	public UserApp fetchByPrimaryKey(String appId) {
		return fetchByPrimaryKey((Serializable)appId);
	}

	/**
	 * Returns all the user apps.
	 *
	 * @return the user apps
	 */
	@Override
	public List<UserApp> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<UserApp> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<UserApp> findAll(
		int start, int end, OrderByComparator<UserApp> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<UserApp> findAll(
		int start, int end, OrderByComparator<UserApp> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<UserApp> list = null;

		if (useFinderCache) {
			list = (List<UserApp>)finderCache.getResult(finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_USERAPP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_USERAPP;

				sql = sql.concat(UserAppModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<UserApp>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the user apps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserApp userApp : findAll()) {
			remove(userApp);
		}
	}

	/**
	 * Returns the number of user apps.
	 *
	 * @return the number of user apps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_USERAPP);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "appId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERAPP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserAppModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user app persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_setUserAppUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setUserAppUtilPersistence(null);

		entityCache.removeCache(UserAppImpl.class.getName());
	}

	private void _setUserAppUtilPersistence(
		UserAppPersistence userAppPersistence) {

		try {
			Field field = UserAppUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, userAppPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = AppPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = AppPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = AppPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_USERAPP =
		"SELECT userApp FROM UserApp userApp";

	private static final String _SQL_SELECT_USERAPP_WHERE =
		"SELECT userApp FROM UserApp userApp WHERE ";

	private static final String _SQL_COUNT_USERAPP =
		"SELECT COUNT(userApp) FROM UserApp userApp";

	private static final String _SQL_COUNT_USERAPP_WHERE =
		"SELECT COUNT(userApp) FROM UserApp userApp WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userApp.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserApp exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserApp exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserAppPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

	@Reference
	private UserAppModelArgumentsResolver _userAppModelArgumentsResolver;

}