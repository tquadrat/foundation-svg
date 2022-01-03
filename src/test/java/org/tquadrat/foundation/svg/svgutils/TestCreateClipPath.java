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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_HTML;
import static org.tquadrat.foundation.svg.SVGUtils.createClipPath;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.EmptyArgumentException;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVG;
import org.tquadrat.foundation.svg.SVGClipPath;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the methods
 *  {@link SVGUtils#createClipPath(String)}
 *  and
 *  {@link SVGUtils#createClipPath(String, SVG)}.
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreateClipPath.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestCreateClipPath.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreateClipPath" )
public class TestCreateClipPath extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests the methods
     *  {@link SVGUtils#createClipPath(String)}
     *  and
     *  {@link SVGUtils#createClipPath(String, SVG)}.
     */
    @Test
    final void testCreateClipPath()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        SVGClipPath candidate;

        String actual, expected;

        candidate = createClipPath( "id" );
        assertNotNull( candidate );
        expected = "\n<clipPath id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createClipPath( "id", parent );
        assertNotNull( candidate );
        expected =
            """

            <svg xmlns:svg="http://www.w3.org/2000/svg"
                 xmlns:xlink="http://www.w3.org/1999/xlink"
                 version='1.1'
                 baseProfile='full'>
                <defs>
                    <clipPath id='id'/>
                </defs>
            </svg>""";
        actual = parent.toString();
        assertEquals( expected, actual );
    }   //  testCreateClipPath()

    /**
     *  Tests the methods
     *  {@link SVGUtils#createClipPath(String)}
     *  and
     *  {@link SVGUtils#createClipPath(String,SVG)}.
     */
    @Test
    final void testCreateClipPathWithEmptyArgument()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        final Class<? extends Throwable> expectedException = EmptyArgumentException.class;
        try
        {
            createClipPath( EMPTY_STRING );
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
            createClipPath( EMPTY_STRING, parent );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateClipPathWithEmptyArgument()

    /**
     *  Tests the methods
     *  {@link SVGUtils#createClipPath(String)}
     *  and
     *  {@link SVGUtils#createClipPath(String,SVG)}.
     */
    @Test
    final void testCreateClipPathWithInvalidArgument()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            createClipPath( "1234" );
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
            createClipPath( "1234", parent );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateClipPathWithInvalidArgument()

    /**
     *  Tests the methods
     *  {@link SVGUtils#createClipPath(String)}
     *  and
     *  {@link SVGUtils#createClipPath(String,SVG)}.
     */
    @Test
    final void testCreateClipPathWithNullArgument()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            createClipPath( null );
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
            createClipPath( null, parent );
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
            createClipPath( "id", null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateClipPathWithNullArgument()
}
//  class TestCreateClipPath

/*
 *  End of File
 */