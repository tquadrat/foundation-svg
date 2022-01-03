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
import static org.tquadrat.foundation.svg.SVGUtils.closePath;
import static org.tquadrat.foundation.svg.SVGUtils.createPath;
import static org.tquadrat.foundation.svg.SVGUtils.lineTo;
import static org.tquadrat.foundation.svg.SVGUtils.moveToAbs;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGPathElement;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGPath}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGPath.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestAutoSVGPath.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGPath" )
public class TestAutoSVGPath extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGPath createCandidate()
    {
        skipThreadTest();

        final var retValue = createPath();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGPath#setPathDefinition(org.tquadrat.foundation.svg.type.SVGPathElement...)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetPathDefinition() throws Exception
    {
        skipThreadTest();

        String actual, expected;

        final var candidate = createCandidate();
        expected = "\n<path/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathDefinition();
        expected = "\n<path d=''/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathDefinition( moveToAbs( 10, 10 ) );
        expected = "\n<path d='M10,10'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathDefinition( lineTo( 20, 20 ), closePath() );
        expected = "\n<path d='M10,10 l20,20 Z'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        //noinspection CastToConcreteClass
        candidate.setPathDefinition( (SVGPathElement[]) null );
        expected = "\n<path/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPathDefinition()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGPath#setPathLength(double)}.
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
        expected = "\n<path pathLength='1000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 1000L );
        expected = "\n<path pathLength='1000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 1000.0 );
        expected = "\n<path pathLength='1000.000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( number( 0 ) );
        expected = "\n<path pathLength='0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 0 );
        expected = "\n<path pathLength='0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( 0.0 );
        expected = "\n<path pathLength='0.000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPathLength( null );
        expected = "\n<path/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPathLength()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGPath#setPathLength(double)}.
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
}
//  class TestAutoSVGPath

/*
 *  End of File
 */