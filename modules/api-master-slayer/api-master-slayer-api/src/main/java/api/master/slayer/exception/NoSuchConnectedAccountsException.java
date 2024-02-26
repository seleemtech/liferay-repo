/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package api.master.slayer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchConnectedAccountsException extends NoSuchModelException {

	public NoSuchConnectedAccountsException() {
	}

	public NoSuchConnectedAccountsException(String msg) {
		super(msg);
	}

	public NoSuchConnectedAccountsException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchConnectedAccountsException(Throwable throwable) {
		super(throwable);
	}

}