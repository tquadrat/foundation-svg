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
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tquadrat.foundation.svg.type.SVGCalculator.increase;
import static org.tquadrat.foundation.svg.type.SVGCalculator.multiply;
import static org.tquadrat.foundation.svg.type.SVGCalculator.reduce;
import static org.tquadrat.foundation.svg.type.SVGUnit.CENTIMETER;
import static org.tquadrat.foundation.svg.type.SVGUnit.EM;
import static org.tquadrat.foundation.svg.type.SVGUnit.EX;
import static org.tquadrat.foundation.svg.type.SVGUnit.INCH;
import static org.tquadrat.foundation.svg.type.SVGUnit.MILLIMETER;
import static org.tquadrat.foundation.svg.type.SVGUnit.PERCENT;
import static org.tquadrat.foundation.svg.type.SVGUnit.PICA;
import static org.tquadrat.foundation.svg.type.SVGUnit.PIXEL;
import static org.tquadrat.foundation.svg.type.SVGUnit.POINT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.type.SVGCalculator;
import org.tquadrat.foundation.svg.type.SVGNumber;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGMillimeter;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGPercent;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGPixel;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGUserUnitValue;
import org.tquadrat.foundation.testutil.TestBaseClass;

/**
 *  Some tests for
 *  {@link org.tquadrat.foundation.svg.type.SVGCalculator}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 */
@DisplayName( "org.tquadrat.foundation.svg.type.calculator.TestSVGCalculator" )
public class TestSVGCalculator extends TestBaseClass
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests for
     *  {@link SVGCalculator#increase(SVGNumber, double)}-
     *
     *  @throws Exception   Something unexpected went wrong.
     */
    @Test
    final void testIncrease() throws Exception
    {
        skipThreadTest();

        assertThrows( NullArgumentException.class, () -> increase( null, 5.0 ) );

        SVGNumber candidate, actual;
        String expected;
        Class<?> candidateClass;

        candidate = new SVGDegree( 5.0 );
        assertInstanceOf( SVGDegree.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGMillimeter( 5.0 );
        assertInstanceOf( SVGMillimeter.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000mm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGPercent( 5.0 );
        assertInstanceOf( SVGPercent.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000%";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGPixel( 5.0 );
        assertInstanceOf( SVGPixel.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000px";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGUserUnitValue( 5.0 );
        assertInstanceOf( SVGUserUnitValue.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, CENTIMETER );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000cm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, EM );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000em";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, EX );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000ex";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, INCH );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000in";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, MILLIMETER );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000mm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, PERCENT );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000%";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, PICA );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000pc";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, PIXEL );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000px";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, POINT );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = increase( candidate, 5.0 );
        expected = "10.000pt";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );
    }   //  testIncrease()

    /**
     *  Tests for
     *  {@link SVGCalculator#multiply(SVGNumber, double)}-
     *
     *  @throws Exception   Something unexpected went wrong.
     */
    @Test
    final void testMultiply() throws Exception
    {
        skipThreadTest();

        assertThrows( NullArgumentException.class, () -> multiply( null, 5.0 ) );

        SVGNumber candidate, actual;
        String expected;
        Class<?> candidateClass;

        candidate = new SVGDegree( 5.0 );
        assertInstanceOf( SVGDegree.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGMillimeter( 5.0 );
        assertInstanceOf( SVGMillimeter.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000mm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGPercent( 5.0 );
        assertInstanceOf( SVGPercent.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000%";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGPixel( 5.0 );
        assertInstanceOf( SVGPixel.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000px";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGUserUnitValue( 5.0 );
        assertInstanceOf( SVGUserUnitValue.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, CENTIMETER );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000cm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, EM );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000em";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, EX );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000ex";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, INCH );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000in";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, MILLIMETER );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000mm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, PERCENT );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000%";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, PICA );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000pc";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, PIXEL );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000px";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 5.0, POINT );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = multiply( candidate, 5.0 );
        expected = "25.000pt";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );
    }   //  testMultiply()

    /**
     *  Tests for
     *  {@link SVGCalculator#reduce(SVGNumber, double)}-
     *
     *  @throws Exception   Something unexpected went wrong.
     */
    @Test
    final void testReduce() throws Exception
    {
        skipThreadTest();

        assertThrows( NullArgumentException.class, () -> reduce( null, 5.0 ) );

        SVGNumber candidate, actual;
        String expected;
        Class<?> candidateClass;

        candidate = new SVGDegree( 30.0 );
        assertInstanceOf( SVGDegree.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGMillimeter( 30.0 );
        assertInstanceOf( SVGMillimeter.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000mm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGPercent( 30.0 );
        assertInstanceOf( SVGPercent.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000%";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGPixel( 30.0 );
        assertInstanceOf( SVGPixel.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000px";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGUserUnitValue( 30.0 );
        assertInstanceOf( SVGUserUnitValue.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, CENTIMETER );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000cm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, EM );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000em";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, EX );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000ex";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, INCH );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000in";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, MILLIMETER );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000mm";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, PERCENT );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000%";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, PICA );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000pc";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, PIXEL );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000px";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );

        candidate = new SVGNumber( 30.0, POINT );
        assertInstanceOf( SVGNumber.class, candidate );
        candidateClass = candidate.getClass();
        actual = reduce( candidate, 5.0 );
        expected = "25.000pt";
        assertEquals( candidateClass, actual.getClass() );
        assertEquals( expected, actual.value() );
    }   //  testReduce()

    /**
     *  Validates whether the class is static.
     */
    @Test
    final void validateClass()
    {
        assertTrue( validateAsStaticClass( SVGCalculator.class ) );
    }   //  validateClass()
}
//  class TestSVGCalculator

/*
 *  End of File
 */