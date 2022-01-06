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
import static org.tquadrat.foundation.svg.SVGUtils.createSymbol;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.svg.SVGUtils.percent;
import static org.tquadrat.foundation.svg.type.SVGPreserveAspectRatio.XMID_YMID;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGSymbol}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGSymbol.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGSymbol.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGSymbol" )
public class TestAutoSVGSymbol extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGSymbol createCandidate()
    {
        skipThreadTest();

        final var retValue = createSymbol( "id" );

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGSymbol#setExternalResourcesRequired(boolean)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetExternalResourcesRequired() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setExternalResourcesRequired( true );
        expected =
            """

            <symbol id='id'
                    externalResourcesRequired='true'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setExternalResourcesRequired( false );
        expected =
            """

            <symbol id='id'
                    externalResourcesRequired='false'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetExternalResourcesRequired()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGSymbol#setPreserveAspectRatio(org.tquadrat.foundation.svg.type.SVGPreserveAspectRatio)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetPreserveAspectRatio() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setPreserveAspectRatio( XMID_YMID );
        expected =
            """

            <symbol id='id'
                    preserveAspectRatio='xMidYMid'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPreserveAspectRatio( null );
        expected = "\n<symbol id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPreserveAspectRatio()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGSymbol#setViewBox(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetViewBox() throws Exception
    {
        skipThreadTest();

        final String actual;
        final String expected;
        final var candidate = createCandidate();

        final var x = number( 0 );
        final var y = number( 0 );
        final var width = percent( 100 );
        final var height = percent( 100 );

        candidate.setViewBox( x, y, width, height );
        expected =
            """

            <symbol id='id'
                    viewBox='0,0,100%,100%'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetViewBox()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGSymbol#setViewBox(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetViewBoxWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final var x = number( 0 );
        final var y = number( 0 );
        final var width = percent( 100 );
        final var height = percent( 100 );

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.setViewBox( null, y, width, height );
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
            candidate.setViewBox( x, null, width, height );
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
            candidate.setViewBox( x, y, null, height );
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
            candidate.setViewBox( x, y, width, null );
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
    }   //  testSetViewBoxWithNullArgument()
}
//  class TestAutoSVGSymbol

/*
 *  End of File
 */