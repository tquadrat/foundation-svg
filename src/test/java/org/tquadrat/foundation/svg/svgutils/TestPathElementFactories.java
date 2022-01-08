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

package org.tquadrat.foundation.svg.svgutils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.tquadrat.foundation.svg.SVGUtils.arcTo;
import static org.tquadrat.foundation.svg.SVGUtils.arcToAbs;
import static org.tquadrat.foundation.svg.SVGUtils.closePath;
import static org.tquadrat.foundation.svg.SVGUtils.cubicCurveTo;
import static org.tquadrat.foundation.svg.SVGUtils.cubicCurveToAbs;
import static org.tquadrat.foundation.svg.SVGUtils.hLineTo;
import static org.tquadrat.foundation.svg.SVGUtils.hLineToAbs;
import static org.tquadrat.foundation.svg.SVGUtils.lineTo;
import static org.tquadrat.foundation.svg.SVGUtils.lineToAbs;
import static org.tquadrat.foundation.svg.SVGUtils.moveTo;
import static org.tquadrat.foundation.svg.SVGUtils.moveToAbs;
import static org.tquadrat.foundation.svg.SVGUtils.quadraticCurveTo;
import static org.tquadrat.foundation.svg.SVGUtils.quadraticCurveToAbs;
import static org.tquadrat.foundation.svg.SVGUtils.vLineTo;
import static org.tquadrat.foundation.svg.SVGUtils.vLineToAbs;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGPathElement;

