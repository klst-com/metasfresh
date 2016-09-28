package de.metas.edi.esb.bean.desadv;

/*
 * #%L
 * de.metas.edi.esb
 * %%
 * Copyright (C) 2015 metas GmbH
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 2 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-2.0.html>.
 * #L%
 */


import org.apache.camel.Exchange;

import de.metas.edi.esb.pojo.desadv.compudata.H000;

/**
 * Contains common DESADV processing per InOut document, regardless of whether documents are aggregated or not
 *
 * @author al
 */
public abstract class AbstractEDIDesadvCommonBean
{
	public static final String METHOD_createEDIData = "createEDIData";

	protected static final String voidString = "";

	/**
	 * <ul>
	 * <li>IN: Unmarshalled XML Document (type unknown)</li>
	 * <li>OUT: {@link H000}</li>
	 * </ul>
	 *
	 * @param exchange
	 */
	public abstract void createEDIData(final Exchange exchange);
}