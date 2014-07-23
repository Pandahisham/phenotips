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
package org.phenotips.security.authorization;

import org.xwiki.component.annotation.Role;
import org.xwiki.model.reference.DocumentReference;
import org.xwiki.security.authorization.Right;
import org.xwiki.stability.Unstable;
import org.xwiki.users.User;

/**
 * Service which checks if a specific operation on a patient record should be granted or not. The default implementation
 * forwards the decision to implementations of the {@link AuthorizationModule} role, in descending order of their
 * {@link AuthorizationModule#getPriority() priority}, until one responds with a non-null decision.
 *
 * @version $Id$
 * @since 1.0RC1
 */
@Unstable
@Role
public interface AuthorizationService
{
    /**
     * Checks if the specified user has the requested access level on the target document.
     *
     * @param user the user whose rights should be checked
     * @param access the requested access level
     * @param document the target document
     * @return {@code true} if access is granted, {@code false} if access is denied
     */
    boolean hasAccess(User user, Right access, DocumentReference document);
}