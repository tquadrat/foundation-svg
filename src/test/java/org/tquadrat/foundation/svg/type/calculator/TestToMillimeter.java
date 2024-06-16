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
import static org.tquadrat.foundation.svg.type.SVGCalculator.toMillimeter;
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
 *  {@link org.tquadrat.foundation.svg.type.SVGCalculator#toMillimeter(SVGNumber)}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 */
@DisplayName( "org.tquadrat.foundation.svg.type.calculator.TestToMillimeter" )
public class TestToMillimeter extends TestBaseClass
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Some tests for
     *  {@link org.tquadrat.foundation.svg.type.SVGCalculator#toMillimeter(SVGNumber)}.
     *
     *  @throws Exception   Something unexpected went wrong.
     */
    @Test
    final void testToMillimeter() throws Exception
    {
        skipThreadTest();

        assertThrows( NullArgumentException.class, () -> toMillimeter( null ) );
        assertThrows( IllegalArgumentException.class, () -> toMillimeter( new SVGDegree( 0 ) ) );
        assertThrows( IllegalArgumentException.class, () -> toMillimeter( new SVGPercent( 0 ) ) );
        assertThrows( IllegalArgumentException.class, () -> toMillimeter( new SVGNumber( 0, EM ) ) );
        assertThrows( IllegalArgumentException.class, () -> toMillimeter( new SVGNumber( 0, EX ) ) );
        assertThrows( IllegalArgumentException.class, () -> toMillimeter( new SVGNumber( 0, NONE ) ) );
        assertThrows( IllegalArgumentException.class, () -> toMillimeter( new SVGNumber( 0, PERCENT ) ) );

        SVGNumber candidate;
        String expected;

        candidate = new SVGMillimeter( 25.0 );
        assertEquals( candidate, toMillimeter( candidate ) );

        candidate = new SVGNumber( 25.0, MILLIMETER );
        assertEquals( "25.000mm", toMillimeter( candidate ).value() );

        candidate = new SVGPixel( 96 );
        expected = "25.400mm";
        assertEquals( expected, toMillimeter( candidate ).value() );

        candidate = new SVGNumber( 96, PIXEL );
        expected = "25.400mm";
        assertEquals( expected, toMillimeter( candidate ).value() );

        candidate = new SVGUserUnitValue( 96 );
        expected = "25.400mm";
        assertEquals( expected, toMillimeter( candidate ).value() );

        candidate = new SVGNumber( 1, CENTIMETER );
        expected = "10mm";
        assertEquals( expected, toMillimeter( candidate ).value() );

        candidate = new SVGNumber( 1.2, CENTIMETER );
        expected = "12.000mm";
        assertEquals( expected, toMillimeter( candidate ).value() );

        candidate = new SVGNumber( 1, INCH );
        expected = "25.400mm";
        assertEquals( expected, toMillimeter( candidate ).value() );

        candidate = new SVGNumber( 6, PICA );
        expected = "25.400mm";
        assertEquals( expected, toMillimeter( candidate ).value() );

        candidate = new SVGNumber( 1000, POINT );
        expected = "352.778mm";
        assertEquals( expected, toMillimeter( candidate ).value() );
    }   //  testToMillimeter()
}
//  class TestToMillimeter

/*
 *  End of File
 */