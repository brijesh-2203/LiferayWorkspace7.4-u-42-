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

package externaldbservice.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import externaldbservice.model.ExternalDBTest;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for ExternalDBTest. This utility wraps
 * <code>externaldbservice.service.impl.ExternalDBTestLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ExternalDBTestLocalService
 * @generated
 */
public class ExternalDBTestLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>externaldbservice.service.impl.ExternalDBTestLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the external db test to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExternalDBTestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param externalDBTest the external db test
	 * @return the external db test that was added
	 */
	public static ExternalDBTest addExternalDBTest(
		ExternalDBTest externalDBTest) {

		return getService().addExternalDBTest(externalDBTest);
	}

	/**
	 * Creates a new external db test with the primary key. Does not add the external db test to the database.
	 *
	 * @param fooId the primary key for the new external db test
	 * @return the new external db test
	 */
	public static ExternalDBTest createExternalDBTest(long fooId) {
		return getService().createExternalDBTest(fooId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the external db test from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExternalDBTestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param externalDBTest the external db test
	 * @return the external db test that was removed
	 */
	public static ExternalDBTest deleteExternalDBTest(
		ExternalDBTest externalDBTest) {

		return getService().deleteExternalDBTest(externalDBTest);
	}

	/**
	 * Deletes the external db test with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExternalDBTestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test that was removed
	 * @throws PortalException if a external db test with the primary key could not be found
	 */
	public static ExternalDBTest deleteExternalDBTest(long fooId)
		throws PortalException {

		return getService().deleteExternalDBTest(fooId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>externaldbservice.model.impl.ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>externaldbservice.model.impl.ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static ExternalDBTest fetchExternalDBTest(long fooId) {
		return getService().fetchExternalDBTest(fooId);
	}

	/**
	 * Returns the external db test matching the UUID and group.
	 *
	 * @param uuid the external db test's UUID
	 * @param groupId the primary key of the group
	 * @return the matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	public static ExternalDBTest fetchExternalDBTestByUuidAndGroupId(
		String uuid, long groupId) {

		return getService().fetchExternalDBTestByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	/**
	 * Returns the external db test with the primary key.
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test
	 * @throws PortalException if a external db test with the primary key could not be found
	 */
	public static ExternalDBTest getExternalDBTest(long fooId)
		throws PortalException {

		return getService().getExternalDBTest(fooId);
	}

	/**
	 * Returns the external db test matching the UUID and group.
	 *
	 * @param uuid the external db test's UUID
	 * @param groupId the primary key of the group
	 * @return the matching external db test
	 * @throws PortalException if a matching external db test could not be found
	 */
	public static ExternalDBTest getExternalDBTestByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return getService().getExternalDBTestByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the external db tests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>externaldbservice.model.impl.ExternalDBTestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @return the range of external db tests
	 */
	public static List<ExternalDBTest> getExternalDBTests(int start, int end) {
		return getService().getExternalDBTests(start, end);
	}

	/**
	 * Returns all the external db tests matching the UUID and company.
	 *
	 * @param uuid the UUID of the external db tests
	 * @param companyId the primary key of the company
	 * @return the matching external db tests, or an empty list if no matches were found
	 */
	public static List<ExternalDBTest> getExternalDBTestsByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getExternalDBTestsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of external db tests matching the UUID and company.
	 *
	 * @param uuid the UUID of the external db tests
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of external db tests
	 * @param end the upper bound of the range of external db tests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching external db tests, or an empty list if no matches were found
	 */
	public static List<ExternalDBTest> getExternalDBTestsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ExternalDBTest> orderByComparator) {

		return getService().getExternalDBTestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of external db tests.
	 *
	 * @return the number of external db tests
	 */
	public static int getExternalDBTestsCount() {
		return getService().getExternalDBTestsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the external db test in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ExternalDBTestLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param externalDBTest the external db test
	 * @return the external db test that was updated
	 */
	public static ExternalDBTest updateExternalDBTest(
		ExternalDBTest externalDBTest) {

		return getService().updateExternalDBTest(externalDBTest);
	}

	public static ExternalDBTestLocalService getService() {
		return _service;
	}

	private static volatile ExternalDBTestLocalService _service;

}