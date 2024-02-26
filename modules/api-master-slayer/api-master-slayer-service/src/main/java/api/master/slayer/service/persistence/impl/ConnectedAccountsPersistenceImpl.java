/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence.impl;

import api.master.slayer.exception.NoSuchConnectedAccountsException;
import api.master.slayer.model.ConnectedAccounts;
import api.master.slayer.model.ConnectedAccountsTable;
import api.master.slayer.model.impl.ConnectedAccountsImpl;
import api.master.slayer.model.impl.ConnectedAccountsModelImpl;
import api.master.slayer.service.persistence.ConnectedAccountsPersistence;
import api.master.slayer.service.persistence.ConnectedAccountsUtil;
import api.master.slayer.service.persistence.impl.constants.APIPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the connected accounts service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ConnectedAccountsPersistence.class)
public class ConnectedAccountsPersistenceImpl
	extends BasePersistenceImpl<ConnectedAccounts>
	implements ConnectedAccountsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ConnectedAccountsUtil</code> to access the connected accounts persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ConnectedAccountsImpl.class.getName();

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
	 * Returns all the connected accountses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the connected accountses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the connected accountses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the connected accountses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator,
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

		List<ConnectedAccounts> list = null;

		if (useFinderCache) {
			list = (List<ConnectedAccounts>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConnectedAccounts connectedAccounts : list) {
					if (!uuid.equals(connectedAccounts.getUuid())) {
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

			sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

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
				sb.append(ConnectedAccountsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ConnectedAccounts>)QueryUtil.list(
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
	 * Returns the first connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByUuid_First(
			String uuid, OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByUuid_First(
			uuid, orderByComparator);

		if (connectedAccounts != null) {
			return connectedAccounts;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchConnectedAccountsException(sb.toString());
	}

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByUuid_First(
		String uuid, OrderByComparator<ConnectedAccounts> orderByComparator) {

		List<ConnectedAccounts> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByUuid_Last(
			String uuid, OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByUuid_Last(
			uuid, orderByComparator);

		if (connectedAccounts != null) {
			return connectedAccounts;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchConnectedAccountsException(sb.toString());
	}

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByUuid_Last(
		String uuid, OrderByComparator<ConnectedAccounts> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ConnectedAccounts> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the connected accountses before and after the current connected accounts in the ordered set where uuid = &#63;.
	 *
	 * @param c_accountId the primary key of the current connected accounts
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts[] findByUuid_PrevAndNext(
			long c_accountId, String uuid,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		uuid = Objects.toString(uuid, "");

		ConnectedAccounts connectedAccounts = findByPrimaryKey(c_accountId);

		Session session = null;

		try {
			session = openSession();

			ConnectedAccounts[] array = new ConnectedAccountsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, connectedAccounts, uuid, orderByComparator, true);

			array[1] = connectedAccounts;

			array[2] = getByUuid_PrevAndNext(
				session, connectedAccounts, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConnectedAccounts getByUuid_PrevAndNext(
		Session session, ConnectedAccounts connectedAccounts, String uuid,
		OrderByComparator<ConnectedAccounts> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

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
			sb.append(ConnectedAccountsModelImpl.ORDER_BY_JPQL);
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
						connectedAccounts)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConnectedAccounts> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the connected accountses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ConnectedAccounts connectedAccounts :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(connectedAccounts);
		}
	}

	/**
	 * Returns the number of connected accountses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching connected accountses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONNECTEDACCOUNTS_WHERE);

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
		"connectedAccounts.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(connectedAccounts.uuid IS NULL OR connectedAccounts.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByUUID_G(String uuid, long groupId)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByUUID_G(uuid, groupId);

		if (connectedAccounts == null) {
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

			throw new NoSuchConnectedAccountsException(sb.toString());
		}

		return connectedAccounts;
	}

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the connected accounts where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof ConnectedAccounts) {
			ConnectedAccounts connectedAccounts = (ConnectedAccounts)result;

			if (!Objects.equals(uuid, connectedAccounts.getUuid()) ||
				(groupId != connectedAccounts.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

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

				List<ConnectedAccounts> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ConnectedAccounts connectedAccounts = list.get(0);

					result = connectedAccounts;

					cacheResult(connectedAccounts);
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
			return (ConnectedAccounts)result;
		}
	}

	/**
	 * Removes the connected accounts where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the connected accounts that was removed
	 */
	@Override
	public ConnectedAccounts removeByUUID_G(String uuid, long groupId)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = findByUUID_G(uuid, groupId);

		return remove(connectedAccounts);
	}

	/**
	 * Returns the number of connected accountses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching connected accountses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONNECTEDACCOUNTS_WHERE);

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
		"connectedAccounts.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(connectedAccounts.uuid IS NULL OR connectedAccounts.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"connectedAccounts.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator,
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

		List<ConnectedAccounts> list = null;

		if (useFinderCache) {
			list = (List<ConnectedAccounts>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConnectedAccounts connectedAccounts : list) {
					if (!uuid.equals(connectedAccounts.getUuid()) ||
						(companyId != connectedAccounts.getCompanyId())) {

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

			sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

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
				sb.append(ConnectedAccountsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ConnectedAccounts>)QueryUtil.list(
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
	 * Returns the first connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (connectedAccounts != null) {
			return connectedAccounts;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchConnectedAccountsException(sb.toString());
	}

	/**
	 * Returns the first connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		List<ConnectedAccounts> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (connectedAccounts != null) {
			return connectedAccounts;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchConnectedAccountsException(sb.toString());
	}

	/**
	 * Returns the last connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ConnectedAccounts> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the connected accountses before and after the current connected accounts in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param c_accountId the primary key of the current connected accounts
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts[] findByUuid_C_PrevAndNext(
			long c_accountId, String uuid, long companyId,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		uuid = Objects.toString(uuid, "");

		ConnectedAccounts connectedAccounts = findByPrimaryKey(c_accountId);

		Session session = null;

		try {
			session = openSession();

			ConnectedAccounts[] array = new ConnectedAccountsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, connectedAccounts, uuid, companyId, orderByComparator,
				true);

			array[1] = connectedAccounts;

			array[2] = getByUuid_C_PrevAndNext(
				session, connectedAccounts, uuid, companyId, orderByComparator,
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

	protected ConnectedAccounts getByUuid_C_PrevAndNext(
		Session session, ConnectedAccounts connectedAccounts, String uuid,
		long companyId, OrderByComparator<ConnectedAccounts> orderByComparator,
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

		sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

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
			sb.append(ConnectedAccountsModelImpl.ORDER_BY_JPQL);
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
						connectedAccounts)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConnectedAccounts> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the connected accountses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ConnectedAccounts connectedAccounts :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(connectedAccounts);
		}
	}

	/**
	 * Returns the number of connected accountses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching connected accountses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONNECTEDACCOUNTS_WHERE);

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
		"connectedAccounts.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(connectedAccounts.uuid IS NULL OR connectedAccounts.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"connectedAccounts.companyId = ?";

	private FinderPath _finderPathFetchByAppName;
	private FinderPath _finderPathCountByAppName;

	/**
	 * Returns the connected accounts where appName = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByAppName(String appName)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByAppName(appName);

		if (connectedAccounts == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("appName=");
			sb.append(appName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchConnectedAccountsException(sb.toString());
		}

		return connectedAccounts;
	}

	/**
	 * Returns the connected accounts where appName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByAppName(String appName) {
		return fetchByAppName(appName, true);
	}

	/**
	 * Returns the connected accounts where appName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByAppName(
		String appName, boolean useFinderCache) {

		appName = Objects.toString(appName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {appName};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByAppName, finderArgs, this);
		}

		if (result instanceof ConnectedAccounts) {
			ConnectedAccounts connectedAccounts = (ConnectedAccounts)result;

			if (!Objects.equals(appName, connectedAccounts.getAppName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

			boolean bindAppName = false;

			if (appName.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPNAME_APPNAME_3);
			}
			else {
				bindAppName = true;

				sb.append(_FINDER_COLUMN_APPNAME_APPNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppName) {
					queryPos.add(appName);
				}

				List<ConnectedAccounts> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByAppName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {appName};
							}

							_log.warn(
								"ConnectedAccountsPersistenceImpl.fetchByAppName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ConnectedAccounts connectedAccounts = list.get(0);

					result = connectedAccounts;

					cacheResult(connectedAccounts);
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
			return (ConnectedAccounts)result;
		}
	}

	/**
	 * Removes the connected accounts where appName = &#63; from the database.
	 *
	 * @param appName the app name
	 * @return the connected accounts that was removed
	 */
	@Override
	public ConnectedAccounts removeByAppName(String appName)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = findByAppName(appName);

		return remove(connectedAccounts);
	}

	/**
	 * Returns the number of connected accountses where appName = &#63;.
	 *
	 * @param appName the app name
	 * @return the number of matching connected accountses
	 */
	@Override
	public int countByAppName(String appName) {
		appName = Objects.toString(appName, "");

		FinderPath finderPath = _finderPathCountByAppName;

		Object[] finderArgs = new Object[] {appName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONNECTEDACCOUNTS_WHERE);

			boolean bindAppName = false;

			if (appName.isEmpty()) {
				sb.append(_FINDER_COLUMN_APPNAME_APPNAME_3);
			}
			else {
				bindAppName = true;

				sb.append(_FINDER_COLUMN_APPNAME_APPNAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppName) {
					queryPos.add(appName);
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

	private static final String _FINDER_COLUMN_APPNAME_APPNAME_2 =
		"connectedAccounts.appName = ?";

	private static final String _FINDER_COLUMN_APPNAME_APPNAME_3 =
		"(connectedAccounts.appName IS NULL OR connectedAccounts.appName = '')";

	private FinderPath _finderPathFetchByGetAccount;
	private FinderPath _finderPathCountByGetAccount;

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByGetAccount(
			String appName, String emailAddress)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByGetAccount(
			appName, emailAddress);

		if (connectedAccounts == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("appName=");
			sb.append(appName);

			sb.append(", emailAddress=");
			sb.append(emailAddress);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchConnectedAccountsException(sb.toString());
		}

		return connectedAccounts;
	}

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByGetAccount(
		String appName, String emailAddress) {

		return fetchByGetAccount(appName, emailAddress, true);
	}

	/**
	 * Returns the connected accounts where appName = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByGetAccount(
		String appName, String emailAddress, boolean useFinderCache) {

		appName = Objects.toString(appName, "");
		emailAddress = Objects.toString(emailAddress, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {appName, emailAddress};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByGetAccount, finderArgs, this);
		}

		if (result instanceof ConnectedAccounts) {
			ConnectedAccounts connectedAccounts = (ConnectedAccounts)result;

			if (!Objects.equals(appName, connectedAccounts.getAppName()) ||
				!Objects.equals(
					emailAddress, connectedAccounts.getEmailAddress())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

			boolean bindAppName = false;

			if (appName.isEmpty()) {
				sb.append(_FINDER_COLUMN_GETACCOUNT_APPNAME_3);
			}
			else {
				bindAppName = true;

				sb.append(_FINDER_COLUMN_GETACCOUNT_APPNAME_2);
			}

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_GETACCOUNT_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_GETACCOUNT_EMAILADDRESS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppName) {
					queryPos.add(appName);
				}

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
				}

				List<ConnectedAccounts> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByGetAccount, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									appName, emailAddress
								};
							}

							_log.warn(
								"ConnectedAccountsPersistenceImpl.fetchByGetAccount(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ConnectedAccounts connectedAccounts = list.get(0);

					result = connectedAccounts;

					cacheResult(connectedAccounts);
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
			return (ConnectedAccounts)result;
		}
	}

	/**
	 * Removes the connected accounts where appName = &#63; and emailAddress = &#63; from the database.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the connected accounts that was removed
	 */
	@Override
	public ConnectedAccounts removeByGetAccount(
			String appName, String emailAddress)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = findByGetAccount(
			appName, emailAddress);

		return remove(connectedAccounts);
	}

	/**
	 * Returns the number of connected accountses where appName = &#63; and emailAddress = &#63;.
	 *
	 * @param appName the app name
	 * @param emailAddress the email address
	 * @return the number of matching connected accountses
	 */
	@Override
	public int countByGetAccount(String appName, String emailAddress) {
		appName = Objects.toString(appName, "");
		emailAddress = Objects.toString(emailAddress, "");

		FinderPath finderPath = _finderPathCountByGetAccount;

		Object[] finderArgs = new Object[] {appName, emailAddress};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CONNECTEDACCOUNTS_WHERE);

			boolean bindAppName = false;

			if (appName.isEmpty()) {
				sb.append(_FINDER_COLUMN_GETACCOUNT_APPNAME_3);
			}
			else {
				bindAppName = true;

				sb.append(_FINDER_COLUMN_GETACCOUNT_APPNAME_2);
			}

			boolean bindEmailAddress = false;

			if (emailAddress.isEmpty()) {
				sb.append(_FINDER_COLUMN_GETACCOUNT_EMAILADDRESS_3);
			}
			else {
				bindEmailAddress = true;

				sb.append(_FINDER_COLUMN_GETACCOUNT_EMAILADDRESS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindAppName) {
					queryPos.add(appName);
				}

				if (bindEmailAddress) {
					queryPos.add(emailAddress);
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

	private static final String _FINDER_COLUMN_GETACCOUNT_APPNAME_2 =
		"connectedAccounts.appName = ? AND ";

	private static final String _FINDER_COLUMN_GETACCOUNT_APPNAME_3 =
		"(connectedAccounts.appName IS NULL OR connectedAccounts.appName = '') AND ";

	private static final String _FINDER_COLUMN_GETACCOUNT_EMAILADDRESS_2 =
		"connectedAccounts.emailAddress = ?";

	private static final String _FINDER_COLUMN_GETACCOUNT_EMAILADDRESS_3 =
		"(connectedAccounts.emailAddress IS NULL OR connectedAccounts.emailAddress = '')";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the connected accountses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the connected accountses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUserId(
		long userId, int start, int end) {

		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the connected accountses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the connected accountses where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUserId;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUserId;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<ConnectedAccounts> list = null;

		if (useFinderCache) {
			list = (List<ConnectedAccounts>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ConnectedAccounts connectedAccounts : list) {
					if (userId != connectedAccounts.getUserId()) {
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

			sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ConnectedAccountsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<ConnectedAccounts>)QueryUtil.list(
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
	 * Returns the first connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByUserId_First(
			long userId, OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByUserId_First(
			userId, orderByComparator);

		if (connectedAccounts != null) {
			return connectedAccounts;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchConnectedAccountsException(sb.toString());
	}

	/**
	 * Returns the first connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByUserId_First(
		long userId, OrderByComparator<ConnectedAccounts> orderByComparator) {

		List<ConnectedAccounts> list = findByUserId(
			userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts
	 * @throws NoSuchConnectedAccountsException if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts findByUserId_Last(
			long userId, OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByUserId_Last(
			userId, orderByComparator);

		if (connectedAccounts != null) {
			return connectedAccounts;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchConnectedAccountsException(sb.toString());
	}

	/**
	 * Returns the last connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching connected accounts, or <code>null</code> if a matching connected accounts could not be found
	 */
	@Override
	public ConnectedAccounts fetchByUserId_Last(
		long userId, OrderByComparator<ConnectedAccounts> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<ConnectedAccounts> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the connected accountses before and after the current connected accounts in the ordered set where userId = &#63;.
	 *
	 * @param c_accountId the primary key of the current connected accounts
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts[] findByUserId_PrevAndNext(
			long c_accountId, long userId,
			OrderByComparator<ConnectedAccounts> orderByComparator)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = findByPrimaryKey(c_accountId);

		Session session = null;

		try {
			session = openSession();

			ConnectedAccounts[] array = new ConnectedAccountsImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, connectedAccounts, userId, orderByComparator, true);

			array[1] = connectedAccounts;

			array[2] = getByUserId_PrevAndNext(
				session, connectedAccounts, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ConnectedAccounts getByUserId_PrevAndNext(
		Session session, ConnectedAccounts connectedAccounts, long userId,
		OrderByComparator<ConnectedAccounts> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CONNECTEDACCOUNTS_WHERE);

		sb.append(_FINDER_COLUMN_USERID_USERID_2);

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
			sb.append(ConnectedAccountsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						connectedAccounts)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ConnectedAccounts> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the connected accountses where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (ConnectedAccounts connectedAccounts :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(connectedAccounts);
		}
	}

	/**
	 * Returns the number of connected accountses where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching connected accountses
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CONNECTEDACCOUNTS_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_USERID_USERID_2 =
		"connectedAccounts.userId = ?";

	public ConnectedAccountsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ConnectedAccounts.class);

		setModelImplClass(ConnectedAccountsImpl.class);
		setModelPKClass(long.class);

		setTable(ConnectedAccountsTable.INSTANCE);
	}

	/**
	 * Caches the connected accounts in the entity cache if it is enabled.
	 *
	 * @param connectedAccounts the connected accounts
	 */
	@Override
	public void cacheResult(ConnectedAccounts connectedAccounts) {
		entityCache.putResult(
			ConnectedAccountsImpl.class, connectedAccounts.getPrimaryKey(),
			connectedAccounts);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				connectedAccounts.getUuid(), connectedAccounts.getGroupId()
			},
			connectedAccounts);

		finderCache.putResult(
			_finderPathFetchByAppName,
			new Object[] {connectedAccounts.getAppName()}, connectedAccounts);

		finderCache.putResult(
			_finderPathFetchByGetAccount,
			new Object[] {
				connectedAccounts.getAppName(),
				connectedAccounts.getEmailAddress()
			},
			connectedAccounts);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the connected accountses in the entity cache if it is enabled.
	 *
	 * @param connectedAccountses the connected accountses
	 */
	@Override
	public void cacheResult(List<ConnectedAccounts> connectedAccountses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (connectedAccountses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ConnectedAccounts connectedAccounts : connectedAccountses) {
			if (entityCache.getResult(
					ConnectedAccountsImpl.class,
					connectedAccounts.getPrimaryKey()) == null) {

				cacheResult(connectedAccounts);
			}
		}
	}

	/**
	 * Clears the cache for all connected accountses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ConnectedAccountsImpl.class);

		finderCache.clearCache(ConnectedAccountsImpl.class);
	}

	/**
	 * Clears the cache for the connected accounts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ConnectedAccounts connectedAccounts) {
		entityCache.removeResult(
			ConnectedAccountsImpl.class, connectedAccounts);
	}

	@Override
	public void clearCache(List<ConnectedAccounts> connectedAccountses) {
		for (ConnectedAccounts connectedAccounts : connectedAccountses) {
			entityCache.removeResult(
				ConnectedAccountsImpl.class, connectedAccounts);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ConnectedAccountsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ConnectedAccountsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ConnectedAccountsModelImpl connectedAccountsModelImpl) {

		Object[] args = new Object[] {
			connectedAccountsModelImpl.getUuid(),
			connectedAccountsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, connectedAccountsModelImpl);

		args = new Object[] {connectedAccountsModelImpl.getAppName()};

		finderCache.putResult(_finderPathCountByAppName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByAppName, args, connectedAccountsModelImpl);

		args = new Object[] {
			connectedAccountsModelImpl.getAppName(),
			connectedAccountsModelImpl.getEmailAddress()
		};

		finderCache.putResult(
			_finderPathCountByGetAccount, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByGetAccount, args, connectedAccountsModelImpl);
	}

	/**
	 * Creates a new connected accounts with the primary key. Does not add the connected accounts to the database.
	 *
	 * @param c_accountId the primary key for the new connected accounts
	 * @return the new connected accounts
	 */
	@Override
	public ConnectedAccounts create(long c_accountId) {
		ConnectedAccounts connectedAccounts = new ConnectedAccountsImpl();

		connectedAccounts.setNew(true);
		connectedAccounts.setPrimaryKey(c_accountId);

		String uuid = PortalUUIDUtil.generate();

		connectedAccounts.setUuid(uuid);

		connectedAccounts.setCompanyId(CompanyThreadLocal.getCompanyId());

		return connectedAccounts;
	}

	/**
	 * Removes the connected accounts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts that was removed
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts remove(long c_accountId)
		throws NoSuchConnectedAccountsException {

		return remove((Serializable)c_accountId);
	}

	/**
	 * Removes the connected accounts with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the connected accounts
	 * @return the connected accounts that was removed
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts remove(Serializable primaryKey)
		throws NoSuchConnectedAccountsException {

		Session session = null;

		try {
			session = openSession();

			ConnectedAccounts connectedAccounts =
				(ConnectedAccounts)session.get(
					ConnectedAccountsImpl.class, primaryKey);

			if (connectedAccounts == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchConnectedAccountsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(connectedAccounts);
		}
		catch (NoSuchConnectedAccountsException noSuchEntityException) {
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
	protected ConnectedAccounts removeImpl(
		ConnectedAccounts connectedAccounts) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(connectedAccounts)) {
				connectedAccounts = (ConnectedAccounts)session.get(
					ConnectedAccountsImpl.class,
					connectedAccounts.getPrimaryKeyObj());
			}

			if (connectedAccounts != null) {
				session.delete(connectedAccounts);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (connectedAccounts != null) {
			clearCache(connectedAccounts);
		}

		return connectedAccounts;
	}

	@Override
	public ConnectedAccounts updateImpl(ConnectedAccounts connectedAccounts) {
		boolean isNew = connectedAccounts.isNew();

		if (!(connectedAccounts instanceof ConnectedAccountsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(connectedAccounts.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					connectedAccounts);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in connectedAccounts proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ConnectedAccounts implementation " +
					connectedAccounts.getClass());
		}

		ConnectedAccountsModelImpl connectedAccountsModelImpl =
			(ConnectedAccountsModelImpl)connectedAccounts;

		if (Validator.isNull(connectedAccounts.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			connectedAccounts.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (connectedAccounts.getCreateDate() == null)) {
			if (serviceContext == null) {
				connectedAccounts.setCreateDate(date);
			}
			else {
				connectedAccounts.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!connectedAccountsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				connectedAccounts.setModifiedDate(date);
			}
			else {
				connectedAccounts.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(connectedAccounts);
			}
			else {
				connectedAccounts = (ConnectedAccounts)session.merge(
					connectedAccounts);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ConnectedAccountsImpl.class, connectedAccountsModelImpl, false,
			true);

		cacheUniqueFindersCache(connectedAccountsModelImpl);

		if (isNew) {
			connectedAccounts.setNew(false);
		}

		connectedAccounts.resetOriginalValues();

		return connectedAccounts;
	}

	/**
	 * Returns the connected accounts with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the connected accounts
	 * @return the connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts findByPrimaryKey(Serializable primaryKey)
		throws NoSuchConnectedAccountsException {

		ConnectedAccounts connectedAccounts = fetchByPrimaryKey(primaryKey);

		if (connectedAccounts == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchConnectedAccountsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return connectedAccounts;
	}

	/**
	 * Returns the connected accounts with the primary key or throws a <code>NoSuchConnectedAccountsException</code> if it could not be found.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts
	 * @throws NoSuchConnectedAccountsException if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts findByPrimaryKey(long c_accountId)
		throws NoSuchConnectedAccountsException {

		return findByPrimaryKey((Serializable)c_accountId);
	}

	/**
	 * Returns the connected accounts with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param c_accountId the primary key of the connected accounts
	 * @return the connected accounts, or <code>null</code> if a connected accounts with the primary key could not be found
	 */
	@Override
	public ConnectedAccounts fetchByPrimaryKey(long c_accountId) {
		return fetchByPrimaryKey((Serializable)c_accountId);
	}

	/**
	 * Returns all the connected accountses.
	 *
	 * @return the connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the connected accountses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @return the range of connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the connected accountses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findAll(
		int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the connected accountses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ConnectedAccountsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of connected accountses
	 * @param end the upper bound of the range of connected accountses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of connected accountses
	 */
	@Override
	public List<ConnectedAccounts> findAll(
		int start, int end,
		OrderByComparator<ConnectedAccounts> orderByComparator,
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

		List<ConnectedAccounts> list = null;

		if (useFinderCache) {
			list = (List<ConnectedAccounts>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CONNECTEDACCOUNTS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CONNECTEDACCOUNTS;

				sql = sql.concat(ConnectedAccountsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ConnectedAccounts>)QueryUtil.list(
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
	 * Removes all the connected accountses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ConnectedAccounts connectedAccounts : findAll()) {
			remove(connectedAccounts);
		}
	}

	/**
	 * Returns the number of connected accountses.
	 *
	 * @return the number of connected accountses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CONNECTEDACCOUNTS);

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
		return "c_accountId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CONNECTEDACCOUNTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ConnectedAccountsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the connected accounts persistence.
	 */
	@Activate
	public void activate() {
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

		_finderPathFetchByAppName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByAppName",
			new String[] {String.class.getName()}, new String[] {"appName"},
			true);

		_finderPathCountByAppName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAppName",
			new String[] {String.class.getName()}, new String[] {"appName"},
			false);

		_finderPathFetchByGetAccount = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByGetAccount",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"appName", "emailAddress"}, true);

		_finderPathCountByGetAccount = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGetAccount",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"appName", "emailAddress"}, false);

		_finderPathWithPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"userId"}, true);

		_finderPathWithoutPaginationFindByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"}, true);

		_finderPathCountByUserId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
			new String[] {Long.class.getName()}, new String[] {"userId"},
			false);

		ConnectedAccountsUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ConnectedAccountsUtil.setPersistence(null);

		entityCache.removeCache(ConnectedAccountsImpl.class.getName());
	}

	@Override
	@Reference(
		target = APIPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = APIPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = APIPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CONNECTEDACCOUNTS =
		"SELECT connectedAccounts FROM ConnectedAccounts connectedAccounts";

	private static final String _SQL_SELECT_CONNECTEDACCOUNTS_WHERE =
		"SELECT connectedAccounts FROM ConnectedAccounts connectedAccounts WHERE ";

	private static final String _SQL_COUNT_CONNECTEDACCOUNTS =
		"SELECT COUNT(connectedAccounts) FROM ConnectedAccounts connectedAccounts";

	private static final String _SQL_COUNT_CONNECTEDACCOUNTS_WHERE =
		"SELECT COUNT(connectedAccounts) FROM ConnectedAccounts connectedAccounts WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "connectedAccounts.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ConnectedAccounts exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ConnectedAccounts exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ConnectedAccountsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}