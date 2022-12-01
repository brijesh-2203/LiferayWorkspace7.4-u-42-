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

package externaldbservice.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import externaldbservice.exception.NoSuchTestException;

import externaldbservice.model.ExternalDBTest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the external db test service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ExternalDBTestUtil
 * @generated
 */
@ProviderType
public interface ExternalDBTestPersistence
	extends BasePersistence<ExternalDBTest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ExternalDBTestUtil} to access the external db test persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the external db tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching external db tests
	 */
	public java.util.List<ExternalDBTest> findByUuid(String uuid);

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
	public java.util.List<ExternalDBTest> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ExternalDBTest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator);

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
	public java.util.List<ExternalDBTest> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first external db test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	public ExternalDBTest findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Returns the first external db test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	public ExternalDBTest fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator);

	/**
	 * Returns the last external db test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	public ExternalDBTest findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Returns the last external db test in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	public ExternalDBTest fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator);

	/**
	 * Returns the external db tests before and after the current external db test in the ordered set where uuid = &#63;.
	 *
	 * @param fooId the primary key of the current external db test
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next external db test
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	public ExternalDBTest[] findByUuid_PrevAndNext(
			long fooId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Removes all the external db tests where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of external db tests where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching external db tests
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the external db test where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTestException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	public ExternalDBTest findByUUID_G(String uuid, long groupId)
		throws NoSuchTestException;

	/**
	 * Returns the external db test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	public ExternalDBTest fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the external db test where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	public ExternalDBTest fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the external db test where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the external db test that was removed
	 */
	public ExternalDBTest removeByUUID_G(String uuid, long groupId)
		throws NoSuchTestException;

	/**
	 * Returns the number of external db tests where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching external db tests
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the external db tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching external db tests
	 */
	public java.util.List<ExternalDBTest> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ExternalDBTest> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ExternalDBTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator);

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
	public java.util.List<ExternalDBTest> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	public ExternalDBTest findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Returns the first external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	public ExternalDBTest fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator);

	/**
	 * Returns the last external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external db test
	 * @throws NoSuchTestException if a matching external db test could not be found
	 */
	public ExternalDBTest findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Returns the last external db test in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	public ExternalDBTest fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator);

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
	public ExternalDBTest[] findByUuid_C_PrevAndNext(
			long fooId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
				orderByComparator)
		throws NoSuchTestException;

	/**
	 * Removes all the external db tests where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of external db tests where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching external db tests
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Caches the external db test in the entity cache if it is enabled.
	 *
	 * @param externalDBTest the external db test
	 */
	public void cacheResult(ExternalDBTest externalDBTest);

	/**
	 * Caches the external db tests in the entity cache if it is enabled.
	 *
	 * @param externalDBTests the external db tests
	 */
	public void cacheResult(java.util.List<ExternalDBTest> externalDBTests);

	/**
	 * Creates a new external db test with the primary key. Does not add the external db test to the database.
	 *
	 * @param fooId the primary key for the new external db test
	 * @return the new external db test
	 */
	public ExternalDBTest create(long fooId);

	/**
	 * Removes the external db test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test that was removed
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	public ExternalDBTest remove(long fooId) throws NoSuchTestException;

	public ExternalDBTest updateImpl(ExternalDBTest externalDBTest);

	/**
	 * Returns the external db test with the primary key or throws a <code>NoSuchTestException</code> if it could not be found.
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test
	 * @throws NoSuchTestException if a external db test with the primary key could not be found
	 */
	public ExternalDBTest findByPrimaryKey(long fooId)
		throws NoSuchTestException;

	/**
	 * Returns the external db test with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test, or <code>null</code> if a external db test with the primary key could not be found
	 */
	public ExternalDBTest fetchByPrimaryKey(long fooId);

	/**
	 * Returns all the external db tests.
	 *
	 * @return the external db tests
	 */
	public java.util.List<ExternalDBTest> findAll();

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
	public java.util.List<ExternalDBTest> findAll(int start, int end);

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
	public java.util.List<ExternalDBTest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator);

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
	public java.util.List<ExternalDBTest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ExternalDBTest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the external db tests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of external db tests.
	 *
	 * @return the number of external db tests
	 */
	public int countAll();

}