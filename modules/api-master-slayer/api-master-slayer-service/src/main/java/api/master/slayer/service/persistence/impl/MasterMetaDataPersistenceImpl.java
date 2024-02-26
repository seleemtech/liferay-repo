/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package api.master.slayer.service.persistence.impl;

import api.master.slayer.exception.NoSuchMasterMetaDataException;
import api.master.slayer.model.MasterMetaData;
import api.master.slayer.model.MasterMetaDataTable;
import api.master.slayer.model.impl.MasterMetaDataImpl;
import api.master.slayer.model.impl.MasterMetaDataModelImpl;
import api.master.slayer.service.persistence.MasterMetaDataPersistence;
import api.master.slayer.service.persistence.MasterMetaDataUtil;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the master meta data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MasterMetaDataPersistence.class)
public class MasterMetaDataPersistenceImpl
	extends BasePersistenceImpl<MasterMetaData>
	implements MasterMetaDataPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MasterMetaDataUtil</code> to access the master meta data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MasterMetaDataImpl.class.getName();

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
	 * Returns all the master meta datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching master meta datas
	 */
	@Override
	public List<MasterMetaData> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master meta datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @return the range of matching master meta datas
	 */
	@Override
	public List<MasterMetaData> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master meta datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master meta datas
	 */
	@Override
	public List<MasterMetaData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master meta datas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master meta datas
	 */
	@Override
	public List<MasterMetaData> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator,
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

		List<MasterMetaData> list = null;

		if (useFinderCache) {
			list = (List<MasterMetaData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterMetaData masterMetaData : list) {
					if (!uuid.equals(masterMetaData.getUuid())) {
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

			sb.append(_SQL_SELECT_MASTERMETADATA_WHERE);

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
				sb.append(MasterMetaDataModelImpl.ORDER_BY_JPQL);
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

				list = (List<MasterMetaData>)QueryUtil.list(
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
	 * Returns the first master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData findByUuid_First(
			String uuid, OrderByComparator<MasterMetaData> orderByComparator)
		throws NoSuchMasterMetaDataException {

		MasterMetaData masterMetaData = fetchByUuid_First(
			uuid, orderByComparator);

		if (masterMetaData != null) {
			return masterMetaData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMasterMetaDataException(sb.toString());
	}

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData fetchByUuid_First(
		String uuid, OrderByComparator<MasterMetaData> orderByComparator) {

		List<MasterMetaData> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData findByUuid_Last(
			String uuid, OrderByComparator<MasterMetaData> orderByComparator)
		throws NoSuchMasterMetaDataException {

		MasterMetaData masterMetaData = fetchByUuid_Last(
			uuid, orderByComparator);

		if (masterMetaData != null) {
			return masterMetaData;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMasterMetaDataException(sb.toString());
	}

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData fetchByUuid_Last(
		String uuid, OrderByComparator<MasterMetaData> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MasterMetaData> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master meta datas before and after the current master meta data in the ordered set where uuid = &#63;.
	 *
	 * @param mmdId the primary key of the current master meta data
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	@Override
	public MasterMetaData[] findByUuid_PrevAndNext(
			long mmdId, String uuid,
			OrderByComparator<MasterMetaData> orderByComparator)
		throws NoSuchMasterMetaDataException {

		uuid = Objects.toString(uuid, "");

		MasterMetaData masterMetaData = findByPrimaryKey(mmdId);

		Session session = null;

		try {
			session = openSession();

			MasterMetaData[] array = new MasterMetaDataImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, masterMetaData, uuid, orderByComparator, true);

			array[1] = masterMetaData;

			array[2] = getByUuid_PrevAndNext(
				session, masterMetaData, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MasterMetaData getByUuid_PrevAndNext(
		Session session, MasterMetaData masterMetaData, String uuid,
		OrderByComparator<MasterMetaData> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MASTERMETADATA_WHERE);

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
			sb.append(MasterMetaDataModelImpl.ORDER_BY_JPQL);
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
						masterMetaData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterMetaData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master meta datas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MasterMetaData masterMetaData :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(masterMetaData);
		}
	}

	/**
	 * Returns the number of master meta datas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching master meta datas
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MASTERMETADATA_WHERE);

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
		"masterMetaData.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(masterMetaData.uuid IS NULL OR masterMetaData.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMasterMetaDataException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData findByUUID_G(String uuid, long groupId)
		throws NoSuchMasterMetaDataException {

		MasterMetaData masterMetaData = fetchByUUID_G(uuid, groupId);

		if (masterMetaData == null) {
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

			throw new NoSuchMasterMetaDataException(sb.toString());
		}

		return masterMetaData;
	}

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the master meta data where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData fetchByUUID_G(
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

		if (result instanceof MasterMetaData) {
			MasterMetaData masterMetaData = (MasterMetaData)result;

			if (!Objects.equals(uuid, masterMetaData.getUuid()) ||
				(groupId != masterMetaData.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MASTERMETADATA_WHERE);

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

				List<MasterMetaData> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					MasterMetaData masterMetaData = list.get(0);

					result = masterMetaData;

					cacheResult(masterMetaData);
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
			return (MasterMetaData)result;
		}
	}

	/**
	 * Removes the master meta data where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the master meta data that was removed
	 */
	@Override
	public MasterMetaData removeByUUID_G(String uuid, long groupId)
		throws NoSuchMasterMetaDataException {

		MasterMetaData masterMetaData = findByUUID_G(uuid, groupId);

		return remove(masterMetaData);
	}

	/**
	 * Returns the number of master meta datas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching master meta datas
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MASTERMETADATA_WHERE);

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
		"masterMetaData.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(masterMetaData.uuid IS NULL OR masterMetaData.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"masterMetaData.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching master meta datas
	 */
	@Override
	public List<MasterMetaData> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @return the range of matching master meta datas
	 */
	@Override
	public List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching master meta datas
	 */
	@Override
	public List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching master meta datas
	 */
	@Override
	public List<MasterMetaData> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator,
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

		List<MasterMetaData> list = null;

		if (useFinderCache) {
			list = (List<MasterMetaData>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MasterMetaData masterMetaData : list) {
					if (!uuid.equals(masterMetaData.getUuid()) ||
						(companyId != masterMetaData.getCompanyId())) {

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

			sb.append(_SQL_SELECT_MASTERMETADATA_WHERE);

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
				sb.append(MasterMetaDataModelImpl.ORDER_BY_JPQL);
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

				list = (List<MasterMetaData>)QueryUtil.list(
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
	 * Returns the first master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MasterMetaData> orderByComparator)
		throws NoSuchMasterMetaDataException {

		MasterMetaData masterMetaData = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (masterMetaData != null) {
			return masterMetaData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMasterMetaDataException(sb.toString());
	}

	/**
	 * Returns the first master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MasterMetaData> orderByComparator) {

		List<MasterMetaData> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data
	 * @throws NoSuchMasterMetaDataException if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MasterMetaData> orderByComparator)
		throws NoSuchMasterMetaDataException {

		MasterMetaData masterMetaData = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (masterMetaData != null) {
			return masterMetaData;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMasterMetaDataException(sb.toString());
	}

	/**
	 * Returns the last master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching master meta data, or <code>null</code> if a matching master meta data could not be found
	 */
	@Override
	public MasterMetaData fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MasterMetaData> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MasterMetaData> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the master meta datas before and after the current master meta data in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param mmdId the primary key of the current master meta data
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	@Override
	public MasterMetaData[] findByUuid_C_PrevAndNext(
			long mmdId, String uuid, long companyId,
			OrderByComparator<MasterMetaData> orderByComparator)
		throws NoSuchMasterMetaDataException {

		uuid = Objects.toString(uuid, "");

		MasterMetaData masterMetaData = findByPrimaryKey(mmdId);

		Session session = null;

		try {
			session = openSession();

			MasterMetaData[] array = new MasterMetaDataImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, masterMetaData, uuid, companyId, orderByComparator,
				true);

			array[1] = masterMetaData;

			array[2] = getByUuid_C_PrevAndNext(
				session, masterMetaData, uuid, companyId, orderByComparator,
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

	protected MasterMetaData getByUuid_C_PrevAndNext(
		Session session, MasterMetaData masterMetaData, String uuid,
		long companyId, OrderByComparator<MasterMetaData> orderByComparator,
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

		sb.append(_SQL_SELECT_MASTERMETADATA_WHERE);

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
			sb.append(MasterMetaDataModelImpl.ORDER_BY_JPQL);
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
						masterMetaData)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MasterMetaData> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the master meta datas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MasterMetaData masterMetaData :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(masterMetaData);
		}
	}

	/**
	 * Returns the number of master meta datas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching master meta datas
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MASTERMETADATA_WHERE);

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
		"masterMetaData.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(masterMetaData.uuid IS NULL OR masterMetaData.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"masterMetaData.companyId = ?";

	public MasterMetaDataPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MasterMetaData.class);

		setModelImplClass(MasterMetaDataImpl.class);
		setModelPKClass(long.class);

		setTable(MasterMetaDataTable.INSTANCE);
	}

	/**
	 * Caches the master meta data in the entity cache if it is enabled.
	 *
	 * @param masterMetaData the master meta data
	 */
	@Override
	public void cacheResult(MasterMetaData masterMetaData) {
		entityCache.putResult(
			MasterMetaDataImpl.class, masterMetaData.getPrimaryKey(),
			masterMetaData);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				masterMetaData.getUuid(), masterMetaData.getGroupId()
			},
			masterMetaData);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the master meta datas in the entity cache if it is enabled.
	 *
	 * @param masterMetaDatas the master meta datas
	 */
	@Override
	public void cacheResult(List<MasterMetaData> masterMetaDatas) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (masterMetaDatas.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MasterMetaData masterMetaData : masterMetaDatas) {
			if (entityCache.getResult(
					MasterMetaDataImpl.class, masterMetaData.getPrimaryKey()) ==
						null) {

				cacheResult(masterMetaData);
			}
		}
	}

	/**
	 * Clears the cache for all master meta datas.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MasterMetaDataImpl.class);

		finderCache.clearCache(MasterMetaDataImpl.class);
	}

	/**
	 * Clears the cache for the master meta data.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MasterMetaData masterMetaData) {
		entityCache.removeResult(MasterMetaDataImpl.class, masterMetaData);
	}

	@Override
	public void clearCache(List<MasterMetaData> masterMetaDatas) {
		for (MasterMetaData masterMetaData : masterMetaDatas) {
			entityCache.removeResult(MasterMetaDataImpl.class, masterMetaData);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MasterMetaDataImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MasterMetaDataImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MasterMetaDataModelImpl masterMetaDataModelImpl) {

		Object[] args = new Object[] {
			masterMetaDataModelImpl.getUuid(),
			masterMetaDataModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, masterMetaDataModelImpl);
	}

	/**
	 * Creates a new master meta data with the primary key. Does not add the master meta data to the database.
	 *
	 * @param mmdId the primary key for the new master meta data
	 * @return the new master meta data
	 */
	@Override
	public MasterMetaData create(long mmdId) {
		MasterMetaData masterMetaData = new MasterMetaDataImpl();

		masterMetaData.setNew(true);
		masterMetaData.setPrimaryKey(mmdId);

		String uuid = PortalUUIDUtil.generate();

		masterMetaData.setUuid(uuid);

		masterMetaData.setCompanyId(CompanyThreadLocal.getCompanyId());

		return masterMetaData;
	}

	/**
	 * Removes the master meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data that was removed
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	@Override
	public MasterMetaData remove(long mmdId)
		throws NoSuchMasterMetaDataException {

		return remove((Serializable)mmdId);
	}

	/**
	 * Removes the master meta data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the master meta data
	 * @return the master meta data that was removed
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	@Override
	public MasterMetaData remove(Serializable primaryKey)
		throws NoSuchMasterMetaDataException {

		Session session = null;

		try {
			session = openSession();

			MasterMetaData masterMetaData = (MasterMetaData)session.get(
				MasterMetaDataImpl.class, primaryKey);

			if (masterMetaData == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMasterMetaDataException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(masterMetaData);
		}
		catch (NoSuchMasterMetaDataException noSuchEntityException) {
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
	protected MasterMetaData removeImpl(MasterMetaData masterMetaData) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(masterMetaData)) {
				masterMetaData = (MasterMetaData)session.get(
					MasterMetaDataImpl.class,
					masterMetaData.getPrimaryKeyObj());
			}

			if (masterMetaData != null) {
				session.delete(masterMetaData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (masterMetaData != null) {
			clearCache(masterMetaData);
		}

		return masterMetaData;
	}

	@Override
	public MasterMetaData updateImpl(MasterMetaData masterMetaData) {
		boolean isNew = masterMetaData.isNew();

		if (!(masterMetaData instanceof MasterMetaDataModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(masterMetaData.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					masterMetaData);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in masterMetaData proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MasterMetaData implementation " +
					masterMetaData.getClass());
		}

		MasterMetaDataModelImpl masterMetaDataModelImpl =
			(MasterMetaDataModelImpl)masterMetaData;

		if (Validator.isNull(masterMetaData.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			masterMetaData.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (masterMetaData.getCreateDate() == null)) {
			if (serviceContext == null) {
				masterMetaData.setCreateDate(date);
			}
			else {
				masterMetaData.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!masterMetaDataModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				masterMetaData.setModifiedDate(date);
			}
			else {
				masterMetaData.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(masterMetaData);
			}
			else {
				masterMetaData = (MasterMetaData)session.merge(masterMetaData);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			MasterMetaDataImpl.class, masterMetaDataModelImpl, false, true);

		cacheUniqueFindersCache(masterMetaDataModelImpl);

		if (isNew) {
			masterMetaData.setNew(false);
		}

		masterMetaData.resetOriginalValues();

		return masterMetaData;
	}

	/**
	 * Returns the master meta data with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the master meta data
	 * @return the master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	@Override
	public MasterMetaData findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMasterMetaDataException {

		MasterMetaData masterMetaData = fetchByPrimaryKey(primaryKey);

		if (masterMetaData == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMasterMetaDataException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return masterMetaData;
	}

	/**
	 * Returns the master meta data with the primary key or throws a <code>NoSuchMasterMetaDataException</code> if it could not be found.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data
	 * @throws NoSuchMasterMetaDataException if a master meta data with the primary key could not be found
	 */
	@Override
	public MasterMetaData findByPrimaryKey(long mmdId)
		throws NoSuchMasterMetaDataException {

		return findByPrimaryKey((Serializable)mmdId);
	}

	/**
	 * Returns the master meta data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mmdId the primary key of the master meta data
	 * @return the master meta data, or <code>null</code> if a master meta data with the primary key could not be found
	 */
	@Override
	public MasterMetaData fetchByPrimaryKey(long mmdId) {
		return fetchByPrimaryKey((Serializable)mmdId);
	}

	/**
	 * Returns all the master meta datas.
	 *
	 * @return the master meta datas
	 */
	@Override
	public List<MasterMetaData> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the master meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @return the range of master meta datas
	 */
	@Override
	public List<MasterMetaData> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the master meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of master meta datas
	 */
	@Override
	public List<MasterMetaData> findAll(
		int start, int end,
		OrderByComparator<MasterMetaData> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the master meta datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MasterMetaDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of master meta datas
	 * @param end the upper bound of the range of master meta datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of master meta datas
	 */
	@Override
	public List<MasterMetaData> findAll(
		int start, int end, OrderByComparator<MasterMetaData> orderByComparator,
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

		List<MasterMetaData> list = null;

		if (useFinderCache) {
			list = (List<MasterMetaData>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MASTERMETADATA);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MASTERMETADATA;

				sql = sql.concat(MasterMetaDataModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MasterMetaData>)QueryUtil.list(
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
	 * Removes all the master meta datas from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MasterMetaData masterMetaData : findAll()) {
			remove(masterMetaData);
		}
	}

	/**
	 * Returns the number of master meta datas.
	 *
	 * @return the number of master meta datas
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MASTERMETADATA);

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
		return "mmdId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MASTERMETADATA;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MasterMetaDataModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the master meta data persistence.
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

		MasterMetaDataUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		MasterMetaDataUtil.setPersistence(null);

		entityCache.removeCache(MasterMetaDataImpl.class.getName());
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

	private static final String _SQL_SELECT_MASTERMETADATA =
		"SELECT masterMetaData FROM MasterMetaData masterMetaData";

	private static final String _SQL_SELECT_MASTERMETADATA_WHERE =
		"SELECT masterMetaData FROM MasterMetaData masterMetaData WHERE ";

	private static final String _SQL_COUNT_MASTERMETADATA =
		"SELECT COUNT(masterMetaData) FROM MasterMetaData masterMetaData";

	private static final String _SQL_COUNT_MASTERMETADATA_WHERE =
		"SELECT COUNT(masterMetaData) FROM MasterMetaData masterMetaData WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "masterMetaData.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MasterMetaData exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MasterMetaData exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MasterMetaDataPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}