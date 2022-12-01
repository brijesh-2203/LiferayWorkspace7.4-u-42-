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
 * Provides a wrapper for {@link AppService}.
 *
 * @author Brian Wing Shun Chan
 * @see AppService
 * @generated
 */
public class AppServiceWrapper
	implements AppService, ServiceWrapper<AppService> {

	public AppServiceWrapper() {
		this(null);
	}

	public AppServiceWrapper(AppService appService) {
		_appService = appService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _appService.getOSGiServiceIdentifier();
	}

	@Override
	public AppService getWrappedService() {
		return _appService;
	}

	@Override
	public void setWrappedService(AppService appService) {
		_appService = appService;
	}

	private AppService _appService;

}