/**
 *  Tests for the method
 *  {@link SVGUtils#arcTo(long, long, long, boolean, boolean, long, long)},
 *  {@link SVGUtils#arcTo(double, double, double, boolean, boolean, double, double)},
 *  {@link SVGUtils#arcToAbs(long, long, long, boolean, boolean, long, long)},
 *  {@link SVGUtils#arcToAbs(double, double, double, boolean, boolean, double, double)},
 *  {@link SVGUtils#closePath()},
 *  {@link SVGUtils#cubicCurveTo(long, long, long, long)},
 *  {@link SVGUtils#cubicCurveTo(double, double, double, double)},
 *  {@link SVGUtils#cubicCurveTo(long, long, long, long, long, long)},
 *  {@link SVGUtils#cubicCurveTo(double, double, double, double, double, double)},
 *  {@link SVGUtils#cubicCurveToAbs(long, long, long, long)},
 *  {@link SVGUtils#cubicCurveToAbs(double, double, double, double)},
 *  {@link SVGUtils#cubicCurveToAbs(long, long, long, long, long, long)},
 *  {@link SVGUtils#cubicCurveToAbs(double, double, double, double, double, double)},
 *  {@link SVGUtils#hLineTo(long)},
 *  {@link SVGUtils#hLineTo(double)},
 *  {@link SVGUtils#hLineToAbs(long)},
 *  {@link SVGUtils#hLineToAbs(double)},
 *  {@link SVGUtils#lineTo(long, long)},
 *  {@link SVGUtils#lineTo(double, double)},
 *  {@link SVGUtils#lineToAbs(long, long)},
 *  {@link SVGUtils#lineToAbs(double, double)},
 *  {@link SVGUtils#lineTo(long, long)},
 *  {@link SVGUtils#lineTo(double, double)},
 *  {@link SVGUtils#lineToAbs(long, long)},
 *  {@link SVGUtils#lineToAbs(double, double)},
 *  {@link SVGUtils#moveTo(long, long)},
 *  {@link SVGUtils#moveTo(double, double)},
 *  {@link SVGUtils#moveToAbs(long, long)},
 *  {@link SVGUtils#moveToAbs(double, double)},
 *  {@link SVGUtils#quadraticCurveTo(long, long)},
 *  {@link SVGUtils#quadraticCurveTo(double, double)},
 *  {@link SVGUtils#quadraticCurveTo(long, long, long, long)},
 *  {@link SVGUtils#quadraticCurveTo(double, double, double, double)},
 *  {@link SVGUtils#quadraticCurveToAbs(long, long)},
 *  {@link SVGUtils#quadraticCurveToAbs(double, double)},
 *  {@link SVGUtils#quadraticCurveToAbs(long, long, long, long)},
 *  {@link SVGUtils#quadraticCurveToAbs(double, double, double, double)},
 *  {@link SVGUtils#vLineTo(long)},
 *  {@link SVGUtils#vLineTo(double)},
 *  {@link SVGUtils#vLineToAbs(long)},
 *  and
 *  {@link SVGUtils#vLineToAbs(double)}
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestPathElementFactories.java 980 2022-01-06 15:29:19Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestPathElementFactories.java 980 2022-01-06 15:29:19Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestPathElementFactories" )
public class TestPathElementFactories extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/

    /**
     *  Tests the path element factory methods.
     */
    @Test
    final void testPathElementFactories()
    {
        skipThreadTest();

        SVGPathElement candidate;
        String expected, actual;
        final Collection<SVGPathElement> candidates = new ArrayList<>();

        candidate = arcToAbs( 5, 5, 45, true, true, 0, 0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "A5,5,45,1,1,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcToAbs( 5.0, 5.0, 45.0, false, false, 1.0, 1.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "A5.000,5.000,45.000,0,0,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5, 5, 45, true, true, 0, 0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "a5,5,45,1,1,0,0";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = arcTo( 5.0, 5.0, 45.0, false, false, 1.0, 1.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "a5.000,5.000,45.000,0,0,1.000,1.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = closePath();
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "Z";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = cubicCurveToAbs( 5, 5, 7, 7, 9, 9 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "C5,5,7,7,9,9";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = cubicCurveToAbs( 5.0, 5.0, 7.0, 7.0, 9.0, 9.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "C5.000,5.000,7.000,7.000,9.000,9.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = cubicCurveToAbs( 7, 7, 9, 9 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "S7,7,9,9";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = cubicCurveToAbs( 7.0, 7.0, 9.0, 9.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "S7.000,7.000,9.000,9.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = cubicCurveTo( 5, 5, 7, 7, 9, 9 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "c5,5,7,7,9,9";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = cubicCurveTo( 5.0, 5.0, 7.0, 7.0, 9.0, 9.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "c5.000,5.000,7.000,7.000,9.000,9.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = cubicCurveTo( 7, 7, 9, 9 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "s7,7,9,9";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = cubicCurveTo( 7.0, 7.0, 9.0, 9.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "s7.000,7.000,9.000,9.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = hLineToAbs( 5 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "H5";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = hLineToAbs( 5.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "H5.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = hLineTo( 5 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "h5";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = hLineTo( 5.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "h5.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = lineToAbs( 5, 5 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "L5,5";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = lineToAbs( 5.0, 5.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "L5.000,5.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = lineTo( 5, 5 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "l5,5";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = lineTo( 5.0, 5.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "l5.000,5.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = moveToAbs( 5, 5 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "M5,5";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = moveToAbs( 5.0, 5.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "M5.000,5.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = moveTo( 5, 5 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "m5,5";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = moveTo( 5.0, 5.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "m5.000,5.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = quadraticCurveToAbs( 5, 5, 9, 9 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "Q5,5,9,9";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = quadraticCurveToAbs( 5.0, 5.0, 9.0, 9.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "Q5.000,5.000,9.000,9.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = quadraticCurveToAbs( 9, 9 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "T9,9";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = quadraticCurveToAbs( 9.0, 9.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "T9.000,9.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = quadraticCurveTo( 5, 5, 9, 9 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "q5,5,9,9";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = quadraticCurveTo( 5.0, 5.0, 9.0, 9.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "q5.000,5.000,9.000,9.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = quadraticCurveTo( 9, 9 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "t9,9";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = quadraticCurveTo( 9.0, 9.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "t9.000,9.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = vLineToAbs( 5 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "V5";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = vLineToAbs( 5.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "V5.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = vLineTo( 5 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "v5";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = vLineTo( 5.0 );
        assertNotNull( candidate );
        candidates.add( candidate );
        expected = "v5.000";
        actual = candidate.toString();
        assertEquals( expected, actual );

        //---* Test the Stringer for the path element array *------------------
        final var candidatesArray = candidates.toArray( SVGPathElement[]::new );
        expected = "A5,5,45,1,1,0,0 5.000,5.000,45.000,0,0,1.000,1.000 "
            + "a5,5,45,1,1,0,0 5.000,5.000,45.000,0,0,1.000,1.000 Z "
            + "C5,5,7,7,9,9 5.000,5.000,7.000,7.000,9.000,9.000 S7,7,9,9 "
            + "7.000,7.000,9.000,9.000 c5,5,7,7,9,9 "
            + "5.000,5.000,7.000,7.000,9.000,9.000 "
            + "s7,7,9,9 7.000,7.000,9.000,9.000 H5 5.000 h5 5.000 "
            + "L5,5 5.000,5.000 l5,5 5.000,5.000 M5,5 5.000,5.000 "
            + "m5,5 5.000,5.000 Q5,5,9,9 5.000,5.000,9.000,9.000 "
            + "T9,9 9.000,9.000 q5,5,9,9 5.000,5.000,9.000,9.000 "
            + "t9,9 9.000,9.000 V5 5.000 v5 5.000";
        actual = SVGPathElement.toString( candidatesArray );
        assertEquals( expected, actual );
    }   //  testPathElementFactories()
}
//  class TestPathElementFactories

/*
 *  End of File
 */