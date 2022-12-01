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
 * Provides a wrapper for {@link ExternalDBTestService}.
 *
 * @author Brian Wing Shun Chan
 * @see ExternalDBTestService
 * @generated
 */
public class ExternalDBTestServiceWrapper
	implements ExternalDBTestService, ServiceWrapper<ExternalDBTestService> {

	public ExternalDBTestServiceWrapper() {
		this(null);
	}

	public ExternalDBTestServiceWrapper(
		ExternalDBTestService externalDBTestService) {

		_externalDBTestService = externalDBTestService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _externalDBTestService.getOSGiServiceIdentifier();
	}

	@Override
	public ExternalDBTestService getWrappedService() {
		return _externalDBTestService;
	}

	@Override
	public void setWrappedService(ExternalDBTestService externalDBTestService) {
		_externalDBTestService = externalDBTestService;
	}

	private ExternalDBTestService _externalDBTestService;

}