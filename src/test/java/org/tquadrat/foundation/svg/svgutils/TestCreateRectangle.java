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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVGUtils.createRectangle;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVGElementWithChildren;
import org.tquadrat.foundation.svg.SVGRectangle;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the methods
 *  {@link SVGUtils#createRectangle()},
 *  {@link SVGUtils#createRectangle(SVGElementWithChildren)}
 *  {@link SVGUtils#createRectangle(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)},
 *  and
 *  {@link SVGUtils#createRectangle(SVGElementWithChildren,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreateRectangle.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( {"MisorderedAssertEqualsArguments", "CommentedOutCode"} )
@ClassVersion( sourceVersion = "$Id: TestCreateRectangle.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreateRectangle" )
public class TestCreateRectangle extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Test the methods
     *  {@link SVGUtils#createRectangle()},
     *  {@link SVGUtils#createRectangle(SVGElementWithChildren)}
     *  {@link SVGUtils#createRectangle(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)},
     *  and
     *  {@link SVGUtils#createRectangle(SVGElementWithChildren,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     */
    @Test
    final void testCreateRectangle()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVGRectangle.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        String actual, expected;
        SVGRectangle candidate;

        candidate = createRectangle();
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createRectangle( parent );
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createRectangle( number( 10 ), number( 10 ), number( 10 ), number( 10 ) );
        expected =
            """

            <rect x='10'
                  y='10'
                  width='10'
                  height='10'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createRectangle( parent, number( 10 ), number( 10 ), number( 10 ), number( 10 ) );
        expected =
            """

            <rect x='10'
                  y='10'
                  width='10'
                  height='10'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testCreateRectangle()

    /**
     *  Test the methods
     *  {@link SVGUtils#createRectangle(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)},
     *  and
     *  {@link SVGUtils#createRectangle(SVGElementWithChildren,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     */
    @Test
    final void testCreateRectangleWithInvalidArgument()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVGRectangle.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            createRectangle( number( 10 ), number( 10 ), number( -10 ), number( 10 ) );
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
            createRectangle( number( 10 ), number( 10 ), number( 10 ), number( -10 ) );
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
            createRectangle( parent, number( 10 ), number( 10 ), number( -10 ), number( 10 ) );
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
            createRectangle( parent, number( 10 ), number( 10 ), number( 10 ), number( -10 ) );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateRectangleWithInvalidArgument()

    /**
     *  Test the methods
     *  {@link SVGUtils#createRectangle(SVGElementWithChildren)}
     *  {@link SVGUtils#createRectangle(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)},
     *  and
     *  {@link SVGUtils#createRectangle(SVGElementWithChildren,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     */
    @Test
    final void testCreateRectangleWithNullArgument()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVGRectangle.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            createRectangle( null, number( 10 ), number( -10 ), number( -10 ) );
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
            createRectangle( number( 10 ), null, number( -10 ), number( -10 ) );
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
            createRectangle( number( 10 ), number( 10 ), null, number( 10 ) );
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
            createRectangle( number( 10 ), number( 10 ), number( 10 ), null );
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
            createRectangle( null, number( 10 ), number( 10 ), number( 10 ), number( 10 ) );
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
            createRectangle( parent, null, number( 10 ), number( 10 ), number( 10 ) );
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
            createRectangle( parent, number( 10 ), null, number( 10 ), number( 10 ) );
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
            createRectangle( parent, number( 10 ), number( 10 ), null, number( 10 ) );
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
            createRectangle( parent, number( 10 ), number( 10 ), number( 10 ), null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateRectangleWithNullArgument()
}
//  class TestCreateRectangle

/*
 *  End of File
 */