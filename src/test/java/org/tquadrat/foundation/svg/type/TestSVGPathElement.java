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

package org.tquadrat.foundation.svg.type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.svg.SVGUtils.arcTo;
import static org.tquadrat.foundation.svg.SVGUtils.arcToAbs;

import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGPathElement.SVGArcTo;
import org.tquadrat.foundation.svg.type.SVGPathElement.SVGMoveTo;

/**
 *  Some tests for the class
 *  {@link SVGPathElement}
 *  and its inner classes
 *  {@link SVGPathElement.SVGArcTo},
 *  {@link SVGPathElement.SVGClosePath},
 *  {@link SVGPathElement.SVGCubicCurveTo},
 *  {@link SVGPathElement.SVGHLineTo},
 *  {@link SVGPathElement.SVGLineTo},
 *  {@link SVGPathElement.SVGMoveTo},
 *  {@link SVGPathElement.SVGQuadraticCurveTo},
 *  and
 *  {@link SVGPathElement.SVGVLineTo}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGPathElement.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestSVGPathElement.java 820 2020-12-29 20:34:22Z tquadrat $" )
public class TestSVGPathElement extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Satisfies the test coverage ratio.
     */
    @Test
    @SuppressWarnings( {"unlikely-arg-type", "MisorderedAssertEqualsArguments"} )
    final void cover()
    {
        skipThreadTest();

        SVGPathElement candidate;

        candidate = new SVGArcTo( true, 5, 5, 30, true, false, 7, 9 );
        final var otherCandidate = new SVGArcTo( true, 5, 5, 30, true, false, 7, 9 );

        //noinspection SimplifiableAssertion
        assertTrue( candidate.equals( candidate ) );
        //noinspection SimplifiableAssertion
        assertFalse( candidate.equals( null ) );
        //noinspection EqualsBetweenInconvertibleTypes,SimplifiableAssertion
        assertFalse( candidate.equals( EMPTY_STRING ) );
        //noinspection SimplifiableAssertion
        assertFalse( candidate.equals( new SVGMoveTo( false, 7, 5 ) ) );
        //noinspection SimplifiableAssertion
        assertFalse( candidate.equals( new SVGArcTo( false, 5, 5, 30, true, false, 7, 9 ) ) );
        //noinspection SimplifiableAssertion
        assertTrue( candidate.equals( otherCandidate ) );

        assertEquals( otherCandidate.hashCode(), candidate.hashCode() );

        String expected, actual;

        candidate = arcToAbs( 5, 5, 45, true, true, 0, 0 );
        assertNotNull( candidate );
        expected = "A5,5,45,1,1,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcToAbs( 5, 5, 45, true, false, 0, 0 );
        assertNotNull( candidate );
        expected = "A5,5,45,1,0,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcToAbs( 5, 5, 45, false, true, 0, 0 );
        assertNotNull( candidate );
        expected = "A5,5,45,0,1,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcToAbs( 5, 5, 45, false, false, 0, 0 );
        assertNotNull( candidate );
        expected = "A5,5,45,0,0,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcToAbs( 5.0, 5.0, 45.0, true, true, 1.0, 1.0 );
        assertNotNull( candidate );
        expected = "A5.000,5.000,45.000,1,1,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcToAbs( 5.0, 5.0, 45.0, true, false, 1.0, 1.0 );
        assertNotNull( candidate );
        expected = "A5.000,5.000,45.000,1,0,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcToAbs( 5.0, 5.0, 45.0, false, true, 1.0, 1.0 );
        assertNotNull( candidate );
        expected = "A5.000,5.000,45.000,0,1,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcToAbs( 5.0, 5.0, 45.0, false, false, 1.0, 1.0 );
        assertNotNull( candidate );
        expected = "A5.000,5.000,45.000,0,0,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5, 5, 45, true, true, 0, 0 );
        assertNotNull( candidate );
        expected = "a5,5,45,1,1,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5, 5, 45, true, false, 0, 0 );
        assertNotNull( candidate );
        expected = "a5,5,45,1,0,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5, 5, 45, false, true, 0, 0 );
        assertNotNull( candidate );
        expected = "a5,5,45,0,1,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5, 5, 45, false, false, 0, 0 );
        assertNotNull( candidate );
        expected = "a5,5,45,0,0,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5.0, 5.0, 45.0, true, true, 1.0, 1.0 );
        assertNotNull( candidate );
        expected = "a5.000,5.000,45.000,1,1,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5.0, 5.0, 45.0, true, false, 1.0, 1.0 );
        assertNotNull( candidate );
        expected = "a5.000,5.000,45.000,1,0,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5.0, 5.0, 45.0, false, true, 1.0, 1.0 );
        assertNotNull( candidate );
        expected = "a5.000,5.000,45.000,0,1,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5.0, 5.0, 45.0, false, false, 1.0, 1.0 );
        assertNotNull( candidate );
        expected = "a5.000,5.000,45.000,0,0,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  cover()
}
//  class TestSVGPathElement

/*
 *  End of File
 */