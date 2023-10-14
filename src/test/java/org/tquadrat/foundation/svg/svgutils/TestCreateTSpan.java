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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVGUtils.createTSpan;
import static org.tquadrat.foundation.svg.SVGUtils.createText;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVGTSpan;
import org.tquadrat.foundation.svg.SVGText;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the method
 *  {@link SVGUtils#createTSpan()},
 *  {@link SVGUtils#createTSpan(SVGText)},
 *  {@link SVGUtils#createTSpan(SVGTSpan)},
 *  {@link SVGUtils#createTSpan(CharSequence)},
 *  {@link SVGUtils#createTSpan(SVGText, CharSequence)},
 *  and
 *  {@link SVGUtils#createTSpan(SVGTSpan, CharSequence)}
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreateTSpan.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestCreateTSpan.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreateTSpan" )
public class TestCreateTSpan extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests the method
     *  {@link SVGUtils#createTSpan()}.
     */
    @Test
    final void testCreateTSpan()
    {
        skipThreadTest();

        String expected, actual;

        final var candidate = createTSpan();
        assertNotNull( candidate );

        candidate.addText( "tspan" );
        expected = "\n<tspan>tspan</tspan>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        final var tspan = createTSpan( candidate );
        tspan.addText( "tspan" );
        expected =
            """

            <tspan>tspan
                <tspan>tspan</tspan>
            </tspan>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testCreateTSpan()

    /**
     *  Tests the method
     *  {@link SVGUtils#createTSpan()}.
     */
    @Test
    final void testCreateTSpanWithNullArgument()
    {
        skipThreadTest();

        final var textParent = createText();
        final var tspanParent = createTSpan();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            createTSpan( (SVGText) null );
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
            createTSpan( (SVGTSpan) null );
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
            createTSpan( (CharSequence) null );
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
            createTSpan( (SVGText) null, "text" );
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
            createTSpan( (SVGTSpan) null, "text" );
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
            createTSpan( textParent, null );
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
            createTSpan( tspanParent, null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateTSpanWithNullArgument()
}
//  class TestCreateTSpan

/*
 *  End of File
 */