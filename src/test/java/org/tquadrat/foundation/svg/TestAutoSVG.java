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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_HTML;
import static org.tquadrat.foundation.svg.SVG.Usage.EMBED_SVG;
import static org.tquadrat.foundation.svg.SVG.Usage.STANDALONE_DOCUMENT;
import static org.tquadrat.foundation.svg.SVGUtils.createSVG;
import static org.tquadrat.foundation.svg.SVGUtils.createStyle;
import static org.tquadrat.foundation.svg.SVGUtils.createText;
import static org.tquadrat.foundation.svg.SVGUtils.number;
import static org.tquadrat.foundation.svg.SVGUtils.percent;
import static org.tquadrat.foundation.svg.SVGUtils.pixel;
import static org.tquadrat.foundation.svg.type.SVGPreserveAspectRatio.XMID_YMID;
import static org.tquadrat.foundation.util.StringUtils.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.tquadrat.foundation.annotation.ClassVersion;
import org.tquadrat.foundation.exception.NullArgumentException;
import org.tquadrat.foundation.svg.helper.SVGTestBase;
import org.tquadrat.foundation.svg.type.SVGNumber;
import jakarta.activation.MimeType;

/**
 *  Generated tests for the interface
 *  {@link org.tquadrat.foundation.svg.SVG}.
 *
 *  @extauthor Thomas Thrien - thomas.thrien@tquadrat.org
 *  @version $Id: TestAutoSVG.java 820 2020-12-29 20:34:22Z tquadrat $
 *  @since 0.0.5
 */
@ClassVersion( sourceVersion = "$Id: TestAutoSVG.java 820 2020-12-29 20:34:22Z tquadrat $" )
@DisplayName( "org.tquadrat.foundation.svg.TestAutoSVG" )
public class TestAutoSVG extends SVGTestBase
{
        /*---------*\
    ====** Methods **==========================================================
        \*---------*/
    /**
     *  Satisfies the test coverage ratio.
     */
    @Test
    final void cover()
    {
        skipThreadTest();

        final var candidate = createCandidate();
        assertFalse( candidate.hasChildren() );
        assertTrue( candidate.getChildren().isEmpty() );
        candidate.addChild( createText( "text" ) );
        assertTrue( candidate.hasChildren() );
    }   //  cover()

    /**
     * Create the candidate object.
     *
     * @return The candidate object.
     */
    private static final SVG createCandidate()
    {
        final var retValue = createSVG( STANDALONE_DOCUMENT );

        // ---* Done *----------------------------------------------------------
        return retValue;
    }   //  createCandidate()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#addDefinition(org.tquadrat.foundation.svg.SVGElement)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddDefinition() throws Exception
    {
        skipThreadTest();

        SVG candidate;
        String actual, expected;

        SVGElement definition;

        definition = createSVG( EMBED_SVG );
        definition.setId( "id" );

        candidate = createCandidate();
        assertFalse( candidate.hasChildren() );
        candidate.addDefinition( definition );
        assertTrue( candidate.hasChildren() );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'>
                       <defs>
                           <svg id='id'/>
                       </defs>
                   </svg>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        definition = createStyle( "circle { fill: black; }" );
        /*
         * No id is set to this definition element!!
         */

        candidate = createCandidate();
        assertFalse( candidate.hasChildren() );
        candidate.addDefinition( definition );
        assertTrue( candidate.hasChildren() );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'>
                       <defs>
                           <style><![CDATA[
                               circle { fill: black; }
                               ]]></style>
                       </defs>
                   </svg>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testAddDefinition()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#addDefinition(org.tquadrat.foundation.svg.SVGElement)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddDefinitionWithInvalidArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final var definition = createSVG( EMBED_SVG );

        {
            /*
             * The definition does not have an id.
             */
            final Class<? extends Throwable> expectedException = IllegalArgumentException.class;
            try
            {
                candidate.addDefinition( definition );
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
        }

        {
            /*
             * The definition has already a parent.
             */
            final var parent = createSVG( EMBED_HTML );
            parent.addChild( definition );
            definition.setId( "id" );

            final Class<? extends Throwable> expectedException = IllegalStateException.class;
            try
            {
                candidate.addDefinition( definition );
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
        }
    }   //  testAddDefinitionWithInvalidArgument()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg#SVGaddDefinition(org.tquadrat.foundation.svg.SVGElement)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testAddDefinitionWithNullArgument() throws Exception
    {
        skipThreadTest();

        final var candidate = createCandidate();

        final SVGElement element = null;
        final Class<? extends Throwable> expectedException = NullArgumentException.class;
        try
        {
            candidate.addDefinition( element );
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
     * {@link org.tquadrat.foundation.svg.SVG#setContentScriptType(jakarta.activation.MimeType)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetContentScriptType() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();
        final var scriptType = new MimeType( "application/ecmascript" );

        candidate.setContentScriptType( scriptType );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        contentScriptType='application/ecmascript'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setContentScriptType( null );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetContentScriptType()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#setHeight(SVGNumber)}
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
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        height='200px'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setHeight( null );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetHeight()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#setPreserveAspectRatio(org.tquadrat.foundation.svg.type.SVGPreserveAspectRatio)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetPreserveAspectRatio() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setPreserveAspectRatio( XMID_YMID );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        preserveAspectRatio='xMidYMid'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setPreserveAspectRatio( null );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetPreserveAspectRatio()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#setViewBox(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}
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
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        viewBox='0,0,100%,100%'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetViewBox()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg#SVGsetViewBox(org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber,org.tquadrat.foundation.svg.type.SVGNumber)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetViewBoxNull() throws Exception
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
    }   //  testSetViewBoxNull()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#setWidth(org.tquadrat.foundation.svg.type.SVGNumber)}
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
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        width='200px'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setWidth( null );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetWidth()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#setX(org.tquadrat.foundation.svg.type.SVGNumber)}
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
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        x='200px'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setX( null );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetX()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#setY(org.tquadrat.foundation.svg.type.SVGNumber)}
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
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        y='200px'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setY( null );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetY()

    /**
     * Test for
     * {@link org.tquadrat.foundation.svg.SVG#setZoomAndPan(boolean)}
     *
     * @throws Exception Something unexpected went wrong
     */
    @Test
    final void testSetZoomAndPan() throws Exception
    {
        skipThreadTest();

        String actual, expected;
        final var candidate = createCandidate();

        candidate.setZoomAndPan( true );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        zoomAndPan='magnify'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );

        candidate.setZoomAndPan( false );
        expected = """

                   <svg xmlns="http://www.w3.org/2000/svg"
                        xmlns:cc="http://creativecommons.org/ns#"
                        xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
                        xmlns:svg="http://www.w3.org/2000/svg"
                        xmlns:xlink="http://www.w3.org/1999/xlink"
                        version='1.1'
                        baseProfile='full'
                        zoomAndPan='disable'/>""";
        actual = candidate.toString();
        assertEquals( expected, actual );
    }   //  testSetZoomAndPan()
}
//  class TestAutoSVG

/*
 *  End of File
 */