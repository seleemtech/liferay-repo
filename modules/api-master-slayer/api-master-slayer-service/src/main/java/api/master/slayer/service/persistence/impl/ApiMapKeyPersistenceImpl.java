/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence.impl;

import api.master.slayer.exception.NoSuchApiMapKeyException;
import api.master.slayer.model.ApiMapKey;
import api.master.slayer.model.ApiMapKeyTable;
import api.master.slayer.model.impl.ApiMapKeyImpl;
import api.master.slayer.model.impl.ApiMapKeyModelImpl;
import api.master.slayer.service.persistence.ApiMapKeyPersistence;
import api.master.slayer.service.persistence.ApiMapKeyUtil;
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
 * The persistence implementation for the api map key service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ApiMapKeyPersistence.class)
public class ApiMapKeyPersistenceImpl
	extends BasePersistenceImpl<ApiMapKey> implements ApiMapKeyPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ApiMapKeyUtil</code> to access the api map key persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ApiMapKeyImpl.class.getName();

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
	 * Returns all the api map keys where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching api map keys
	 */
	@Override
	public List<ApiMapKey> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the api map keys where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @return the range of matching api map keys
	 */
	@Override
	public List<ApiMapKey> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the api map keys where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching api map keys
	 */
	@Override
	public List<ApiMapKey> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the api map keys where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching api map keys
	 */
	@Override
	public List<ApiMapKey> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator,
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

		List<ApiMapKey> list = null;

		if (useFinderCache) {
			list = (List<ApiMapKey>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApiMapKey apiMapKey : list) {
					if (!uuid.equals(apiMapKey.getUuid())) {
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

			sb.append(_SQL_SELECT_APIMAPKEY_WHERE);

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
				sb.append(ApiMapKeyModelImpl.ORDER_BY_JPQL);
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

				list = (List<ApiMapKey>)QueryUtil.list(
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
	 * Returns the first api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey findByUuid_First(
			String uuid, OrderByComparator<ApiMapKey> orderByComparator)
		throws NoSuchApiMapKeyException {

		ApiMapKey apiMapKey = fetchByUuid_First(uuid, orderByComparator);

		if (apiMapKey != null) {
			return apiMapKey;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchApiMapKeyException(sb.toString());
	}

	/**
	 * Returns the first api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey fetchByUuid_First(
		String uuid, OrderByComparator<ApiMapKey> orderByComparator) {

		List<ApiMapKey> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey findByUuid_Last(
			String uuid, OrderByComparator<ApiMapKey> orderByComparator)
		throws NoSuchApiMapKeyException {

		ApiMapKey apiMapKey = fetchByUuid_Last(uuid, orderByComparator);

		if (apiMapKey != null) {
			return apiMapKey;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchApiMapKeyException(sb.toString());
	}

	/**
	 * Returns the last api map key in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey fetchByUuid_Last(
		String uuid, OrderByComparator<ApiMapKey> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ApiMapKey> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the api map keys before and after the current api map key in the ordered set where uuid = &#63;.
	 *
	 * @param apiMapKeyId the primary key of the current api map key
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	@Override
	public ApiMapKey[] findByUuid_PrevAndNext(
			long apiMapKeyId, String uuid,
			OrderByComparator<ApiMapKey> orderByComparator)
		throws NoSuchApiMapKeyException {

		uuid = Objects.toString(uuid, "");

		ApiMapKey apiMapKey = findByPrimaryKey(apiMapKeyId);

		Session session = null;

		try {
			session = openSession();

			ApiMapKey[] array = new ApiMapKeyImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, apiMapKey, uuid, orderByComparator, true);

			array[1] = apiMapKey;

			array[2] = getByUuid_PrevAndNext(
				session, apiMapKey, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApiMapKey getByUuid_PrevAndNext(
		Session session, ApiMapKey apiMapKey, String uuid,
		OrderByComparator<ApiMapKey> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APIMAPKEY_WHERE);

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
			sb.append(ApiMapKeyModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(apiMapKey)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ApiMapKey> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the api map keys where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ApiMapKey apiMapKey :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(apiMapKey);
		}
	}

	/**
	 * Returns the number of api map keys where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching api map keys
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APIMAPKEY_WHERE);

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
		"apiMapKey.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(apiMapKey.uuid IS NULL OR apiMapKey.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey findByUUID_G(String uuid, long groupId)
		throws NoSuchApiMapKeyException {

		ApiMapKey apiMapKey = fetchByUUID_G(uuid, groupId);

		if (apiMapKey == null) {
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

			throw new NoSuchApiMapKeyException(sb.toString());
		}

		return apiMapKey;
	}

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the api map key where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey fetchByUUID_G(
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

		if (result instanceof ApiMapKey) {
			ApiMapKey apiMapKey = (ApiMapKey)result;

			if (!Objects.equals(uuid, apiMapKey.getUuid()) ||
				(groupId != apiMapKey.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_APIMAPKEY_WHERE);

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

				List<ApiMapKey> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ApiMapKey apiMapKey = list.get(0);

					result = apiMapKey;

					cacheResult(apiMapKey);
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
			return (ApiMapKey)result;
		}
	}

	/**
	 * Removes the api map key where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the api map key that was removed
	 */
	@Override
	public ApiMapKey removeByUUID_G(String uuid, long groupId)
		throws NoSuchApiMapKeyException {

		ApiMapKey apiMapKey = findByUUID_G(uuid, groupId);

		return remove(apiMapKey);
	}

	/**
	 * Returns the number of api map keys where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching api map keys
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_APIMAPKEY_WHERE);

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
		"apiMapKey.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(apiMapKey.uuid IS NULL OR apiMapKey.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"apiMapKey.groupId = ?";

	private FinderPath _finderPathFetchByName;
	private FinderPath _finderPathCountByName;

	/**
	 * Returns the api map key where name = &#63; or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey findByName(String name) throws NoSuchApiMapKeyException {
		ApiMapKey apiMapKey = fetchByName(name);

		if (apiMapKey == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchApiMapKeyException(sb.toString());
		}

		return apiMapKey;
	}

	/**
	 * Returns the api map key where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey fetchByName(String name) {
		return fetchByName(name, true);
	}

	/**
	 * Returns the api map key where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey fetchByName(String name, boolean useFinderCache) {
		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByName, finderArgs, this);
		}

		if (result instanceof ApiMapKey) {
			ApiMapKey apiMapKey = (ApiMapKey)result;

			if (!Objects.equals(name, apiMapKey.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_APIMAPKEY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<ApiMapKey> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"ApiMapKeyPersistenceImpl.fetchByName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ApiMapKey apiMapKey = list.get(0);

					result = apiMapKey;

					cacheResult(apiMapKey);
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
			return (ApiMapKey)result;
		}
	}

	/**
	 * Removes the api map key where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the api map key that was removed
	 */
	@Override
	public ApiMapKey removeByName(String name) throws NoSuchApiMapKeyException {
		ApiMapKey apiMapKey = findByName(name);

		return remove(apiMapKey);
	}

	/**
	 * Returns the number of api map keys where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching api map keys
	 */
	@Override
	public int countByName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APIMAPKEY_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_2 =
		"apiMapKey.name = ?";

	private static final String _FINDER_COLUMN_NAME_NAME_3 =
		"(apiMapKey.name IS NULL OR apiMapKey.name = '')";

	private FinderPath _finderPathWithPaginationFindByUserId;
	private FinderPath _finderPathWithoutPaginationFindByUserId;
	private FinderPath _finderPathCountByUserId;

	/**
	 * Returns all the api map keys where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching api map keys
	 */
	@Override
	public List<ApiMapKey> findByUserId(long userId) {
		return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the api map keys where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @return the range of matching api map keys
	 */
	@Override
	public List<ApiMapKey> findByUserId(long userId, int start, int end) {
		return findByUserId(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the api map keys where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching api map keys
	 */
	@Override
	public List<ApiMapKey> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator) {

		return findByUserId(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the api map keys where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching api map keys
	 */
	@Override
	public List<ApiMapKey> findByUserId(
		long userId, int start, int end,
		OrderByComparator<ApiMapKey> orderByComparator,
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

		List<ApiMapKey> list = null;

		if (useFinderCache) {
			list = (List<ApiMapKey>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ApiMapKey apiMapKey : list) {
					if (userId != apiMapKey.getUserId()) {
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

			sb.append(_SQL_SELECT_APIMAPKEY_WHERE);

			sb.append(_FINDER_COLUMN_USERID_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ApiMapKeyModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(userId);

				list = (List<ApiMapKey>)QueryUtil.list(
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
	 * Returns the first api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey findByUserId_First(
			long userId, OrderByComparator<ApiMapKey> orderByComparator)
		throws NoSuchApiMapKeyException {

		ApiMapKey apiMapKey = fetchByUserId_First(userId, orderByComparator);

		if (apiMapKey != null) {
			return apiMapKey;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchApiMapKeyException(sb.toString());
	}

	/**
	 * Returns the first api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey fetchByUserId_First(
		long userId, OrderByComparator<ApiMapKey> orderByComparator) {

		List<ApiMapKey> list = findByUserId(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key
	 * @throws NoSuchApiMapKeyException if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey findByUserId_Last(
			long userId, OrderByComparator<ApiMapKey> orderByComparator)
		throws NoSuchApiMapKeyException {

		ApiMapKey apiMapKey = fetchByUserId_Last(userId, orderByComparator);

		if (apiMapKey != null) {
			return apiMapKey;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchApiMapKeyException(sb.toString());
	}

	/**
	 * Returns the last api map key in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching api map key, or <code>null</code> if a matching api map key could not be found
	 */
	@Override
	public ApiMapKey fetchByUserId_Last(
		long userId, OrderByComparator<ApiMapKey> orderByComparator) {

		int count = countByUserId(userId);

		if (count == 0) {
			return null;
		}

		List<ApiMapKey> list = findByUserId(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the api map keys before and after the current api map key in the ordered set where userId = &#63;.
	 *
	 * @param apiMapKeyId the primary key of the current api map key
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	@Override
	public ApiMapKey[] findByUserId_PrevAndNext(
			long apiMapKeyId, long userId,
			OrderByComparator<ApiMapKey> orderByComparator)
		throws NoSuchApiMapKeyException {

		ApiMapKey apiMapKey = findByPrimaryKey(apiMapKeyId);

		Session session = null;

		try {
			session = openSession();

			ApiMapKey[] array = new ApiMapKeyImpl[3];

			array[0] = getByUserId_PrevAndNext(
				session, apiMapKey, userId, orderByComparator, true);

			array[1] = apiMapKey;

			array[2] = getByUserId_PrevAndNext(
				session, apiMapKey, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ApiMapKey getByUserId_PrevAndNext(
		Session session, ApiMapKey apiMapKey, long userId,
		OrderByComparator<ApiMapKey> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_APIMAPKEY_WHERE);

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
			sb.append(ApiMapKeyModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(apiMapKey)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ApiMapKey> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the api map keys where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUserId(long userId) {
		for (ApiMapKey apiMapKey :
				findByUserId(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(apiMapKey);
		}
	}

	/**
	 * Returns the number of api map keys where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching api map keys
	 */
	@Override
	public int countByUserId(long userId) {
		FinderPath finderPath = _finderPathCountByUserId;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_APIMAPKEY_WHERE);

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
		"apiMapKey.userId = ?";

	public ApiMapKeyPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("key", "key_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ApiMapKey.class);

		setModelImplClass(ApiMapKeyImpl.class);
		setModelPKClass(long.class);

		setTable(ApiMapKeyTable.INSTANCE);
	}

	/**
	 * Caches the api map key in the entity cache if it is enabled.
	 *
	 * @param apiMapKey the api map key
	 */
	@Override
	public void cacheResult(ApiMapKey apiMapKey) {
		entityCache.putResult(
			ApiMapKeyImpl.class, apiMapKey.getPrimaryKey(), apiMapKey);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {apiMapKey.getUuid(), apiMapKey.getGroupId()},
			apiMapKey);

		finderCache.putResult(
			_finderPathFetchByName, new Object[] {apiMapKey.getName()},
			apiMapKey);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the api map keys in the entity cache if it is enabled.
	 *
	 * @param apiMapKeys the api map keys
	 */
	@Override
	public void cacheResult(List<ApiMapKey> apiMapKeys) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (apiMapKeys.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ApiMapKey apiMapKey : apiMapKeys) {
			if (entityCache.getResult(
					ApiMapKeyImpl.class, apiMapKey.getPrimaryKey()) == null) {

				cacheResult(apiMapKey);
			}
		}
	}

	/**
	 * Clears the cache for all api map keys.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ApiMapKeyImpl.class);

		finderCache.clearCache(ApiMapKeyImpl.class);
	}

	/**
	 * Clears the cache for the api map key.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ApiMapKey apiMapKey) {
		entityCache.removeResult(ApiMapKeyImpl.class, apiMapKey);
	}

	@Override
	public void clearCache(List<ApiMapKey> apiMapKeys) {
		for (ApiMapKey apiMapKey : apiMapKeys) {
			entityCache.removeResult(ApiMapKeyImpl.class, apiMapKey);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ApiMapKeyImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ApiMapKeyImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ApiMapKeyModelImpl apiMapKeyModelImpl) {

		Object[] args = new Object[] {
			apiMapKeyModelImpl.getUuid(), apiMapKeyModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, apiMapKeyModelImpl);

		args = new Object[] {apiMapKeyModelImpl.getName()};

		finderCache.putResult(_finderPathCountByName, args, Long.valueOf(1));
		finderCache.putResult(_finderPathFetchByName, args, apiMapKeyModelImpl);
	}

	/**
	 * Creates a new api map key with the primary key. Does not add the api map key to the database.
	 *
	 * @param apiMapKeyId the primary key for the new api map key
	 * @return the new api map key
	 */
	@Override
	public ApiMapKey create(long apiMapKeyId) {
		ApiMapKey apiMapKey = new ApiMapKeyImpl();

		apiMapKey.setNew(true);
		apiMapKey.setPrimaryKey(apiMapKeyId);

		String uuid = PortalUUIDUtil.generate();

		apiMapKey.setUuid(uuid);

		return apiMapKey;
	}

	/**
	 * Removes the api map key with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key that was removed
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	@Override
	public ApiMapKey remove(long apiMapKeyId) throws NoSuchApiMapKeyException {
		return remove((Serializable)apiMapKeyId);
	}

	/**
	 * Removes the api map key with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the api map key
	 * @return the api map key that was removed
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	@Override
	public ApiMapKey remove(Serializable primaryKey)
		throws NoSuchApiMapKeyException {

		Session session = null;

		try {
			session = openSession();

			ApiMapKey apiMapKey = (ApiMapKey)session.get(
				ApiMapKeyImpl.class, primaryKey);

			if (apiMapKey == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchApiMapKeyException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(apiMapKey);
		}
		catch (NoSuchApiMapKeyException noSuchEntityException) {
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
	protected ApiMapKey removeImpl(ApiMapKey apiMapKey) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(apiMapKey)) {
				apiMapKey = (ApiMapKey)session.get(
					ApiMapKeyImpl.class, apiMapKey.getPrimaryKeyObj());
			}

			if (apiMapKey != null) {
				session.delete(apiMapKey);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (apiMapKey != null) {
			clearCache(apiMapKey);
		}

		return apiMapKey;
	}

	@Override
	public ApiMapKey updateImpl(ApiMapKey apiMapKey) {
		boolean isNew = apiMapKey.isNew();

		if (!(apiMapKey instanceof ApiMapKeyModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(apiMapKey.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(apiMapKey);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in apiMapKey proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ApiMapKey implementation " +
					apiMapKey.getClass());
		}

		ApiMapKeyModelImpl apiMapKeyModelImpl = (ApiMapKeyModelImpl)apiMapKey;

		if (Validator.isNull(apiMapKey.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			apiMapKey.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(apiMapKey);
			}
			else {
				apiMapKey = (ApiMapKey)session.merge(apiMapKey);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ApiMapKeyImpl.class, apiMapKeyModelImpl, false, true);

		cacheUniqueFindersCache(apiMapKeyModelImpl);

		if (isNew) {
			apiMapKey.setNew(false);
		}

		apiMapKey.resetOriginalValues();

		return apiMapKey;
	}

	/**
	 * Returns the api map key with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the api map key
	 * @return the api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	@Override
	public ApiMapKey findByPrimaryKey(Serializable primaryKey)
		throws NoSuchApiMapKeyException {

		ApiMapKey apiMapKey = fetchByPrimaryKey(primaryKey);

		if (apiMapKey == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchApiMapKeyException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return apiMapKey;
	}

	/**
	 * Returns the api map key with the primary key or throws a <code>NoSuchApiMapKeyException</code> if it could not be found.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key
	 * @throws NoSuchApiMapKeyException if a api map key with the primary key could not be found
	 */
	@Override
	public ApiMapKey findByPrimaryKey(long apiMapKeyId)
		throws NoSuchApiMapKeyException {

		return findByPrimaryKey((Serializable)apiMapKeyId);
	}

	/**
	 * Returns the api map key with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param apiMapKeyId the primary key of the api map key
	 * @return the api map key, or <code>null</code> if a api map key with the primary key could not be found
	 */
	@Override
	public ApiMapKey fetchByPrimaryKey(long apiMapKeyId) {
		return fetchByPrimaryKey((Serializable)apiMapKeyId);
	}

	/**
	 * Returns all the api map keys.
	 *
	 * @return the api map keys
	 */
	@Override
	public List<ApiMapKey> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the api map keys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @return the range of api map keys
	 */
	@Override
	public List<ApiMapKey> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the api map keys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of api map keys
	 */
	@Override
	public List<ApiMapKey> findAll(
		int start, int end, OrderByComparator<ApiMapKey> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the api map keys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ApiMapKeyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of api map keys
	 * @param end the upper bound of the range of api map keys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of api map keys
	 */
	@Override
	public List<ApiMapKey> findAll(
		int start, int end, OrderByComparator<ApiMapKey> orderByComparator,
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

		List<ApiMapKey> list = null;

		if (useFinderCache) {
			list = (List<ApiMapKey>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_APIMAPKEY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_APIMAPKEY;

				sql = sql.concat(ApiMapKeyModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ApiMapKey>)QueryUtil.list(
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
	 * Removes all the api map keys from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ApiMapKey apiMapKey : findAll()) {
			remove(apiMapKey);
		}
	}

	/**
	 * Returns the number of api map keys.
	 *
	 * @return the number of api map keys
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_APIMAPKEY);

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
		return "apiMapKeyId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_APIMAPKEY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ApiMapKeyModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the api map key persistence.
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

		_finderPathFetchByName = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByName = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

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

		ApiMapKeyUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ApiMapKeyUtil.setPersistence(null);

		entityCache.removeCache(ApiMapKeyImpl.class.getName());
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

	private static final String _SQL_SELECT_APIMAPKEY =
		"SELECT apiMapKey FROM ApiMapKey apiMapKey";

	private static final String _SQL_SELECT_APIMAPKEY_WHERE =
		"SELECT apiMapKey FROM ApiMapKey apiMapKey WHERE ";

	private static final String _SQL_COUNT_APIMAPKEY =
		"SELECT COUNT(apiMapKey) FROM ApiMapKey apiMapKey";

	private static final String _SQL_COUNT_APIMAPKEY_WHERE =
		"SELECT COUNT(apiMapKey) FROM ApiMapKey apiMapKey WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "apiMapKey.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ApiMapKey exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ApiMapKey exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ApiMapKeyPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "key"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}