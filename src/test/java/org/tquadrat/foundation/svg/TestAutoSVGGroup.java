/*
 * ============================================================================
 * Copyright © 2002-2020 by Thomas Thrien.
 * All Rights Reserved.
 * ============================================================================
 * Licensed to the public under the agreements of the GNU Lesser General Public
 * License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/lgpl.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.tquadrat.foundation.svg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.tquadrat.foundation.svg.SVGGroup.EMPTY_SVGGroup_ARRAY;
import static org.tquadrat.foundation.svg.SVGUtils.createGroup;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGGroup}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGGroup.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGGroup.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGGroup" )
public class TestAutoSVGGroup extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Satisfies the test coverage ratio.
     */
    @SuppressWarnings( "MisorderedAssertEqualsArguments" )
    @Test
    final void cover()
    {
        skipThreadTest();

        final List<SVGGroup> list = List.of();
        assertEquals( 0, list.toArray( EMPTY_SVGGroup_ARRAY ).length );

        assertNotNull( createCandidate() );
    }   //  cover()

    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGGroup createCandidate()
    {
        skipThreadTest();

        final var retValue = createGroup();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()
}
//  class TestAutoSVGGroup

/*
 *  End of File
 */