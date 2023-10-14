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
import static java.util.Locale.GERMAN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.xml.builder.XMLElement.Flags.ALLOWS_CHILDREN;

import java.net.URI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.EmptyArgumentException;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGElement}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGElement.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGElement.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGElement" )
public class TestAutoSVGElement extends SVGTestBase
{
        /*---------------*\
    ====** Inner Classes **====================================================
        \*---------------*/
    /**
     *  A dummy element just for testing.
     */
    private static class SVGDummy extends SVGElementAdapter
    {
            /*--------------*\
        ====** Constructors **=================================================
            \*--------------*/
        /**
         *  Creates a new {@code SVGDummy} instance.
         */
        public SVGDummy()
        {
            super( "SVGDummy", ALLOWS_CHILDREN );
        }   //  SVGDummy()
    }
    //  class SVGDummy

        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Create the candidate object.
     *
     *  @return The candidate object.
     */
    private static final SVGElement createCandidate()
    {
        final var retValue = new SVGDummy();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link SVGElement#getSVGElementCategory()}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testGetSVGElementCategory() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final var categories = candidate.getSVGElementCategory();
        assertNotNull( categories );
        /*
         * As <SVGDummy> is not a valid SVG element, it does not have a
         * category ...
         */
        assertTrue( categories.isEmpty() );
    }   //  testGetSVGElementCategory()

    /**
     * Test for
     * {@link SVGElement#addComment(java.lang.CharSequence)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddComment() throws Exception
    {
        skipThreadTest();

        SVGElement candidate;
        String actual, expected;

        candidate = createCandidate();
        candidate.addComment( "comment" );
        expected =
            """

            <SVGDummy>
                <!--
                comment
                -->
            </SVGDummy>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createCandidate();
        candidate.addComment( EMPTY_STRING );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createCandidate();
        candidate.addComment( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testAddComment()

    /**
     * Test for
     * {@link SVGElement#setId(java.lang.String)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetId() throws Exception
    {
        skipThreadTest();

        final SVGElement candidate;
        final String actual;
        final String expected;

        candidate = createCandidate();
        candidate.setId( "id" );
        expected = "\n<SVGDummy id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetId()

    /**
     * Test for
     * {@link SVGElement#setId(java.lang.String)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetIdWithEmptyArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = EmptyArgumentException.class;
        try
        {
            candidate.setId( EMPTY_STRING );
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
    }   //  testSetIdWithEmptyArgument()

    /**
     * Test for
     * {@link SVGElement#setId(java.lang.String)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetIdWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            /*
             * An id that starts with a numerical character is invalid.
             */
            candidate.setId( "123" );
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
    }   //  testSetIdWithInvalidArgument()

    /**
     * Test for
     * {@link SVGElement#setId(java.lang.String)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetIdWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.setId( null );
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
    }   //  testSetIdWithNullArgument()

    /**
     * Test for
     * {@link SVGElement#setLang(java.util.Locale)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetLang() throws Exception
    {
        skipThreadTest();

        final SVGElement candidate;
        String actual, expected;

        candidate = createCandidate();
        candidate.setLang( GERMAN );
        expected = "\n<SVGDummy lang='de'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setLang( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetLang()

    /**
     * Test for
     * {@link SVGElement#setPreserveSpace(boolean)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetPreserveSpace() throws Exception
    {
        skipThreadTest();

        final SVGElement candidate;
        String actual, expected;

        candidate = createCandidate();
        candidate.setPreserveSpace( true );
        expected = "\n<SVGDummy xml:space='preserve'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPreserveSpace( false );
        expected = "\n<SVGDummy xml:space='default'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPreserveSpace()

    /**
     * Test for
     * {@link SVGElement#setTabIndex(int)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetTabIndex() throws Exception
    {
        skipThreadTest();

        final SVGElement candidate;
        final String actual;
        final String expected;

        candidate = createCandidate();
        candidate.setTabIndex( 22 );
        expected = "\n<SVGDummy tabindex='22'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetTabIndex()

    /**
     * Test for
     * {@link SVGElement#setTitle(java.lang.CharSequence)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetTitle() throws Exception
    {
        skipThreadTest();

        SVGElement candidate;
        String actual, expected;

        candidate = createCandidate();
        candidate.setTitle( "title" );
        expected =
            """

            <SVGDummy>
                <title>title</title>
            </SVGDummy>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createCandidate();
        candidate.setTitle( " " );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createCandidate();
        candidate.setTitle( EMPTY_STRING );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate = createCandidate();
        candidate.setTitle( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetTitle

    /**
     * Test for
     * {@link SVGElement#setTitle(java.lang.CharSequence)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetTitleWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();
        candidate.setTitle( "title" );

        final Class<? extends Throwable> expectedException = IllegalStateException.class;
        try
        {
            /*
             * If a title was already applied, it cannot be changed or
             * overwritten.
             */
            candidate.setTitle( "title again" );
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
    }   //  testSetTitleWithInvalidArgument()

    /**
     * Test for
     * {@link SVGElement#setXMLBase(java.net.URI)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetXMLBase() throws Exception
    {
        skipThreadTest();

        final var value = URI.create( "tquadrat.org/foundation" );
        final SVGElement candidate;
        String actual, expected;

        candidate = createCandidate();
        candidate.setXMLBase( value );
        expected = "\n<SVGDummy xml:base='tquadrat.org/foundation'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setXMLBase( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetXMLBase()

    /**
     * Test for
     * {@link SVGElement#setXMLId(java.lang.String)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetXMLId() throws Exception
    {
        skipThreadTest();

        final SVGElement candidate;
        final String actual;
        final String expected;

        candidate = createCandidate();
        candidate.setXMLId( "id" );
        expected = "\n<SVGDummy xml:id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetXMLId()

    /**
     * Test for
     * {@link SVGElement#setXMLId(java.lang.String)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetXMLIdWithEmptyArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = EmptyArgumentException.class;
        try
        {
            candidate.setXMLId( EMPTY_STRING );
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
    }   //  testSetXMLIdWithEmptyArgument()

    /**
     * Test for
     * {@link SVGElement#setXMLId(java.lang.String)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetXMLIdWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            /*
             * An id that starts with a numerical character is invalid.
             */
            candidate.setXMLId( "123" );
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
    }   //  testSetXMLIdWithInvalidArgument()

    /**
     * Test for
     * {@link SVGElement#setXMLId(java.lang.String)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetXMLIdWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.setXMLId( null );
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
    }   //  testSetXMLIdWithNullArgument()

    /**
     * Test for
     * {@link SVGElement#setXMLLang(java.util.Locale)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetXMLLang() throws Exception
    {
        skipThreadTest();

        final SVGElement candidate;
        String actual, expected;

        candidate = createCandidate();
        candidate.setXMLLang( GERMAN );
        expected = "\n<SVGDummy xml:lang='de'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setXMLLang( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetXMLLang()
}
//  class TestAutoSVGElement
/*
 *  End of File
 */