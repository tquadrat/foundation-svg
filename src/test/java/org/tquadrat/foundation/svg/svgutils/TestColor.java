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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.svg.SVGUtils.color;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.EmptyArgumentException;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGColor;

/**
 *  Tests for the methods
 *  {@link SVGUtils#color()},.
 *  {@link SVGUtils#color(String)},
 *  {@link SVGUtils#color(int, int, int)},
 *  and
 *  {@link SVGUtils#color(boolean, int, int, int)}.
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestColor.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestColor.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestColor" )
public class TestColor extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Test for
     *  {@link SVGUtils#color()},.
     *  {@link SVGUtils#color(String)},
     *  {@link SVGUtils#color(int, int, int)},
     *  and
     *  {@link SVGUtils#color(boolean, int, int, int)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testColor() throws Exception
    {
        skipThreadTest();

        SVGColor candidate;
        String actual, expected;

        candidate = color();
        expected = "inherit";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = color( "black" );
        expected = "black";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = color( 0xFF, 0x30, 0x4E );
        expected = "#ff304e";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = color( true, 22, 33, 44 );
        expected = "rgb(22%,33%,44%)";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = color( false, 22, 33, 44 );
        expected = "rgb(22,33,44)";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testColor()

    /**
     * Test for
     * {@link SVGUtils#color(String)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testColorWithEmptyArgument() throws Exception
    {
        skipThreadTest();

        final Class<? extends Throwable> expectedException = EmptyArgumentException.class;
        try
        {
            color( EMPTY_STRING );
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
    }   //  testColorWithEmptyArgument()

    /**
     * Test for
     * {@link SVGUtils#color(String)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testColorWithNullArgument() throws Exception
    {
        skipThreadTest();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            color( null );
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
    }   //  testColorWithNullArgument()
}
//  class TestColor

/*
 *  End of File
 */