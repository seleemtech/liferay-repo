/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package api.master.slayer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchApiMapKeyException extends NoSuchModelException {

	public NoSuchApiMapKeyException() {
	}

	public NoSuchApiMapKeyException(String msg) {
		super(msg);
	}

	public NoSuchApiMapKeyException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchApiMapKeyException(Throwable throwable) {
		super(throwable);
	}

}