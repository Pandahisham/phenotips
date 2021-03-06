/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.phenotips.data.internal.controller;

import org.phenotips.data.PatientDataController;

import org.xwiki.component.annotation.Component;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Handles the information found in the family history section of the patient record.
 *
 * @version $Id$
 * @since 1.0RC1
 */
@Component(roles = { PatientDataController.class })
@Named("prenatalPerinatalHistory")
@Singleton
public class PrenatalPerinatalHistoryController extends AbstractComplexController<String>
{
    private static final String IVF = "ivf";

    private static final String ASSISTED_REPRODUCTION_FERTILITY_MEDS = "assistedReproduction_fertilityMeds";

    private static final String ASSISTED_REPRODUCTION_SURROGACY = "assistedReproduction_surrogacy";

    private List<String> booleans =
        Arrays.asList(IVF, ASSISTED_REPRODUCTION_FERTILITY_MEDS, ASSISTED_REPRODUCTION_SURROGACY);

    @Override
    public String getName()
    {
        return "prenatalPerinatalHistory";
    }

    @Override
    protected String getJsonPropertyName()
    {
        return "prenatal_perinatal_history";
    }

    @Override
    protected List<String> getProperties()
    {
        return Arrays.asList("gestation", IVF, ASSISTED_REPRODUCTION_FERTILITY_MEDS, ASSISTED_REPRODUCTION_SURROGACY);
    }

    @Override
    protected List<String> getBooleanFields()
    {
        return this.booleans;
    }

    @Override
    protected List<String> getCodeFields()
    {
        return new LinkedList<>();
    }
}
