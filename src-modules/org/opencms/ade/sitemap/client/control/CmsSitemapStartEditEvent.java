/*
 * File   : $Source: /alkacon/cvs/opencms/src-modules/org/opencms/ade/sitemap/client/control/Attic/CmsSitemapStartEditEvent.java,v $
 * Date   : $Date: 2010/05/27 11:13:52 $
 * Version: $Revision: 1.1 $
 *
 * This library is part of OpenCms -
 * the Open Source Content Management System
 *
 * Copyright (C) 2002 - 2009 Alkacon Software (http://www.alkacon.com)
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

package org.opencms.ade.sitemap.client.control;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Sitemap start edit event.<p>
 * 
 * @author Michael Moossen
 * 
 * @version $Revision: 1.1 $ 
 * 
 * @since 8.0.0
 * 
 * @see org.opencms.ade.sitemap.client.control.CmsSitemapController
 */
public class CmsSitemapStartEditEvent extends GwtEvent<I_CmsSitemapStartEditHandler> {

    /** Event type for sitemap change events. */
    private static final Type<I_CmsSitemapStartEditHandler> TYPE = new Type<I_CmsSitemapStartEditHandler>();

    /**
     * Constructor.<p>
     */
    public CmsSitemapStartEditEvent() {

        // empty
    }

    /**
     * Gets the event type associated with change events.<p>
     * 
     * @return the handler type
     */
    public static Type<I_CmsSitemapStartEditHandler> getType() {

        return TYPE;
    }

    /**
     * @see com.google.gwt.event.shared.GwtEvent#getAssociatedType()
     */
    @Override
    public final Type<I_CmsSitemapStartEditHandler> getAssociatedType() {

        return TYPE;
    }

    /**
     * @see com.google.gwt.event.shared.GwtEvent#dispatch(com.google.gwt.event.shared.EventHandler)
     */
    @Override
    protected void dispatch(I_CmsSitemapStartEditHandler handler) {

        handler.onStartEdit(this);
    }
}
