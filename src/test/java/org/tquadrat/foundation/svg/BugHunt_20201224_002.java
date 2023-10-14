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
import static java.lang.System.out;
import static java.util.Collections.unmodifiableMap;
import static java.util.Comparator.naturalOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.lang.CommonConstants.XMLATTRIBUTE_Language;
import static org.tquadrat.foundation.svg.SVG.Usage.STANDALONE_DOCUMENT;
import static org.tquadrat.foundation.svg.SVGElement.CORE_ATTRIBUTES;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Class;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_ExternalResourcesRequired;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Id;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_MarkerHeight;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_MarkerUnits;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_MarkerWidth;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Orientation;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Position;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_PreserveAspectRatio;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_ReferenceX;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_ReferenceY;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Style;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_Transform;
import static org.tquadrat.foundation.svg.SVGUtils.SVGATTRIBUTE_ViewBox;
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
import static org.tquadrat.foundation.util.Comparators.listBasedComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGMarkerOrientation;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;
import org.tquadrat.foundation.svg.type.SVGTransform;
import org.tquadrat.foundation.util.internal.ListBasedComparator;

/**
 *  The expected sequence for the attributes starts with
 *  '{@value SVGUtils#SVGATTRIBUTE_Id}'
 *  but unfortunately did this not work in the beginning.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: BugHunt_20201224_002.java 1076 2023-10-03 18:36:07Z tquadrat $
 */
