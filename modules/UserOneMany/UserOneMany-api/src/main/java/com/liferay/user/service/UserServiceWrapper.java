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

package com.liferay.user.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link UserService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserService
 * @generated
 */
public class UserServiceWrapper
	implements ServiceWrapper<UserService>, UserService {

	public UserServiceWrapper() {
		this(null);
	}

	public UserServiceWrapper(UserService userService) {
		_userService = userService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userService.getOSGiServiceIdentifier();
	}

	@Override
	public UserService getWrappedService() {
		return _userService;
	}

	@Override
	public void setWrappedService(UserService userService) {
		_userService = userService;
	}

	private UserService _userService;

}