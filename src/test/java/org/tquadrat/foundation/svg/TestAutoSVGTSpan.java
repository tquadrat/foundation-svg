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
import static org.tquadrat.foundation.lang.CommonConstants.EMPTY_STRING;
import static org.tquadrat.foundation.svg.SVGUtils.centimeter;
import static org.tquadrat.foundation.svg.SVGUtils.createTSpan;
import static org.tquadrat.foundation.svg.SVGUtils.degree;
import static org.tquadrat.foundation.svg.SVGUtils.pixel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGNumber;
import org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGTSpan}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGTSpan.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGTSpan.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGTSpan" )
public class TestAutoSVGTSpan extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private static final SVGTSpan createCandidate()
    {
        final var retValue = createTSpan();

        //---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#addCDATA(java.lang.CharSequence)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddCDATA() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.addCDATA( "cdata" );
        expected = "\n<tspan><![CDATA[cdata]]></tspan>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.addCDATA( "cdata]]cdata" );
        expected = "\n<tspan><![CDATA[cdata]]><![CDATA[cdata]]>]]<![CDATA[cdata]]></tspan>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.addCDATA( EMPTY_STRING );
        expected = "\n<tspan><![CDATA[cdata]]><![CDATA[cdata]]>]]<![CDATA[cdata]]><![CDATA[]]></tspan>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testAddCDATA()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#addCDATA(java.lang.CharSequence)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddCDATAWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.addCDATA( null );
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
    }   //  testAddCDATAWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#addText(java.lang.CharSequence)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddText() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.addText( "text" );
        expected = "\n<tspan>text</tspan>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.addText( EMPTY_STRING );
        expected = "\n<tspan>text</tspan>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testAddText()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#addText(java.lang.CharSequence)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddTextWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.addText( null );
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
    }   //  testAddTextWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#setDx(org.tquadrat.foundation.svg.type.SVGNumber[])}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetDx() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setDx( pixel( 10 ) );
        expected = "\n<tspan dx='10px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setDx();
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setDx( pixel( 10 ), pixel( 20 ), pixel( 30 ) );
        expected = "\n<tspan dx='10px,20px,30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setDx( (SVGNumber []) null );
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetDx()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#setDy(org.tquadrat.foundation.svg.type.SVGNumber[])}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetDy() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setDy( pixel( 10 ) );
        expected = "\n<tspan dy='10px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setDy();
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setDy( pixel( 10 ), pixel( 20 ), pixel( 30 ) );
        expected = "\n<tspan dy='10px,20px,30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setDy( (SVGNumber []) null );
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetDy()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#setLengthAdjust(boolean)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetLengthAdjust() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setLengthAdjust( true );
        expected = "\n<tspan lengthAdjust='spacingAndGlyphs'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setLengthAdjust( false );
        expected = "\n<tspan lengthAdjust='spacing'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetLengthAdjust()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#setRotate(org.tquadrat.foundation.svg.type.SVGNumber.SVGDegree[])}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetRotate() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setRotate( degree( 10 ) );
        expected = "\n<tspan rotate='10'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setRotate();
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setRotate( degree( 10 ), degree( -10 ), degree( 10 ) );
        expected = "\n<tspan rotate='10,-10,10'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setRotate( (SVGDegree []) null );
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetRotate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#setTextLength(org.tquadrat.foundation.svg.type.SVGNumber)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetTextLength() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setTextLength( centimeter( 10 ) );
        expected = "\n<tspan textLength='10cm'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setTextLength( null );
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetTextLength()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#setX(org.tquadrat.foundation.svg.type.SVGNumber[])}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetX() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setX( pixel( 10 ) );
        expected = "\n<tspan x='10px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX();
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX( pixel( 10 ), pixel( 20 ), pixel( 30 ) );
        expected = "\n<tspan x='10px,20px,30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX( (SVGNumber []) null );
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetX()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGTSpan#setY(org.tquadrat.foundation.svg.type.SVGNumber[])}.
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetY() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setY( pixel( 10 ) );
        expected = "\n<tspan y='10px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY();
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY( pixel( 10 ), pixel( 20 ), pixel( 30 ) );
        expected = "\n<tspan y='10px,20px,30px'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY( (SVGNumber []) null );
        expected = "\n<tspan/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetY()
}
//  class TestAutoSVGTSpan

/*
 *  End of File
 */