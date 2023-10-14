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

import static java.lang.String.format;
import static java.util.Locale.ROOT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.tquadrat.foundation.svg.SVGUtils.centimeter;
import static org.tquadrat.foundation.svg.SVGUtils.degree;
import static org.tquadrat.foundation.svg.SVGUtils.em;
import static org.tquadrat.foundation.svg.SVGUtils.ex;
import static org.tquadrat.foundation.svg.SVGUtils.inch;
import static org.tquadrat.foundation.svg.SVGUtils.millimeter;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.svg.SVGUtils.percent;
import static org.tquadrat.foundation.svg.SVGUtils.pica;
import static org.tquadrat.foundation.svg.SVGUtils.pixel;
import static org.tquadrat.foundation.svg.SVGUtils.point;
import static org.tquadrat.foundation.svg.type.SVGUnit.CENTIMETER;
import static org.tquadrat.foundation.svg.type.SVGUnit.EM;
import static org.tquadrat.foundation.svg.type.SVGUnit.EX;
import static org.tquadrat.foundation.svg.type.SVGUnit.INCH;
import static org.tquadrat.foundation.svg.type.SVGUnit.MILLIMETER;
import static org.tquadrat.foundation.svg.type.SVGUnit.NONE;
import static org.tquadrat.foundation.svg.type.SVGUnit.PERCENT;
import static org.tquadrat.foundation.svg.type.SVGUnit.PICA;
import static org.tquadrat.foundation.svg.type.SVGUnit.PIXEL;
import static org.tquadrat.foundation.svg.type.SVGUnit.POINT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the methods
 *  {@link SVGUtils#centimeter(double)},
 *  {@link SVGUtils#centimeter(long)},
 *  {@link SVGUtils#degree(double)},
 *  {@link SVGUtils#degree(long)},
 *  {@link SVGUtils#em(double)},
 *  {@link SVGUtils#em(long)},
 *  {@link SVGUtils#ex(double)},
 *  {@link SVGUtils#ex(long)},
 *  {@link SVGUtils#inch(double)},
 *  {@link SVGUtils#inch(long)},
 *  {@link SVGUtils#millimeter(double)},
 *  {@link SVGUtils#millimeter(long)},
 *  {@link SVGUtils#number(double)},
 *  {@link SVGUtils#number(long)},
 *  {@link SVGUtils#pica(double)},
 *  {@link SVGUtils#pica(long)},
 *  {@link SVGUtils#pixel(double)},
 *  {@link SVGUtils#pixel(long)},
 *  {@link SVGUtils#point(double)},
 *  and
 *  {@link SVGUtils#point(long)}.
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestNumVal.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestNumVal.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestNumVal" )
public class TestNumVal extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests for the methods
     *  {@link SVGUtils#centimeter(double)},
     *  {@link SVGUtils#centimeter(long)},
     *  {@link SVGUtils#degree(double)},
     *  {@link SVGUtils#degree(long)},
     *  {@link SVGUtils#em(double)},
     *  {@link SVGUtils#em(long)},
     *  {@link SVGUtils#ex(double)},
     *  {@link SVGUtils#ex(long)},
     *  {@link SVGUtils#inch(double)},
     *  {@link SVGUtils#inch(long)},
     *  {@link SVGUtils#millimeter(double)},
     *  {@link SVGUtils#millimeter(long)},
     *  {@link SVGUtils#number(double)},
     *  {@link SVGUtils#number(long)},
     *  {@link SVGUtils#pica(double)},
     *  {@link SVGUtils#pica(long)},
     *  {@link SVGUtils#pixel(double)},
     *  {@link SVGUtils#pixel(long)},
     *  {@link SVGUtils#point(double)},
     *  and
     *  {@link SVGUtils#point(long)}.
     */
    @Test
    final void testNumVal()
    {
        skipThreadTest();

        final var doubleValue = 3.1415;
        final var intValue = 42;

        assertEquals( format( ROOT, "%1.3f", doubleValue ), number( doubleValue).toString() );
        assertEquals( format( ROOT, "%d", intValue ), number( intValue).toString() );

        assertEquals( format( ROOT, "%1.3f", doubleValue ), degree( doubleValue).toString() );
        assertEquals( format( ROOT, "%d", intValue ), degree( intValue).toString() );

        assertEquals( format( ROOT, "%1.3fcm", doubleValue ), centimeter( doubleValue).toString() );
        assertEquals( format( ROOT, "%dcm", intValue ), centimeter( intValue).toString() );

        assertEquals( format( ROOT, "%1.3fem", doubleValue ), em( doubleValue).toString() );
        assertEquals( format( ROOT, "%dem", intValue ), em( intValue).toString() );

        assertEquals( format( ROOT, "%1.3fex", doubleValue ), ex( doubleValue).toString() );
        assertEquals( format( ROOT, "%dex", intValue ), ex( intValue).toString() );

        assertEquals( format( ROOT, "%1.3fin", doubleValue ), inch( doubleValue).toString() );
        assertEquals( format( ROOT, "%din", intValue ), inch( intValue).toString() );

        assertEquals( format( ROOT, "%1.3fmm", doubleValue ), millimeter( doubleValue).toString() );
        assertEquals( format( ROOT, "%dmm", intValue ), millimeter( intValue).toString() );

        assertEquals( format( ROOT, "%1.3f%%", doubleValue ), percent( doubleValue).toString() );
        assertEquals( format( ROOT, "%d%%", intValue ), percent( intValue).toString() );

        assertEquals( format( ROOT, "%1.3fpc", doubleValue ), pica( doubleValue).toString() );
        assertEquals( format( ROOT, "%dpc", intValue ), pica( intValue).toString() );

        assertEquals( format( ROOT, "%1.3fpt", doubleValue ), point( doubleValue).toString() );
        assertEquals( format( ROOT, "%dpt", intValue ), point( intValue).toString() );

        assertEquals( format( ROOT, "%1.3fpx", doubleValue ), pixel( doubleValue).toString() );
        assertEquals( format( ROOT, "%dpx", intValue ), pixel( intValue).toString() );

        assertEquals( NONE.format( doubleValue ), number( doubleValue).toString() );
        assertEquals( NONE.format(  intValue ), number( intValue).toString() );

        assertEquals( NONE.format( doubleValue ), degree( doubleValue).toString() );
        assertEquals( NONE.format(  intValue ), degree( intValue).toString() );

        assertEquals( CENTIMETER.format(  doubleValue ), centimeter( doubleValue).toString() );
        assertEquals( CENTIMETER.format( intValue ), centimeter( intValue).toString() );

        assertEquals( EM.format( doubleValue ), em( doubleValue).toString() );
        assertEquals( EM.format( intValue ), em( intValue).toString() );

        assertEquals( EX.format( doubleValue ), ex( doubleValue).toString() );
        assertEquals( EX.format( intValue ), ex( intValue).toString() );

        assertEquals( INCH.format( doubleValue ), inch( doubleValue).toString() );
        assertEquals( INCH.format( intValue ), inch( intValue).toString() );

        assertEquals( MILLIMETER.format( doubleValue ), millimeter( doubleValue).toString() );
        assertEquals( MILLIMETER.format( intValue ), millimeter( intValue).toString() );

        assertEquals( PERCENT.format( doubleValue ), percent( doubleValue).toString() );
        assertEquals( PERCENT.format( intValue ), percent( intValue).toString() );

        assertEquals( PICA.format( doubleValue ), pica( doubleValue).toString() );
        assertEquals( PICA.format( intValue ), pica( intValue).toString() );

        assertEquals( POINT.format( doubleValue ), point( doubleValue).toString() );
        assertEquals( POINT.format( intValue ), point( intValue).toString() );

        assertEquals( PIXEL.format( doubleValue ), pixel( doubleValue).toString() );
        assertEquals( PIXEL.format( intValue ), pixel( intValue).toString() );
    }   //  testNumValue;
}
//  class TestNumVal

/*
 *  End of File
 */