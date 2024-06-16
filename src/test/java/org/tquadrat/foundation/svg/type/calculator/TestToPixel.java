/*
 * ============================================================================
 *  Copyright © 2002-2024 by Thomas Thrien.
 *  All Rights Reserved.
 * ============================================================================
 *  Licensed to the public under the agreements of the GNU Lesser General Public
 *  License, version 3.0 (the "License"). You may obtain a copy of the License at
 *
 *       http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package org.tquadrat.foundation.svg.type.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.tquadrat.foundation.svg.type.SVGCalculator.toPixel;
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
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.type.SVGNumber;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGMillimeter;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGPercent;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGPixel;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGUserUnitValue;
import org.tquadrat.foundation.testutil.TestBaseClass;

/**
 *  Some tests for
 *  {@link org.tquadrat.foundation.svg.type.SVGCalculator#toPixel(SVGNumber)}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 */
@DisplayName( "org.tquadrat.foundation.svg.type.calculator.TestToPixel" )
public class TestToPixel extends TestBaseClass
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Some tests for
     *  {@link org.tquadrat.foundation.svg.type.SVGCalculator#toPixel(SVGNumber)}.
     *
     *  @throws Exception   Something unexpected went wrong.
     */
    @Test
    final void testToPixel() throws Exception
    {
        skipThreadTest();

        assertThrows( NullArgumentException.class, () -> toPixel( null ) );
        assertThrows( IllegalArgumentException.class, () -> toPixel( new SVGDegree( 0 ) ) );
        assertThrows( IllegalArgumentException.class, () -> toPixel( new SVGPercent( 0 ) ) );
        assertThrows( IllegalArgumentException.class, () -> toPixel( new SVGNumber( 0, EM ) ) );
        assertThrows( IllegalArgumentException.class, () -> toPixel( new SVGNumber( 0, EX ) ) );
        assertThrows( IllegalArgumentException.class, () -> toPixel( new SVGNumber( 0, NONE ) ) );
        assertThrows( IllegalArgumentException.class, () -> toPixel( new SVGNumber( 0, PERCENT ) ) );

        SVGNumber candidate;
        String expected;

        candidate = new SVGPixel( 25.0 );
        assertEquals( candidate, toPixel( candidate ) );

        candidate = new SVGNumber( 25, PIXEL );
        assertEquals( "25px", toPixel( candidate ).value() );

        candidate = new SVGMillimeter( 25.4 );
        expected = "96.000px";
        assertEquals( expected, toPixel( candidate ).value() );

        candidate = new SVGNumber( 254, MILLIMETER );
        expected = "960.000px";
        assertEquals( expected, toPixel( candidate ).value() );

        candidate = new SVGUserUnitValue( 96 );
        expected = "96px";
        assertEquals( expected, toPixel( candidate ).value() );

        candidate = new SVGUserUnitValue( 96.0 );
        expected = "96.000px";
        assertEquals( expected, toPixel( candidate ).value() );

        candidate = new SVGNumber( 25.4, CENTIMETER );
        expected = "960.000px";
        assertEquals( expected, toPixel( candidate ).value() );

        candidate = new SVGNumber( 1, INCH );
        expected = "96.000px";
        assertEquals( expected, toPixel( candidate ).value() );

        candidate = new SVGNumber( 1.5, INCH );
        expected = "144.000px";
        assertEquals( expected, toPixel( candidate ).value() );

        candidate = new SVGNumber( 6, PICA );
        expected = "96.000px";
        assertEquals( expected, toPixel( candidate ).value() );

        candidate = new SVGNumber( 10, POINT );
        expected = "7.500px";
        assertEquals( expected, toPixel( candidate ).value() );
    }   //  testToPixel()
}
//  class TestToPixel

/*
 *  End of File
 */