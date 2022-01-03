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
import static org.tquadrat.foundation.svg.SVGPositionedMarker.EMPTY_SVGPositionedMarker_ARRAY;
import static org.tquadrat.foundation.svg.SVGUtils.createPositionedMarker;
import static org.tquadrat.foundation.svg.SVGUtils.ex;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGPositionedMarker}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGPositionedMarker.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestAutoSVGPositionedMarker.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGPositionedMarker" )
public class TestAutoSVGPositionedMarker extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Satisfies the test coverage ratio.
     */
    @Test
    final void cover()
    {
        skipThreadTest();

        final List<SVGPositionedMarker> list = List.of();
        assertEquals( 0, list.toArray( EMPTY_SVGPositionedMarker_ARRAY ).length );
    }   //  cover()

    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGPositionedMarker createCandidate()
    {
        skipThreadTest();

        final var retValue = createPositionedMarker();

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGPositionedMarker#setPosition(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetPosition() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setPosition( ex( 7.5 ) );
        expected = "\n<marker position='7.500ex'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPosition( null );
        expected = "\n<marker/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPosition()
}
//  class TestAutoSVGPositionedMarker

/*
 *  End of File
 */