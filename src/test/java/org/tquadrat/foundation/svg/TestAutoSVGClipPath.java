
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
import static org.tquadrat.foundation.svg.SVGUtils.createClipPath;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGClipPath}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGClipPath.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGClipPath.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGClipPath" )
public class TestAutoSVGClipPath extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGClipPath createCandidate()
    {
        skipThreadTest();

        final var retValue = createClipPath( "id" );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGClipPath#setClipPathUnits(boolean)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetClipPathUnits() throws Exception
    {
        skipThreadTest();

        final SVGClipPath candidate;
        String actual, expected;

        candidate = createCandidate();
        expected = "\n<clipPath id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setClipPathUnits( true );
        expected =
            """

            <clipPath id='id'
                      clipPathUnits='objectBoundingBox'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setClipPathUnits( false );
        expected =
            """

            <clipPath id='id'
                      clipPathUnits='userSpaceOnUse'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetClipPathUnits()
}
//  class TestAutoSVGClipPath

/*
 *  End of File
 */