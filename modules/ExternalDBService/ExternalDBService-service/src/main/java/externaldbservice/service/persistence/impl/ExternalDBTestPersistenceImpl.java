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

package externaldbservice.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;
import com.liferay.portal.spring.extender.service.ServiceReference;

import externaldbservice.exception.NoSuchTestException;

import externaldbservice.model.ExternalDBTest;
import externaldbservice.model.ExternalDBTestTable;
import externaldbservice.model.impl.ExternalDBTestImpl;
import externaldbservice.model.impl.ExternalDBTestModelImpl;

import externaldbservice.service.persistence.ExternalDBTestPersistence;
import externaldbservice.service.persistence.ExternalDBTestUtil;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the external db test service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ExternalDBTestPersistenceImpl
	extends BasePersistenceImpl<ExternalDBTest>
	implements ExternalDBTestPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ExternalDBTestUtil</code> to access the external db test persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ExternalDBTestImpl.class.getName();

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
	 * Returns all the external db tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching external db tests
	 */
	@Override
	public List<ExternalDBTest> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external db tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @return the range of matching external db tests
	 */
	@Override
	public List<ExternalDBTest> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external db tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external db tests
	 */
	@Override
	public List<ExternalDBTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ExternalDBTest> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the external db tests where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching external db tests
	 */
	@Override
	public List<ExternalDBTest> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ExternalDBTest> orderByComparator,
		boolean useFinderCache) {

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

		List<ExternalDBTest> list = null;

		if (useFinderCache) {
			list = (List<ExternalDBTest>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ExternalDBTest externalDBTest : list) {
					if (!uuid.equals(externalDBTest.getUuid())) {
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

			sb.append(_SQL_SELECT_EXTERNALDBTEST_WHERE);

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
				sb.append(ExternalDBTestModelImpl.ORDER_BY_JPQL);
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

				list = (List<ExternalDBTest>)QueryUtil.list(
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
	 * Returns the first external db test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest findByUuid_First(
			String uuid, OrderByComparator<ExternalDBTest> orderByComparator)
		throws NoSuchTestException {

		ExternalDBTest externalDBTest = fetchByUuid_First(
			uuid, orderByComparator);

		if (externalDBTest != null) {
			return externalDBTest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTestException(sb.toString());
	}

	/**
	 * Returns the first external db test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest fetchByUuid_First(
		String uuid, OrderByComparator<ExternalDBTest> orderByComparator) {

		List<ExternalDBTest> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external db test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest findByUuid_Last(
			String uuid, OrderByComparator<ExternalDBTest> orderByComparator)
		throws NoSuchTestException {

		ExternalDBTest externalDBTest = fetchByUuid_Last(
			uuid, orderByComparator);

		if (externalDBTest != null) {
			return externalDBTest;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTestException(sb.toString());
	}

	/**
	 * Returns the last external db test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest fetchByUuid_Last(
		String uuid, OrderByComparator<ExternalDBTest> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ExternalDBTest> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external db tests before and after the current external db test in the ordered set where uuid = &#63;.
	 *
	 * @param fooId the primary key of the current external db test
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external db test
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	@Override
	public ExternalDBTest[] findByUuid_PrevAndNext(
			long fooId, String uuid,
			OrderByComparator<ExternalDBTest> orderByComparator)
		throws NoSuchTestException {

		uuid = Objects.toString(uuid, "");

		ExternalDBTest externalDBTest = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			ExternalDBTest[] array = new ExternalDBTestImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, externalDBTest, uuid, orderByComparator, true);

			array[1] = externalDBTest;

			array[2] = getByUuid_PrevAndNext(
				session, externalDBTest, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExternalDBTest getByUuid_PrevAndNext(
		Session session, ExternalDBTest externalDBTest, String uuid,
		OrderByComparator<ExternalDBTest> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_EXTERNALDBTEST_WHERE);

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
			sb.append(ExternalDBTestModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						externalDBTest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExternalDBTest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external db tests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ExternalDBTest externalDBTest :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(externalDBTest);
		}
	}

	/**
	 * Returns the number of external db tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching external db tests
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_EXTERNALDBTEST_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"externalDBTest.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(externalDBTest.uuid IS NULL OR externalDBTest.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the external db test where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest findByUUID_G(String uuid, long groupId)
		throws NoSuchTestException {

		ExternalDBTest externalDBTest = fetchByUUID_G(uuid, groupId);

		if (externalDBTest == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTestException(sb.toString());
		}

		return externalDBTest;
	}

	/**
	 * Returns the external db test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the external db test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs);
		}

		if (result instanceof ExternalDBTest) {
			ExternalDBTest externalDBTest = (ExternalDBTest)result;

			if (!Objects.equals(uuid, externalDBTest.getUuid()) ||
				(groupId != externalDBTest.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_EXTERNALDBTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ExternalDBTest> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ExternalDBTest externalDBTest = list.get(0);

					result = externalDBTest;

					cacheResult(externalDBTest);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ExternalDBTest)result;
		}
	}

	/**
	 * Removes the external db test where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the external db test that was removed
	 */
	@Override
	public ExternalDBTest removeByUUID_G(String uuid, long groupId)
		throws NoSuchTestException {

		ExternalDBTest externalDBTest = findByUUID_G(uuid, groupId);

		return remove(externalDBTest);
	}

	/**
	 * Returns the number of external db tests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching external db tests
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXTERNALDBTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"externalDBTest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(externalDBTest.uuid IS NULL OR externalDBTest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"externalDBTest.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the external db tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching external db tests
	 */
	@Override
	public List<ExternalDBTest> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external db tests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @return the range of matching external db tests
	 */
	@Override
	public List<ExternalDBTest> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the external db tests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching external db tests
	 */
	@Override
	public List<ExternalDBTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExternalDBTest> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the external db tests where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching external db tests
	 */
	@Override
	public List<ExternalDBTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExternalDBTest> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ExternalDBTest> list = null;

		if (useFinderCache) {
			list = (List<ExternalDBTest>)finderCache.getResult(
				finderPath, finderArgs);

			if ((list != null) && !list.isEmpty()) {
				for (ExternalDBTest externalDBTest : list) {
					if (!uuid.equals(externalDBTest.getUuid()) ||
						(companyId != externalDBTest.getCompanyId())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_EXTERNALDBTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ExternalDBTestModelImpl.ORDER_BY_JPQL);
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

				queryPos.add(companyId);

				list = (List<ExternalDBTest>)QueryUtil.list(
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
	 * Returns the first external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ExternalDBTest> orderByComparator)
		throws NoSuchTestException {

		ExternalDBTest externalDBTest = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (externalDBTest != null) {
			return externalDBTest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTestException(sb.toString());
	}

	/**
	 * Returns the first external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ExternalDBTest> orderByComparator) {

		List<ExternalDBTest> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ExternalDBTest> orderByComparator)
		throws NoSuchTestException {

		ExternalDBTest externalDBTest = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (externalDBTest != null) {
			return externalDBTest;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTestException(sb.toString());
	}

	/**
	 * Returns the last external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	@Override
	public ExternalDBTest fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ExternalDBTest> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ExternalDBTest> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the external db tests before and after the current external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param fooId the primary key of the current external db test
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external db test
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	@Override
	public ExternalDBTest[] findByUuid_C_PrevAndNext(
			long fooId, String uuid, long companyId,
			OrderByComparator<ExternalDBTest> orderByComparator)
		throws NoSuchTestException {

		uuid = Objects.toString(uuid, "");

		ExternalDBTest externalDBTest = findByPrimaryKey(fooId);

		Session session = null;

		try {
			session = openSession();

			ExternalDBTest[] array = new ExternalDBTestImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, externalDBTest, uuid, companyId, orderByComparator,
				true);

			array[1] = externalDBTest;

			array[2] = getByUuid_C_PrevAndNext(
				session, externalDBTest, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ExternalDBTest getByUuid_C_PrevAndNext(
		Session session, ExternalDBTest externalDBTest, String uuid,
		long companyId, OrderByComparator<ExternalDBTest> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_EXTERNALDBTEST_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			sb.append(ExternalDBTestModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						externalDBTest)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ExternalDBTest> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the external db tests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ExternalDBTest externalDBTest :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(externalDBTest);
		}
	}

	/**
	 * Returns the number of external db tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching external db tests
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_EXTERNALDBTEST_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"externalDBTest.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(externalDBTest.uuid IS NULL OR externalDBTest.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"externalDBTest.companyId = ?";

	public ExternalDBTestPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ExternalDBTest.class);

		setModelImplClass(ExternalDBTestImpl.class);
		setModelPKClass(long.class);

		setTable(ExternalDBTestTable.INSTANCE);
	}

	/**
	 * Caches the external db test in the entity cache if it is enabled.
	 *
	 * @param externalDBTest the external db test
	 */
	@Override
	public void cacheResult(ExternalDBTest externalDBTest) {
		entityCache.putResult(
			ExternalDBTestImpl.class, externalDBTest.getPrimaryKey(),
			externalDBTest);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				externalDBTest.getUuid(), externalDBTest.getGroupId()
			},
			externalDBTest);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the external db tests in the entity cache if it is enabled.
	 *
	 * @param externalDBTests the external db tests
	 */
	@Override
	public void cacheResult(List<ExternalDBTest> externalDBTests) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (externalDBTests.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ExternalDBTest externalDBTest : externalDBTests) {
			if (entityCache.getResult(
					ExternalDBTestImpl.class, externalDBTest.getPrimaryKey()) ==
						null) {

				cacheResult(externalDBTest);
			}
		}
	}

	/**
	 * Clears the cache for all external db tests.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ExternalDBTestImpl.class);

		finderCache.clearCache(ExternalDBTestImpl.class);
	}

	/**
	 * Clears the cache for the external db test.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ExternalDBTest externalDBTest) {
		entityCache.removeResult(ExternalDBTestImpl.class, externalDBTest);
	}

	@Override
	public void clearCache(List<ExternalDBTest> externalDBTests) {
		for (ExternalDBTest externalDBTest : externalDBTests) {
			entityCache.removeResult(ExternalDBTestImpl.class, externalDBTest);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ExternalDBTestImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ExternalDBTestImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ExternalDBTestModelImpl externalDBTestModelImpl) {

		Object[] args = new Object[] {
			externalDBTestModelImpl.getUuid(),
			externalDBTestModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, externalDBTestModelImpl);
	}

	/**
	 * Creates a new external db test with the primary key. Does not add the external db test to the database.
	 *
	 * @param fooId the primary key for the new external db test
	 * @return the new external db test
	 */
	@Override
	public ExternalDBTest create(long fooId) {
		ExternalDBTest externalDBTest = new ExternalDBTestImpl();

		externalDBTest.setNew(true);
		externalDBTest.setPrimaryKey(fooId);

		String uuid = _portalUUID.generate();

		externalDBTest.setUuid(uuid);

		externalDBTest.setCompanyId(CompanyThreadLocal.getCompanyId());

		return externalDBTest;
	}

	/**
	 * Removes the external db test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test that was removed
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	@Override
	public ExternalDBTest remove(long fooId) throws NoSuchTestException {
		return remove((Serializable)fooId);
	}

	/**
	 * Removes the external db test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the external db test
	 * @return the external db test that was removed
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	@Override
	public ExternalDBTest remove(Serializable primaryKey)
		throws NoSuchTestException {

		Session session = null;

		try {
			session = openSession();

			ExternalDBTest externalDBTest = (ExternalDBTest)session.get(
				ExternalDBTestImpl.class, primaryKey);

			if (externalDBTest == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTestException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(externalDBTest);
		}
		catch (NoSuchTestException noSuchEntityException) {
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
	protected ExternalDBTest removeImpl(ExternalDBTest externalDBTest) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(externalDBTest)) {
				externalDBTest = (ExternalDBTest)session.get(
					ExternalDBTestImpl.class,
					externalDBTest.getPrimaryKeyObj());
			}

			if (externalDBTest != null) {
				session.delete(externalDBTest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (externalDBTest != null) {
			clearCache(externalDBTest);
		}

		return externalDBTest;
	}

	@Override
	public ExternalDBTest updateImpl(ExternalDBTest externalDBTest) {
		boolean isNew = externalDBTest.isNew();

		if (!(externalDBTest instanceof ExternalDBTestModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(externalDBTest.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					externalDBTest);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in externalDBTest proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ExternalDBTest implementation " +
					externalDBTest.getClass());
		}

		ExternalDBTestModelImpl externalDBTestModelImpl =
			(ExternalDBTestModelImpl)externalDBTest;

		if (Validator.isNull(externalDBTest.getUuid())) {
			String uuid = _portalUUID.generate();

			externalDBTest.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (externalDBTest.getCreateDate() == null)) {
			if (serviceContext == null) {
				externalDBTest.setCreateDate(date);
			}
			else {
				externalDBTest.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!externalDBTestModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				externalDBTest.setModifiedDate(date);
			}
			else {
				externalDBTest.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(externalDBTest);
			}
			else {
				externalDBTest = (ExternalDBTest)session.merge(externalDBTest);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ExternalDBTestImpl.class, externalDBTestModelImpl, false, true);

		cacheUniqueFindersCache(externalDBTestModelImpl);

		if (isNew) {
			externalDBTest.setNew(false);
		}

		externalDBTest.resetOriginalValues();

		return externalDBTest;
	}

	/**
	 * Returns the external db test with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the external db test
	 * @return the external db test
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	@Override
	public ExternalDBTest findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTestException {

		ExternalDBTest externalDBTest = fetchByPrimaryKey(primaryKey);

		if (externalDBTest == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTestException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return externalDBTest;
	}

	/**
	 * Returns the external db test with the primary key or throws a <code>NoSuchTestException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	@Override
	public ExternalDBTest findByPrimaryKey(long fooId)
		throws NoSuchTestException {

		return findByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns the external db test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test, or <code>null</code> if a external db test with the primary key could not be found
	 */
	@Override
	public ExternalDBTest fetchByPrimaryKey(long fooId) {
		return fetchByPrimaryKey((Serializable)fooId);
	}

	/**
	 * Returns all the external db tests.
	 *
	 * @return the external db tests
	 */
	@Override
	public List<ExternalDBTest> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the external db tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @return the range of external db tests
	 */
	@Override
	public List<ExternalDBTest> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the external db tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of external db tests
	 */
	@Override
	public List<ExternalDBTest> findAll(
		int start, int end,
		OrderByComparator<ExternalDBTest> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the external db tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of external db tests
	 */
	@Override
	public List<ExternalDBTest> findAll(
		int start, int end, OrderByComparator<ExternalDBTest> orderByComparator,
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

		List<ExternalDBTest> list = null;

		if (useFinderCache) {
			list = (List<ExternalDBTest>)finderCache.getResult(
				finderPath, finderArgs);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_EXTERNALDBTEST);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_EXTERNALDBTEST;

				sql = sql.concat(ExternalDBTestModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ExternalDBTest>)QueryUtil.list(
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
	 * Removes all the external db tests from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ExternalDBTest externalDBTest : findAll()) {
			remove(externalDBTest);
		}
	}

	/**
	 * Returns the number of external db tests.
	 *
	 * @return the number of external db tests
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_EXTERNALDBTEST);

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
		return "fooId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_EXTERNALDBTEST;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ExternalDBTestModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the external db test persistence.
	 */
	public void afterPropertiesSet() {
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

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_setExternalDBTestUtilPersistence(this);
	}

	public void destroy() {
		_setExternalDBTestUtilPersistence(null);

		entityCache.removeCache(ExternalDBTestImpl.class.getName());
	}

	private void _setExternalDBTestUtilPersistence(
		ExternalDBTestPersistence externalDBTestPersistence) {

		try {
			Field field = ExternalDBTestUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, externalDBTestPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;

	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_EXTERNALDBTEST =
		"SELECT externalDBTest FROM ExternalDBTest externalDBTest";

	private static final String _SQL_SELECT_EXTERNALDBTEST_WHERE =
		"SELECT externalDBTest FROM ExternalDBTest externalDBTest WHERE ";

	private static final String _SQL_COUNT_EXTERNALDBTEST =
		"SELECT COUNT(externalDBTest) FROM ExternalDBTest externalDBTest";

	private static final String _SQL_COUNT_EXTERNALDBTEST_WHERE =
		"SELECT COUNT(externalDBTest) FROM ExternalDBTest externalDBTest WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "externalDBTest.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ExternalDBTest exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ExternalDBTest exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ExternalDBTestPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@ServiceReference(type = PortalUUID.class)
	private PortalUUID _portalUUID;

}