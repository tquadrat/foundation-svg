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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVG.Usage.STANDALONE_DOCUMENT;
import static org.tquadrat.foundation.svg.SVGUtils.cloneElement;
import static org.tquadrat.foundation.svg.SVGUtils.createGroup;
import static org.tquadrat.foundation.svg.SVGUtils.createLine;
import static org.tquadrat.foundation.svg.SVGUtils.createPath;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.svg.SVGUtils.createText;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.SVGElement;
import org.tquadrat.foundation.svg.SVGUtils;
import org.tquadrat.foundation.svg.helper.SVGTestBase;

/**
 *  Tests for the method
 *  {@link SVGUtils#cloneElement(SVGElement)}.
 *  from the class
 *  {@link SVGUtils}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestCloneElement.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@SuppressWarnings( "MisorderedAssertEqualsArguments" )
@ClassVersion( sourceVersion = "$Id: TestCloneElement.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.svgutils.TestCloneElement" )
public class TestCloneElement extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Test for
     *  {@link SVGUtils#cloneElement(SVGElement)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testCloneElement() throws Exception
    {
        skipThreadTest();

        final var parent1 = createSVG( STANDALONE_DOCUMENT );
        final var parent2 = createSVG( STANDALONE_DOCUMENT );

        final var candidate = createGroup( parent1 );
        createText( candidate );
        createLine( candidate );
        createPath( candidate );

        final var clone = cloneElement( candidate );

        final String actual;
        final String expected;

        expected = candidate.toString();
        actual = clone.toString();
        assertEquals( expected, actual );

        parent2.addChild( clone );

    }   //  testCloneElement()

    /**
     *  Test for
     *  {@link SVGUtils#cloneElement(SVGElement)}.
     *
     *  @throws Exception Something unexpected went wrong
     */
    @Test
    final void testCloneElementWithNullArgument() throws Exception
    {
        skipThreadTest();

        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            cloneElement( null );
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
    }   //  testCloneElementWithNullArgument()
}
//  class TestCloneElement

/*
 *  End of File
 */