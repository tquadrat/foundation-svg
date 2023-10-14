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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVG.Usage.STANDALONE_DOCUMENT;
import static org.tquadrat.foundation.svg.SVGUtils.createMarker;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.svg.SVGUtils.degree;
import static org.tquadrat.foundation.svg.SVGUtils.em;
import static org.tquadrat.foundation.svg.SVGUtils.ex;
import static org.tquadrat.foundation.svg.SVGUtils.matrix;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.svg.SVGUtils.percent;
import static org.tquadrat.foundation.svg.SVGUtils.rotate;
import static org.tquadrat.foundation.svg.SVGUtils.skewX;
import static org.tquadrat.foundation.svg.SVGUtils.translate;
import static org.tquadrat.foundation.svg.type.SVGMarkerOrientation.AUTO;
import static org.tquadrat.foundation.svg.type.SVGMarkerOrientation.AUTO_START_REVERSE;
import static org.tquadrat.foundation.svg.type.SVGPreserveAspectRatio.XMID_YMID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGMarkerOrientation;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;
import org.tquadrat.foundation.svg.type.SVGTransform;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGMarker}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGMarker.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGMarker.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGMarker" )
public class TestAutoSVGMarker extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private final SVGMarker createCandidate()
    {
        skipThreadTest();

        final var retValue = createMarker( "id", createSVG( STANDALONE_DOCUMENT ) );

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setExternalResourcesRequired(boolean)}.
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

            <marker id='id'
                    externalResourcesRequired='true'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setExternalResourcesRequired( false );
        expected =
            """

            <marker id='id'
                    externalResourcesRequired='false'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetExternalResourcesRequired()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setMarkerHeight(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetMarkerHeight() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setMarkerHeight( ex( 7.5 ) );
        expected =
            """

            <marker id='id'
                    markerHeight='7.500ex'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setMarkerHeight( null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetMarkerHeight()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setMarkerUnits(boolean)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetMarkerUnits() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setMarkerUnits( true );
        expected =
            """

            <marker id='id'
                    markerUnits='userSpaceOnUse'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setMarkerUnits( false );
        expected =
            """

            <marker id='id'
                    markerUnits='strokeWidth'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetMarkerUnits()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setMarkerWidth(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetMarkerWidth() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setMarkerWidth( em( 7.5 ) );
        expected =
            """

            <marker id='id'
                    markerWidth='7.500em'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setMarkerWidth( null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetMarkerWidth()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setOrientation(org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree)}
     * and
     * {@link org.tquadrat.foundation.svg.SVGMarker#setOrientation(org.tquadrat.foundation.svg.type.SVGMarkerOrientation)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetOrientation() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setOrientation( degree( 90 ) );
        expected =
            """

            <marker id='id'
                    orient='90'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setOrientation( (SVGDegree) null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setOrientation( AUTO );
        expected =
            """

            <marker id='id'
                    orient='auto'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setOrientation( AUTO_START_REVERSE );
        expected =
            """

            <marker id='id'
                    orient='auto-start-reverse'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setOrientation( (SVGMarkerOrientation) null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetOrientation()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setPreserveAspectRatio(org.tquadrat.foundation.svg.type.SVGPreserveAspectRatio)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @DisplayName( "setPreserveAspectRatio(org.tquadrat.foundation.svg.type.SVGPreserveAspectRatio) with valid argument" )
    @Test
    final void testSetPreserveAspectRatio() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setPreserveAspectRatio( XMID_YMID );
        expected =
            """

            <marker id='id'
                    preserveAspectRatio='xMidYMid'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPreserveAspectRatio( null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPreserveAspectRatio()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setReferencePoint(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetReferencePoint() throws Exception
    {
        skipThreadTest();

        final String actual;
        final String expected;
        final var candidate = createCandidate();

        candidate.setReferencePoint( number( 0 ), number( 0 ) );
        expected =
            """

            <marker id='id'
                    refX='0'
                    refY='0'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetReferencePoint()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setReferencePoint(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetReferencePointWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.setReferencePoint( null, number( 0 ) );
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
            candidate.setReferencePoint( number( 0 ), null );
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
    }   //  testSetReferencePointWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setReferenceX(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetReferenceX() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setReferenceX( em( 7.5 ) );
        expected =
            """

            <marker id='id'
                    refX='7.500em'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setReferenceX( null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetReferenceX()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setReferenceY(org.tquadrat.foundation.svg.type.SVGNumber)}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetReferenceY() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setReferenceY( em( 7.5 ) );
        expected =
            """

            <marker id='id'
                    refY='7.500em'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setReferenceY( null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetReferenceY()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setTransform(org.tquadrat.foundation.svg.type.SVGTransform[])}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetTransform() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setTransform( matrix( 1, 1, 2, 2, 3, 3 ) );
        expected =
            """

            <marker id='id'
                    transform='matrix(1 1 2 2 3 3)'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setTransform( rotate( 90.0 ), skewX( -45.0 ) );
        expected =
            """

            <marker id='id'
                    transform='matrix(1 1 2 2 3 3) rotate(90.000) skewX(-45.000)'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setTransform( translate( 100, 100 ) );
        expected =
            """

            <marker id='id'
                    transform='matrix(1 1 2 2 3 3) rotate(90.000) skewX(-45.000) translate(100 100)'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setTransform( (SVGTransform []) null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetTransform

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setViewBox(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
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

            <marker id='id'
                    viewBox='0,0,100%,100%'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetViewBox()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGMarker#setViewBox(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
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
//  class TestAutoSVGMarker

/*
 *  End of File
 */