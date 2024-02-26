/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package api.master.slayer.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchMasterMetaDataException extends NoSuchModelException {

	public NoSuchMasterMetaDataException() {
	}

	public NoSuchMasterMetaDataException(String msg) {
		super(msg);
	}

	public NoSuchMasterMetaDataException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchMasterMetaDataException(Throwable throwable) {
		super(throwable);
	}

}