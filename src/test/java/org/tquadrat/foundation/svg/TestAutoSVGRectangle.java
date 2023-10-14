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

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVGUtils.createRectangle;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.svg.SVGUtils.pixel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGRectangle}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGRectangle.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGRectangle.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGRectangle" )
public class TestAutoSVGRectangle extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGRectangle createCandidate()
    {
        skipThreadTest();

        final var retValue = createRectangle();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#defineRectangle(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testDefineRectangle() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        candidate.defineRectangle( pixel( 10 ), pixel( 10 ), pixel( 100 ), pixel( 30 ) );
        final var expected =
            """

            <rect x='10px'
                  y='10px'
                  width='100px'
                  height='30px'/>""";
        final var actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testDefineRectangle()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#defineRectangle(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testDefineRectangleWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            candidate.defineRectangle( pixel( 10 ), pixel( 10 ), pixel( -100 ), pixel( 30 ) );
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
            candidate.defineRectangle( pixel( 10 ), pixel( 10 ), pixel( 100 ), pixel( -30 ) );
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
    }   //  testDefineRectangleWithInvalidArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#defineRectangle(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testDefineRectangleWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.defineRectangle( null, pixel( 10 ), pixel( 100 ), pixel( 30 ) );
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
            candidate.defineRectangle( pixel( 10 ), null, pixel( 100 ), pixel( 30 ) );
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
            candidate.defineRectangle( pixel( 10 ), pixel( 10 ), null, pixel( 30 ) );
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
            candidate.defineRectangle( pixel( 10 ), pixel( 10 ), pixel( 100 ), null );
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
    }   //  testDefineRectangleWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setHeight(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetHeight() throws Exception
    {
        skipThreadTest();

        String actual, expected;

        final var candidate = createCandidate();

        candidate.setHeight( pixel( 30 ) );
        expected = "\n<rect height='30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setHeight( null );
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetHeight()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setHeight(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetHeightWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            candidate.setHeight( pixel( -30 ) );
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
    }   //  testSetHeightWithInvalidArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setPathLength(org.tquadrat.foundation.svg.type.SVGNumber.SVGUserUnitValue)}.
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
        expected = "\n<rect pathLength='1000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 1000L );
        expected = "\n<rect pathLength='1000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 1000.0 );
        expected = "\n<rect pathLength='1000.000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( number( 0 ) );
        expected = "\n<rect pathLength='0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 0 );
        expected = "\n<rect pathLength='0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 0.0 );
        expected = "\n<rect pathLength='0.000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( null );
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPathLength()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setPathLength(org.tquadrat.foundation.svg.type.SVGNumber.SVGUserUnitValue)}.
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
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setRx(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetRx() throws Exception
    {
        String actual, expected;

        final var candidate = createCandidate();

        candidate.setRx( pixel( 30 ) );
        expected = "\n<rect rx='30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setRx( null );
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetRx()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setRx(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetRxWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            candidate.setRx( pixel( -30 ) );
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
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setRy(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetRy() throws Exception
    {
        String actual, expected;

        final var candidate = createCandidate();

        candidate.setRy( pixel( 30 ) );
        expected = "\n<rect ry='30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setRy( null );
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetRy()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setRy(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetRyWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            candidate.setRy( pixel( -30 ) );
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
    }   //  testSetRyWithInvalidArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setWidth(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetWidth() throws Exception
    {
        skipThreadTest();

        String actual, expected;

        final var candidate = createCandidate();

        candidate.setWidth( pixel( 100 ) );
        expected = "\n<rect width='100px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setWidth( null );
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetWidth()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setWidth(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetWidthWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            candidate.setWidth( pixel( -100 ) );
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
    }   //  testSetWidthWithInvalidArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setX(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetX() throws Exception
    {
        String actual, expected;

        final var candidate = createCandidate();

        candidate.setX( pixel( 30 ) );
        expected = "\n<rect x='30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX( pixel( -30 ) );
        expected = "\n<rect x='-30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX( null );
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetX()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGRectangle#setY(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetY() throws Exception
    {
        String actual, expected;

        final var candidate = createCandidate();

        candidate.setY( pixel( 30 ) );
        expected = "\n<rect y='30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY( pixel( -30 ) );
        expected = "\n<rect y='-30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY( null );
        expected = "\n<rect/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetY()
}
//  class TestAutoAVGRectangle

/*
 *  End of File
 */