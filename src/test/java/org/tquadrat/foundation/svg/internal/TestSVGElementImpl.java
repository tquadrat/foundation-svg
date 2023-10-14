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

package org.tquadrat.foundation.svg.internal;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVGUtils.color;
import static org.tquadrat.foundation.svg.SVGUtils.number;

import java.net.URI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.AllowsPresentationAttributes;
import org.tquadrat.foundation.svg.SVGElementAdapter;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGColor;

/**
 *  Manually created tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGElement}
 *  and the implementing class
 *  {@link org.tquadrat.foundation.svg.internal.SVGElementImpl}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVGElementImpl.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestSVGElementImpl.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.internal.TestSVGElementImpl" )
public class TestSVGElementImpl extends SVGTestBase
{
        /*---------------*\
    ====** Inner Classes **====================================================
        \*---------------*/
    /**
     *  A dummy element just for testing.
     *
     *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
     *  @version $Id: TestSVGElementImpl.java 1076 2023-10-03 18:36:07Z tquadrat $
     *  @since 0.0.5
     */
    @ClassVersion( sourceVersion = "$Id: TestSVGElementImpl.java 1076 2023-10-03 18:36:07Z tquadrat $" )
    private static class SVGDummy extends SVGElementAdapter
    {
            /*--------------*\
        ====** Constructors **=================================================
            \*--------------*/
        /**
         *  Creates a new {@code SVGDummy} instance that does not allow
         *  anything.
         */
        public SVGDummy() { super( "SVGDummy" ); }
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
    private static final SVGDummy createCandidate()
    {
        final var retValue = new SVGDummy();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     *  Test for
     *  {@link AllowsPresentationAttributes#setClipPath(java.net.URI)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetClipPath() throws Exception
    {
        skipThreadTest();

        final AllowsPresentationAttributes candidate;
        String actual, expected;

        candidate = createCandidate();

        final var uri = URI.create( "#link" );

        candidate.setClipPath( uri );
        expected = "\n<SVGDummy clip-path='url(#link)'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setClipPath( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetClipPath()

    /**
     *  Test for
     *  {@link AllowsPresentationAttributes#setColor(SVGColor)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetColor() throws Exception
    {
        skipThreadTest();

        final AllowsPresentationAttributes candidate;
        String actual, expected;

        candidate = createCandidate();

        candidate.setColor( color() );
        expected = "\n<SVGDummy color='inherit'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setColor( color( "black" ) );
        expected = "\n<SVGDummy color='black'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setColor( color( 0xFF, 0x30, 0x4E ) );
        expected = "\n<SVGDummy color='#ff304e'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setColor( color( true, 22, 33, 44 ) );
        expected = "\n<SVGDummy color='rgb(22%,33%,44%)'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setColor( color( false, 22, 33, 44 ) );
        expected = "\n<SVGDummy color='rgb(22,33,44)'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setColor( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetColor()

    /**
     *  Test for
     *  {@link AllowsPresentationAttributes#setMarkerEnd(java.net.URI)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetMarkerEnd() throws Exception
    {
        skipThreadTest();

        final AllowsPresentationAttributes candidate;
        String actual, expected;

        candidate = createCandidate();

        final var uri = URI.create( "#link" );

        candidate.setMarkerEnd( uri );
        expected = "\n<SVGDummy marker-end='url(#link)'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setMarkerEnd( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetMarkerEnd()

    /**
     *  Test for
     *  {@link AllowsPresentationAttributes#setMarkerMid(java.net.URI)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetMarkerMid() throws Exception
    {
        skipThreadTest();

        final AllowsPresentationAttributes candidate;
        String actual, expected;

        candidate = createCandidate();

        final var uri = URI.create( "#link" );

        candidate.setMarkerMid( uri );
        expected = "\n<SVGDummy marker-mid='url(#link)'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setMarkerMid( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetMarkerMid()

    /**
     *  Test for
     *  {@link AllowsPresentationAttributes#setMarkerStart(java.net.URI)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetMarkerStart() throws Exception
    {
        skipThreadTest();

        final AllowsPresentationAttributes candidate;
        String actual, expected;

        candidate = createCandidate();

        final var uri = URI.create( "#link" );

        candidate.setMarkerStart( uri );
        expected = "\n<SVGDummy marker-start='url(#link)'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setMarkerStart( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetMarkerStart()

    /**
     *  Test for
     *  {@link AllowsPresentationAttributes#setStrokeOpacity(double)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetStrokeOpacity() throws Exception
    {
        skipThreadTest();

        final AllowsPresentationAttributes candidate;
        String actual, expected;

        candidate = createCandidate();

        candidate.setStrokeOpacity( Double.NEGATIVE_INFINITY );
        expected = "\n<SVGDummy stroke-opacity='0.0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStrokeOpacity( -1.0 );
        expected = "\n<SVGDummy stroke-opacity='0.0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStrokeOpacity( 0.0 );
        expected = "\n<SVGDummy stroke-opacity='0.0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStrokeOpacity( 0.5 );
        expected = "\n<SVGDummy stroke-opacity='0.5'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStrokeOpacity( 1.0 );
        expected = "\n<SVGDummy stroke-opacity='1.0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStrokeOpacity( 2.0 );
        expected = "\n<SVGDummy stroke-opacity='1.0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStrokeOpacity( Double.POSITIVE_INFINITY );
        expected = "\n<SVGDummy stroke-opacity='1.0'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetStrokeOpacity()

    /**
     *  Test for
     *  {@link AllowsPresentationAttributes#setStrokeOpacity(double)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetStrokeOpacityInvalid() throws Exception
    {
        skipThreadTest();

        final AllowsPresentationAttributes candidate;

        candidate = createCandidate();

        final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
        try
        {
            candidate.setStrokeOpacity( Double.NaN );
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
    }   //  testSetStrokeOpacityInvalid()

    /**
     *  Test for
     *  {@link AllowsPresentationAttributes#setStrokeWidth(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetStrokeWidth() throws Exception
    {
        skipThreadTest();

        final AllowsPresentationAttributes candidate;
        String actual, expected;

        candidate = createCandidate();

        candidate.setStrokeWidth( number( 3 ) );
        expected = "\n<SVGDummy stroke-width='3'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStrokeWidth( number( 4.0 ) );
        expected = "\n<SVGDummy stroke-width='4.000'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStrokeWidth( null );
        expected = "\n<SVGDummy/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetStrokeWidth()
}
//  class TestSVGElementImpl
/*
 *  End of File
 */