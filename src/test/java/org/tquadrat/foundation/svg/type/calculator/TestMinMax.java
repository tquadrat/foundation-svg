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
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.svg.SVGUtils.pixel;
import static org.tquadrat.foundation.svg.type.SVGCalculator.max;
import static org.tquadrat.foundation.svg.type.SVGCalculator.min;
import static org.tquadrat.foundation.svg.type.SVGUnit.EX;
import static org.tquadrat.foundation.svg.type.SVGUnit.PIXEL;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.type.SVGNumber;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGPixel;
import org.tquadrat.foundation.testutil.TestBaseClass;

/**
 *  Some tests for the methods
 *  {@link org.tquadrat.foundation.svg.type.SVGCalculator#min(SVGNumber, SVGNumber[])}
 *  and
 *  {@link org.tquadrat.foundation.svg.type.SVGCalculator#max(SVGNumber, SVGNumber[])}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 */
@DisplayName( "org.tquadrat.foundation.svg.type.calculator.TestMinMax" )
public class TestMinMax extends TestBaseClass
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Some tests for the method
     *  {@link org.tquadrat.foundation.svg.type.SVGCalculator#min(SVGNumber, SVGNumber[])}.
     *
     *  @throws Exception   Some unexpected went wrong.
     */
    @Test
    final void testMin() throws Exception
    {
        skipThreadTest();

        assertThrows( NullArgumentException.class, () -> min( null, pixel( 0 ) ) );
        assertThrows( NullArgumentException.class, () -> min( pixel( 0 ), (SVGPixel[]) null ) );
        assertThrows( NullArgumentException.class, () -> min( pixel( 0 ), pixel( 1 ), pixel( 2 ), null, pixel( 4 ) ) );

        assertThrows( IllegalArgumentException.class, () -> min( new SVGNumber( 0, EX ), new SVGNumber( 2, EX ), new SVGNumber( 3, PIXEL) ) );

        final var min = number( 4 );
        final var max = number( 99 );

        assertEquals( min, min( min, max ) );
        assertEquals( min, min( max, min ) );
    }   //  testMin()

    /**
     *  Some tests for the method
     *  {@link org.tquadrat.foundation.svg.type.SVGCalculator#max(SVGNumber, SVGNumber[])}.
     *
     *  @throws Exception   Some unexpected went wrong.
     */
    @Test
    final void testMax() throws Exception
    {
        skipThreadTest();

        assertThrows( NullArgumentException.class, () -> max( null, pixel( 0 ) ) );
        assertThrows( NullArgumentException.class, () -> max( pixel( 0 ), (SVGPixel[]) null ) );
        assertThrows( NullArgumentException.class, () -> max( pixel( 0 ), pixel( 1 ), pixel( 2 ), null, pixel( 4 ) ) );

        assertThrows( IllegalArgumentException.class, () -> max( new SVGNumber( 0, EX ), new SVGNumber( 2, EX ), new SVGNumber( 3, PIXEL) ) );

        final var min = number( 4 );
        final var max = number( 99 );

        assertEquals( max, max( min, max ) );
        assertEquals( max, max( max, min ) );
    }   //  testMax()
}
//  class TestMinMax

/*
 *  End of File
 */