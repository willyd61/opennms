/*******************************************************************************
 * This file is part of OpenNMS(R).
 *
 * Copyright (C) 2019-2019 The OpenNMS Group, Inc.
 * OpenNMS(R) is Copyright (C) 1999-2019 The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is a registered trademark of The OpenNMS Group, Inc.
 *
 * OpenNMS(R) is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * OpenNMS(R) is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with OpenNMS(R).  If not, see:
 *      http://www.gnu.org/licenses/
 *
 * For more information contact:
 *     OpenNMS(R) Licensing <license@opennms.org>
 *     http://www.opennms.org/
 *     http://www.opennms.com/
 *******************************************************************************/

package org.opennms.netmgt.graph.api.validation;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.opennms.netmgt.graph.api.validation.exception.InvalidGraphContainerIdException;

import com.google.common.base.Strings;

public class GraphContainerIdValidator {

    private static final Pattern PATTERN = Pattern.compile(NamespaceValidator.REG_EXP);

    public void validate(String containerId) {
        Objects.requireNonNull(containerId);
        if (Strings.isNullOrEmpty(containerId)) {
            throw new InvalidGraphContainerIdException("Id of container must nut be empty or null");
        }
        final Matcher matcher = PATTERN.matcher(containerId);
        if (!matcher.matches()) {
            throw new InvalidGraphContainerIdException(NamespaceValidator.REG_EXP, containerId);
        }
    }
}
