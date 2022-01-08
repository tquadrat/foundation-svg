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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVG.Usage.STANDALONE_DOCUMENT;
import static org.tquadrat.foundation.svg.SVGUtils.createMarker;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Manually created tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGMarker}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGMarker.java 980 2022-01-06 15:29:19Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestSVGMarker.java 980 2022-01-06 15:29:19Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestSVGMarker" )
public class TestSVGMarker extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGMarker createCandidate()
    {
        skipThreadTest();

        final var retValue = createMarker( "id", createSVG( STANDALONE_DOCUMENT ) );

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link SVGMarker#setMarkerDimensions(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetMarkerDimensions() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        candidate.setMarkerDimensions( number( 0 ), number( 0 ) );
        final var expected =
            """

            <marker id='id'
                    markerWidth='0'
                    markerHeight='0'/>""";
        final var actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetMarkerDimensions()

    /**
     * Test for
     * {@link SVGMarker#setMarkerDimensions(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetMarkerDimensionsWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.setMarkerDimensions( null, number( 0 ) );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e )
        {
            throw e;
        }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
        try
        {
            candidate.setMarkerDimensions( number( 0 ), null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e )
        {
            throw e;
        }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testSetMarkerDimensionsWithNullArgument()
}
//  class TestSVGMarker

/*
 *  End of File
 */