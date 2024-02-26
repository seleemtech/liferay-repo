/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence.impl;

import api.master.slayer.exception.NoSuchMasterUrlException;
import api.master.slayer.model.MasterUrl;
import api.master.slayer.model.MasterUrlTable;
import api.master.slayer.model.impl.MasterUrlImpl;
import api.master.slayer.model.impl.MasterUrlModelImpl;
import api.master.slayer.service.persistence.MasterUrlPersistence;
import api.master.slayer.service.persistence.MasterUrlUtil;
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
 * The persistence implementation for the master url service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MasterUrlPersistence.class)
public class MasterUrlPersistenceImpl
	extends BasePersistenceImpl<MasterUrl> implements MasterUrlPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterUrlUtil</code> to access the master url persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterUrlImpl.class.getName();

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
	 * Returns all the master urls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching master urls
	 */
	@Override
	public List<MasterUrl> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master urls where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @return the range of matching master urls
	 */
	@Override
	public List<MasterUrl> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master urls where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master urls
	 */
	@Override
	public List<MasterUrl> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master urls where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master urls
	 */
	@Override
	public List<MasterUrl> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator,
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

		List<MasterUrl> list = null;

		if (useFinderCache) {
			list = (List<MasterUrl>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterUrl masterUrl : list) {
					if (!uuid.equals(masterUrl.getUuid())) {
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

			sb.append(_SQL_SELECT_MASTERURL_WHERE);

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
				sb.append(MasterUrlModelImpl.ORDER_BY_JPQL);
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

				list = (List<MasterUrl>)QueryUtil.list(
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
	 * Returns the first master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	@Override
	public MasterUrl findByUuid_First(
			String uuid, OrderByComparator<MasterUrl> orderByComparator)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = fetchByUuid_First(uuid, orderByComparator);

		if (masterUrl != null) {
			return masterUrl;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMasterUrlException(sb.toString());
	}

	/**
	 * Returns the first master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchByUuid_First(
		String uuid, OrderByComparator<MasterUrl> orderByComparator) {

		List<MasterUrl> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	@Override
	public MasterUrl findByUuid_Last(
			String uuid, OrderByComparator<MasterUrl> orderByComparator)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = fetchByUuid_Last(uuid, orderByComparator);

		if (masterUrl != null) {
			return masterUrl;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMasterUrlException(sb.toString());
	}

	/**
	 * Returns the last master url in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchByUuid_Last(
		String uuid, OrderByComparator<MasterUrl> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MasterUrl> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master urls before and after the current master url in the ordered set where uuid = &#63;.
	 *
	 * @param masterUrlId the primary key of the current master url
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	@Override
	public MasterUrl[] findByUuid_PrevAndNext(
			long masterUrlId, String uuid,
			OrderByComparator<MasterUrl> orderByComparator)
		throws NoSuchMasterUrlException {

		uuid = Objects.toString(uuid, "");

		MasterUrl masterUrl = findByPrimaryKey(masterUrlId);

		Session session = null;

		try {
			session = openSession();

			MasterUrl[] array = new MasterUrlImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, masterUrl, uuid, orderByComparator, true);

			array[1] = masterUrl;

			array[2] = getByUuid_PrevAndNext(
				session, masterUrl, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterUrl getByUuid_PrevAndNext(
		Session session, MasterUrl masterUrl, String uuid,
		OrderByComparator<MasterUrl> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERURL_WHERE);

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
			sb.append(MasterUrlModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(masterUrl)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterUrl> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master urls where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MasterUrl masterUrl :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterUrl);
		}
	}

	/**
	 * Returns the number of master urls where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching master urls
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERURL_WHERE);

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
		"masterUrl.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(masterUrl.uuid IS NULL OR masterUrl.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	@Override
	public MasterUrl findByUUID_G(String uuid, long groupId)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = fetchByUUID_G(uuid, groupId);

		if (masterUrl == null) {
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

			throw new NoSuchMasterUrlException(sb.toString());
		}

		return masterUrl;
	}

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the master url where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchByUUID_G(
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

		if (result instanceof MasterUrl) {
			MasterUrl masterUrl = (MasterUrl)result;

			if (!Objects.equals(uuid, masterUrl.getUuid()) ||
				(groupId != masterUrl.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MASTERURL_WHERE);

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

				List<MasterUrl> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					MasterUrl masterUrl = list.get(0);

					result = masterUrl;

					cacheResult(masterUrl);
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
			return (MasterUrl)result;
		}
	}

	/**
	 * Removes the master url where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the master url that was removed
	 */
	@Override
	public MasterUrl removeByUUID_G(String uuid, long groupId)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = findByUUID_G(uuid, groupId);

		return remove(masterUrl);
	}

	/**
	 * Returns the number of master urls where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching master urls
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MASTERURL_WHERE);

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
		"masterUrl.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(masterUrl.uuid IS NULL OR masterUrl.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"masterUrl.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching master urls
	 */
	@Override
	public List<MasterUrl> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @return the range of matching master urls
	 */
	@Override
	public List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master urls
	 */
	@Override
	public List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master urls
	 */
	@Override
	public List<MasterUrl> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterUrl> orderByComparator,
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

		List<MasterUrl> list = null;

		if (useFinderCache) {
			list = (List<MasterUrl>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterUrl masterUrl : list) {
					if (!uuid.equals(masterUrl.getUuid()) ||
						(companyId != masterUrl.getCompanyId())) {

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

			sb.append(_SQL_SELECT_MASTERURL_WHERE);

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
				sb.append(MasterUrlModelImpl.ORDER_BY_JPQL);
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

				list = (List<MasterUrl>)QueryUtil.list(
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
	 * Returns the first master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	@Override
	public MasterUrl findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MasterUrl> orderByComparator)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (masterUrl != null) {
			return masterUrl;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMasterUrlException(sb.toString());
	}

	/**
	 * Returns the first master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MasterUrl> orderByComparator) {

		List<MasterUrl> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	@Override
	public MasterUrl findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MasterUrl> orderByComparator)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (masterUrl != null) {
			return masterUrl;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMasterUrlException(sb.toString());
	}

	/**
	 * Returns the last master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MasterUrl> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MasterUrl> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master urls before and after the current master url in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param masterUrlId the primary key of the current master url
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	@Override
	public MasterUrl[] findByUuid_C_PrevAndNext(
			long masterUrlId, String uuid, long companyId,
			OrderByComparator<MasterUrl> orderByComparator)
		throws NoSuchMasterUrlException {

		uuid = Objects.toString(uuid, "");

		MasterUrl masterUrl = findByPrimaryKey(masterUrlId);

		Session session = null;

		try {
			session = openSession();

			MasterUrl[] array = new MasterUrlImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, masterUrl, uuid, companyId, orderByComparator, true);

			array[1] = masterUrl;

			array[2] = getByUuid_C_PrevAndNext(
				session, masterUrl, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterUrl getByUuid_C_PrevAndNext(
		Session session, MasterUrl masterUrl, String uuid, long companyId,
		OrderByComparator<MasterUrl> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MASTERURL_WHERE);

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
			sb.append(MasterUrlModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(masterUrl)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterUrl> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master urls where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MasterUrl masterUrl :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(masterUrl);
		}
	}

	/**
	 * Returns the number of master urls where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching master urls
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MASTERURL_WHERE);

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
		"masterUrl.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(masterUrl.uuid IS NULL OR masterUrl.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"masterUrl.companyId = ?";

	private FinderPath _finderPathFetchByAppName;
	private FinderPath _finderPathCountByAppName;

	/**
	 * Returns the master url where appName = &#63; or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param appName the app name
	 * @return the matching master url
	 * @throws NoSuchMasterUrlException if a matching master url could not be found
	 */
	@Override
	public MasterUrl findByAppName(String appName)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = fetchByAppName(appName);

		if (masterUrl == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("appName=");
			sb.append(appName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMasterUrlException(sb.toString());
		}

		return masterUrl;
	}

	/**
	 * Returns the master url where appName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param appName the app name
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchByAppName(String appName) {
		return fetchByAppName(appName, true);
	}

	/**
	 * Returns the master url where appName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param appName the app name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master url, or <code>null</code> if a matching master url could not be found
	 */
	@Override
	public MasterUrl fetchByAppName(String appName, boolean useFinderCache) {
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

		if (result instanceof MasterUrl) {
			MasterUrl masterUrl = (MasterUrl)result;

			if (!Objects.equals(appName, masterUrl.getAppName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MASTERURL_WHERE);

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

				List<MasterUrl> list = query.list();

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
								"MasterUrlPersistenceImpl.fetchByAppName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MasterUrl masterUrl = list.get(0);

					result = masterUrl;

					cacheResult(masterUrl);
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
			return (MasterUrl)result;
		}
	}

	/**
	 * Removes the master url where appName = &#63; from the database.
	 *
	 * @param appName the app name
	 * @return the master url that was removed
	 */
	@Override
	public MasterUrl removeByAppName(String appName)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = findByAppName(appName);

		return remove(masterUrl);
	}

	/**
	 * Returns the number of master urls where appName = &#63;.
	 *
	 * @param appName the app name
	 * @return the number of matching master urls
	 */
	@Override
	public int countByAppName(String appName) {
		appName = Objects.toString(appName, "");

		FinderPath finderPath = _finderPathCountByAppName;

		Object[] finderArgs = new Object[] {appName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERURL_WHERE);

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
		"masterUrl.appName = ?";

	private static final String _FINDER_COLUMN_APPNAME_APPNAME_3 =
		"(masterUrl.appName IS NULL OR masterUrl.appName = '')";

	public MasterUrlPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterUrl.class);

		setModelImplClass(MasterUrlImpl.class);
		setModelPKClass(long.class);

		setTable(MasterUrlTable.INSTANCE);
	}

	/**
	 * Caches the master url in the entity cache if it is enabled.
	 *
	 * @param masterUrl the master url
	 */
	@Override
	public void cacheResult(MasterUrl masterUrl) {
		entityCache.putResult(
			MasterUrlImpl.class, masterUrl.getPrimaryKey(), masterUrl);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {masterUrl.getUuid(), masterUrl.getGroupId()},
			masterUrl);

		finderCache.putResult(
			_finderPathFetchByAppName, new Object[] {masterUrl.getAppName()},
			masterUrl);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master urls in the entity cache if it is enabled.
	 *
	 * @param masterUrls the master urls
	 */
	@Override
	public void cacheResult(List<MasterUrl> masterUrls) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterUrls.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterUrl masterUrl : masterUrls) {
			if (entityCache.getResult(
					MasterUrlImpl.class, masterUrl.getPrimaryKey()) == null) {

				cacheResult(masterUrl);
			}
		}
	}

	/**
	 * Clears the cache for all master urls.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterUrlImpl.class);

		finderCache.clearCache(MasterUrlImpl.class);
	}

	/**
	 * Clears the cache for the master url.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterUrl masterUrl) {
		entityCache.removeResult(MasterUrlImpl.class, masterUrl);
	}

	@Override
	public void clearCache(List<MasterUrl> masterUrls) {
		for (MasterUrl masterUrl : masterUrls) {
			entityCache.removeResult(MasterUrlImpl.class, masterUrl);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MasterUrlImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterUrlImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MasterUrlModelImpl masterUrlModelImpl) {

		Object[] args = new Object[] {
			masterUrlModelImpl.getUuid(), masterUrlModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, masterUrlModelImpl);

		args = new Object[] {masterUrlModelImpl.getAppName()};

		finderCache.putResult(_finderPathCountByAppName, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByAppName, args, masterUrlModelImpl);
	}

	/**
	 * Creates a new master url with the primary key. Does not add the master url to the database.
	 *
	 * @param masterUrlId the primary key for the new master url
	 * @return the new master url
	 */
	@Override
	public MasterUrl create(long masterUrlId) {
		MasterUrl masterUrl = new MasterUrlImpl();

		masterUrl.setNew(true);
		masterUrl.setPrimaryKey(masterUrlId);

		String uuid = PortalUUIDUtil.generate();

		masterUrl.setUuid(uuid);

		masterUrl.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterUrl;
	}

	/**
	 * Removes the master url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url that was removed
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	@Override
	public MasterUrl remove(long masterUrlId) throws NoSuchMasterUrlException {
		return remove((Serializable)masterUrlId);
	}

	/**
	 * Removes the master url with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master url
	 * @return the master url that was removed
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	@Override
	public MasterUrl remove(Serializable primaryKey)
		throws NoSuchMasterUrlException {

		Session session = null;

		try {
			session = openSession();

			MasterUrl masterUrl = (MasterUrl)session.get(
				MasterUrlImpl.class, primaryKey);

			if (masterUrl == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterUrlException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterUrl);
		}
		catch (NoSuchMasterUrlException noSuchEntityException) {
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
	protected MasterUrl removeImpl(MasterUrl masterUrl) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterUrl)) {
				masterUrl = (MasterUrl)session.get(
					MasterUrlImpl.class, masterUrl.getPrimaryKeyObj());
			}

			if (masterUrl != null) {
				session.delete(masterUrl);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterUrl != null) {
			clearCache(masterUrl);
		}

		return masterUrl;
	}

	@Override
	public MasterUrl updateImpl(MasterUrl masterUrl) {
		boolean isNew = masterUrl.isNew();

		if (!(masterUrl instanceof MasterUrlModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterUrl.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(masterUrl);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterUrl proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterUrl implementation " +
					masterUrl.getClass());
		}

		MasterUrlModelImpl masterUrlModelImpl = (MasterUrlModelImpl)masterUrl;

		if (Validator.isNull(masterUrl.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			masterUrl.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterUrl.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterUrl.setCreateDate(date);
			}
			else {
				masterUrl.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!masterUrlModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterUrl.setModifiedDate(date);
			}
			else {
				masterUrl.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterUrl);
			}
			else {
				masterUrl = (MasterUrl)session.merge(masterUrl);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterUrlImpl.class, masterUrlModelImpl, false, true);

		cacheUniqueFindersCache(masterUrlModelImpl);

		if (isNew) {
			masterUrl.setNew(false);
		}

		masterUrl.resetOriginalValues();

		return masterUrl;
	}

	/**
	 * Returns the master url with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master url
	 * @return the master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	@Override
	public MasterUrl findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterUrlException {

		MasterUrl masterUrl = fetchByPrimaryKey(primaryKey);

		if (masterUrl == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterUrlException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterUrl;
	}

	/**
	 * Returns the master url with the primary key or throws a <code>NoSuchMasterUrlException</code> if it could not be found.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url
	 * @throws NoSuchMasterUrlException if a master url with the primary key could not be found
	 */
	@Override
	public MasterUrl findByPrimaryKey(long masterUrlId)
		throws NoSuchMasterUrlException {

		return findByPrimaryKey((Serializable)masterUrlId);
	}

	/**
	 * Returns the master url with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param masterUrlId the primary key of the master url
	 * @return the master url, or <code>null</code> if a master url with the primary key could not be found
	 */
	@Override
	public MasterUrl fetchByPrimaryKey(long masterUrlId) {
		return fetchByPrimaryKey((Serializable)masterUrlId);
	}

	/**
	 * Returns all the master urls.
	 *
	 * @return the master urls
	 */
	@Override
	public List<MasterUrl> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @return the range of master urls
	 */
	@Override
	public List<MasterUrl> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master urls
	 */
	@Override
	public List<MasterUrl> findAll(
		int start, int end, OrderByComparator<MasterUrl> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master urls.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterUrlModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master urls
	 * @param end the upper bound of the range of master urls (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master urls
	 */
	@Override
	public List<MasterUrl> findAll(
		int start, int end, OrderByComparator<MasterUrl> orderByComparator,
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

		List<MasterUrl> list = null;

		if (useFinderCache) {
			list = (List<MasterUrl>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERURL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERURL;

				sql = sql.concat(MasterUrlModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterUrl>)QueryUtil.list(
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
	 * Removes all the master urls from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterUrl masterUrl : findAll()) {
			remove(masterUrl);
		}
	}

	/**
	 * Returns the number of master urls.
	 *
	 * @return the number of master urls
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERURL);

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
		return "masterUrlId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERURL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterUrlModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master url persistence.
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

		MasterUrlUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		MasterUrlUtil.setPersistence(null);

		entityCache.removeCache(MasterUrlImpl.class.getName());
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

	private static final String _SQL_SELECT_MASTERURL =
		"SELECT masterUrl FROM MasterUrl masterUrl";

	private static final String _SQL_SELECT_MASTERURL_WHERE =
		"SELECT masterUrl FROM MasterUrl masterUrl WHERE ";

	private static final String _SQL_COUNT_MASTERURL =
		"SELECT COUNT(masterUrl) FROM MasterUrl masterUrl";

	private static final String _SQL_COUNT_MASTERURL_WHERE =
		"SELECT COUNT(masterUrl) FROM MasterUrl masterUrl WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterUrl.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterUrl exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterUrl exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterUrlPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}