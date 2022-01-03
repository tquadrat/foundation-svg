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

package org.tquadrat.foundation.svg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVGUtils.createLine;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGLine}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGLine.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestAutoSVGLine.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGLine" )
public class TestAutoSVGLine extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGLine createCandidate()
    {
        skipThreadTest();

        final var retValue = createLine();

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#defineLine(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testDefineLine() throws Exception
    {
        skipThreadTest();

        final String actual;
        final String expected;

        final var candidate = createCandidate();

        candidate.defineLine( number( 10 ), number( 10 ), number( -10 ), number( -10 ) );
        expected =
            """

            <line x1='10'
                  y1='10'
                  x2='-10'
                  y2='-10'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testDefineLine()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#defineLine(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testDefineLineWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.defineLine( null, number( 10 ), number( -10 ), number( -10 ) );
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
        try
        {
            candidate.defineLine( number( 10 ), null, number( -10 ), number( -10 ) );
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
        try
        {
            candidate.defineLine( number( 10 ), number( 10 ), null, number( -10 ) );
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
        try
        {
            candidate.defineLine( number( 10 ), number( 10 ), number( -10 ), null );
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
    }   //  testDefineLineWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setEndPoint(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetEndPoint() throws Exception
    {
        skipThreadTest();

        final String actual;
        final String expected;

        final var candidate = createCandidate();

        candidate.setEndPoint( number( -10 ), number( -10 ) );
        expected =
            """

            <line x2='-10'
                  y2='-10'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetEndPoint()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setEndPoint(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetEndPointWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.setEndPoint( null, number( -10 ) );
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
        try
        {
            candidate.setEndPoint( number( -10 ), null );
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
    }   //  testSetEndPointWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setPathLength(org.tquadrat.foundation.svg.type.SVGNumber.SVGUserUnitValue)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetPathLength() throws Exception
    {
        skipThreadTest();

        String actual, expected;

        final var candidate = createCandidate();

        candidate.setPathLength( number( 1000 ) );
        expected = "\n<line pathLength='1000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 1000L );
        expected = "\n<line pathLength='1000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 1000.0 );
        expected = "\n<line pathLength='1000.000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( number( 0 ) );
        expected = "\n<line pathLength='0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 0 );
        expected = "\n<line pathLength='0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 0.0 );
        expected = "\n<line pathLength='0.000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( null );
        expected = "\n<line/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPathLength()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setPathLength(org.tquadrat.foundation.svg.type.SVGNumber.SVGUserUnitValue)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetPathLengthWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            candidate.setPathLength( number( -1000 ) );
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
        try
        {
            candidate.setPathLength( -1000 );
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
        try
        {
            candidate.setPathLength( -1000.0 );
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
    }   //  testSetPathLengthWithInvalidArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setStartPoint(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetStartPoint() throws Exception
    {
        skipThreadTest();

        final String actual;
        final String expected;

        final var candidate = createCandidate();

        candidate.setStartPoint( number( 10 ), number( 10 ) );
        expected =
            """

            <line x1='10'
                  y1='10'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetStartPoint()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setStartPoint(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetStartPointWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.setStartPoint( null, number( 10 ) );
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
        try
        {
            candidate.setStartPoint( number( 10 ), null );
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
    }   //  testSetStartPointWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setX1(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetX1() throws Exception
    {
        skipThreadTest();

        String actual, expected;

        final var candidate = createCandidate();

        candidate.setX1( number( 10 ) );
        expected = "\n<line x1='10'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX1( null );
        expected = "\n<line/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetX1()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setX2(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetX2() throws Exception
    {
        String actual, expected;

        final var candidate = createCandidate();

        candidate.setX2( number( -10 ) );
        expected = "\n<line x2='-10'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX2( null );
        expected = "\n<line/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetX2()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setY1(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetY1() throws Exception
    {
        String actual, expected;

        final var candidate = createCandidate();

        candidate.setY1( number( 10 ) );
        expected = "\n<line y1='10'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY1( null );
        expected = "\n<line/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetY1()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGLine#setY2(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetY2() throws Exception
    {
        String actual, expected;

        final var candidate = createCandidate();

        candidate.setY2( number( -10 ) );
        expected = "\n<line y2='-10'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY2( null );
        expected = "\n<line/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetY2()
}
//  class TestAutoSVGLine

/*
 *  End of File
 */