/*
 * ============================================================================
 * Copyright © 2002-2018 by Thomas Thrien.
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
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_SVG;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.svg.SVGUtils.createStyle;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Manually written tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVG}
 *  and its implementation class
 *  {@link org.tquadrat.foundation.svg.internal.SVGImpl}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestSVG.java 1076 2023-10-03 18:36:07Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestSVG.java 1076 2023-10-03 18:36:07Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestSVG" )
public class TestSVG extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private static final SVG createCandidate()
    {
        final var retValue = createSVG( EMBED_SVG );

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#addDefinition(org.tquadrat.foundation.svg.SVGStyle)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddDefinition() throws Exception
    {
        skipThreadTest();

        final var style = createStyle( "circle { fill: black; }" );

        final var candidate = createCandidate();
        assertFalse( candidate.hasChildren() );
        candidate.addDefinition( style );
        assertTrue( candidate.hasChildren() );
        final var expected =
            """

            <svg>
                <defs>
                    <style><![CDATA[
                        circle { fill: black; }
                        ]]></style>
                </defs>
            </svg>""";
        final var actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testAddDefinition()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg#SVGaddDefinition(org.tquadrat.foundation.svg.SVGStyle)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddDefinitionWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.addDefinition( null );
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
    }   //  testAddDefinitionWithNullArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#setStyleSheet(CharSequence...)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetStyleSheet() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setStyleSheet( "circle { fill: black; }" );
        expected =
            """

            <svg>
                <defs>
                    <style><![CDATA[
                        circle { fill: black; }
                        ]]></style>
                </defs>
            </svg>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setStyleSheet( "rect { fill: yellow; }" );
        expected =
            """

            <svg>
                <defs>
                    <style><![CDATA[
                        circle { fill: black; }
                        rect { fill: yellow; }
                        ]]></style>
                </defs>
            </svg>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetStyleSheet()
}
//  class TestSVG

/*
 *  End of File
 */