/*
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (c) Alkacon Software GmbH & Co. KG (http://www.alkacon.com)
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

package org.opencms.jsp.util;

import org.opencms.ade.configuration.plugins.CmsTemplatePlugin;
import org.opencms.file.CmsObject;
import org.opencms.relations.CmsLink;
import org.opencms.relations.CmsLinkInfo;

/**
 * Wrapper around template plugin objects for use in JSP EL expressions.
 */
public class CmsTemplatePluginWrapper {

    /** The current CmsObject. */
    private CmsObject m_cms;

    /** The wrapped plugin. */
    private CmsTemplatePlugin m_plugin;

    /**
     * Creates a new wrapper.
     *
     * @param cms the current CmsObject
     * @param plugin the plugin to wrap
     */
    public CmsTemplatePluginWrapper(CmsObject cms, CmsTemplatePlugin plugin) {

        m_cms = cms;
        m_plugin = plugin;
    }

    /**
     * Gets the group of the plugin.
     *
     * @return the group
     */
    public String getGroup() {

        return m_plugin.getGroup();
    }

    /**
     * Gets a link to the plugin target.
     *
     * @return a link to the plugin target
     */
    public String getLink() {

        CmsLinkInfo target = m_plugin.getTarget();
        CmsLink targetLink = target.toLink();
        String link = targetLink.getLink(m_cms);
        return link;
    }

    /**
     * Gets the order of the plugin.
     *
     * @return the order of the plugin
     */
    public int getOrder() {

        return m_plugin.getOrder();
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {

        return m_plugin.toString();
    }

}