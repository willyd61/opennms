/*
 * This file is part of the OpenNMS(R) Application.
 *
 * OpenNMS(R) is Copyright (C) 2004-2008 The OpenNMS Group, Inc.  All rights reserved.
 * OpenNMS(R) is a derivative work, containing both original code, included code and modified
 * code that was published under the GNU General Public License. Copyrights for modified
 * and included code are below.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * Modifications:
 * 
 * Created November 20, 2004
 *
 * Copyright (C) 2004-2008 The OpenNMS Group, Inc.  All rights reserved.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 *
 * For more information contact:
 *      OpenNMS Licensing       <license@opennms.org>
 *      http://www.opennms.org/
 *      http://www.opennms.com/
 */
/*
 * Created on Nov 14, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package org.opennms.netmgt.poller;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

/**
 * @author brozow
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public interface QueryManager {
    /**
     * @param whichEvent
     * @param nodeId
     * @param ipAddr
     * @param serviceName
     * @return
     */
    public boolean activeServiceExists(String whichEvent, int nodeId, String ipAddr, String serviceName);

    /**
     * @param ipaddr
     * @return
     * @throws SQLException
     */
    public List<Integer> getActiveServiceIdsForInterface(String ipaddr) throws SQLException;

    /**
     * @param ipaddr
     * @return
     * @throws SQLException
     */
    public int getNodeIDForInterface(String ipaddr) throws SQLException;

    /**
     * @param nodeId
     * @return
     * @throws SQLException
     */
    public String getNodeLabel(int nodeId) throws SQLException;

    /**
     * @param ipaddr
     * @return
     * @throws SQLException
     */
    public int getServiceCountForInterface(String ipaddr) throws SQLException;

    /**
     * @param svcName
     * @return
     * @throws SQLException
     */
    public List<IfKey> getInterfacesWithService(String svcName) throws SQLException;

    /**
     * @param poller
     * @param nodeId
     * @param ipAddr
     * @param svcName
     * @return
     */
    public Date getServiceLostDate(int nodeId, String ipAddr, String svcName, int serviceId);

    /**
     * @param connectionFactory
     */
    public void setDataSource(DataSource dataSource);
    
    @Deprecated
    public DataSource getDataSource();

    /**
     * @param nodeId
     * @param ipAddr
     * @param svcName TODO
     * @param dbid
     * @param time
     */
    public void openOutage(String outageIdSQL, int nodeId, String ipAddr, String svcName, int dbid, String time);

    /**
     * @param nodeId
     * @param ipAddr
     * @param svcName TODO
     * @param dbid
     * @param time
     */
    public void resolveOutage(int nodeId, String ipAddr, String svcName, int dbid, String time);

    /**
     * @param ipAddr
     * @param oldNodeId
     * @param newNodeId
     */
    public void reparentOutages(String ipAddr, int oldNodeId, int newNodeId);
    
    

    public String[] getCriticalPath(int nodeId);
}
