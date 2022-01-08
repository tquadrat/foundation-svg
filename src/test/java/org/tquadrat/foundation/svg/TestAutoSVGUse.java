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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.tquadrat.foundation.svg.SVGUtils.createUse;
import static org.tquadrat.foundation.svg.SVGUtils.pixel;

import java.net.URI;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGNumber;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVGUse}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVGUse.java 980 2022-01-06 15:29:19Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVGUse.java 980 2022-01-06 15:29:19Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVGUse" )
public class TestAutoSVGUse extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private static final SVGUse createCandidate()
    {
        final var retValue = createUse( URI.create( "#id" ) );

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGUse#setHeight(SVGNumber)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetHeight() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setHeight( pixel( 200 ) );
        expected =
            """

            <use height='200px'
                 xlink:href='#id'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setHeight( null );
        expected = "\n<use xlink:href='#id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetHeight()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGUse#setWidth(org.tquadrat.foundation.svg.type.SVGNumber)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetWidth() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setWidth( pixel( 200 ) );
        expected =
            """

            <use width='200px'
                 xlink:href='#id'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setWidth( null );
        expected = "\n<use xlink:href='#id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetWidth()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGUse#setX(org.tquadrat.foundation.svg.type.SVGNumber)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetX() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setX( pixel( 200 ) );
        expected =
            """

            <use x='200px'
                 xlink:href='#id'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX( null );
        expected = "\n<use xlink:href='#id'/>";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetX()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVGUse#setY(org.tquadrat.foundation.svg.type.SVGNumber)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetY() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setY( pixel( 200 ) );
        expected =
            """

            <use y='200px'
                 xlink:href='#id'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY( null );
        expected =
            """
            
            <use xlink:href='#id'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetY()
}
//  class TestAutoSVGUse

/*
 *  End of File
 */