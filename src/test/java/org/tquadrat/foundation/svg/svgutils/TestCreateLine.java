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
import static org.tquadrat.foundation.svg.SVGUtils.createLine;
import static org.tquadrat.foundation.svg.SVGUtils.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVGElementWithChildren;
import org.tquadrat.foundation.svg.SVGLine;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the methods
 *  {@link SVGUtils#createLine()},
 *  {@link SVGUtils#createLine(SVGElementWithChildren)}
 *  {@link SVGUtils#createLine(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)},
 *  and
 *  {@link SVGUtils#createLine(SVGElementWithChildren,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreateLine.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( {"MisorderedAssertEqualsArguments", "CommentedOutCode"} )
@ClassVersion( sourceVersion = "$Id: TestCreateLine.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreateLine" )
public class TestCreateLine extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Test the methods
     *  {@link SVGUtils#createLine()},
     *  {@link SVGUtils#createLine(SVGElementWithChildren)}
     *  {@link SVGUtils#createLine(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)},
     *  and
     *  {@link SVGUtils#createLine(SVGElementWithChildren,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     */
    @Test
    final void testCreateLine()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVGLine.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        String actual, expected;
        SVGLine candidate;

        candidate = createLine();
        expected = "\n<line/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createLine( parent );
        expected = "\n<line/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createLine( number( 10 ), number( 10 ), number( -10 ), number( -10 ) );
        expected =
            """

            <line x1='10'
                  y1='10'
                  x2='-10'
                  y2='-10'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createLine( parent, number( 10 ), number( 10 ), number( -10 ), number( -10 ) );
        expected =
            """

            <line x1='10'
                  y1='10'
                  x2='-10'
                  y2='-10'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testCreateLine()

    /**
     *  Test the methods
     *  {@link SVGUtils#createLine(SVGElementWithChildren)}
     *  {@link SVGUtils#createLine(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)},
     *  and
     *  {@link SVGUtils#createLine(SVGElementWithChildren,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     */
    @Test
    final void testCreateLineWithNullArgument()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVGLine.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            createLine( null, number( 10 ), number( -10 ), number( -10 ) );
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
            createLine( number( 10 ), null, number( -10 ), number( -10 ) );
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
            createLine( number( 10 ), number( 10 ), null, number( -10 ) );
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
            createLine( number( 10 ), number( 10 ), number( -10 ), null );
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
            createLine( null, number( 10 ), number( 10 ), number( -10 ), number( -10 ) );
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
            createLine( parent, null, number( 10 ), number( -10 ), number( -10 ) );
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
            createLine( parent, number( 10 ), null, number( -10 ), number( -10 ) );
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
            createLine( parent, number( 10 ), number( 10 ), null, number( -10 ) );
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
            createLine( parent, number( 10 ), number( 10 ), number( -10 ), null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateLineWithNullArgument()
}
//  class TestCreateLine

/*
 *  End of File
 */