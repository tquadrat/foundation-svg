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
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_HTML;
import static org.tquadrat.foundation.svg.SVGUtils.createMarker;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.EmptyArgumentException;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVG;
import org.tquadrat.foundation.svg.SVGMarker;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the method
 *  {@link SVGUtils#createMarker(String, SVG)}
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreateMarker.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestCreateMarker.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreateMarker" )
public class TestCreateMarker extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests the method
     *  {@link SVGUtils#createMarker(String, SVG)}.
     */
    @Test
    final void testCreateMarker()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        final SVGMarker candidate;

        final String actual;
        final String expected;

        candidate = createMarker( "id", parent );
        assertNotNull( candidate );
        expected =
            """

            <svg xmlns:svg="http://www.w3.org/2000/svg"
                 xmlns:xlink="http://www.w3.org/1999/xlink"
                 version='1.1'
                 baseProfile='full'>
                <defs>
                    <marker id='id'/>
                </defs>
            </svg>""";
        actual = parent.toString();
        assertEquals( expected, actual );
    }   //  testCreateMarker()

    /**
     *  Tests the method
     *  {@link SVGUtils#createMarker(String, SVG)}.
     */
    @Test
    final void testCreateMarkerWithEmptyArgument()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        final Class<? extends Throwable> expectedException = EmptyArgumentException.class;
        try
        {
            createMarker( EMPTY_STRING, parent );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateMarkerWithEmptyArgument()

    /**
     *  Tests the method
     *  {@link SVGUtils#createMarker(String, SVG)}.
     */
    @Test
    final void testCreateMarkerWithInvalidArgument()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            createMarker( "1234", parent );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateMarkerWithInvalidArgument()

    /**
     *  Tests the method
     *  {@link SVGUtils#createMarker(String, SVG)}.
     */
    @Test
    final void testCreateMarkerWithNullArgument()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            createMarker( null, parent );
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
            createMarker( "id", null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateMarkerWithNullArgument()
}
//  class TestCreateMarker

/*
 *  End of File
 */