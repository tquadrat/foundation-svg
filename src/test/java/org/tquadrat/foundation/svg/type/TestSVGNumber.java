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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.svg.type.SVGUnit.NONE;
import static org.tquadrat.foundation.svg.type.SVGUnit.PIXEL;
import static org.tquadrat.foundation.util.StringUtils.format;

import java.util.function.DoubleFunction;
import java.util.function.LongFunction;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the class
 *  {@link SVGNumber}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestSVGNumber.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.type.TestSVGNumber" )
public class TestSVGNumber extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Provides the
     *  {@link SVGNumber}
     *  factories that take {@code long} arguments.
     *
     *  @return A stream with the factories.
     */
    static final Stream<LongFunction<? extends SVGNumber>> provideLongFactories()
    {
        final Stream<LongFunction<? extends SVGNumber>> retValue =
            Stream.of( SVGUtils::centimeter, SVGUtils::degree, SVGUtils::em,
                SVGUtils::ex, SVGUtils::millimeter, SVGUtils::number,
                SVGUtils::percent, SVGUtils::pica, SVGUtils::pixel,
                SVGUtils::point );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  provideLongFactories()

    /**
     *  Provides the
     *  {@link SVGNumber}
     *  factories that take {@code double} arguments.
     *
     *  @return A stream with the factories.
     */
    static final Stream<DoubleFunction<? extends SVGNumber>> provideDoubleFactories()
    {
        final Stream<DoubleFunction<? extends SVGNumber>> retValue =
            Stream.of( SVGUtils::centimeter, SVGUtils::degree, SVGUtils::em,
                SVGUtils::ex, SVGUtils::millimeter, SVGUtils::number,
                SVGUtils::percent, SVGUtils::pica, SVGUtils::pixel,
                SVGUtils::point );

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  provideDoubleFactories()

    /**
     *  Tests for the constructors
     *  {@link SVGNumber#SVGNumber(double, SVGUnit)}
     *  and
     *  {@link SVGNumber#SVGNumber(long, SVGUnit)}.
     *
     *  @param  unit    The unit for the new instance.
     */
    @ParameterizedTest
    @EnumSource( SVGUnit.class )
    final void testConstructor( final SVGUnit unit )
    {
        skipThreadTest();

        SVGNumber candidate;

        final String floatFormatString, intFormatString;
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
            candidate = new SVGNumber( intArg, unit );
            assertEquals( format( ROOT, intFormatString, intArg ), candidate.value() );
        }

        final var doubleArgs = new double [] { -2.2, 0.0, 1.34, 100.0, 900.0, 1.2345678 };
        for( final var doubleArg : doubleArgs )
        {
            candidate = new SVGNumber( doubleArg, unit );
            assertEquals( format( ROOT, floatFormatString, doubleArg ), candidate.value() );
        }
    }   //  testConstructor()

    /**
     *  Tests for the constructors
     *  {@link SVGNumber#SVGNumber(double, SVGUnit)}
     *  and
     *  {@link SVGNumber#SVGNumber(long, SVGUnit)}.
     */
    @Test
    final void testConstructorWithNullArgument()
    {
        skipThreadTest();

        @SuppressWarnings( "unused" )
        SVGNumber candidate;

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate = new SVGNumber( 0.0, null );
            assertNotNull( candidate );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
        try
        {
            candidate = new SVGNumber( 0, null );
            assertNotNull( candidate );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testConstructorWithNullArgument()

    /**
     *  Tests for the methods
     *  {@link SVGNumber#equals(Object)}
     *  and
     *  {@link SVGNumber#hashCode()}
     */
    @SuppressWarnings( "unlikely-arg-type" )
    @Test
    final void testEquals()
    {
        skipThreadTest();

        final var candidate1 = new SVGNumber( 0, NONE );

        //noinspection SimplifiableAssertion
        assertFalse( candidate1.equals( null ) );
        //noinspection EqualsBetweenInconvertibleTypes,SimplifiableAssertion
        assertFalse( candidate1.equals( EMPTY_STRING ) );
        //noinspection SimplifiableAssertion
        assertTrue( candidate1.equals( candidate1 ) );

        final var candidate2 = new SVGNumber( 0, NONE );
        assertNotSame( candidate1, candidate2 );
        //noinspection SimplifiableAssertion
        assertTrue( candidate1.equals( candidate2 ) );
        //noinspection SimplifiableAssertion
        assertTrue( candidate2.equals( candidate1 ) );

        assertEquals( candidate1.hashCode(), candidate2.hashCode() );

        final var candidate3 = new SVGNumber( 0, PIXEL );
        //noinspection SimplifiableAssertion
        assertFalse( candidate1.equals( candidate3 ) );
        //noinspection SimplifiableAssertion
        assertFalse( candidate3.equals( candidate1 ) );
    }   //  testEquals()

    /**
     *  Tests for the flags
     *  {@link SVGNumber#isInteger()},
     *  {@link SVGNumber#isNegative()},
     *  and
     *  {@link SVGNumber#isZero()}.
     *
     *  @param  factory The candidate factory.
     */
    @ParameterizedTest
    @MethodSource( "provideLongFactories" )
    final void testFlags( final LongFunction<? extends SVGNumber> factory )
    {
        skipThreadTest();

        SVGNumber candidate;

        candidate = factory.apply( -1 );
        assertTrue( candidate.isInteger() );
        assertTrue( candidate.isNegative() );
        assertFalse( candidate.isZero() );

        candidate = factory.apply( 0 );
        assertTrue( candidate.isInteger() );
        assertFalse( candidate.isNegative() );
        assertTrue( candidate.isZero() );

        candidate = factory.apply( 1 );
        assertTrue( candidate.isInteger() );
        assertFalse( candidate.isNegative() );
        assertFalse( candidate.isZero() );
    }   //  testFlags()

    /**
     *  Tests for the flags
     *  {@link SVGNumber#isInteger()},
     *  {@link SVGNumber#isNegative()},
     *  and
     *  {@link SVGNumber#isZero()}.
     *
     *  @param  factory The candidate factory.
     */
    @ParameterizedTest
    @MethodSource( "provideDoubleFactories" )
    final void testFlags( final DoubleFunction<? extends SVGNumber> factory )
    {
        skipThreadTest();

        SVGNumber candidate;

        candidate = factory.apply( -1.0 );
        assertFalse( candidate.isInteger() );
        assertTrue( candidate.isNegative() );
        assertFalse( candidate.isZero() );

        candidate = factory.apply( 0.0 );
        assertFalse( candidate.isInteger() );
        assertFalse( candidate.isNegative() );
        assertTrue( candidate.isZero() );

        candidate = factory.apply( 1.0 );
        assertFalse( candidate.isInteger() );
        assertFalse( candidate.isNegative() );
        assertFalse( candidate.isZero() );
    }   //  testFlags()
}
//  class TestSVGNumber

/*
 *  End of File
 */