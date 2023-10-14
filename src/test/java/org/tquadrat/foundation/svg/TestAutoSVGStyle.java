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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.svg.SVGUtils.createStyle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 * Generated tests for the interface
 * {@link org.tquadrat.foundation.svg.SVGStyle}.
 *
 * @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 * @version $Id: TestAutoSVGStyle.java 1076 2023-10-03 18:36:07Z tquadrat $
 * @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGStyle.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGStyle" )
public class TestAutoSVGStyle extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGStyle createCandidate()
    {
        skipThreadTest();

        final var retValue = createStyle();

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGStyle#addStyle(java.lang.CharSequence...)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddStyle() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.addStyle();
        expected = "\n<style/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
        assertFalse( candidate.hasChildren() );

        candidate.addStyle( "circle { fill: black; }" );
        expected =
            """

            <style><![CDATA[
                circle { fill: black; }
                ]]></style>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
        assertTrue( candidate.hasChildren() );

        candidate.addStyle();
        expected =
            """

            <style><![CDATA[
                circle { fill: black; }
                ]]></style>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
        assertTrue( candidate.hasChildren() );

        candidate.addStyle( "rect { fill: yellow; }" );
        expected =
            """

            <style><![CDATA[
                circle { fill: black; }
                rect { fill: yellow; }
                ]]></style>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
        assertTrue( candidate.hasChildren() );

        candidate.addStyle();
        expected =
            """

            <style><![CDATA[
                circle { fill: black; }
                rect { fill: yellow; }
                ]]></style>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
        assertTrue( candidate.hasChildren() );
    }   //  testAddStyle()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGStyle#addStyle(java.lang.CharSequence...)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddStyleWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.addStyle( (CharSequence []) null );
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
    }   //  testAddStyleWithNullArgument

    /**
     * Test for
     * {@link SVGStyle#getChildren()}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testGetChildren() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        assertTrue( candidate.getChildren().isEmpty() );

        candidate.addStyle( "circle { fill: black; }" );
        assertFalse( candidate.getChildren().isEmpty() );
    }   //  testGetChildren()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGStyle#getStyleSheet()}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testGetStyleSheet() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        String actual, expected;

        expected = EMPTY_STRING;
        actual = candidate.getStyleSheet();
        assertEquals( expected, actual );

        candidate.addStyle( "circle { fill: black; }" );
        expected = "circle { fill: black; }";
        actual = candidate.getStyleSheet();
        assertEquals( expected, actual );
    }   //  testGetStyleSheet()

    /**
     * Test for
     * {@link SVGStyle#hasChildren()}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testHasChildren() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        assertFalse( candidate.hasChildren() );

        candidate.addStyle( "circle { fill: black; }" );
        assertTrue( candidate.hasChildren() );
    }   //  testHasChildren()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGStyle#merge(org.tquadrat.foundation.svg.SVGStyle)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testMerge() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final String actual;
        final String expected;

        candidate.addStyle( "circle { fill: black; }" );
        candidate.merge( createStyle( "rect { fill: yellow; }" ) );
        expected =
            """

            <style><![CDATA[
                circle { fill: black; }
                rect { fill: yellow; }
                ]]></style>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testMerge()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGStyle#merge(org.tquadrat.foundation.svg.SVGStyle)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testMergeWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.merge( null );
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
    }   //  testMergeWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGStyle#toString(int,boolean)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testToString() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final String actual;
        final String expected;

        candidate.addStyle( "circle { fill: black; }" );
        expected =
            """

            <style><![CDATA[
                circle { fill: black; }
                ]]></style>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testToString()
}
//  class TestAutoSVGStyle

/*
 *  End of File
 */