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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ExternalDBTestLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExternalDBTestLocalService
 * @generated
 */
public class ExternalDBTestLocalServiceWrapper
	implements ExternalDBTestLocalService,
			   ServiceWrapper<ExternalDBTestLocalService> {

	public ExternalDBTestLocalServiceWrapper() {
		this(null);
	}

	public ExternalDBTestLocalServiceWrapper(
		ExternalDBTestLocalService externalDBTestLocalService) {

		_externalDBTestLocalService = externalDBTestLocalService;
	}

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
	@Override
	public externaldbservice.model.ExternalDBTest addExternalDBTest(
		externaldbservice.model.ExternalDBTest externalDBTest) {

		return _externalDBTestLocalService.addExternalDBTest(externalDBTest);
	}

	/**
	 * Creates a new external db test with the primary key. Does not add the external db test to the database.
	 *
	 * @param fooId the primary key for the new external db test
	 * @return the new external db test
	 */
	@Override
	public externaldbservice.model.ExternalDBTest createExternalDBTest(
		long fooId) {

		return _externalDBTestLocalService.createExternalDBTest(fooId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _externalDBTestLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public externaldbservice.model.ExternalDBTest deleteExternalDBTest(
		externaldbservice.model.ExternalDBTest externalDBTest) {

		return _externalDBTestLocalService.deleteExternalDBTest(externalDBTest);
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
	@Override
	public externaldbservice.model.ExternalDBTest deleteExternalDBTest(
			long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _externalDBTestLocalService.deleteExternalDBTest(fooId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _externalDBTestLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _externalDBTestLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _externalDBTestLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _externalDBTestLocalService.dynamicQuery();
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

		return _externalDBTestLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _externalDBTestLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _externalDBTestLocalService.dynamicQuery(
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

		return _externalDBTestLocalService.dynamicQueryCount(dynamicQuery);
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

		return _externalDBTestLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public externaldbservice.model.ExternalDBTest fetchExternalDBTest(
		long fooId) {

		return _externalDBTestLocalService.fetchExternalDBTest(fooId);
	}

	/**
	 * Returns the external db test matching the UUID and group.
	 *
	 * @param uuid the external db test's UUID
	 * @param groupId the primary key of the group
	 * @return the matching external db test, or <code>null</code> if a matching external db test could not be found
	 */
	@Override
	public externaldbservice.model.ExternalDBTest
		fetchExternalDBTestByUuidAndGroupId(String uuid, long groupId) {

		return _externalDBTestLocalService.fetchExternalDBTestByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _externalDBTestLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _externalDBTestLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	/**
	 * Returns the external db test with the primary key.
	 *
	 * @param fooId the primary key of the external db test
	 * @return the external db test
	 * @throws PortalException if a external db test with the primary key could not be found
	 */
	@Override
	public externaldbservice.model.ExternalDBTest getExternalDBTest(long fooId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _externalDBTestLocalService.getExternalDBTest(fooId);
	}

	/**
	 * Returns the external db test matching the UUID and group.
	 *
	 * @param uuid the external db test's UUID
	 * @param groupId the primary key of the group
	 * @return the matching external db test
	 * @throws PortalException if a matching external db test could not be found
	 */
	@Override
	public externaldbservice.model.ExternalDBTest
			getExternalDBTestByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _externalDBTestLocalService.getExternalDBTestByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<externaldbservice.model.ExternalDBTest>
		getExternalDBTests(int start, int end) {

		return _externalDBTestLocalService.getExternalDBTests(start, end);
	}

	/**
	 * Returns all the external db tests matching the UUID and company.
	 *
	 * @param uuid the UUID of the external db tests
	 * @param companyId the primary key of the company
	 * @return the matching external db tests, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<externaldbservice.model.ExternalDBTest>
		getExternalDBTestsByUuidAndCompanyId(String uuid, long companyId) {

		return _externalDBTestLocalService.getExternalDBTestsByUuidAndCompanyId(
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
	@Override
	public java.util.List<externaldbservice.model.ExternalDBTest>
		getExternalDBTestsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<externaldbservice.model.ExternalDBTest> orderByComparator) {

		return _externalDBTestLocalService.getExternalDBTestsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of external db tests.
	 *
	 * @return the number of external db tests
	 */
	@Override
	public int getExternalDBTestsCount() {
		return _externalDBTestLocalService.getExternalDBTestsCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _externalDBTestLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _externalDBTestLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _externalDBTestLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public externaldbservice.model.ExternalDBTest updateExternalDBTest(
		externaldbservice.model.ExternalDBTest externalDBTest) {

		return _externalDBTestLocalService.updateExternalDBTest(externalDBTest);
	}

	@Override
	public ExternalDBTestLocalService getWrappedService() {
		return _externalDBTestLocalService;
	}

	@Override
	public void setWrappedService(
		ExternalDBTestLocalService externalDBTestLocalService) {

		_externalDBTestLocalService = externalDBTestLocalService;
	}

	private ExternalDBTestLocalService _externalDBTestLocalService;

}