@ClassVersion( sourceVersion = "$Id: BugHunt_20201224_002.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.BugHunt_20201224_002" )
public class BugHunt_20201224_002 extends SVGTestBase
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
     * {@link SVGMarker#setExternalResourcesRequired(boolean)}.
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
     * {@link SVGMarker#setMarkerHeight(org.tquadrat.foundation.svg.type.SVGNumber)}.
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
     * {@link SVGMarker#setMarkerUnits(boolean)}.
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
     * {@link SVGMarker#setMarkerWidth(org.tquadrat.foundation.svg.type.SVGNumber)}.
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
     * {@link SVGMarker#setOrientation(SVGDegree)}
     * and
     * {@link SVGMarker#setOrientation(SVGMarkerOrientation)}
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

        //noinspection CastToConcreteClass
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
     * {@link SVGMarker#setPreserveAspectRatio(org.tquadrat.foundation.svg.type.SVGPreserveAspectRatio)}.
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
     * {@link SVGMarker#setReferencePoint(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
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
     * {@link SVGMarker#setReferencePoint(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
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
     * {@link SVGMarker#setReferenceX(org.tquadrat.foundation.svg.type.SVGNumber)}.
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
     * {@link SVGMarker#setReferenceY(org.tquadrat.foundation.svg.type.SVGNumber)}.
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
     * {@link SVGMarker#setTransform(SVGTransform[])}.
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

        //noinspection CastToConcreteClass
        candidate.setTransform( (SVGTransform []) null );
        expected = "\n<marker id='id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetTransform

    /**
     * Test for
     * {@link SVGMarker#setViewBox(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
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

        assertTrue( candidate.getAttributes() instanceof SortedMap );
        final var sortedMap = (SortedMap<String,String>) candidate.getAttributes();
        out.println( sortedMap.comparator().getClass() );
        final var attributeNames = candidate.getAttributes().keySet().toArray( String[]::new );
        assertEquals( SVGATTRIBUTE_Id, attributeNames [0] );

        expected =
            """

            <marker id='id'
                    viewBox='0,0,100%,100%'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetViewBox()

    /**
     * Test for
     * {@link SVGMarker#setViewBox(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}.
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

    /**
     *  Validate that the comparator works as expected.
     */
    @Test
    @Order( 2 )
    final void validateComparator()
    {
        skipThreadTest();

        //---* Copied from SVGMarkerImpl (version 807) *-----------------------
        final Collection<String> attributes = new ArrayList<>();
        attributes.addAll( List.of( SVGATTRIBUTE_Id,
            SVGATTRIBUTE_PreserveAspectRatio, SVGATTRIBUTE_ViewBox,
            SVGATTRIBUTE_MarkerUnits, SVGATTRIBUTE_ReferenceX,
            SVGATTRIBUTE_ReferenceY, SVGATTRIBUTE_MarkerWidth,
            SVGATTRIBUTE_MarkerHeight, SVGATTRIBUTE_Orientation,
            SVGATTRIBUTE_Class, SVGATTRIBUTE_Style,
            SVGATTRIBUTE_ExternalResourcesRequired, SVGATTRIBUTE_Transform,
            SVGATTRIBUTE_Position ) );
        attributes.addAll( CORE_ATTRIBUTES );
        attributes.addAll( AllowsStyleAttributes.STYLE_ATTRIBUTES );
        attributes.addAll( AllowsPresentationAttributes.PRESENTATION_ATTRIBUTES );

        //---* Determine the sequence *----------------------------------------
        final var attributeSequence = attributes.stream().distinct().toArray( String []::new );

        //---* The comparator *------------------------------------------------
        final Comparator<String> comparator = listBasedComparator( s -> s, naturalOrder(), attributeSequence );

        assertEquals( 0, comparator.compare( SVGATTRIBUTE_Id, SVGATTRIBUTE_Id ) );
        assertEquals( -1, comparator.compare( SVGATTRIBUTE_Id, SVGATTRIBUTE_ViewBox ) );
        assertEquals( 1, comparator.compare( SVGATTRIBUTE_ViewBox, SVGATTRIBUTE_Id ) );
    }   //  validateComparator

    /**
     *  Validate that the comparator works as expected.
     */
    @Test
    @Order( 4 )
    final void validateComparatorFromElement()
    {
        skipThreadTest();

        //---* The comparator *------------------------------------------------
        final var candidate = createCandidate();
        final var sortedMap = (SortedMap<String,String>) candidate.getAttributes();
        final var comparator = sortedMap.comparator();

        //noinspection InstanceofConcreteClass
        assertTrue( comparator instanceof ListBasedComparator );

        assertEquals( 0, comparator.compare( SVGATTRIBUTE_Id, SVGATTRIBUTE_Id ) );
        assertEquals( -1, comparator.compare( SVGATTRIBUTE_Id, SVGATTRIBUTE_ViewBox ) );
        assertEquals( 1, comparator.compare( SVGATTRIBUTE_ViewBox, SVGATTRIBUTE_Id ) );
    }   //  validateComparatorFromElement

    /**
     *  Validate that the attributes map works as expected.
     */
    @Test
    @Order( 3 )
    final void validateMap()
    {
        skipThreadTest();

        //---* Copied from SVGMarkerImpl (version 807) *-----------------------
        final Collection<String> attributes = new ArrayList<>();
        attributes.addAll( List.of( SVGATTRIBUTE_Id,
            SVGATTRIBUTE_PreserveAspectRatio, SVGATTRIBUTE_ViewBox,
            SVGATTRIBUTE_MarkerUnits, SVGATTRIBUTE_ReferenceX,
            SVGATTRIBUTE_ReferenceY, SVGATTRIBUTE_MarkerWidth,
            SVGATTRIBUTE_MarkerHeight, SVGATTRIBUTE_Orientation,
            SVGATTRIBUTE_Class, SVGATTRIBUTE_Style,
            SVGATTRIBUTE_ExternalResourcesRequired, SVGATTRIBUTE_Transform,
            SVGATTRIBUTE_Position ) );
        attributes.addAll( CORE_ATTRIBUTES );
        attributes.addAll( AllowsStyleAttributes.STYLE_ATTRIBUTES );
        attributes.addAll( AllowsPresentationAttributes.PRESENTATION_ATTRIBUTES );

        //---* Determine the sequence *----------------------------------------
        final var attributeSequence = attributes.stream().distinct().toArray( String []::new );

        //---* The comparator *------------------------------------------------
        final Comparator<String> comparator = listBasedComparator( s -> s, naturalOrder(), attributeSequence );

        //---* Attributes Map *------------------------------------------------
        final Map<String,String> attributesMap = new HashMap<>();
        attributesMap.put( XMLATTRIBUTE_Language, XMLATTRIBUTE_Language );
        attributesMap.put( SVGATTRIBUTE_ReferenceY, SVGATTRIBUTE_ReferenceY );
        attributesMap.put( SVGATTRIBUTE_ViewBox, SVGATTRIBUTE_ViewBox );
        attributesMap.put( SVGATTRIBUTE_Id, SVGATTRIBUTE_Id );

        final Map<String,String> map = new TreeMap<>( comparator );
        map.putAll( attributesMap );

        final var buffer = new StringBuilder();
        unmodifiableMap( map ).forEach( (key,value) ->
        {
            if( !buffer.isEmpty() ) buffer.append( "|" );
            buffer.append( key )
                .append( "='")
                .append( value )
                .append( '\'' );
        });

        assertEquals( "id='id'|viewBox='viewBox'|refY='refY'|xml:lang='xml:lang'", buffer.toString() );
    }   //  validateMap()

    /**
     *  Validates that the sequence is build as desired.
     */
    @Test
    @Order( 1 )
    final void validateSequence()
    {
        skipThreadTest();

        //---* Copied from SVGMarkerImpl (version 807) *-----------------------
        final Collection<String> attributes = new ArrayList<>();
        attributes.addAll( List.of( SVGATTRIBUTE_Id,
            SVGATTRIBUTE_PreserveAspectRatio, SVGATTRIBUTE_ViewBox,
            SVGATTRIBUTE_MarkerUnits, SVGATTRIBUTE_ReferenceX,
            SVGATTRIBUTE_ReferenceY, SVGATTRIBUTE_MarkerWidth,
            SVGATTRIBUTE_MarkerHeight, SVGATTRIBUTE_Orientation,
            SVGATTRIBUTE_Class, SVGATTRIBUTE_Style,
            SVGATTRIBUTE_ExternalResourcesRequired, SVGATTRIBUTE_Transform,
            SVGATTRIBUTE_Position ) );
        attributes.addAll( CORE_ATTRIBUTES );
        attributes.addAll( AllowsStyleAttributes.STYLE_ATTRIBUTES );
        attributes.addAll( AllowsPresentationAttributes.PRESENTATION_ATTRIBUTES );

        //---* Determine the sequence *----------------------------------------
        final var attributeSequence = attributes.stream().distinct().toArray( String []::new );

        assertEquals( SVGATTRIBUTE_Id, attributeSequence [0] );

        assertEquals( SVGATTRIBUTE_Id, attributes.toArray( attributeSequence ) [0] );
    }   //  validateSequence()
}
//  class BugHunt_20201224_002

/*
 *  End of File
 */