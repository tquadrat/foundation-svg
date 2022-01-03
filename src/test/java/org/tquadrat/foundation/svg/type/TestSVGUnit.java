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

import static java.util.Locale.ROOT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Test for the enum
 *  {@link SVGUnit}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGUnit.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestSVGUnit.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.type.TestSVGUnit" )
public class TestSVGUnit extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests for
     *  {@link SVGUnit#format(double)}.
     *
     *  @param  unit    The unit to be tested.
     */
    @ParameterizedTest
    @EnumSource( SVGUnit.class )
    final void testFormat( final SVGUnit unit )
    {
        skipThreadTest();

        final String floatFormatString;
        final String intFormatString;
        if( unit == SVGUnit.PERCENT )
        {
            floatFormatString = "%1.3f%%";
            intFormatString = "%d%%";
        }
        else
        {
            floatFormatString = "%1.3f" + unit.toString();
            intFormatString = "%d" + unit.toString();
        }

        final var intArgs = new int [] { -2, 0, 1, 100, 900 };
        for( final var intArg : intArgs )
        {
            assertEquals( format( ROOT, intFormatString, intArg ), unit.format( intArg ) );
        }

        final var doubleArgs = new double [] { -2.2, 0.0, 1.34, 100.0, 900.0, 1.2345678 };
        for( final var doubleArg : doubleArgs )
        {
            assertEquals( format( ROOT, floatFormatString, doubleArg ), unit.format( doubleArg ) );
        }
    }   //  testFormat()

    /**
     *  Tests for
     *  {@link SVGUnit#valueForUnit(String)}.
     *
     *  @param  unit    The unit to be tested.
     */
    @ParameterizedTest
    @EnumSource( SVGUnit.class )
    final void testValueForUnit( final SVGUnit unit )
    {
        skipThreadTest();

        assertEquals( unit, SVGUnit.valueForUnit( unit.toString() ) );
    }   //  testValueForUnit()

    /**
     *  Tests for
     *  {@link SVGUnit#valueForUnit(String)}.
     */
    @Test
    final void testValueForUnitWithInvalidArgument()
    {
        skipThreadTest();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            SVGUnit.valueForUnit( "km" );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testValueForUnitWithInvalidArgument()

    /**
     *  Tests for
     *  {@link SVGUnit#valueForUnit(String)}.
     */
    @Test
    final void testValueForUnitWithNullArgument()
    {
        skipThreadTest();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            SVGUnit.valueForUnit( null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testValueForUnitWithNullArgument()
}
//  class TestSVGUnit

/*
 *  End of File
 */