/*
 * File   : $Source: /alkacon/cvs/opencms/src/org/opencms/db/CmsPublishedResource.java,v $
 * Date   : $Date: 2003/09/26 15:11:51 $
 * Version: $Revision: 1.1 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Mananagement System
 *
 * Copyright (C) 2002 - 2003 Alkacon Software (http://www.alkacon.com)
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 *
 * For further information about OpenCms, please see the
 * project website: http://www.opencms.org
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package org.opencms.db;

import org.opencms.util.CmsUUID;

import java.io.Serializable;

/**
 * Represents the state of a Cms resource that was published.<p>
 * 
 * This allows various subsequent tasks in the Cms app. (e.g. exporting files and folders)
 * to identify published resources after a resource or project was published.<p>
 * 
 * The values to fill this container are read from the Cms publish history database table 
 * that is written during each publishing process.<p>
 * 
 * @author Thomas Weckert (t.weckert@alkacon.com)
 * @version $Revision: 1.1 $ $Date: 2003/09/26 15:11:51 $
 * @since 5.1.11
 * @see org.opencms.db.I_CmsProjectDriver#readPublishedResources(int, int)
 */
public class CmsPublishedResource extends Object implements Serializable, Cloneable {

    /** The structure ID of the published resource.<p> */
    private CmsUUID m_structureId;

    /** The resource ID of the published resource.<p> */
    private CmsUUID m_resourceId;

    /** The content ID of the published resource.<p> */
    private CmsUUID m_contentId;

    /** The root path of the published resource.<p> */
    private String m_rootPath;

    /** The type of the published resource.<p> */
    private int m_resourceType;

    /** The state of the resource *before* it was published.<p> */
    private int m_resourceState;

    /**
     * Creates a new published resource object.<p>
     * 
     * @param structureId the structure ID of the published resource
     * @param resourceId the resource ID of the published resource
     * @param contentId the content ID of the published resource
     * @param rootPath the root path of the published resource
     * @param resourceType the type of the published resource
     * @param resourceState the state of the resource *before* it was published
     */
    public CmsPublishedResource(CmsUUID structureId, CmsUUID resourceId, CmsUUID contentId, String rootPath, int resourceType, int resourceState) {
        m_structureId = structureId;
        m_resourceId = resourceId;
        m_contentId = contentId;
        m_rootPath = rootPath;
        m_resourceType = resourceType;
        m_resourceState = resourceState;
    }

    /**
     * @see java.lang.Object#finalize()
     */
    protected void finalize() throws Throwable {
        m_structureId = null;
        m_resourceId = null;
        m_contentId = null;
        m_rootPath = null;
    }

    /**
     * @see java.lang.Object#toString()
     */
    public String toString() {
        String objInfo = "[" + this.getClass().getName() + ": ";

        objInfo += "structure ID: " + m_structureId + ", ";
        objInfo += "resource ID: " + m_resourceId + ", ";
        objInfo += "content ID: " + m_contentId + ", ";
        objInfo += "root path: " + m_rootPath + ", ";
        objInfo += "state: " + m_resourceState + ", ";
        objInfo += "type: " + m_resourceType + "]";

        return objInfo;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return m_structureId.hashCode();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (!(obj instanceof CmsPublishedResource)) {
            return false;
        }

        return getStructureId().equals(((CmsPublishedResource) obj).getStructureId());
    }

    /**
     * Returns the resource ID of the published resource.<p>
     * 
     * @return the resource ID of the published resource
     */
    public CmsUUID getResourceId() {
        return m_resourceId;
    }

    /**
     * Returns the resource state of the published resource.<p>
     * 
     * @return the resource state of the published resource
     */
    public int getResourceState() {
        return m_resourceState;
    }

    /**
     * Returns the resource type of the published resource.<p>
     * 
     * @return the resource type of the published resource
     */
    public int getResourceType() {
        return m_resourceType;
    }

    /**
     * Returns the root path of the published resource.<p>
     * 
     * @return the root path of the published resource
     */
    public String getRootPath() {
        return m_rootPath;
    }

    /**
     * Returns the structure ID of the published resource.<p>
     * 
     * @return the structure ID of the published resource
     */
    public CmsUUID getStructureId() {
        return m_structureId;
    }

    /**
     * Returns the content ID of the published resource.<p>
     * 
     * @return the content ID of the published resource
     */
    public CmsUUID getContentId() {
        return m_contentId;
    }

}
