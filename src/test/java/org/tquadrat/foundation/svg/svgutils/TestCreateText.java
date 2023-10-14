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
import static org.tquadrat.foundation.svg.SVGUtils.createTSpan;
import static org.tquadrat.foundation.svg.SVGUtils.createText;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVGElementWithChildren;
import org.tquadrat.foundation.svg.SVGTSpan;
import org.tquadrat.foundation.svg.SVGText;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the method
 *  {@link SVGUtils#createText()}
 *  {@link SVGUtils#createText(CharSequence)}
 *  {@link SVGUtils#createText(SVGElementWithChildren)}
 *  and
 *  {@link SVGUtils#createText(SVGElementWithChildren, CharSequence)}
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCreateText.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( {"MisorderedAssertEqualsArguments", "CommentedOutCode"} )
@ClassVersion( sourceVersion = "$Id: TestCreateText.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCreateText" )
public class TestCreateText extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Tests the method
     *  {@link SVGUtils#createText()}.
     */
    @Test
    final void testCreateText()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        parent.addChild( isA( SVGText.class ) );
//        expectLastCall().anyTimes();
//        replayAll();
        final var parent = createParentElement( "parent" );

        String expected, actual;

        SVGText candidate;
        SVGTSpan tspan;

        candidate = createText();
        assertNotNull( candidate );

        candidate.addText( "text" );
        expected = "\n<text>text</text>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        tspan = createTSpan( candidate );
        tspan.addText( "tspan" );
        expected =
            """

            <text>text
                <tspan>tspan</tspan>
            </text>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createText( parent );
        assertNotNull( candidate );

        candidate.addText( "text" );
        expected = "\n<text>text</text>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        tspan = createTSpan( candidate );
        tspan.addText( "tspan" );
        expected =
            """

            <text>text
                <tspan>tspan</tspan>
            </text>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createText( parent, "text" );
        assertNotNull( candidate );
        expected = "\n<text>text</text>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        tspan = createTSpan( candidate );
        tspan.addText( "tspan" );
        expected =
            """

            <text>text
                <tspan>tspan</tspan>
            </text>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testCreateText()

    /**
     *  Tests the method
     *  {@link SVGUtils#createText()}.
     */
    @Test
    final void testCreateTextWithNullArgument()
    {
        skipThreadTest();

//        final var parent = mockSVGElementWithChildren( "parent" );
//        replayAll();
        final var parent = createParentElement( "parent" );

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            createText( (SVGElementWithChildren) null );
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
            createText( (CharSequence) null );
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
            createText( null, "text" );
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
            createText( parent, null );
            fail( () -> format( MSG_ExceptionNotThrown, expectedException.getName() ) );
        }
        catch( final AssertionError e ) { throw e; }
        catch( final Throwable t )
        {
            final var isExpectedException = expectedException.isInstance( t );
            assertTrue( isExpectedException, () -> format( MSG_WrongExceptionThrown, expectedException.getName(), t.getClass().getName() ) );
        }
    }   //  testCreateTextWithNullArgument()
}
//  class TestCreateText

/*
 *  End of File
 */