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
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_HTML;
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_HTML5;
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_SVG;
import static org.tquadrat.foundation.svg.SVG.Usage.STANDALONE_DOCUMENT;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVG;
import org.tquadrat.foundation.svg.SVG.Usage;
import org.tquadrat.foundation.svg.SVGElementWithChildren;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the method
 *  {@link SVGUtils#createSVG(Usage)}
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreateSVG.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( {"MisorderedAssertEqualsArguments", "CommentedOutCode"} )
@ClassVersion( sourceVersion = "$Id: TestCreateSVG.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreateSVG" )
public class TestCreateSVG extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests the method
     *  {@link SVGUtils#createSVG(Usage)}.
     */
    @Test
    final void testCreateSVG()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVG.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        SVG svg;
        String actual, expected;

        svg = createSVG( EMBED_HTML );
        assertNotNull( svg );
        expected =
            """

            <svg xmlns:svg="http://www.w3.org/2000/svg"
                 xmlns:xlink="http://www.w3.org/1999/xlink"
                 version='1.1'
                 baseProfile='full'/>""";
        actual = svg.toString();
        assertEquals( expected, actual );

        svg = createSVG( EMBED_HTML5 );
        assertNotNull( svg );
        expected =
            """

            <svg version='1.1'
                 baseProfile='full'/>""";
        actual = svg.toString();
        assertEquals( expected, actual );

        svg = createSVG( EMBED_SVG );
        assertNotNull( svg );
        expected = "\n<svg/>";
        actual = svg.toString();
        assertEquals( expected, actual );

        svg = createSVG( parent );
        assertNotNull( svg );
        expected = "\n<svg/>";
        actual = svg.toString();
        assertEquals( expected, actual );

        svg = createSVG( STANDALONE_DOCUMENT );
        assertNotNull( svg );
        expected =
            """

            <svg xmlns="http://www.w3.org/2000/svg"
                 xmlns:cc="http://creativecommons.org/ns#"
                 xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                 xmlns:svg="http://www.w3.org/2000/svg"
                 xmlns:xlink="http://www.w3.org/1999/xlink"
                 version='1.1'
                 baseProfile='full'/>""";
        actual = svg.toString();
        assertEquals( expected, actual );
    }   //  testCreateSVG()

    /**
     *  Tests the method
     *  {@link SVGUtils#createSVG(Usage)}.
     */
    @Test
    final void testCreateSVGWithNullArgument()
    {
        skipThreadTest();

        @SuppressWarnings( "unused" )
        SVG svg;

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            svg = createSVG( (Usage) null );
            assertNotNull( svg );
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
            svg = createSVG( (SVGElementWithChildren) null );
            assertNotNull( svg );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateSVGWithNullArgument()
}
//  class TestCreateSVG

/*
 *  End of File
 */