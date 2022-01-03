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
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_HTML;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.svg.SVGUtils.createStyle;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVG;
import org.tquadrat.foundation.svg.SVGStyle;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the methods
 *  {@link SVGUtils#createStyle()},
 *  {@link SVGUtils#createStyle(CharSequence...)},
 *  {@link SVGUtils#createStyle(SVG)}
 *  and
 *  {@link SVGUtils#createStyle(SVG, CharSequence...)}.
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreateStyle.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestCreateStyle.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreateStyle" )
public class TestCreateStyle extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests the methods
     *  {@link SVGUtils#createStyle()},
     *  {@link SVGUtils#createStyle(CharSequence...)},
     *  {@link SVGUtils#createStyle(SVG)}
     *  and
     *  {@link SVGUtils#createStyle(SVG, CharSequence...)}.
     */
    @Test
    final void testCreateStyle()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        SVGStyle candidate;

        String actual, expected;

        candidate = createStyle();
        assertNotNull( candidate );
        expected = "\n<style/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createStyle( "circle {", "  fill: orange;", "  stroke: black;", "}" );
        assertNotNull( candidate );
        expected =
            """

            <style><![CDATA[
                circle {
                  fill: orange;
                  stroke: black;
                }
                ]]></style>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createStyle( parent );
        assertNotNull( candidate );
        expected =
            """

            <svg xmlns:svg="http://www.w3.org/2000/svg"
                 xmlns:xlink="http://www.w3.org/1999/xlink"
                 version='1.1'
                 baseProfile='full'>
                <defs>
                    <style/>
                </defs>
            </svg>""";
        actual = parent.toString();
        assertEquals( expected, actual );

        candidate = createStyle( parent,  "circle {\n  fill: orange;\n  stroke: black;\n}");
        assertNotNull( candidate );
        expected =
            """

            <svg xmlns:svg="http://www.w3.org/2000/svg"
                 xmlns:xlink="http://www.w3.org/1999/xlink"
                 version='1.1'
                 baseProfile='full'>
                <defs>
                    <style><![CDATA[
                        circle {
                          fill: orange;
                          stroke: black;
                        }
                        ]]></style>
                </defs>
            </svg>""";
        actual = parent.toString();
        assertEquals( expected, actual );
    }   //  testCreateStyle()

    /**
     *  Tests the methods
     *  {@link SVGUtils#createStyle(CharSequence...)},
     *  {@link SVGUtils#createStyle(SVG)}
     *  and
     *  {@link SVGUtils#createStyle(SVG, CharSequence...)}.
     */
    @Test
    final void testCreateStyleWithNullArgument()
    {
        skipThreadTest();

        final var parent = createSVG( EMBED_HTML );

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            createStyle( (SVG) null );
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
            createStyle( (CharSequence []) null );
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
            createStyle( (SVG) null, "circle { fill: orange; }" );
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
            createStyle( parent, (CharSequence []) null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateStyleWithNullArgument()
}
//  class TestCreateStyle

/*
 *  End of File
 */